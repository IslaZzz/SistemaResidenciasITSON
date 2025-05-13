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
     *
     * @param residente residente a liberar de su habitación.
     */
    void desasignarHabitacion(ResidenteDTO residente);

    /**
     * Asigna un residente a una habitación si hay espacio disponible.
     *
     * @param residente residente a asignar en la habitación
     * @param habitacion La habitación a asignar
     */
    void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) throws NegocioException;

    /**
     * Obtiene una lista de habitaciones disponibles.
     *
     * @return una lista de habitaciones disponibles.
     */
    List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException;

    /**
     * Obtiene una habitación específica.
     *
     * @param habitacion Habitacion a buscar
     * @return la habitación solicitada.
     */
    HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) throws NegocioException;

    /**
     * Obtiene una lista con todos los números de piso disponibles en el
     * sistema.
     *
     * @return una lista de enteros que representan los pisos disponibles.
     */
    List<Integer> obtenerTodosLosPisos();

    /**
     * Obtiene una lista con los números de las habitaciones disponibles en un
     * piso específico.
     *
     * @param piso el número del piso para el cual se desean consultar las
     * habitaciones disponibles.
     * @return una lista de enteros que representan los números de habitación
     * disponibles en el piso indicado.
     */
    List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso);

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente
     * específico en un piso determinado. La lógica de recomendación puede estar
     * basada en las características del residente y las habitaciones
     * disponibles.
     *
     * @param residente el objeto {@code ResidenteDTO} que representa al
     * residente para quien se realiza la recomendación.
     * @param piso el número del piso en el que se desea buscar habitaciones
     * recomendadas.
     * @return una lista de objetos {@code HabitacionDTO} que representan las
     * habitaciones recomendadas.
     * @throws NegocioException si ocurre un error en la lógica de negocio al
     * generar las recomendaciones.
     */
    List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException;

}
