package interfaz;

import java.util.List;

import dto.HabitacionDTO;
import entities.Habitacion;

public interface IHabitacionesDAO {

    /**
     * Metodo que realiza un registro masivo de habitaciones en la base de datos.
     * Usado en la primera ejecución del programa para crear las habitaciones.
     * @param numeroPisos Numero de pisos que tendrá el edificio
     * @param numeroHabitacionesPorPiso Numero de habitaciones por piso
     */
    public abstract List<Habitacion> registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso);

    public abstract Habitacion registrarHabitacion(HabitacionDTO habitacion);

    public abstract HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion);

    public abstract List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso);
    
    public abstract boolean eliminarHabitacion(HabitacionDTO habitacion);

    /**
     * Metodo que obtiene la cantidad de habitaciones en la base de datos.
     * @return Numero de habitaciones en la base de datos.
     */
    public abstract  Long obtenerCantidadHabitaciones();

}
