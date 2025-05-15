package administradorFiador;

import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import objetosnegocio.FiadorBO;

/**
 *
 * @author abrilislas
 */
public class AdministradorFiadorFachada implements IAdministradorFiador{
    
    private FiadorBO fiadorBO = FiadorBO.getInstance();

    @Override
    public Fiador registrarFiador(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO) throws NegocioException{
        try{
            return fiadorBO.registrarFiador(fiadorDTO, residenteDTO);
        }catch(NoEncontradoException ex){
            throw new NegocioException(ex.getMessage());
        }    
    }
   

    @Override
    public FiadorDTO buscarFiadorResidente(ResidenteDTO residenteDTO) throws NegocioException{
        try{
            return fiadorBO.consultarFiador(residenteDTO);
        }
        catch(Exception ex){
            throw new NegocioException(ex.getMessage());
        }
    }
}
