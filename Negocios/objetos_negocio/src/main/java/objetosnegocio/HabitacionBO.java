package objetosnegocio;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que administra la lógica de negocio relacionada con las habitaciones.
 * Esta clase se encarga de mantener un registro de las habitaciones en un mapa y ofrece métodos
 * para agregar, obtener, asignar y liberar habitaciones.
 */
public class HabitacionBO {

    /**
     * Mapa que almacena las habitaciones registradas.
     * La clave es el identificador único de la habitación (idHabitacion).
     */
    private Map<Integer, HabitacionDTO> habitaciones;

    /**
     * Construye una instancia de {@code HabitacionBO} e inicializa el mapa de habitaciones.
     */
    public HabitacionBO() {
        this.habitaciones = new HashMap<>();
    }

    /**
     * Agrega una habitación al sistema.
     * @param habitacion el objeto {@code HabitacionDTO} que se agregará.
     */
    public void agregarHabitacion(HabitacionDTO habitacion) {
        habitaciones.put(habitacion.getIdHabitacion(), habitacion);
    }

    /**
     * Obtiene la habitación correspondiente al identificador proporcionado.
     * @param idHabitacion el identificador único de la habitación.
     * @return el objeto {@link HabitacionDTO} asociado, o {@code null} si no existe.
     */
    public HabitacionDTO obtenerHabitacion(int idHabitacion) {
        return habitaciones.get(idHabitacion);
    }

    /**
     * Asigna un residente a una habitación si no ha alcanzado su capacidad máxima.
     * @param residente el objeto {@link ResidenteDTO} que se asignará a la habitación.
     * @param habitacion el objeto {@link HabitacionDTO} que representa la habitación a asignar.
     * @return {@code true} si el residente fue asignado, {@code false} si la habitación está llena.
     */
    public boolean asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        if (habitacion.getResidentesActuales().size() < 2) {
            habitacion.agregarResidente(residente);
            System.out.println("Habitación " + habitacion.getIdHabitacion() + " asignada al residente " + residente.getMatricula());
            return true; // Residente asignado con éxito
        }
        return false; // Habitación llena
    }

    /**
     * Libera a un residente de una habitación específica.
     * @param residente el objeto {@link ResidenteDTO} que se eliminará de la habitación.
     * @param habitacion el objeto {@link HabitacionDTO} en la que el residente está registrado.
     * @return {@code true} si el residente fue removido, {@code false} si no se encontraba en la habitación.
     */
    public boolean liberarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        if (habitacion.removerResidente(residente)) {
            System.out.println("El residente " + residente.getMatricula() + " ha salido de la habitación " + habitacion.getIdHabitacion());
            return true; // Residente liberado con éxito
        }
        return false; // El residente no estaba en la habitación
    }
}
