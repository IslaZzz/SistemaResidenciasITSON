package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.HabitacionBO;

public class FetcherHabitaciones {

    /**
     * Objeto de negocio encargado de la lógica relacionada con las
     * habitaciones. Se utiliza para acceder a operaciones como consulta de
     * pisos, habitaciones disponibles y recomendaciones de habitaciones.
     */
    private HabitacionBO habitacionBO;

    /**
     * Constructor del fetcher habitaciones obtiene la instancia del objeto de
     * negocio
     */
    public FetcherHabitaciones() {
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
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException {
        return habitacionBO.obtenerHabitacionesDisponiblesParaResidente(residente, piso);
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
     * @param piso el piso a buscar.
     * @return una lista de habitaciones disponibles en el piso.
     */
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso) {
        return habitacionBO.obtenerNumerosHabitacionDisponibles(piso);
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente
     * específico.
     *
     * @param residente Residente para el cual se buscan las habitaciones
     * @param piso Piso en el que se buscan las habitaciones
     * @return
     * @throws NegocioException
     */
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException {
        List<HabitacionDTO> habitacionesRecomendadas = habitacionBO.obtenerHabitacionesRecomendadas(residente, piso);
        if (habitacionesRecomendadas.isEmpty()) {
            throw new NegocioException("No hay habitaciones recomendadas para el residente en el piso " + piso);
        }
        return habitacionesRecomendadas;
    }
}
