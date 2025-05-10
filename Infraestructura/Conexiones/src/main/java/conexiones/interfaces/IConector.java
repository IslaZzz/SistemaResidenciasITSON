package conexiones.interfaces;

import conexiones.excepciones.ServidorExcepcion;
import org.json.JSONObject;

public interface IConector {
    JSONObject getAlumno(JSONObject alumno) throws ServidorExcepcion;
}
