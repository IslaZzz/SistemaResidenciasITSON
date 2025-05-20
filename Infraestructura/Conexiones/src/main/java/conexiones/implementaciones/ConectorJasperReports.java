/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones.implementaciones;

import DTO_Infraestructura.ContratoInfoDTO;
import conexiones.interfaces.IConectorJasperReports;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author abrilislas
 */
public class ConectorJasperReports implements IConectorJasperReports{
    private String NOMBRE_RESIDENTE;
    
    /**
     * 
     * @param contratoInfo informacion del contrato relacionada al residente y fiador
     * @param reporteInformacionDTO recibe la informacion para generar el contrato
     * @param destinoPDF
     * @return retorna el archivoPDF
     * @throws JRException en caso de ocurrir un error, lanza una exepcion de tipo JRException
     */
    @Override
    public File generarContratoResidente(ContratoInfoDTO contratoInfo, File destinoPDF) throws JRException {
        
        try {
            //obtiene el recurso base del contrato
            InputStream baseContrato = getClass().getResourceAsStream("/ContratoResidenteF.jrxml");
            // Carga y compilar el reporte .jrxml
            JasperReport reporte = JasperCompileManager.compileReport(baseContrato);

            //Lista con un solo elemento como fuente de datos
            List<ContratoInfoDTO> datos = Collections.singletonList(contratoInfo);
            
            //establece fuente de datos
            JRBeanCollectionDataSource fuenteDatos = new JRBeanCollectionDataSource(datos);

            Map<String, Object> parametros = new HashMap<>();

            // Llenar el reporte con el DTO
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, fuenteDatos);
            
            JasperExportManager.exportReportToPdfFile(jasperPrint, destinoPDF.getAbsolutePath());
            return destinoPDF;
        } catch (JRException e) {
             e.printStackTrace();
        }
        return destinoPDF;
    }
}