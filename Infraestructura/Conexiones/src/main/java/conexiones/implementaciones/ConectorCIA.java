package conexiones.implementaciones;

import conexiones.interfaces.IConector;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ConectorCIA implements IConector {

    private URL url;
    private HttpURLConnection conn;

    public ConectorCIA() {
        try {
            url = new URL("http://localhost:5000/buscar-alumno");
            conn = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public JSONObject getAlumno(JSONObject alumno){
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
            e.printStackTrace();
            return null;
        }
    }

}
