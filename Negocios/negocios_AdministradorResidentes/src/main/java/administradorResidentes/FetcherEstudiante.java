package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class FetcherEstudiante {
    
    private ResidenteBO residenteBO;
    
    public FetcherEstudiante(ResidenteBO residenteBO){
        this.residenteBO = residenteBO;
    }
    
    protected ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException{
        return residenteBO.getEstudianteCIA(alumno);
    }
}
