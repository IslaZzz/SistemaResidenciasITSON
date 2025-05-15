package itson.negocios_administradorreportes;

import dto.ReporteDTO;
import entities.Reporte;
import excepciones.NegocioException;

/**
 * Interfaz que define las operaciones principales relacionadas con la
 * administración de reportes de mantenimiento por parte del residente.
 * Proporciona métodos para registrar nuevos reportes y verificar si ya existe
 * alguno pendiente.
 *
 * Esta interfaz permite desacoplar la lógica de negocio de su implementación.
 *
 * @author rauln
 */
public interface IAdministradorReportes {

    /**
     * Registra un nuevo reporte de mantenimiento si no existe ya uno pendiente
     * para la misma habitación y piso.
     *
     * @param reporteDTO el objeto {@link ReporteDTO} que contiene la
     * información del reporte a registrar.
     * @return el {@link ReporteDTO} registrado con los datos generados como el
     * ID y la fecha.
     * @throws NegocioException si ya existe un reporte pendiente o si ocurre un
     * error en el negocio.
     */
    public abstract ReporteDTO registrarReporte(ReporteDTO reporteDTO) throws NegocioException;

    /**
     * Verifica si ya existe un reporte de mantenimiento pendiente para la misma
     * habitación y piso indicados en el objeto {@link ReporteDTO}.
     *
     * @param reporteDTO el objeto {@link ReporteDTO} que contiene los datos de
     * ubicación a verificar.
     * @return {@code true} si ya existe un reporte pendiente, {@code false} en
     * caso contrario.
     * @throws NegocioException si ocurre un error durante la verificación.
     */
    public abstract boolean verificarExistenciaDeReportePendiente(ReporteDTO reporteDTO) throws NegocioException;

    void enviarReportePorWhatsapp(ReporteDTO reporte) throws NegocioException;
}
