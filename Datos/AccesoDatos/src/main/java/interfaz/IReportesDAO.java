/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.ReporteDTO;
import entities.Reporte;

/**
 * Interfaz que define las operaciones de acceso a datos relacionadas con los
 * reportes de mantenimiento en el sistema de residencias.
 */
public interface IReportesDAO {

    /**
     * Registra un nuevo reporte de mantenimiento en el sistema.
     *
     * @param reporte Objeto {@link ReporteDTO} que contiene los datos del
     * reporte a registrar.
     * @return Retorna el reporte generado.
     */
    public abstract ReporteDTO registrarReporte(ReporteDTO reporte);

    /**
     * Verifica si ya existe un reporte de mantenimiento con estado PENDIENTE
     * para el mismo piso y habitación que el proporcionado en el DTO.
     *
     * @param reporte Objeto {@link ReporteDTO} con la información del reporte a
     * verificar.
     * @return {@code true} si ya existe un reporte pendiente para el mismo piso
     * y habitación, {@code false} en caso contrario.
     */
    public abstract boolean verificarExistenciaReportePendiente(ReporteDTO reporte);

}
