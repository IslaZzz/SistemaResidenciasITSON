package administradorResidentes;

import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class AdministradorResidentesFachada implements IAdministradorResidentes{

    private ResidenteBO residenteBO = ResidenteBO.getInstance();
    private FetcherEstudiante fetcherEstudiante = new FetcherEstudiante(residenteBO);
    
    @Override
    public ResidenteDTO fetchEstudiante(String matricula) throws NegocioException {
        return fetcherEstudiante.fetchEstudiante(matricula);
    }
    
    @Override
    public ResidenteDTO fetchEstudianteCIA(String matricula) throws NegocioException{
        return fetcherEstudiante.fetchEstudianteCIA(matricula);
    }
    
    @Override
    public ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo){
        return residenteBO.asignarTipo(residente, tipo);
    }

    @Override
    public ResidenteDTO getResidente(String matricula) throws NegocioException{
        return residenteBO.getResidente(matricula);
    }

    @Override
    public void registrarResidente(ResidenteDTO residente) {
        residenteBO.registrarResidente(residente);
    }

    
}
