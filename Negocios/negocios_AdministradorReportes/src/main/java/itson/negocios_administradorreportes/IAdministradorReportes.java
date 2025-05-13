/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_administradorreportes;

import dto.ReporteDTO;
import excepciones.NegocioException;

/**
 *
 * @author rauln
 */
public interface IAdministradorReportes {
    ReporteDTO registrarReporte(ReporteDTO reporteDTO) throws NegocioException;
    ReporteDTO verificarExistenciaDeReportePendiente(ReporteDTO reporteDTO) throws NegocioException;
}
