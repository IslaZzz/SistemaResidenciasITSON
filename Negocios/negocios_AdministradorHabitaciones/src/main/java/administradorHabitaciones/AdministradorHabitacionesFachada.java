package administradorHabitaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.HabitacionBO;

/**
 * Fachada para la administración de habitaciones.
 * Solo actúa como intermediario entre las capas superiores y la lógica de
 * negocio (BO).
 */
public class AdministradorHabitacionesFachada implements IAdministradorHabitaciones{

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
     * 
     * @param idResidente      el identificador del residente.
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    @Override
    public void asignarHabitacion(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        boolean asignado = habitacionBO.asignarResidente(idResidente, piso, numeroHabitacion);
        if (asignado) {
            System.out.println("Residente " + idResidente + " asignado a la habitación " + piso + numeroHabitacion);
        } else {
            System.out.println(
                    "No se pudo asignar al residente " + idResidente + " a la habitación " + piso + numeroHabitacion);
        }
    }

    /**
     * Libera a un residente de una habitación.
     * 
     * @param idResidente      el identificador del residente.
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
    @Override
    public void liberarHabitacion(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        boolean liberado = habitacionBO.liberarResidente(idResidente, piso, numeroHabitacion);
        if (liberado) {
            System.out.println("Residente " + idResidente + " ha salido de la habitación " + piso + numeroHabitacion);
        } else {
            System.out.println(
                    "El residente " + idResidente + " no se encuentra en la habitación " + piso + numeroHabitacion);
        }
    }

    /**
     * Obtiene una habitación específica.
     * 
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return La habitación solicitada o {@code null} si no existe.
     */
    @Override
    public HabitacionDTO obtenerHabitacion(String piso, int numeroHabitacion) throws NegocioException {
        return habitacionBO.obtenerHabitacion(piso, numeroHabitacion);
    }

    /**
     * Obtiene todas las habitaciones disponibles.
     * 
     * @param residente El residente a buscar.
     * @return Una lista con todas las habitaciones disponibles.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException {
        return habitacionBO.obtenerHabitacionesDisponibles(residente);
    }

    /**
     * Obtiene los pisos disponibles en la lista de habitaciones.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @return una lista de pisos disponibles.
     */
    @Override
    public List<String> obtenerPisosDisponibles(List<HabitacionDTO> habitaciones) {
        return habitacionBO.obtenerPisosDisponibles(habitaciones);

    }

    /**
     * Obtiene las habitaciones disponibles en un piso específico.
     * 
     * @param habitaciones la lista de habitaciones disponibles.
     * @param piso         el piso a buscar.
     * @return una lista de habitaciones disponibles en el piso.
     */
    @Override
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(List<HabitacionDTO> habitaciones, String piso) {
        return habitacionBO.obtenerNumerosHabitacionDisponibles(habitaciones, piso);
    }

}
