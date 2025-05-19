package implementaciones;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import controlConexiones.ControlMensajeria;
import excepciones.MensajeriaException;

/**
 * Fachada para la comunicación con el servidor de mensajería vía WhatsApp. Se
 * encarga de enviar un objeto {@link ReporteInfDTO} como JSON al servidor.
 */
public class MensajeriaFachada implements interfaz.IMensajeria  {

    /**
     * Envía el reporte recibido al servidor de mensajería.
     *
     * @param reporte Objeto DTO con la información del reporte
     * @throws conexiones.excepciones.ServidorExcepcion
     * @throws excepciones.MensajeriaException
     */
    @Override
    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        ControlMensajeria controlMensajeria = new ControlMensajeria();
        controlMensajeria.enviarReportePorWhatsapp(reporte);
    }

}
