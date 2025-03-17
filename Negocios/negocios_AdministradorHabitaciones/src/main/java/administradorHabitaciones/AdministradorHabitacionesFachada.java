package administradorHabitaciones;

import dto.HabitacionDTO;
import objetosnegocio.HabitacionBO;

/**
 * Fachada para la administración de habitaciones.
 * Esta clase proporciona una interfaz simplificada para la gestión de habitaciones, permitiendo
 * registrar, asignar y liberar habitaciones. La implementación delega la lógica de negocio en la clase
 * {@link HabitacionBO}.
 */
public class AdministradorHabitacionesFachada {

    /**
     * Instancia de {@link HabitacionBO} que contiene la lógica de negocio para el manejo de habitaciones.
     */
    private HabitacionBO habitacionBO;

    /**
     * Construye una nueva instancia de {@code AdministradorHabitacionesFachada}.
     * Inicializa la instancia de {@code HabitacionBO} que se utiliza para gestionar las operaciones sobre las habitaciones.
     */
    public AdministradorHabitacionesFachada() {
        this.habitacionBO = new HabitacionBO();
    }

    /**
     * Registra una nueva habitación en el sistema.
     * Crea una instancia de {@link HabitacionDTO} con el identificador proporcionado y el estado "libre",
     * y la añade a la gestión interna a través de {@code HabitacionBO}.
     * @param idHabitacion el identificador único de la habitación a registrar.
     */
    public void registrarHabitacion(int idHabitacion) {
        HabitacionDTO habitacion = new HabitacionDTO(idHabitacion, false);
        habitacionBO.agregarHabitacion(habitacion);
        System.out.println("Habitación " + idHabitacion + " registrada.");
    }

    /**
     * Asigna una habitación a un estudiante.
     * Busca la habitación registrada con el identificador especificado. Si la habitación existe,
     * procede a asignarla al estudiante (marcándola como ocupada). En caso contrario, informa que la habitación
     * no se encuentra registrada.
     * @param idEstudiante el identificador del estudiante al que se asignará la habitación.
     * @param idHabitacion el identificador de la habitación a asignar.
     */
    public void asignarHabitacion(int idEstudiante, int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            habitacionBO.asignarHabitacion(idEstudiante, habitacion);
        } else {
            System.out.println("La habitación " + idHabitacion + " no existe.");
        }
    }

    /**
     * Libera una habitación, haciéndola disponible nuevamente.
     * Busca la habitación registrada con el identificador proporcionado. Si se encuentra, la libera (modifica el estado a no ocupada).
     * En caso de que la habitación no exista, se muestra un mensaje informativo.
     * @param idHabitacion el identificador de la habitación que se desea liberar.
     */
    public void liberarHabitacion(int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            habitacionBO.liberarHabitacion(habitacion);
        } else {
            System.out.println("La habitación " + idHabitacion + " no existe.");
        }
    }
}
