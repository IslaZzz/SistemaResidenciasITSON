
package objetosnegocio;

import DTO_Infraestructura.ContratoInfoDTO;
import dto.FiadorDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

/**
 *
 * @author abrilislas
 */
public class ContratoBO {
    
    private static ContratoBO instance;
    
    /**
     * Crea instancia de un objeto Contrato negocio
     * @return 
     */
    public static ContratoBO getInstance() {
        if (instance == null) {
            instance = new ContratoBO();
        }
        return instance;
    }
    
    /**
     * 
     * @param contratoInfoDTO recibe la informacion del contrato
     * @return en caso de todo estar correcto, retorna la informacion a facade 
     * @throws NegocioException si contiene un campo vacio
     */
    public ContratoInfoDTO generarReporte(ContratoInfoDTO contratoInfoDTO) throws NegocioException {
          if (contratoInfoDTO == null || validarCamposResidenteYFiador(contratoInfoDTO)==false) throw new NegocioException("Hay campos vacíos");
          return contratoInfoDTO;
    }
    
    /**
     * valida que ningun dato este vacio 
     * @param contratoInfoDTO
     * @return 
     */
    private boolean validarCamposResidenteYFiador(ContratoInfoDTO contratoInfoDTO) {

         return esValido(contratoInfoDTO.getIdResidente())&&
                esValido(contratoInfoDTO.getCarrera())&&
                esValido(contratoInfoDTO.getNombreResidente())&&
                esValido(contratoInfoDTO.getAdeudo())&& 
                esValido(contratoInfoDTO.getubicacionEdificio())&&  
                esValido(contratoInfoDTO.getHabitacionResidente())&& 
                esValido(contratoInfoDTO.getDireccionFiador())&& 
                esValido(contratoInfoDTO.getDireccionResidente())&& 
                esValido(contratoInfoDTO.getNombreFiador())&&   
                esValido(contratoInfoDTO.getPiso());
}
    /**
     * 
     * @param campo recibe un campo de texto y verifica que no este vacio ni nulo
     * @return retorna un valor de tipo booleano
     */
    private boolean esValido(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }
}
