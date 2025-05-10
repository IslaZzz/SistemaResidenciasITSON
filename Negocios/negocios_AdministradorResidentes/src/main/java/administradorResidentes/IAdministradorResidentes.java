package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

public interface IAdministradorResidentes {
        
    ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException;
    
    ResidenteDTO getResidente(String matricula) throws NegocioException;

    void registrarResidente(ResidenteDTO residente) ;
    
}
