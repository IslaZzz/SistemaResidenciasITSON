package administradorHabitaciones;


/**
 * Interfaz que define los métodos para la administración de habitaciones.
 */
public interface IAdministradorHabitaciones {
    void registrarHabitacion(int idHabitacion);
    void asignarHabitacion(String idEstudiante, int idHabitacion);
    void liberarHabitacion(String idEstudiante, int idHabitacion);
}
