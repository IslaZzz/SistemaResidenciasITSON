package objetosnegocio;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import dto.ReporteDTO;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import implementaciones.MensajeriaFachada;
import interfaz.IAccesoDatos;
import interfaz.IMensajeria;


/**
 * Clase de lógica de negocio para gestionar reportes de mantenimiento.
 * Implementa el patrón Singleton para asegurar una única instancia en toda la
 * aplicación. Esta clase sirve como intermediario entre la capa de presentación
 * y la capa de acceso a datos.
 *
 * Se encarga de validar, preparar y delegar la lógica necesaria para registrar
 * reportes utilizando la fachada de acceso a datos.
 *
 * @author rauln
 */
public class ReporteBO {

    /**
     * Instancia única de la clase ReporteBO (patrón Singleton).
     */
    private static ReporteBO reporteBO;

    /**
     * Retorna la instancia única de la clase ReporteBO. Si no existe, la crea.
     *
     * @return La instancia única de ReporteBO.
     */
    public static ReporteBO getInstance() {
        if (reporteBO == null) {
            reporteBO = new ReporteBO();
        }
        return reporteBO;
    }

    /**
     * Registra un nuevo reporte de mantenimiento en el sistema. Este método
     * delega la operación a la capa de acceso a datos a través de la fachada.
     *
     * @param reporte El DTO que contiene la información del reporte a
     * registrar.
     * @throws NegocioException Si ya existe un reporte pendiente para la misma
     * habitación.
     */
    public void registrarReporte(ReporteDTO reporte) throws NegocioException {
        // Verificar si ya existe un reporte pendiente para la misma habitación
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        boolean reportePendiente = accesoDatos.verificarExistenciaDeReportePendiente(reporte);

        if (reportePendiente) {
            throw new NegocioException("Ya existe un reporte pendiente para esta habitación.");
        }

        // Si no hay reporte pendiente, proceder con el registro
        accesoDatos.registrarReporte(reporte);
    }
    
    public void enviarReportePorWhatsapp(ReporteDTO reporte) throws NegocioException, ServidorExcepcion{
        ReporteInfDTO reporteInfDTO = new ReporteInfDTO(
                reporte.getPiso(),
                reporte.getHabitacion(),
                reporte.getResidente(),
                reporte.getHorarioVisita(),
                reporte.getDescripcionProblema(),
                reporte.getFechaHoraReporte(),
                reporte.getEstadoReporte()
        );
        IMensajeria mensajeria = new MensajeriaFachada();
        mensajeria.enviarReportePorWhatsapp(reporteInfDTO);
    }
}
