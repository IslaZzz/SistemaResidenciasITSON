package administradorHabitaciones;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import objetosnegocio.HabitacionBO;

/**
 * Fachada para la administración de habitaciones.
 * Solo actúa como intermediario entre las capas superiores y la lógica de negocio (BO).
 */
public class AdministradorHabitacionesFachada {

    private HabitacionBO habitacionBO;

    /**
     * Inicializa la instancia de {@code HabitacionBO}.
     */
    public AdministradorHabitacionesFachada() {
        this.habitacionBO = new HabitacionBO();
    }

    /**
     * Registra una nueva habitación llamando a la lógica de negocio.
     * @param idHabitacion el identificador único de la habitación.
     */
    public void registrarHabitacion(int idHabitacion) {
        habitacionBO.agregarHabitacion(new HabitacionDTO(idHabitacion));
        System.out.println("Habitación " + idHabitacion + " registrada.");
    }

    /**
     * Asigna un residente a una habitación si hay espacio disponible.
<<<<<<< Updated upstream
     * La fachada simplemente delega la operación a la clase BO.
     * @param idResidente el identificador del residente.
     * @param idHabitacion el identificador de la habitación.
     */
    public void asignarResidente(String idResidente, int idHabitacion) {
        boolean asignado = habitacionBO.asignarResidente(idResidente, idHabitacion);
        if (asignado) {
            System.out.println("Residente " + idResidente + " asignado a la habitación " + idHabitacion);
=======
     * @param idResidente el identificador del residente.
     * @param idHabitacion el identificador de la habitación.
     */
    @Override
    public void asignarHabitacion(int idResidente, int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            // Crear el objeto ResidenteDTO con el idResidente
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            
            // Asignar la habitación
            boolean asignado = habitacion.agregarResidente(residente);
            if (asignado) {
                System.out.println("Residente " + idResidente + " asignado a habitación " + idHabitacion);
            } else {
                System.out.println("La habitación " + idHabitacion + " ya está ocupada por dos estudiantes.");
            }
>>>>>>> Stashed changes
        } else {
            System.out.println("No se pudo asignar al residente " + idResidente + " a la habitación " + idHabitacion);
        }
    }

    /**
<<<<<<< Updated upstream
     * Libera a un residente de una habitación.
     * @param idResidente el identificador del residente.
     * @param idHabitacion el identificador de la habitación.
     */
    public void liberarResidente(String idResidente, int idHabitacion) {
        boolean liberado = habitacionBO.liberarResidente(idResidente, idHabitacion);
        if (liberado) {
            System.out.println("Residente " + idResidente + " ha salido de la habitación " + idHabitacion);
=======
     * Libera a un estudiante de su habitación.
     * @param idResidente el identificador del estudiante.
     * @param idHabitacion el identificador de la habitación.
     */

    @Override
    public void liberarHabitacion(int idResidente, int idHabitacion) {
        HabitacionDTO habitacion = habitacionBO.obtenerHabitacion(idHabitacion);
        if (habitacion != null) {
            // Crear el objeto ResidenteDTO con el idEstudiante
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            
            // Liberar la habitación
            boolean liberado = habitacion.removerResidente(residente);
            if (liberado) {
                System.out.println("Residente " + idResidente + " ha salido de la habitación " + idHabitacion);
            } else {
                System.out.println("El Residente " + idResidente + " no está en la habitación " + idHabitacion);
            }
>>>>>>> Stashed changes
        } else {
            System.out.println("El residente " + idResidente + " no se encuentra en la habitación " + idHabitacion);
        }
    }
}
