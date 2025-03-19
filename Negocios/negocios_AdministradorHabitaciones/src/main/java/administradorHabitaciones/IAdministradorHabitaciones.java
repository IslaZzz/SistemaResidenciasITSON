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
     * @param idHabitacion el identificador único de la habitación.
     */
    void asignarHabitacion(String idResidente, String piso, int numHabitacion) throws NegocioException;

    /**
     * Libera a un residente de su habitación.
     * @param idResidente la matrícula del residente.
     * @param idHabitacion el identificador único de la habitación.
     */
    void liberarHabitacion(String idResidente, String piso, int numHabitacion) throws NegocioException;

    /**
     * Obtiene una lista de habitaciones disponibles.
     * @return una lista de habitaciones disponibles.
     */
    List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException;
    
    /**
     * Obtiene una habitación específica.
     * @param piso el piso de la habitación.
     * @param numeroHabitacion el número de la habitación.
     * @return la habitación solicitada.
     */
    HabitacionDTO obtenerHabitacion(String piso, int numeroHabitacion) throws NegocioException;


    List<String> obtenerPisosDisponibles(List<HabitacionDTO> habitaciones);

    List<Integer> obtenerHabitacionesDisponiblesEnPiso(List<HabitacionDTO> habitaciones, String piso);


    
}
