package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class FetcherEstudiante {
    
    private ResidenteBO residenteBO;
    
    public FetcherEstudiante(ResidenteBO residenteBO){
        this.residenteBO = residenteBO;
    }
    
    protected ResidenteDTO fetchEstudiante(String matricula) throws NegocioException{
        return residenteBO.getEstudiante(matricula);
    }
    
    protected ResidenteDTO fetchEstudianteCIA(String matricula) throws NegocioException{
        return residenteBO.getEstudianteCIA(matricula);
    }
    
}
