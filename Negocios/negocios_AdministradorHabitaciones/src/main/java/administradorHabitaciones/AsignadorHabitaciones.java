package administradorHabitaciones;

import dto.HabitacionDTO;
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
     * @param habitacion la habitación a asignar.
     */
    public void asignarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        boolean asignado = habitacionBO.asignarResidente(idResidente, habitacion);
        if (asignado) {
            System.out.println("Residente " + idResidente + " asignado a la habitación " + habitacion.getPiso() + habitacion.getNumero());
        } else {
            System.out.println(
                    "No se pudo asignar al residente " + idResidente + " a la habitación " + habitacion.getPiso() + habitacion.getNumero());
        }
    }

    /**
     * Libera a un residente de una habitación.
     * 
     * @param idResidente      el identificador del residente.
     * @param habitacion Habitacion a liberar
     */
    public void liberarHabitacion(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        boolean liberado = habitacionBO.liberarResidente(idResidente, habitacion);
        if (liberado) {
            System.out.println("Residente " + idResidente + " ha salido de la habitación " + habitacion.getPiso() + habitacion.getNumero());
        } else {
            System.out.println(
                    "El residente " + idResidente + " no se encuentra en la habitación " + habitacion.getPiso() + habitacion.getNumero());
        }
    }
}
