package administradorHabitaciones;

/**
 * Interfaz que define los métodos para la administración de habitaciones.
 */
public interface IAdministradorHabitaciones {

    /**
     * Registra una nueva habitación en el sistema.
     * @param idHabitacion el identificador único de la habitación.
     */
    void registrarHabitacion(int idHabitacion);

    /**
     * Asigna un residente a una habitación si hay espacio disponible.
     * @param idResidente la matrícula del residente.
     * @param idHabitacion el identificador único de la habitación.
     */
    void asignarHabitacion(String idResidente, int idHabitacion);

    /**
     * Libera a un residente de su habitación.
     * @param idResidente la matrícula del residente.
     * @param idHabitacion el identificador único de la habitación.
     */
    void liberarHabitacion(String idResidente, int idHabitacion);
}
