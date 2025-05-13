package itson.negocios_administradorpersonal;

import dto.PersonalDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar las operaciones relacionadas
 * con el personal en el sistema. Esta interfaz establece los contratos para
 * obtener, registrar y actualizar la información de los empleados.
 *
 * La implementación de esta interfaz debe delegar las acciones correspondientes
 * a la capa de negocio que maneja la lógica de personal.
 */
public interface IAdministradorPersonal {

    /**
     * Obtiene un miembro del personal específico del sistema.
     *
     * @param personalDTO El objeto DTO que representa al miembro del personal a
     * buscar.
     * @return El objeto DTO del miembro del personal encontrado.
     * @throws excepciones.NegocioException
     */
    PersonalDTO obtenerPersonal(PersonalDTO personalDTO) throws NegocioException;

    /**
     * Obtiene una lista de todos los miembros del personal registrados en el
     * sistema.
     *
     * @param puesto
     * @return Una lista de objetos DTO de miembros del personal.
     */
    List<PersonalDTO> obtenerPersonalPorPuesto(String puesto);

}
