package administradorHabitaciones;

import excepciones.NegocioException;
import objetosnegocio.HabitacionBO;

public class AsignadorHabitaciones {

    private HabitacionBO habitacionBO;

    public AsignadorHabitaciones(){
        this.habitacionBO = HabitacionBO.getInstace();
    }

        /**
     * Asigna un residente a una habitación si hay espacio disponible.
     * La fachada simplemente delega la operación a la clase BO.
     * 
     * @param idResidente      el identificador del residente.
     * @param piso             El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     */
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
    public void liberarHabitacion(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        boolean liberado = habitacionBO.liberarResidente(idResidente, piso, numeroHabitacion);
        if (liberado) {
            System.out.println("Residente " + idResidente + " ha salido de la habitación " + piso + numeroHabitacion);
        } else {
            System.out.println(
                    "El residente " + idResidente + " no se encuentra en la habitación " + piso + numeroHabitacion);
        }
    }
}
