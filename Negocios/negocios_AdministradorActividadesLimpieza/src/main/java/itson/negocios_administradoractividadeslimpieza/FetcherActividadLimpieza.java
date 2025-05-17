package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
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
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NoEncontradoException Si no se encuentra la actividad de limpieza
     * para el personal y hora.
     */
    public ActividadLimpiezaDTO obtenerActividadSolapada(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        return actividadLimpiezaBO.obtenerActividadSolapada(actividad);
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

    /**
     * Obtiene una lista de actividades de limpieza filtradas según un
     * criterio
     * @param filtro El criterio de filtro para las actividades de limpieza. 
     * @return Una lista de objetos {@link ActividadLimpiezaDTO} que cumplen con el
     * criterio de filtro.
     */
    public List<ActividadLimpiezaDTO> obtenerActividadesPorFiltro(String filtro) {
        return actividadLimpiezaBO.obtenerActividadesPorFiltro(filtro);
    }

}
