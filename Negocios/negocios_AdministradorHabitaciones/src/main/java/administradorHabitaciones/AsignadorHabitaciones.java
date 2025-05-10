package administradorHabitaciones;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
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
     * @param residente  residente a asignar en la habitación.
     * @param habitacion la habitación a asignar.
     */
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
       habitacionBO.asignarHabitacion(residente, habitacion);
    }

    /**
     * Libera a un residente de una habitación.
     * 
     * @param residente el residente a liberar de su habitación.
     */
    public void desasignarHabitacion(ResidenteDTO residente) {
        habitacionBO.desasignarHabitacion(residente);
    }
}
