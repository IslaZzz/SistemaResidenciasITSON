package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ActividadLimpiezaBO;

/**
 * Clase auxiliar encargada de recuperar información relacionada con las
 * actividades de limpieza del sistema. Esta clase interactúa con la capa de
 * negocio {@link ActividadLimpiezaBO} para obtener, verificar y gestionar
 * actividades de limpieza según diferentes criterios.
 *
 * Los métodos de esta clase permiten acceder a la información de las
 * actividades de limpieza, ya sea por personal asignado, zona o mediante otros
 * filtros.
 */
public class FetcherActividadLimpieza {

    /**
     * Instancia de la clase {@link ActividadLimpiezaBO} que maneja la lógica de
     * negocio relacionada con las actividades de limpieza.
     */
    private ActividadLimpiezaBO actividadLimpiezaBO;

    /**
     * Constructor que inicializa el objeto FetcherActividadLimpieza con la
     * instancia de {@link ActividadLimpiezaBO} proporcionada.
     *
     * @param actividadLimpiezaBO La instancia de {@link ActividadLimpiezaBO}
     * que se utilizará para la obtención de las actividades de limpieza.
     */
    public FetcherActividadLimpieza(ActividadLimpiezaBO actividadLimpiezaBO) {
        this.actividadLimpiezaBO = actividadLimpiezaBO;
    }

    /**
     * Obtiene una actividad de limpieza específica utilizando el objeto
     * {@link ActividadLimpiezaDTO}.
     *
     * @param actividad El objeto {@link ActividadLimpiezaDTO} que representa la
     * actividad de limpieza a obtener.
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NegocioException Si ocurre un error al obtener la actividad.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividad) throws NegocioException {
        try {
            return actividadLimpiezaBO.obtenerActividadLimpieza(actividad);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al obtener la actividad de limpieza: " + e.getMessage());
        }
    }

    /**
     * Obtiene una actividad de limpieza por el personal asignado y la hora de
     * la actividad.
     *
     * @param actividad El objeto {@link ActividadLimpiezaDTO} que representa la
     * actividad de limpieza.
     * @param personal El objeto {@link PersonalDTO} que representa al personal
     * asignado a la actividad.
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NoEncontradoException Si no se encuentra la actividad de limpieza
     * para el personal y hora.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorPersonalYHora(ActividadLimpiezaDTO actividad, PersonalDTO personal) throws NoEncontradoException {
        return actividadLimpiezaBO.obtenerActividadLimpiezaPorPersonalYHora(actividad, personal);
    }

    /**
     * Obtiene una actividad de limpieza por la zona asignada y la hora de la
     * actividad.
     *
     * @param actividad El objeto {@link ActividadLimpiezaDTO} que representa la
     * actividad de limpieza.
     * @param zona El objeto {@link ZonaDTO} que representa la zona donde se
     * realiza la actividad.
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NoEncontradoException Si no se encuentra la actividad de limpieza
     * para la zona y hora.
     */
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorZonaYHora(ActividadLimpiezaDTO actividad, ZonaDTO zona) throws NoEncontradoException {
        return actividadLimpiezaBO.obtenerActividadLimpiezaPorZonaYHora(actividad, zona);
    }

    /**
     * Obtiene todas las actividades de limpieza registradas en el sistema.
     *
     * @return Una lista de objetos {@link ActividadLimpiezaDTO}
     * correspondientes a las actividades de limpieza registradas.
     */
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        return actividadLimpiezaBO.obtenerActividadesLimpieza();
    }

}
