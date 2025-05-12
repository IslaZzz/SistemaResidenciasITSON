package itson.negocios_administradorpersonal;

import dto.PersonalDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.PersonalBO;

public class AdministradorPersonalFachada implements IAdministradorPersonal {

    /**
     * Instancia de la clase PersonalBO que maneja la lógica de negocio relacionada con el personal.
     */
    private PersonalBO personalBO = PersonalBO.getInstance();

    /**
     * Constructor de la clase AdministradorPersonalFachada.
     */
    public AdministradorPersonalFachada() {
    }

    /**
     * Método que obtiene un miembro del personal específico del sistema.
     *
     * @param personalDTO El objeto DTO que representa al miembro del personal a buscar.
     * @return El objeto DTO del miembro del personal encontrado.
     */
    @Override
    public PersonalDTO obtenerPersonal(PersonalDTO personalDTO) throws NegocioException {
        try {
            return personalBO.obtenerPersonal(personalDTO);
        } catch (NoEncontradoException e){
            throw new NegocioException("Error al encontrar personal: "+e.getMessage());
        }
    }

    /**
     * Método que obtiene una lista de todos los miembros del personal registrados en el sistema.
     *
     * @return Una lista de objetos DTO de miembros del personal.
     */
    @Override
    public List<PersonalDTO> obtenerPersonalPorPuesto(String puesto) {
        return personalBO.obtenerPersonalPorPuesto(puesto);
    }
} 