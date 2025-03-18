package administradorHabitaciones;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import objetosnegocio.HabitacionBO;

/**
 * Fachada para la administración de habitaciones.
 * Permite registrar, asignar y liberar habitaciones con hasta dos residentes.
 * Implementa la interfaz IAdministradorHabitaciones.
 */
public class AdministradorHabitacionesFachada implements IAdministradorHabitaciones {

    private HabitacionBO habitacionBO;

    /**
     * Inicializa la instancia de {@code HabitacionBO}.
     */
    public AdministradorHabitacionesFachada() {
        this.habitacionBO = new HabitacionBO();
    }

    /**
     * Registra una nueva habitación en el sistema.
     * @param idHabitacion el identificador único de la habitación.
     */
    @Override
    public void registrarHabitacion(int idHabitacion) {
        HabitacionDTO habitacion = new HabitacionDTO(idHabitacion);
        habitacionBO.agregarHabitacion(habitacion);
        System.out.println("Habitación " + idHabitacion + " registrada.");
    }

    /**
     * Asigna un estudiante a una habitación si hay espacio disponible.
     * @param idEstudiante el identificador del estudiante.
     * @param idHabitacion el identificador de la habitación.
     */
    @Override
    public void asignarHabitacion(int idEstudiante, int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            // Crear el objeto ResidenteDTO con el idEstudiante
            ResidenteDTO residente = new ResidenteDTO(idEstudiante);
            
            // Asignar la habitación
            boolean asignado = habitacion.agregarResidente(residente);
            if (asignado) {
                System.out.println("Estudiante " + idEstudiante + " asignado a habitación " + idHabitacion);
            } else {
                System.out.println("La habitación " + idHabitacion + " ya está ocupada por dos estudiantes.");
            }
        } else {
            System.out.println("La habitación " + idHabitacion + " no existe.");
        }
    }

    /**
     * Libera a un estudiante de su habitación.
     * @param idEstudiante el identificador del estudiante.
     * @param idHabitacion el identificador de la habitación.
     */

    @Override
    public void liberarHabitacion(int idEstudiante, int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            // Crear el objeto ResidenteDTO con el idEstudiante
            ResidenteDTO residente = new ResidenteDTO(idEstudiante);
            
            // Liberar la habitación
            boolean liberado = habitacion.removerResidente(residente);
            if (liberado) {
                System.out.println("Estudiante " + idEstudiante + " ha salido de la habitación " + idHabitacion);
            } else {
                System.out.println("El estudiante " + idEstudiante + " no está en la habitación " + idHabitacion);
            }
        } else {
            System.out.println("La habitación " + idHabitacion + " no existe.");
        }
    }
}
