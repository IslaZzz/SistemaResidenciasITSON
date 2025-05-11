package interfaz;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import dto.ZonaDTO;
import entities.Residente;
import entities.Zona;
import exceptions.NoEncontradoException;

public interface IAccesoDatos {
    
    public abstract Residente registrarResidente(ResidenteDTO residente);

    public abstract ResidenteDTO obtenerResidente(String matricula);

    public abstract void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion);

    public abstract void deasignarHabitacion(ResidenteDTO residente);

    public abstract void registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso);

    public abstract Long obtenerCantidadHabitaciones();

    public abstract HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion);
    
    public abstract List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso);

    public abstract List<Integer> obtenerPisosDisponibles();

    public abstract List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso);

    public abstract Zona registrarZona(ZonaDTO zona);

    public abstract ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException;

    public abstract List<ZonaDTO> obtenerZonas();
}
