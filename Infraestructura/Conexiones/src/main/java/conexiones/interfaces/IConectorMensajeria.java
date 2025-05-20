package conexiones.interfaces;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;

/**
 * Interfaz que define los métodos para enviar mensajes a través de diferentes
 * medios de mensajería.
 */
public interface IConectorMensajeria {

    /**
     * Envía un reporte a través de WhatsApp.
     *
     * @param reporte objeto ReporteInfDTO que contiene la información del
     * reporte a enviar.
     * @throws ServidorExcepcion si ocurre un error al comunicarse con el
     * servidor de mensajería.
     */
    public abstract void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion;

    /**
     * Envía una referencia de pago por correo electrónico.
     *
     * @param referencia objeto ReferenciaPagoInfDTO que contiene la información
     * de la referencia a enviar.
     * @return true si el correo se envió correctamente, false en caso
     * contrario.
     * @throws ServidorExcepcion si ocurre un error al comunicarse con el
     * servidor de correo.
     */
    public abstract boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws ServidorExcepcion;

}
