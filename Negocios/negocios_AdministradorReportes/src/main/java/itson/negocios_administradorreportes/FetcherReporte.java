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
 * Clase encargada de manejar la lógica para enviar reportes, actuando como
 * intermediario entre la capa de negocio y otras capas.
 */
public class FetcherReporte {

    private ReporteBO reporteBO;

    /**
     * Constructor que inicializa el FetcherReporte con un objeto ReporteBO.
     *
     * @param reporteBO Objeto ReporteBO que maneja la lógica de negocio del
     * reporte.
     */
    public FetcherReporte(ReporteBO reporteBO) {
        this.reporteBO = reporteBO;
    }

    /**
     * Envía un reporte vía WhatsApp delegando la acción al ReporteBO.
     *
     * @param reporte El objeto ReporteDTO que contiene la información del
     * reporte a enviar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante el envío.
     * @throws ServidorExcepcion Si ocurre un error relacionado con el servidor
     * al enviar el reporte.
     */
    protected void enviarReportePorWhatsapp(ReporteDTO reporte) throws NegocioException, ServidorExcepcion {
        reporteBO.enviarReportePorWhatsapp(reporte);
    }
}
