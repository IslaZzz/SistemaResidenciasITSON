package interfaz;

import java.util.List;

import dto.PersonalDTO;
import entities.Personal;
import enums.Puesto;
import exceptions.NoEncontradoException;

/**
 * Interfaz que define los métodos para gestionar el personal en el sistema.
 * Permite realizar operaciones como registrar, obtener, eliminar y consultar
 * información sobre el personal.
 */
public interface IPersonalDAO {

    /**
     * Registra un nuevo miembro del personal en la base de datos.
     *
     * @param personal El objeto PersonalDTO con los datos del personal a
     * registrar.
     * @return Un objeto Personal que representa al personal registrado.
     */
    public abstract Personal registrarPersonal(PersonalDTO personal);

    /**
     * Obtiene un miembro del personal específico de la base de datos.
     *
     * @param personal El objeto PersonalDTO con los datos del personal a
     * obtener.
     * @return Un objeto Personal que representa al personal encontrado.
     * @throws NoEncontradoException Si no se encuentra el personal.
     */
    public abstract Personal obtenerPersonal(PersonalDTO personal) throws NoEncontradoException;

    /**
     * Elimina un miembro del personal de la base de datos.
     *
     * @param personal El objeto PersonalDTO con los datos del personal a
     * eliminar.
     * @return Un valor booleano que indica si el personal fue eliminado
     * exitosamente.
     * @throws NoEncontradoException Si no se encuentra el personal.
     */
    public abstract boolean eliminarPersonal(PersonalDTO personal) throws NoEncontradoException;

    /**
     * Obtiene una lista de miembros del personal que ocupan un puesto
     * específico.
     *
     * @param puesto El puesto que se busca entre los miembros del personal.
     * @return Una lista de objetos Personal que representan al personal con el
     * puesto especificado.
     */
    public abstract List<Personal> obtenerPersonalPorPuesto(Puesto puesto);

}
