package administradorHabitaciones;


/**
 * Interfaz que define los métodos para la administración de habitaciones.
 */
public interface IAdministradorHabitaciones {
    void registrarHabitacion(int idHabitacion);
    void asignarHabitacion(int idEstudiante, int idHabitacion);
    void liberarHabitacion(int idEstudiante, int idHabitacion);
}
