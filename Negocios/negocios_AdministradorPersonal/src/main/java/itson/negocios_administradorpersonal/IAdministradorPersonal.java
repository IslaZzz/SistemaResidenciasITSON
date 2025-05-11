package itson.negocios_administradorpersonal;

import dto.PersonalDTO;
import excepciones.NegocioException;
import java.util.List;

public interface IAdministradorPersonal {
    
    /**
     * Obtiene un miembro del personal específico del sistema.
     *
     * @param personalDTO El objeto DTO que representa al miembro del personal a buscar.
     * @return El objeto DTO del miembro del personal encontrado.
     */
    PersonalDTO obtenerPersonal(PersonalDTO personalDTO) throws NegocioException;

    /**
     * Obtiene una lista de todos los miembros del personal registrados en el sistema.
     *
     * @return Una lista de objetos DTO de miembros del personal.
     */
    List<PersonalDTO> obtenerPersonalPorPuesto(String puesto);

}
