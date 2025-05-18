package implementaciones;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import controlConexiones.ControlMensajeria;
import excepciones.MensajeriaException;

/**
 * Fachada para la comunicación con el servidor de mensajería vía WhatsApp. Se
 * encarga de enviar un objeto {@link ReporteInfDTO} como JSON al servidor.
 */
public class MensajeriaFachada implements interfaz.IMensajeria {

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

    /**
     * Envía una referencia de pago por correo electrónico utilizando el
     * servicio de mensajería.
     * @param referencia Objeto ReferenciaPagoInfDTO que contiene los
     * datos necesarios para generar y enviar la referencia de pago
     * @throws MensajeriaException Si ocurre un error durante el proceso de
     * envío del correo. Los posibles casos incluyen: - Problemas de conexión
     * con el servidor de correo - Datos incompletos en la referencia - Errores
     * en la plantilla del correo - Limitaciones del servicio de mensajería
     */
    @Override
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws MensajeriaException {
        ControlMensajeria controlMensajeria = new ControlMensajeria();
        try {
            return controlMensajeria.enviarReferenciaCorreo(referencia);
        } catch (ServidorExcepcion ex) {
            throw new MensajeriaException(ex.getMessage());
        }

    }

}
