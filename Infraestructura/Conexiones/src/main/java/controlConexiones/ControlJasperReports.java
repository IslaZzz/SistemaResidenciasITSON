/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlConexiones;

import DTO_Infraestructura.ContratoInfoDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.fabricaConectores.FabricaConectores;
import conexiones.implementaciones.ConectorJasperReports;
import conexiones.interfaces.IConectorJasperReports;
import java.io.File;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author abrilislas
 */
public class ControlJasperReports {
    
    IConectorJasperReports conectorJasperReports;
    
    public File generarReporte(ContratoInfoDTO reporteInformacionDTO, File destinoPDF) throws Exception {
        conectorJasperReports = FabricaConectores.crearConexionJasperReports("JASPERREPORTS");
        return conectorJasperReports.generarContratoResidente(reporteInformacionDTO, destinoPDF);
    }
    
}
