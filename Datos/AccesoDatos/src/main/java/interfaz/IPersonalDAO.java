package interfaz;

import java.util.List;

import dto.PersonalDTO;
import entities.Personal;
import enums.Puesto;
import exceptions.NoEncontradoException;

public interface IPersonalDAO {

    public abstract Personal registrarPersonal(PersonalDTO personal);

    public abstract Personal obtenerPersonal(PersonalDTO personal) throws NoEncontradoException;

    public abstract boolean eliminarPersonal(PersonalDTO personal) throws NoEncontradoException;

    public abstract List<Personal> obtenerPersonalPorPuesto(Puesto puesto);

}
