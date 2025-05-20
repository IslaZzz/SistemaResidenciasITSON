package interfaz;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;

/**
 * Interfaz que define los métodos para gestionar las habitaciones en el
 * sistema. Permite realizar operaciones como registrar, obtener, eliminar y
 * obtener información sobre habitaciones.
 */
public interface IHabitacionesDAO {

    /**
     * Realiza un registro masivo de habitaciones en la base de datos. Este
     * método es utilizado en la primera ejecución del programa para crear las
     * habitaciones de acuerdo con el número de pisos y habitaciones por piso
     * especificado.
     *
     * @param numeroPisos El número de pisos del edificio.
     * @param numeroHabitacionesPorPiso El número de habitaciones que habrá en
     * cada piso.
     * @return Una lista de objetos Habitacion que representa las habitaciones
     * creadas.
     */
    public abstract List<Habitacion> registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso);

    /**
     * Registra una nueva habitación en la base de datos.
     *
     * @param habitacion El objeto HabitacionDTO con los datos de la habitación
     * a registrar.
     * @return Un objeto Habitacion que representa la habitación registrada.
     */
    public abstract Habitacion registrarHabitacion(HabitacionDTO habitacion);

    /**
     * Obtiene una habitación específica de la base de datos.
     *
     * @param habitacion El objeto HabitacionDTO con los datos de la habitación
     * a obtener.
     * @return Un objeto HabitacionDTO que representa la habitación encontrada.
     */
    public abstract HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion);

    /**
     * Obtiene una lista de habitaciones disponibles en un piso específico.
     *
     * @param piso El número del piso donde se buscan las habitaciones
     * disponibles.
     * @return Una lista de objetos HabitacionDTO que representan las
     * habitaciones disponibles en el piso dado.
     */
    public abstract List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso);

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente
     * específico en un piso dado.
     *
     * @param residente El objeto ResidenteDTO que representa al residente.
     * @param piso El número de piso donde se buscan las habitaciones
     * recomendadas.
     * @return Una lista de objetos HabitacionDTO que representan las
     * habitaciones recomendadas.
     */
    public abstract List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso);

    /**
     * Elimina una habitación de la base de datos.
     *
     * @param habitacion El objeto HabitacionDTO con los datos de la habitación
     * a eliminar.
     * @return Un valor booleano que indica si la habitación fue eliminada
     * exitosamente.
     */
    public abstract boolean eliminarHabitacion(HabitacionDTO habitacion);

    /**
     * Obtiene la cantidad total de habitaciones en la base de datos.
     *
     * @return El número total de habitaciones en la base de datos.
     */
    public abstract Long obtenerCantidadHabitaciones();

    /**
     * Obtiene una lista de pisos disponibles en el sistema.
     *
     * @return Una lista de números de pisos disponibles.
     */
    public abstract List<Integer> obtenerPisosDisponibles();

    /**
     * Metodo para liberar una habitacion.
     * @param habitacion
     * @return true si se logra liberar, false si no.
     */
    boolean liberarHabitacion(HabitacionDTO habitacion);
}
