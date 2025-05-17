/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexiones.interfaces;

import DTO_Infraestructura.ContratoInfoDTO;
import DTO_Infraestructura.ReporteInfDTO;
import java.io.File;
import net.sf.jasperreports.engine.JRException;

/**
 *Interfaz utilizada para realizar operaciones relacionadas con el uso de la API JasperReports
 */
public interface IConectorJasperReports {
    
    
    /**
     * Envía la información correspondiente para generar un reporte en formato pdf
     * con los datos de un residente y su fiador. 
     * La implementación debe
     * comunicarse con un servicio externo y devolver el contrato en formato PDF para su
     * posterior descarga.
     *
     * @param reporteInformacionDTO con  la informacion correspondiente del alumno, 
     * su fiador, habitacion e informacion del plan de pago seleccionado
     * @param destinoPDF
     * @return 
     * @throws net.sf.jasperreports.engine.JRException 
     * @throws conexiones.excepciones.ServidorExcepcion lanza una excepcion en caso de error 
     */
    public abstract File generarContratoResidente(ContratoInfoDTO contratoInfo, File destinoPDF) throws Exception;
        
}
