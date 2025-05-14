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

    /**
     * Obtiene el nombre completo del residente que se encuentra en una
     * habitación específica, identificada por su número de piso y habitación.
     *
     * @param piso El número del piso donde se encuentra la habitación.
     * @param habitacion El número de la habitación que se desea consultar.
     * @return El nombre completo del residente si se encuentra en esa
     * habitación, o null si no hay residente registrado en esa habitación.
     */
    public abstract List<String> obtenerResidentePorHabitacion(Integer piso, Integer habitacion);

}
