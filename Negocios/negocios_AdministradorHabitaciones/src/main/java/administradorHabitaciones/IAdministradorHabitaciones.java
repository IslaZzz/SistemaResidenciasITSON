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
     * Asigna un residente a una habitación si hay espacio disponible.
     * @param idResidente la matrícula del residente.
     * @param habitacion la habitación a asignar.
     */
    void asignarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException;

    /**
     * Libera a un residente de su habitación.
     * @param idResidente la matrícula del residente.
     * @param habitacion la habitacion a liberar
     */
    void liberarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException;

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
    
}
