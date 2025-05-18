package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.util.List;
import objetosnegocio.ResidenteBO;

/**
 * La clase {@code AdministradorResidentesFachada} implementa la interfaz
 * {@code IAdministradorResidentes} y actúa como una fachada para encapsular las
 * operaciones relacionadas con la gestión de residentes.
 *
 * <p>
 * Utiliza el objeto de negocio {@code ResidenteBO} para delegar las operaciones
 * como el registro, la recuperación y la obtención de residentes, y un
 * {@code FetcherEstudiante} para obtener datos de estudiantes CIA.</p>
 *
 * <p>
 * Esta clase se encarga de simplificar el acceso a los servicios de gestión de
 * residentes para otras capas del sistema.</p>
 *
 */
public class AdministradorResidentesFachada implements IAdministradorResidentes {

    /**
     * Objeto de negocio responsable de la lógica relacionada con residentes.
     */
    private ResidenteBO residenteBO = ResidenteBO.getInstance();

    /**
     * Componente auxiliar para obtener información de estudiantes CIA.
     */
    private FetcherEstudiante fetcherEstudiante = new FetcherEstudiante(residenteBO);

    /**
     * Obtiene los datos de un estudiante del sistema CIA y los transforma en un
     * objeto {@code ResidenteDTO}.
     *
     * @param alumno El alumno del CIA del cual se desea obtener la información.
     * @return Un objeto {@code ResidenteDTO} con la información del estudiante.
     * @throws NegocioException Si ocurre un error durante la obtención.
     */
    @Override
    public ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException {
        return fetcherEstudiante.fetchEstudianteCIA(alumno);
    }

    /**
     * Recupera un residente registrado a partir de su matrícula.
     *
     * @param matricula La matrícula del residente a buscar.
     * @return El residente correspondiente en forma de {@code ResidenteDTO}.
     * @throws NegocioException Si no se encuentra el residente o si ocurre un
     * error.
     */
    @Override
    public ResidenteDTO getResidente(String matricula) throws NegocioException {
        return residenteBO.getResidente(matricula);
    }

    /**
     * Registra un nuevo residente en el sistema.
     *
     * @param residente El residente a registrar.
     */
    @Override
    public void registrarResidente(ResidenteDTO residente) {
        residenteBO.registrarResidente(residente);
    }
    
    @Override
    public List<String> obtenerResidentesPorHabitacion(Integer piso, Integer habitacion) {
        return residenteBO.obtenerResidentesPorHabitacion(piso, habitacion);
    }


}
