package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

/**
 * Fachada para la administración de habitaciones. Solo actúa como intermediario
 * entre las capas superiores y la lógica de negocio (BO).
 */
public class AdministradorHabitacionesFachada implements IAdministradorHabitaciones {

    /**
     * Encargado de asignar habitaciones a residentes, utilizando lógica de
     * negocio para recomendaciones y disponibilidad según criterios definidos.
     */
    private AsignadorHabitaciones asignador;

    /**
     * Encargado de recuperar información relacionada con las habitaciones, como
     * pisos disponibles y habitaciones libres en un piso determinado.
     */
    private FetcherHabitaciones fetcher;

    /**
     * Inicializa la instancia de {@code HabitacionBO}.
     */
    public AdministradorHabitacionesFachada() {
        this.asignador = new AsignadorHabitaciones();
        this.fetcher = new FetcherHabitaciones();
    }

    /**
     * Asigna un residente a una habitación si hay espacio disponible. La
     * fachada simplemente delega la operación a la clase BO.
     *
     * @param residente residente a asignar en la habitación
     * @param habitacion La habitación a asignar
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        asignador.asignarHabitacion(residente, habitacion);
    }

    /**
     * Libera a un residente de una habitación.
     *
     * @param residente el residente a liberar de su habitación.
     */
    @Override
    public void desasignarHabitacion(ResidenteDTO residente) {
        asignador.desasignarHabitacion(residente);
    }

    /**
     * Obtiene una habitación específica.
     *
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return La habitación solicitada o {@code null} si no existe.
     */
    @Override
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) throws NegocioException {
        return fetcher.obtenerHabitacion(habitacion);
    }

    /**
     * Obtiene todas las habitaciones disponibles.
     *
     * @param residente El residente a buscar.
     * @return Una lista con todas las habitaciones disponibles.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException {
        return fetcher.obtenerHabitacionesDisponiblesParaResidente(residente, piso);
    }

    /**
     * Obtiene los pisos disponibles en la lista de habitaciones.
     *
     * @return una lista de pisos disponibles.
     */
    @Override
    public List<Integer> obtenerTodosLosPisos() {
        return fetcher.obtenerTodosLosPisos();
    }

    /**
     * Obtiene las habitaciones disponibles en un piso específico.
     *
     * @param piso el piso a buscar.
     * @return una lista de habitaciones disponibles en el piso.
     */
    @Override
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso) {
        return fetcher.obtenerHabitacionesDisponiblesEnPiso(piso);
    }

    @Override
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso)
            throws NegocioException {
        return fetcher.obtenerHabitacionesRecomendadas(residente, piso);
    }

}
