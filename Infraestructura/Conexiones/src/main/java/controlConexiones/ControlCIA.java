package controlConexiones;

import conexiones.fabricaConectores.FabricaConectores;
import org.json.JSONObject;
import conexiones.interfaces.IConector;

public class ControlCIA {

    IConector conexionCIA;
    
    public JSONObject getAlumno(JSONObject alumno) {
        conexionCIA = FabricaConectores.crearConector("CIA");
        return conexionCIA.getAlumno(alumno);
    }

}
