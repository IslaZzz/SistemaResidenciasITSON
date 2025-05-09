package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

public class AdministradorResidentesFachada implements IAdministradorResidentes{

    private ResidenteBO residenteBO = ResidenteBO.getInstance();
    private FetcherEstudiante fetcherEstudiante = new FetcherEstudiante(residenteBO);
    
    @Override
    public ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException{
        return fetcherEstudiante.fetchEstudianteCIA(alumno);
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
