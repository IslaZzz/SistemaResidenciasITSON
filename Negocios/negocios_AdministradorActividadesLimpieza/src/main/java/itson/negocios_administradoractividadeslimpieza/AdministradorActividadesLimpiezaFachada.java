package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ActividadLimpiezaBO;

/**
 * Fachada que implementa la interfaz {@link IAdministradorActividadesLimpieza}
 * para gestionar las operaciones relacionadas con las actividades de limpieza
 * en el sistema. Esta clase actúa como un intermediario entre la capa de
 * negocio y la capa de acceso a datos, delegando las acciones correspondientes
 * a la clase {@link ActividadLimpiezaBO} y otras clases auxiliares.
 *
 * Proporciona métodos para registrar, eliminar, obtener y verificar actividades
 * de limpieza en el sistema.
 */
public class AdministradorActividadesLimpiezaFachada implements IAdministradorActividadesLimpieza {

    /**
     * Instancia de la clase ActividadLimpiezaBO que maneja la lógica de negocio
     * relacionada con las actividades de limpieza.
     */
    private ActividadLimpiezaBO actividadLimpiezaBO = ActividadLimpiezaBO.getInstance();

    /**
     * Instancia del objeto {@link FetcherActividadLimpieza} que se utiliza para
     * obtener las actividades de limpieza desde la capa de negocio.
     */
    private FetcherActividadLimpieza fetcherActividadLimpieza = new FetcherActividadLimpieza(actividadLimpiezaBO);

    /**
     * Registra una nueva actividad de limpieza en el sistema.
     *
     * @param actividadLimpiezaDTO El objeto {@link ActividadLimpiezaDTO} que
     * contiene los datos de la actividad de limpieza.
     * @param zonaDTO El objeto {@link ZonaDTO} que representa la zona asociada
     * con la actividad.
     * @param personalDTO El objeto {@link PersonalDTO} que representa al
     * personal asignado a la actividad.
     * @return El objeto {@link ActividadLimpiezaDTO} registrado.
     * @throws NegocioException Si ocurre un error al registrar la actividad.
     */
    @Override
    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException {
        try {
            if (obtenerActividadPorZonaYHora(actividadLimpiezaDTO, actividadLimpiezaDTO.getZona()) != null) {
                throw new NegocioException("Ya existe una actividad de limpieza registrada para esta zona y hora.");
            }
            if (obtenerActividadPorPersonalYHora(actividadLimpiezaDTO, actividadLimpiezaDTO.getPersonal()) != null) {
                throw new NegocioException("Ya existe una actividad de limpieza registrada para este personal y hora.");
            }
            return actividadLimpiezaBO.registrarActividadLimpieza(actividadLimpiezaDTO);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al registrar la actividad de limpieza: " + e.getMessage());
        }
    }

    /**
     * Elimina una actividad de limpieza del sistema.
     *
     * @param actividadLimpiezaDTO El objeto {@link ActividadLimpiezaDTO} que
     * representa la actividad a eliminar.
     * @return true si la actividad fue eliminada exitosamente, false de lo
     * contrario.
     * @throws NegocioException Si ocurre un error al eliminar la actividad.
     */
    @Override
    public boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException {
        try {
            return actividadLimpiezaBO.eliminarActividad(actividadLimpiezaDTO);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al eliminar la actividad de limpieza: " + e.getMessage());
        }
    }

    /**
     * Obtiene todas las actividades de limpieza registradas en el sistema.
     *
     * @return Una lista de objetos {@link ActividadLimpiezaDTO}
     * correspondientes a las actividades de limpieza.
     */
    @Override
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        return fetcherActividadLimpieza.obtenerActividadesLimpieza();
    }

    /**
     * Obtiene una actividad de limpieza específica del sistema.
     *
     * @param actividadLimpiezaDTO El objeto {@link ActividadLimpiezaDTO} que
     * representa la actividad a obtener.
     * @return El objeto {@link ActividadLimpiezaDTO} de la actividad de
     * limpieza encontrada.
     * @throws NegocioException Si ocurre un error al obtener la actividad.
     */
    @Override
    public ActividadLimpiezaDTO obtenerActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException {
        try {
            return fetcherActividadLimpieza.obtenerActividadLimpieza(actividadLimpiezaDTO);
        } catch (NegocioException e) {
            throw new NegocioException("Error al obtener la actividad de limpieza: " + e.getMessage());
        }
    }

    /**
     * Obtiene una actividad de limpieza específica por el personal asignado y
     * la hora de la actividad.
     *
     * @param actividadLimpiezaDTO El objeto {@link ActividadLimpiezaDTO} que
     * contiene los datos de la actividad.
     * @param personal El objeto {@link PersonalDTO} que representa al personal
     * asignado a la actividad.
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NoEncontradoException Si no se encuentra la actividad.
     */
    public ActividadLimpiezaDTO obtenerActividadPorPersonalYHora(ActividadLimpiezaDTO actividadLimpiezaDTO, PersonalDTO personal) throws NoEncontradoException {
        return fetcherActividadLimpieza.obtenerActividadLimpiezaPorPersonalYHora(actividadLimpiezaDTO, personal);
    }

    /**
     * Obtiene una actividad de limpieza específica por la zona y la hora de la
     * actividad.
     *
     * @param actividadLimpiezaDTO El objeto {@link ActividadLimpiezaDTO} que
     * contiene los datos de la actividad.
     * @param zona El objeto {@link ZonaDTO} que representa la zona donde se
     * realiza la actividad.
     * @return El objeto {@link ActividadLimpiezaDTO} correspondiente a la
     * actividad de limpieza.
     * @throws NoEncontradoException Si no se encuentra la actividad.
     */
    public ActividadLimpiezaDTO obtenerActividadPorZonaYHora(ActividadLimpiezaDTO actividadLimpiezaDTO, ZonaDTO zona) throws NoEncontradoException {
        return fetcherActividadLimpieza.obtenerActividadLimpiezaPorZonaYHora(actividadLimpiezaDTO, zona);
    }

}
