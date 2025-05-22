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
     * Actualiza la información de un residente existente en la base de datos.
     *
     * @param residente El objeto {@link ResidenteDTO} que contiene los nuevos
     * datos del residente, incluyendo su ID para identificar qué registro
     * actualizar.
     */
    public abstract void actualizarResidente(ResidenteDTO residente);

    /**
     * Registra múltiples residentes en la base de datos de forma masiva. Este
     * método es útil para realizar cargas iniciales o importar grandes
     * volúmenes de datos.
     *
     * Se espera que cada residente esté correctamente asignado a una
     * habitación, y que se respeten las reglas de ocupación, como la capacidad
     * máxima por habitación.
     */
    public abstract void registrarResidentesMasivo();

    /**
     * Obtiene la cantidad total de residentes registrados en la base de datos.
     *
     * @return la cantidad de documentos (residentes) existentes en la colección
     * correspondiente.
     */
    public abstract Long obtenerCantidadResidentes();
}
