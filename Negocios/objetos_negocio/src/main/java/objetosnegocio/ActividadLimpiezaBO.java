package objetosnegocio;

import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 * La clase {@code ActividadLimpiezaBO} encapsula la lógica de negocio
 * relacionada con la gestión de actividades de limpieza dentro del sistema.
 *
 * <p>
 * Es una clase de tipo Singleton, lo que garantiza que solo exista una
 * instancia de este objeto en la aplicación. Utiliza una fachada de acceso a
 * datos para delegar las operaciones de persistencia.</p>
 *
 * <p>
 * Entre sus responsabilidades se encuentran:</p>
 * <ul>
 * <li>Registrar actividades de limpieza asociadas a zonas y personal.</li>
 * <li>Eliminar actividades de limpieza.</li>
 * <li>Consultar actividades por diferentes criterios (zona, personal,
 * hora).</li>
 * <li>Obtener todas las actividades registradas.</li>
 * </ul>
 *
 * <p>
 * Las excepciones del tipo {@code NoEncontradoException} se utilizan para
 * manejar errores cuando una entidad no es localizada en el sistema.</p>
 *
 *
 */
public class ActividadLimpiezaBO {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static ActividadLimpiezaBO instance;

    /**
     * Constructor privado para evitar la creación directa de instancias.
     */
    private ActividadLimpiezaBO() {
    }

    /**
     * Obtiene la instancia única de {@code ActividadLimpiezaBO}.
     *
     * @return La instancia única de esta clase.
     */
    public static ActividadLimpiezaBO getInstance() {
        if (instance == null) {
            instance = new ActividadLimpiezaBO();
        }
        return instance;
    }

    /**
     * Registra una nueva actividad de limpieza asociada a una zona y un
     * personal.
     *
     * @param actividad La actividad de limpieza a registrar.
     * @param zona La zona donde se realizará la actividad.
     * @param personal El personal asignado a la actividad.
     * @return La actividad registrada con datos completos.
     * @throws NoEncontradoException Si no se encuentra la zona o el personal
     * especificado.
     */
    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividad, ZonaDTO zona, PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.registrarActividadLimpieza(actividad, zona, personal);
    }

    /**
     * Elimina una actividad de limpieza previamente registrada.
     *
     * @param actividad La actividad a eliminar.
     * @return {@code true} si se eliminó correctamente, {@code false} en caso
     * contrario.
     * @throws NoEncontradoException Si la actividad no existe.
     */
    public boolean eliminarActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.eliminarActividad(actividad);
    }

    /**
     * Obtiene los datos de una actividad de limpieza específica.
     *
     * @param actividad La actividad a buscar.
     * @return La actividad encontrada.
     * @throws NoEncontradoException Si no se encuentra la actividad.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpieza(actividad);
    }

    /**
     * Obtiene una actividad de limpieza según el personal y la hora
     * especificados.
     *
     * @param actividad Datos de búsqueda incluyendo hora.
     * @param personal El personal asignado.
     * @return La actividad encontrada.
     * @throws NoEncontradoException Si no se encuentra una coincidencia.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorPersonalYHora(ActividadLimpiezaDTO actividad, PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpiezaPorPersonalYHora(actividad, personal);
    }

    /**
     * Obtiene una actividad de limpieza según la zona y la hora especificadas.
     *
     * @param actividad Datos de búsqueda incluyendo hora.
     * @param zona La zona asignada.
     * @return La actividad encontrada.
     * @throws NoEncontradoException Si no se encuentra una coincidencia.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorZonaYHora(ActividadLimpiezaDTO actividad, ZonaDTO zona) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpiezaPorZonaYHora(actividad, zona);
    }

    /**
     * Obtiene la lista completa de actividades de limpieza registradas en el
     * sistema.
     *
     * @return Una lista con todas las actividades de limpieza.
     */
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadesLimpieza();
    }

}
