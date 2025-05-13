/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.ReporteDTO;
import entities.Reporte;



/**
 * Interfaz que define las operaciones de acceso a datos relacionadas con los reportes
 * de mantenimiento en el sistema de residencias.
 */
public interface IReportesDAO {

    /**
     * Registra un nuevo reporte de mantenimiento en el sistema.
     *
     * @param reporte Objeto {@link ReporteDTO} que contiene los datos del reporte a registrar.
     * @return Retorna el reporte generado.
     */
    public abstract Reporte registrarReporte(ReporteDTO reporte);
    
    
}
