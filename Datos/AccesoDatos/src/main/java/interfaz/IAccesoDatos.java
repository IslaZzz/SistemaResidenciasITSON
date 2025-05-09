package interfaz;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Residente;

public interface IAccesoDatos {
    
    public abstract Residente registrarResidente(ResidenteDTO residente);

    public abstract ResidenteDTO obtenerResidente(String matricula);

    public abstract void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion);

    public abstract void registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso);

    public abstract Long obtenerCantidadHabitaciones();

    public abstract HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion);
    
}
