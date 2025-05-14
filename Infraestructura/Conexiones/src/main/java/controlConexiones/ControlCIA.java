package controlConexiones;

import conexiones.excepciones.ServidorExcepcion;
import conexiones.fabricaConectores.FabricaConectores;
import org.json.JSONObject;
import conexiones.interfaces.IConector;

/**
 * Clase que actúa como controlador para gestionar la comunicación con el
 * servidor CIA. Se encarga de solicitar un conector a la fábrica de conectores
 * y delegar la obtención de información del alumno.
 */
public class ControlCIA {

    /**
     * Objeto que representa el conector utilizado para comunicarse con el
     * servidor CIA. Este conector es creado a través de la fábrica de
     * conectores.
     */
    IConector conexionCIA;

    /**
     * Envía una solicitud al servidor CIA para obtener los datos de un alumno.
     * Utiliza la fábrica de conectores para obtener la instancia del conector
     * apropiado.
     *
     * @param alumno Objeto {@link JSONObject} que contiene la información
     * básica del alumno (por ejemplo, la matrícula).
     * @return Objeto {@link JSONObject} con los datos completos del alumno si
     * se encuentra; {@code null} si no.
     * @throws ServidorExcepcion Si ocurre un error al intentar conectar con el
     * servidor CIA.
     */
    public JSONObject getAlumno(String matricula) throws ServidorExcepcion {
        conexionCIA = FabricaConectores.crearConector("CIA");
        return conexionCIA.getAlumno(matricula);
    }

}
