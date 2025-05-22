package administradorResidentes;

import DTO_Infraestructura.AlumnoInfDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * La interfaz {@code IAdministradorResidentes} define las operaciones que deben
 * ser implementadas para gestionar residentes en el sistema.
 *
 * <p>
 * Incluye métodos para:
 * </p>
 * <ul>
 * <li>Obtener información de estudiantes del sistema CIA.</li>
 * <li>Consultar residentes registrados por matrícula.</li>
 * <li>Registrar nuevos residentes.</li>
 * </ul>
 *
 * <p>
 * Esta interfaz permite desacoplar la lógica de negocio de su implementación
 * concreta, facilitando la mantenibilidad, pruebas y sustitución de
 * implementaciones.
 * </p>
 *
 */
public interface IAdministradorResidentes {

    /**
     * Obtiene la información de un estudiante del sistema CIA y la transforma
     * en un objeto {@code ResidenteDTO}.
     *
     * @param alumno El alumno proveniente del sistema CIA.
     * @return Un objeto {@code ResidenteDTO} con la información del estudiante.
     * @throws NegocioException Si ocurre un error durante la obtención de la
     *                          información.
     */
    ResidenteDTO fetchEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException;

    /**
     * Recupera un residente previamente registrado, identificado por su
     * matrícula.
     *
     * @param matricula La matrícula del residente a buscar.
     * @return El objeto {@code ResidenteDTO} correspondiente.
     * @throws NegocioException Si el residente no existe o ocurre un error
     *                          durante la búsqueda.
     */
    ResidenteDTO getResidente(String matricula) throws NegocioException;

    /**
     * Registra un nuevo residente en el sistema.
     *
     * @param residente El residente a registrar.
     */
    void registrarResidente(ResidenteDTO residente);
    
    /**
     * Obtiene una lista con los nombres completos de los residentes que se
     * encuentran en una habitación específica, identificada por su número de
     * piso y número de habitación.
     *
     * @param piso El número del piso donde se encuentra la habitación.
     * @param habitacion El número de la habitación que se desea consultar.
     * @return Una lista de nombres completos de los residentes registrados en
     * esa habitación. La lista estará vacía si no hay residentes registrados.
     */
    List<String> obtenerResidentesPorHabitacion(Integer piso, Integer habitacion);

    /**
     * Actualiza la información de un residente existente en el sistema.
     *
     * @param residente El DTO con los datos actualizados del residente.
     * @throws NegocioException Si ocurre un error durante la actualización.
     */
    public void actualizarResidente(ResidenteDTO residente);
    
    

}
