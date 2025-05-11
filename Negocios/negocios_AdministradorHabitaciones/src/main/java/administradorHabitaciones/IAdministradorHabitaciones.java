package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define los métodos para la administración de habitaciones.
 */
public interface IAdministradorHabitaciones {

    /**
     * Libera a un residente de su habitación.
     * @param residente residente a liberar de su habitación.
     */
    void desasignarHabitacion(ResidenteDTO residente);

    /**
     * Asigna un residente a una habitación si hay espacio disponible.
     * @param residente  residente a asignar en la habitación
     * @param habitacion La habitación a asignar
     */
    void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) throws NegocioException;

    /**
     * Obtiene una lista de habitaciones disponibles.
     * @return una lista de habitaciones disponibles.
     */
    List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException;
    
    /**
     * Obtiene una habitación específica.
     * @param habitacion Habitacion a buscar
     * @return la habitación solicitada.
     */ 
    HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) throws NegocioException;

    List<Integer> obtenerTodosLosPisos();

    List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso);

    List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException;;
    
}
