/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import excepciones.MensajeriaException;

/**
 *
 * @author rauln
 */
public interface IMensajeria {

    public abstract void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion;
}
