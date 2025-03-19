package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;

public interface IAdministradorResidentes {
    
    ResidenteDTO getEstudiante(String matricula) throws NegocioException;
}
