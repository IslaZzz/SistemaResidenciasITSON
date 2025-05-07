package interfaz;

import dto.ResidenteDTO;
import entities.Residente;

public interface IAccesoDatos {
    
    public abstract Residente registrarResidente(ResidenteDTO residente);

    public abstract ResidenteDTO obtenerResidente(String matricula);
}
