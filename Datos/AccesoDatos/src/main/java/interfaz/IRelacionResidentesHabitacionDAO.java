package interfaz;

import dto.HabitacionDTO;
import dto.ResidenteDTO;

public interface IRelacionResidentesHabitacionDAO {

    public abstract void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion);

    public abstract void desasignarHabitacion(ResidenteDTO residente);

}
