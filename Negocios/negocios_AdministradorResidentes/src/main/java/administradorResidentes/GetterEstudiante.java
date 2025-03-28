package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class GetterEstudiante {
    
    private ResidenteBO residenteBO;
    
    public GetterEstudiante(ResidenteBO residenteBO){
        this.residenteBO = residenteBO;
    }
    
    protected ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        return residenteBO.getEstudiante(matricula);
    }
    
    protected ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        return residenteBO.getEstudianteCIA(matricula);
    }
    
}
