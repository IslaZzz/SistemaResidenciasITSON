package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;

public interface IAdministradorResidentes {
    
    ResidenteDTO getEstudiante(String matricula) throws NegocioException;
    
    ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo);
}
