package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;

public interface IAdministradorResidentes {
    
    ResidenteDTO fetchEstudiante(String matricula) throws NegocioException;
    
    ResidenteDTO fetchEstudianteCIA(String matricula) throws NegocioException;
    
    ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo);

    ResidenteDTO getResidente(String matricula) throws NegocioException;

    void registrarResidente(ResidenteDTO residente) ;
}
