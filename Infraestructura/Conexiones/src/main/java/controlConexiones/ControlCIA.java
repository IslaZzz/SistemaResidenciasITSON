package controlConexiones;

import conexiones.excepciones.ServidorExcepcion;
import conexiones.fabricaConectores.FabricaConectores;
import org.json.JSONObject;
import conexiones.interfaces.IConector;

public class ControlCIA {

    IConector conexionCIA;
    
    public JSONObject getAlumno(JSONObject alumno) throws ServidorExcepcion {
        conexionCIA = FabricaConectores.crearConector("CIA");
        return conexionCIA.getAlumno(alumno);
    }

}
