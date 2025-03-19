package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
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
     * Asigna un residente a una habitación si hay espacio disponible.
     * La fachada simplemente delega la operación a la clase BO.
     * @param idResidente el identificador del residente.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    public void asignarResidente(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        boolean asignado = habitacionBO.asignarResidente(idResidente, piso, numeroHabitacion);
        if (asignado) {
            System.out.println("Residente " + idResidente + " asignado a la habitación " + piso + numeroHabitacion);
        } else {
            System.out.println("No se pudo asignar al residente " + idResidente + " a la habitación " + piso + numeroHabitacion);
        }
    }

    /**
     * Libera a un residente de una habitación.
     * @param idResidente el identificador del residente.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    public void liberarResidente(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        boolean liberado = habitacionBO.liberarResidente(idResidente, piso, numeroHabitacion);
        if (liberado) {
            System.out.println("Residente " + idResidente + " ha salido de la habitación " + piso + numeroHabitacion);
        } else {
            System.out.println("El residente " + idResidente + " no se encuentra en la habitación " + piso + numeroHabitacion);
        }
    }

    /**
     * Obtiene una habitación específica.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return La habitación solicitada o {@code null} si no existe.
     */
    public HabitacionDTO obtenerHabitacion(String piso, int numeroHabitacion) throws NegocioException {
        return habitacionBO.obtenerHabitacion(piso, numeroHabitacion);
    }

    /**
     * Obtiene todas las habitaciones disponibles.
     * @param residente El residente a buscar.
     * @return Una lista con todas las habitaciones disponibles.
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) {
        return habitacionBO.obtenerHabitacionesDisponibles(residente);
    }
}
