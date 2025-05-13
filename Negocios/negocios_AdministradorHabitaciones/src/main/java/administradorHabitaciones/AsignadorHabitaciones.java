package administradorHabitaciones;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import objetosnegocio.HabitacionBO;

/**
 * /**
 * La clase {@code AsignadorHabitaciones} se encarga de gestionar la asignación
 * de habitaciones a residentes dentro del sistema.
 *
 * <p>
 * Esta clase puede incluir lógica para verificar disponibilidad de
 * habitaciones, asignar residentes a habitaciones específicas, y actualizar los
 * registros correspondientes.</p>
 *
 * <p>
 * Forma parte del subsistema de gestión de alojamiento del sistema.</p>
 */
public class AsignadorHabitaciones {

    /**
     * Objeto de negocio encargado de gestionar las operaciones relacionadas con
     * las habitaciones, como la obtención de pisos disponibles, habitaciones
     * libres y recomendaciones personalizadas.
     */
    private HabitacionBO habitacionBO;

    /**
     * Crea una nueva instancia de {@code AsignadorHabitaciones} e inicializa el
     * objeto de negocio {@code HabitacionBO} utilizando su instancia única.
     */
    public AsignadorHabitaciones() {
        this.habitacionBO = HabitacionBO.getInstace();
    }

    /**
     * Asigna un residente a una habitación si hay espacio disponible. La
     * fachada simplemente delega la operación a la clase BO.
     *
     * @param residente residente a asignar en la habitación.
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
