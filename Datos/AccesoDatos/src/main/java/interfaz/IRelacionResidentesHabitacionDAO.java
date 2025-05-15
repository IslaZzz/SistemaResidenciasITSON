package interfaz;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;
import java.util.List;

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

    /**
     * Consulta una habitacion segun el residente otorgado
     *
     * @param residente El objeto ResidenteDTO que representa al residente al
     * que se le encontrara su respectiva habitacion
     * @return
     */
    public abstract HabitacionDTO obtenerHabitacionDeResidente(ResidenteDTO residente);

    /**
     * Metodo que convierte una habitacion a un objeto DTO
     *
     * @param habitacion recibe como parametro una habitacion
     * @return Retorna un objeto de habitacion DTO
     */
    public HabitacionDTO parsearHabitacion(Habitacion habitacion);

    /**
     * Obtiene una lista con los nombres completos de los residentes que ocupan
     * una habitación específica, identificada por su piso y número.
     *
     * @param piso el número de piso donde se encuentra la habitación.
     * @param numero el número de la habitación.
     * @return una lista de nombres completos de los residentes asociados a la
     * habitación. Si la habitación no existe, se retorna una lista vacía.
     */
    public abstract List<String> obtenerResidentesPorHabitacion(int piso, int numero);
}
