/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones.implementaciones;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.interfaces.IConectorJasperReports;
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
    
    @Override
    public void generarReporteResidente(ReporteInfDTO reporteInformacionDTO) throws JRException {
        
        try {
            InputStream baseContrato = getClass().getResourceAsStream("/contrato.jrxml");
            // Carga y compilar el reporte .jrxml
            JasperReport reporte = JasperCompileManager.compileReport(baseContrato);

            //Lista con un solo elemento
            List<ReporteInfDTO> datos = Collections.singletonList(reporteInformacionDTO);
            
            JRBeanCollectionDataSource fuenteDatos = new JRBeanCollectionDataSource(datos);

            Map<String, Object> parametros = new HashMap<>();

            // Llenar el reporte con el DTO
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, fuenteDatos);

            // Exportar a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "contrato_residente_"+NOMBRE_RESIDENTE+".pdf");

            System.out.println("PDF generado correctamente.");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}