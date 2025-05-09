package interfaz;

import dto.ResidenteDTO;
import entities.Residente;

/**
 * @author pc
 */
public interface IResidentesDAO {
    
    public abstract Residente registrarResidente(ResidenteDTO residente);
    
    public abstract ResidenteDTO obtenerResidente(String matricula);

    public abstract ResidenteDTO asignarHabitacion(String matricula, String idHabitacion);
}
