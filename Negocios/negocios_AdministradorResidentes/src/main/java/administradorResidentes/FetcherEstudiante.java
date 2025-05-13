package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ResidenteBO;

/**
 * La clase {@code FetcherEstudiante} se encarga de obtener información de un
 * estudiante del sistema CIA y transformarla en un objeto {@code ResidenteDTO}.
 *
 * <p>
 * Actúa como un componente auxiliar que encapsula la interacción con la lógica
 * de negocio contenida en {@code ResidenteBO}.</p>
 *
 * <p>
 * Este tipo de componente es útil para desacoplar la obtención de datos
 * externos (como los del sistema CIA) de otras capas del sistema.</p>
 *
 */
public class FetcherEstudiante {

    /**
     * Objeto de negocio utilizado para recuperar la información del estudiante
     * CIA.
     */
    private ResidenteBO residenteBO;

    /**
     * Crea una nueva instancia de {@code FetcherEstudiante} con una referencia
     * al objeto de negocio {@code ResidenteBO}.
     *
     * @param residenteBO El objeto de negocio que se usará para consultar la
     * información.
     */
    public FetcherEstudiante(ResidenteBO residenteBO) {
        this.residenteBO = residenteBO;
    }

    /**
     * Obtiene la información de un estudiante proveniente del sistema CIA.
     *
     * @param alumno El objeto {@code AlumnoInfDTO} que representa al estudiante
     * del CIA.
     * @return Un objeto {@code ResidenteDTO} con la información transformada
     * del estudiante.
     * @throws NegocioException Si ocurre un error durante la obtención o
     * transformación de los datos.
     */
    protected ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException {
        return residenteBO.getEstudianteCIA(alumno);
    }
}
