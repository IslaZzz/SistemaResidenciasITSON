/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexiones.interfaces;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import org.json.JSONObject;

/**
 *
 * @author rauln
 */
public interface IConectorMensajeria {
    public abstract void enviarReportePorWhatsapp(ReporteInfDTO reporte)throws ServidorExcepcion;
}
