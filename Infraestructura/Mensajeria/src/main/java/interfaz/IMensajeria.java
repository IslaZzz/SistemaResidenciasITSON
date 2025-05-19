package interfaz;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import excepciones.MensajeriaException;

/**
 * Interfaz que define los métodos para enviar mensajes mediante diferentes canales
 * de comunicación, como WhatsApp y correo electrónico.
 * 
 * Esta interfaz abstrae la funcionalidad de mensajería para enviar reportes y referencias de pago,
 * permitiendo distintas implementaciones según el canal o la tecnología utilizada.
 */
public interface IMensajeria {

    /**
     * Envía un reporte vía WhatsApp.
     *
     * @param reporte el objeto ReporteInfDTO que contiene la información del reporte a enviar
     * @throws MensajeriaException si ocurre un error durante el envío del reporte
     */
    public abstract void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws MensajeriaException;
    
    /**
     * Envía una referencia de pago por correo electrónico utilizando el servicio de mensajería.
     *
     * @param referencia DTO que contiene la información de la referencia de pago
     * @return {@code true} si el envío fue exitoso, {@code false} en caso contrario
     * @throws MensajeriaException si no fue posible darle formato al PDF o ocurrió otro error en la mensajería
     */
    public abstract boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws MensajeriaException;
}
