package implementaciones;

import DTO_Infraestructura.EstudianteDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;
import excepciones.CIAExcepcion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ComunicacionCIAFachada implements IComunicacionCIA {

    @Override
    public EstudianteDTO getEstudiante(String matricula) throws CIAExcepcion{
        String urlString = "http://127.0.0.1:5000/alumno/" + matricula;
        HttpURLConnection conn = null;
        StringBuilder resultado = new StringBuilder();

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new CIAExcepcion("No se encontro el alumno en el sistema CIA");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = br.readLine()) != null) {
                resultado.append(output);
            }

            conn.disconnect();
            JSONObject alumno = new JSONObject(resultado.toString());
            if(alumno != null){
                return convertirAEstudiante(alumno);
            }
            else{
                return null;
            }
            

        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public EstudianteDTO convertirAEstudiante(JSONObject alumno) {
        String matricula = alumno.getString("matricula");
        String nombre = alumno.getString("nombre");
        String sexo = alumno.getString("sexo");
        int semestre = alumno.getInt("semestre");
        String carrera = alumno.getString("carrera");
        String correo = alumno.getString("correo");
        String telefono = alumno.getString("telefono");
        String direccion = alumno.getString("direccion");
        return new EstudianteDTO(matricula,nombre,sexo.charAt(0),semestre,carrera,correo,telefono,direccion);
    }
    
    
    
}
