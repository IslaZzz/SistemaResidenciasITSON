package itson.negocios_administradorreportes;

import dto.ReporteDTO;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 * Clase fachada para la administración de reportes. Actúa como un intermediario
 * entre la capa de presentación y la capa de acceso a datos, delegando la lógica
 * a la clase correspondiente.
 * 
 * @author rauln
 */
public class AdministradorReportesFachada implements IAdministradorReportes {

    private IAccesoDatos accesoDatos;

    public AdministradorReportesFachada() {
        // Inicializar la instancia de acceso a datos (en este caso, fachada de acceso)
        this.accesoDatos = new AccesoDatosFachada();
    }

    @Override
    public ReporteDTO registrarReporte(ReporteDTO reporteDTO) throws NegocioException {
        // Verificar si ya existe un reporte pendiente
        boolean reportePendiente = accesoDatos.verificarExistenciaDeReportePendiente(reporteDTO);

        if (reportePendiente) {
            throw new NegocioException("Ya existe un reporte pendiente para esta habitación.");
        }

        // Si no hay reporte pendiente, registrar el nuevo reporte
        return accesoDatos.registrarReporte(reporteDTO);
    }

    @Override
    public boolean verificarExistenciaDeReportePendiente(ReporteDTO reporteDTO) throws NegocioException {
        return accesoDatos.verificarExistenciaDeReportePendiente(reporteDTO);
    }

}
