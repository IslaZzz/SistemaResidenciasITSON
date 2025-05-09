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
     * @param habitacion La habitacion a buscar
     * @return La habitación solicitada o {@code null} si no existe.
     */
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) throws NegocioException {
        return habitacionBO.obtenerHabitacion(habitacion);
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
     * Obtiene los pisos disponibles.
     * 
     * @return una lista de pisos disponibles.
     */
    public List<Integer> obtenerTodosLosPisos() {
        return habitacionBO.obtenerTodosLosPisos();

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
}
