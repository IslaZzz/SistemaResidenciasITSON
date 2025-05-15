/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.negocios_administradorreportes;

import conexiones.excepciones.ServidorExcepcion;
import dto.ReporteDTO;
import excepciones.NegocioException;
import objetosnegocio.ReporteBO;

/**
 *
 * @author rauln
 */
public class FetcherReporte {
    private ReporteBO reporteBO;

    public FetcherReporte(ReporteBO reporteBO) {
        this.reporteBO = reporteBO;
    }
    
    protected void enviarReportePorWhatsapp(ReporteDTO reporte) throws NegocioException, ServidorExcepcion{
        reporteBO.enviarReportePorWhatsapp(reporte);
    }
}
