/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import excepciones.MensajeriaException;

/**
 *
 * @author rauln
 */
public interface IMensajeria {

    public abstract void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion;
    
    /**
     * Envía una referencia de pago por correo electrónico utilizando el
     * servicio de mensajería.
     * 
     * @param referencia recibe como parametro una dto de la referencia de pago
     * @throws excepciones.MensajeriaException Lanza la excepcion en caso de que no fue posible darle formato al pdf
    **/
    public abstract boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws MensajeriaException;
}
