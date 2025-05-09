package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.HabitacionBO;

public class FetcherHabitaciones {
    
    private HabitacionBO habitacionBO;
    
    /**
     * Constructor del fetcher habitaciones obtiene la instancia del objeto de negocio
     */
    public FetcherHabitaciones(){
        this.habitacionBO = HabitacionBO.getInstace();
    }

    /**
     * Obtiene una habitación específica.
     * 
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return La habitación solicitada o {@code null} si no existe.
     */
    public HabitacionDTO obtenerHabitacion(String piso, int numeroHabitacion) throws NegocioException {
        return habitacionBO.obtenerHabitacion(piso, numeroHabitacion);
    }

    /**
     * Obtiene todas las habitaciones disponibles.
     * 
     * @param residente El residente a buscar.
     * @return Una lista con todas las habitaciones disponibles.
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException {
        return habitacionBO.obtenerHabitacionesDisponibles(residente);
    }

    /**
     * Obtiene los pisos disponibles en la lista de habitaciones.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @return una lista de pisos disponibles.
     */
    public List<String> obtenerPisosDisponibles(List<HabitacionDTO> habitaciones) {
        return habitacionBO.obtenerPisosDisponibles(habitaciones);

    }

    /**
     * Obtiene las habitaciones disponibles en un piso específico.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @param piso         el piso a buscar.
     * @return una lista de habitaciones disponibles en el piso.
     */
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(List<HabitacionDTO> habitaciones, String piso) {
        return habitacionBO.obtenerNumerosHabitacionDisponibles(habitaciones, piso);
    }

    public List<String> obtenerPisos (){
        return habitacionBO.obtenerTodosLosPisos();
    }
}
