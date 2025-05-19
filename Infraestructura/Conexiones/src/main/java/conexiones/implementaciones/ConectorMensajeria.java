package conexiones.implementaciones;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.interfaces.IConectorMensajeria;
import java.io.IOException;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ConectorMensajeria implements IConectorMensajeria {

    private final URL url;

    public ConectorMensajeria() {
        try {
            this.url = new URL("http://localhost:5001/api/enviarReporte"); // Cambiar si es necesario
        } catch (Exception e) {
            throw new RuntimeException("URL inválida para ConectorMensajeria", e);
        }
    }

    @Override
    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            JSONObject reporteJson = convertirReporteAJson(reporte);
            String jsonString = reporteJson.toString();

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
                os.write(input);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200 && responseCode != 201) {
                throw new ServidorExcepcion("Error al enviar reporte. Código HTTP: " + responseCode);
            }

        } catch (Exception e) {
            throw new ServidorExcepcion("Error al enviar reporte", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    // Convierte el objeto DTO en un JSON
    private JSONObject convertirReporteAJson(ReporteInfDTO reporte) {
        JSONObject json = new JSONObject();
        json.put("piso", reporte.getPiso());
        json.put("habitacion", reporte.getHabitacion());
        json.put("residente", reporte.getResidente());
        json.put("horaInicio", reporte.getHorarioVisita());
        json.put("descripcion", reporte.getDescripcionProblema());
        return json;
    }

}
