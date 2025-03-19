package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class AdministradorResidentesFachada implements IAdministradorResidentes{

    private ResidenteBO residenteBO = new ResidenteBO();
    private GetterEstudiante getterEstudiante = new GetterEstudiante(residenteBO);
    
    @Override
    public ResidenteDTO getEstudiante(String matricula) throws NegocioException {
        return getterEstudiante.getEstudiante(matricula);
    }
    @Override
    public ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo){
        return residenteBO.asignarTipo(residente, tipo);
    }
}
