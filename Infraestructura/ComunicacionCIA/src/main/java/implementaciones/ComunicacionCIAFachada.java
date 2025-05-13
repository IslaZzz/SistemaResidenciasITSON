package implementaciones;

import DTO_Infraestructura.AlumnoInfDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;
import conexiones.excepciones.ServidorExcepcion;
import controlConexiones.ControlCIA;
import excepciones.CIAExcepcion;
import org.json.JSONObject;

/**
 * Implementación de la interfaz {@link IComunicacionCIA} que gestiona la
 * comunicación con el sistema de información académica (CIA). Esta clase
 * proporciona métodos para obtener información de estudiantes desde el sistema
 * CIA y convertir entre objetos DTO y JSON.
 *
 * Utiliza el {@link ControlCIA} para interactuar con el servidor y obtener los
 * datos relacionados con los estudiantes.
 */
public class ComunicacionCIAFachada implements IComunicacionCIA {

    /**
     * Objeto JSON que contiene la información del estudiante obtenida desde el
     * servidor
     */
    JSONObject alumnoObtenido;

    /**
     * Obtiene un estudiante desde el sistema CIA utilizando la matrícula
     * proporcionada en el objeto {@link AlumnoInfDTO}.
     *
     * @param alumno El objeto DTO que contiene la matrícula del estudiante
     * @return El objeto DTO {@link AlumnoInfDTO} con la información del
     * estudiante obtenida
     * @throws CIAExcepcion Si ocurre un error de conexión con el servidor CIA
     */
    @Override
    public AlumnoInfDTO getEstudiante(AlumnoInfDTO alumno) throws CIAExcepcion {
        try {
            ControlCIA control = new ControlCIA();
            alumnoObtenido = control.getAlumno(convertirEstudianteDTOaJSON(alumno));
            if (alumnoObtenido != null) {
                return convertirEstudianteJSONaDTO(alumnoObtenido);
            } else {
                return null;
            }
        } catch (ServidorExcepcion ex) {
            throw new CIAExcepcion("Error al conectarse con el servidor CIA");
        }
    }

    /**
     * Convierte un objeto {@link JSONObject} que representa un estudiante a un
     * objeto {@link AlumnoInfDTO}.
     *
     * @param alumno El objeto JSON que contiene la información del estudiante
     * @return El objeto DTO {@link AlumnoInfDTO} con los datos del estudiante
     */
    @Override
    public AlumnoInfDTO convertirEstudianteJSONaDTO(JSONObject alumno) {
        String matricula = alumno.getString("matricula");
        String nombre = alumno.getString("nombre");
        String sexo = alumno.getString("sexo");
        int semestre = alumno.getInt("semestre");
        String carrera = alumno.getString("carrera");
        String correo = alumno.getString("correo");
        String telefono = alumno.getString("telefono");
        String direccion = alumno.getString("direccion");
        return new AlumnoInfDTO(matricula, nombre, sexo.charAt(0), semestre, carrera, correo, telefono, direccion);
    }

    /**
     * Convierte un objeto DTO {@link AlumnoInfDTO} a un objeto
     * {@link JSONObject} para ser utilizado en la comunicación con el servidor
     * CIA.
     *
     * @param alumno El objeto DTO con la información del estudiante
     * @return El objeto JSON que contiene la matrícula del estudiante
     */
    @Override
    public JSONObject convertirEstudianteDTOaJSON(AlumnoInfDTO alumno) {
        JSONObject alumnoJSON = new JSONObject();
        alumnoJSON.put("matricula", alumno.getMatricula());
        return alumnoJSON;
    }

}
