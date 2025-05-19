package interfaz;

import dto.ResidenteDTO;
import entities.Residente;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar los residentes en el sistema.
 * Permite registrar y obtener información de un residente en el sistema.
 *
 * @author pc
 */
public interface IResidentesDAO {

    /**
     * Registra un nuevo residente en el sistema.
     *
     * @param residente El objeto ResidenteDTO que contiene los datos del
     * residente a registrar.
     * @return Un objeto Residente que representa al residente registrado,
     * incluyendo su identificador único.
     */
    public abstract Residente registrarResidente(ResidenteDTO residente);

    /**
     * Obtiene un residente específico del sistema a partir de su matrícula.
     *
     * @param matricula La matrícula del residente a obtener.
     * @return Un objeto ResidenteDTO que representa al residente encontrado, o
     * null si no se encuentra.
     */
    public abstract ResidenteDTO obtenerResidente(String matricula);
    
    public abstract void actualizarResidente(ResidenteDTO residente);

}
