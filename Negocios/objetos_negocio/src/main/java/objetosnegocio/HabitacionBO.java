package objetosnegocio;

import dto.HabitacionDTO;
import dto.ResidenteDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que administra la lógica de negocio relacionada con las habitaciones.
 * Se encarga de agregar, obtener, asignar y liberar residentes en las habitaciones.
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
     * @param idResidente la matrícula del residente.
     * @param idHabitacion el identificador de la habitación.
     * @return {@code true} si el residente fue asignado, {@code false} si la habitación está llena o no existe.
     */
    public boolean asignarResidente(String idResidente, int idHabitacion) {
        HabitacionDTO habitacion = habitaciones.get(idHabitacion);

        if (habitacion != null) {
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            if (habitacion.agregarResidente(residente)) {
                System.out.println("Residente " + idResidente + " asignado a la habitación " + idHabitacion);
                return true;
            } else {
                System.out.println("La habitación " + idHabitacion + " está llena.");
                return false;
            }
        }
        
        System.out.println("La habitación " + idHabitacion + " no existe.");
        return false;
    }

    /**
     * Libera a un residente de una habitación específica.
     * @param idResidente la matrícula del residente.
     * @param idHabitacion el identificador de la habitación.
     * @return {@code true} si el residente fue removido, {@code false} si no se encontraba en la habitación.
     */
    public boolean liberarResidente(String idResidente, int idHabitacion) {
        HabitacionDTO habitacion = habitaciones.get(idHabitacion);

        if (habitacion != null) {
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            
            if (habitacion.removerResidente(residente)) {
                System.out.println("Residente " + idResidente + " liberado de la habitación " + idHabitacion);
                return true;
            } else {
                System.out.println("El residente " + idResidente + " no estaba en la habitación " + idHabitacion);
                return false;
            }
        }
        
        System.out.println("La habitación " + idHabitacion + " no existe.");
        return false;
    }
}
