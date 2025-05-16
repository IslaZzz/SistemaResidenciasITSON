package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones que debe implementar una fachada para
 * gestionar las actividades de limpieza en el sistema.
 *
 * Esta interfaz proporciona métodos para registrar, eliminar, obtener una
 * actividad de limpieza específica o una lista de todas las actividades de
 * limpieza registradas en el sistema.
 */
public interface IAdministradorActividadesLimpieza {

    /**
     * Registra una actividad de limpieza en el sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de
     * limpieza a registrar.
     * @param zonaDTO El objeto DTO que representa la zona asociada a la
     * actividad.
     * @param personalDTO El objeto DTO que representa al personal asignado a la
     * actividad.
     * @return El objeto DTO de la actividad de limpieza registrada.
     * @throws excepciones.NegocioException
     */
    ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException;

    /**
     * Elimina una actividad de limpieza del sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de
     * limpieza a eliminar.
     * @return true si la actividad fue eliminada exitosamente, false en caso
     * contrario.
     * @throws excepciones.NegocioException
     */
    boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException;

    /**
     * Obtiene una actividad de limpieza específica del sistema.
     *
     * @param actividadLimpiezaDTO El objeto DTO que representa la actividad de
     * limpieza a buscar.
     * @return El objeto DTO de la actividad de limpieza encontrada.
     * @throws excepciones.NegocioException
     */
    ActividadLimpiezaDTO obtenerActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException;

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en el
     * sistema.
     *
     * @return Una lista de objetos DTO de actividades de limpieza.
     */
    List<ActividadLimpiezaDTO> obtenerActividadesLimpieza();

    List<ActividadLimpiezaDTO> obtenerActividadesFiltradas(String filtro) ;

}
