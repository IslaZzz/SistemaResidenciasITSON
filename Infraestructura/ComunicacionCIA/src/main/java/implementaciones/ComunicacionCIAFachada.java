package implementaciones;

import DTO_Infraestructura.AlumnoInfDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;
import conexiones.excepciones.ServidorExcepcion;
import controlConexiones.ControlCIA;
import excepciones.CIAExcepcion;
import org.json.JSONObject;

public class ComunicacionCIAFachada implements IComunicacionCIA {

    JSONObject alumnoObtenido;

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

    @Override
    public JSONObject convertirEstudianteDTOaJSON(AlumnoInfDTO alumno) {
        JSONObject alumnoJSON = new JSONObject();
        alumnoJSON.put("matricula", alumno.getMatricula());
        return alumnoJSON;
    }

}
