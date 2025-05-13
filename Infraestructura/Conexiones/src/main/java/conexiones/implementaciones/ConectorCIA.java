package conexiones.implementaciones;

import conexiones.excepciones.ServidorExcepcion;
import conexiones.interfaces.IConector;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 * Implementación del conector HTTP para comunicarse con el servidor de CIA.
 * Esta clase envía una solicitud POST con los datos del alumno en formato JSON
 * y espera una respuesta también en formato JSON.
 */
public class ConectorCIA implements IConector {

    /**
     * URL del servicio web del servidor CIA para buscar alumnos.
     */
    private URL url;

    /**
     * Conexión HTTP utilizada para enviar solicitudes al servidor CIA.
     */
    private HttpURLConnection conn;

    /**
     * Constructor que inicializa la conexión HTTP con la URL del servidor CIA.
     * Se establece la URL del servicio web para la búsqueda de alumnos.
     */
    public ConectorCIA() {
        try {
            url = new URL("http://localhost:5000/buscar-alumno");
            conn = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Envía una solicitud POST al servidor de CIA con los datos del alumno y
     * devuelve la respuesta en formato JSON si la búsqueda es exitosa.
     *
     * @param alumno Un objeto {@link JSONObject} que contiene la matrícula del
     * alumno.
     * @return Un objeto {@link JSONObject} con los datos completos del alumno,
     * o null si no se encuentra.
     * @throws ServidorExcepcion Si ocurre un error al conectarse o comunicarse
     * con el servidor CIA.
     */
    @Override
    public JSONObject getAlumno(JSONObject alumno) throws ServidorExcepcion {
        try {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(alumno.toString().getBytes());
            }

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                Scanner sc = new Scanner(conn.getInputStream());
                String jsonString = sc.useDelimiter("\\A").next();
                sc.close();
                return new JSONObject(jsonString);
            } else {
                System.out.println("Alumno no encontrado o error: Código " + responseCode);
                return null;
            }

        } catch (Exception e) {
            throw new ServidorExcepcion("Error al conectarse con el servidor CIA");
        }
    }

}
