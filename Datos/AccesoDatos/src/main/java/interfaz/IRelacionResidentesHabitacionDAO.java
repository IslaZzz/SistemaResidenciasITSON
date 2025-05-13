package interfaz;

import dto.HabitacionDTO;
import dto.ResidenteDTO;

/**
 * Interfaz que define los métodos para gestionar la relación entre residentes y
 * habitaciones. Permite asignar o desasignar una habitación a un residente en
 * el sistema.
 */
public interface IRelacionResidentesHabitacionDAO {

    /**
     * Asigna una habitación a un residente en el sistema.
     *
     * @param residente El objeto ResidenteDTO que representa al residente al
     * que se asignará la habitación.
     * @param habitacion El objeto HabitacionDTO que representa la habitación
     * que se asignará al residente.
     */
    public abstract void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion);

    /**
     * Desasigna una habitación de un residente en el sistema.
     *
     * @param residente El objeto ResidenteDTO que representa al residente al
     * que se le desasignará la habitación.
     */
    public abstract void desasignarHabitacion(ResidenteDTO residente);

}
