package itson.negocios_administradoractividadeslimpieza;


import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import excepciones.NegocioException;
import java.util.List;

public interface IAdministradorActividadesLimpieza {

    /**
     * Registra una actividad de limpieza en el sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de limpieza a registrar.
     * @param zonaDTO              El objeto DTO que representa la zona asociada a la actividad.
     * @param personalDTO          El objeto DTO que representa al personal asignado a la actividad.
     * @return El objeto DTO de la actividad de limpieza registrada.
     */
    ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpiezaDTO, ZonaDTO zonaDTO, PersonalDTO personalDTO) throws NegocioException;

    /**
     * Elimina una actividad de limpieza del sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de limpieza a eliminar.
     * @return true si la actividad fue eliminada exitosamente, false en caso contrario.
     */
    boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException;

    /**
     * Obtiene una actividad de limpieza específica del sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de limpieza a buscar.
     * @return El objeto DTO de la actividad de limpieza encontrada.
     */
    ActividadLimpiezaDTO obtenerActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException;

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en el sistema.
     *
     * @return Una lista de objetos DTO de actividades de limpieza.
     */
    List<ActividadLimpiezaDTO> obtenerActividadesLimpieza();

}
