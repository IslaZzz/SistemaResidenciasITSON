package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

/**
 * Fachada para la administración de habitaciones.
 * Solo actúa como intermediario entre las capas superiores y la lógica de
 * negocio (BO).
 */
public class AdministradorHabitacionesFachada implements IAdministradorHabitaciones{

    private AsignadorHabitaciones asignador;
    private FetcherHabitaciones fetcher;

    /**
     * Inicializa la instancia de {@code HabitacionBO}.
     */
    public AdministradorHabitacionesFachada() {
        this.asignador = new AsignadorHabitaciones();
        this.fetcher = new FetcherHabitaciones();
    }

    /**
     * Asigna un residente a una habitación si hay espacio disponible.
     * La fachada simplemente delega la operación a la clase BO.
     * 
     * @param idResidente      el identificador del residente.
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    @Override
    public void asignarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        asignador.asignarHabitacion(idResidente, habitacion);
    }

    /**
     * Libera a un residente de una habitación.
     * 
     * @param idResidente      el identificador del residente.
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    @Override
    public void liberarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        asignador.liberarHabitacion(idResidente, habitacion);
    }

    /**
     * Obtiene una habitación específica.
     * 
     * @param piso             El piso de la habitación
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
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException {
        return fetcher.obtenerHabitacionesDisponibles(residente);
    }

    /**
     * Obtiene los pisos disponibles en la lista de habitaciones.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @return una lista de pisos disponibles.
     */
    @Override
    public List<Integer> obtenerTodosLosPisos() {
        return fetcher.obtenerTodosLosPisos();
    }

    /**
     * Obtiene las habitaciones disponibles en un piso específico.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @param piso         el piso a buscar.
     * @return una lista de habitaciones disponibles en el piso.
     */
    @Override
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso) {
        return fetcher.obtenerHabitacionesDisponiblesEnPiso(piso);
    }
    

}
