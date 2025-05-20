package itson.negocios_administradorreportes;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import dto.ReporteDTO;
import entities.Reporte;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosnegocio.ReporteBO;

/**
 *
 * Clase fachada para la administración de reportes. Actúa como un intermediario
 * entre la capa de presentación y la capa de acceso a datos, delegando la
 * lógica a la clase correspondiente.
 *
 */
public class AdministradorReportesFachada implements IAdministradorReportes {

    /**
     * Referencia a la capa de acceso a datos que permite realizar operaciones
     * como registrar reportes y verificar su existencia. Se utiliza para
     * delegar la lógica desde la fachada hacia la implementación
     * correspondiente.
     */
    private ReporteBO reporteBO = ReporteBO.getInstance();
    private IAccesoDatos accesoDatos;
    private FetcherReporte fetcherReporte = new FetcherReporte(reporteBO);

    /**
     * Crea una nueva instancia de {@code AdministradorReportesFachada} e
     * inicializa el acceso a datos mediante una fachada.
     */
    public AdministradorReportesFachada() {
        this.accesoDatos = new AccesoDatosFachada();
    }

    /**
     * Registra un nuevo reporte de mantenimiento si no existe ya uno pendiente
     * para la misma habitación y piso. En caso de que ya exista, lanza una
     * excepción.
     *
     * @param reporteDTO el objeto {@link ReporteDTO} con los datos del nuevo
     * reporte.
     * @return el {@link ReporteDTO} registrado con su información completa.
     * @throws NegocioException si ya existe un reporte pendiente para la
     * habitación.
     */
    @Override
    public ReporteDTO registrarReporte(ReporteDTO reporteDTO) throws NegocioException {
        boolean reportePendiente = accesoDatos.verificarExistenciaDeReportePendiente(reporteDTO);
        if (reportePendiente) {
            throw new NegocioException("Ya existe un reporte pendiente para esta habitación.");
        }
        return accesoDatos.registrarReporte(reporteDTO);
    }

    /**
     * Verifica si ya existe un reporte con estado "PENDIENTE" para la
     * habitación y piso indicados en el {@link ReporteDTO}.
     *
     * @param reporteDTO el objeto {@link ReporteDTO} con los datos a verificar.
     * @return {@code true} si existe un reporte pendiente, {@code false} en
     * caso contrario.
     * @throws NegocioException si ocurre un error durante la verificación.
     */
    @Override
    public boolean verificarExistenciaDeReportePendiente(ReporteDTO reporteDTO) throws NegocioException {
        return accesoDatos.verificarExistenciaDeReportePendiente(reporteDTO);
    }

    /**
     * Envía un reporte vía WhatsApp utilizando el fetcherReporte.
     *
     * @param reporte El objeto ReporteDTO que contiene la información del
     * reporte a enviar.
     * @throws NegocioException Si ocurre un error durante el envío del reporte.
     */
    @Override
    public void enviarReportePorWhatsapp(ReporteDTO reporte) throws NegocioException {
        try {
            fetcherReporte.enviarReportePorWhatsapp(reporte);
        } catch (NegocioException | ServidorExcepcion ex) {
            throw new NegocioException("Error al enviar el reporte");
        }
    }

}
