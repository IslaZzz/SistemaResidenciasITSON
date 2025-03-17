package objetosnegocio;

import dto.HabitacionDTO;
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
     * Inserta el objeto {@link HabitacionDTO} en el mapa de habitaciones utilizando su identificador
     * único como clave.
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
     * Asigna una habitación a un estudiante marcándola como ocupada.
     * Este método modifica el estado de la habitación a ocupada y muestra un mensaje en la consola
     * indicando la asignación.
     * @param idEstudiante el identificador del estudiante al que se asigna la habitación.
     * @param habitacion   el objeto {@link HabitacionDTO} que representa la habitación a asignar.
     */
    public void asignarHabitacion(int idEstudiante, HabitacionDTO habitacion) {
        habitacion.setOcupada(true);
        System.out.println("Habitación " + habitacion.getIdHabitacion() 
                + " asignada al estudiante " + idEstudiante);
    }

    /**
     * Libera una habitación, marcándola como desocupada.
     * Actualiza el estado de la habitación a no ocupada y muestra un mensaje en la consola confirmando
     * la liberación.
     * @param habitacion el objeto {@link HabitacionDTO} que se desea liberar.
     */
    public void liberarHabitacion(HabitacionDTO habitacion) {
        habitacion.setOcupada(false);
        System.out.println("Habitación " + habitacion.getIdHabitacion() + " liberada.");
    }
}
