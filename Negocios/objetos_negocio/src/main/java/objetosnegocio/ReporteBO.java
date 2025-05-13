/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dto.ReporteDTO;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 * Clase de lógica de negocio para gestionar reportes de mantenimiento.
 * Implementa el patrón Singleton para asegurar una única instancia en toda la
 * aplicación. Esta clase sirve como intermediario entre la capa de presentación
 * y la capa de acceso a datos.
 *
 * Se encarga de validar, preparar y delegar la lógica necesaria para registrar
 * reportes utilizando la fachada de acceso a datos.
 *
 * @author rauln
 */
public class ReporteBO {

    /**
     * Instancia única de la clase ReporteBO (patrón Singleton).
     */
    private static ReporteBO reporteBO;

    /**
     * Retorna la instancia única de la clase ReporteBO. Si no existe, la crea.
     *
     * @return La instancia única de ReporteBO.
     */
    public static ReporteBO getInstance() {
        if (reporteBO == null) {
            reporteBO = new ReporteBO();
        }
        return reporteBO;
    }

    /**
     * Registra un nuevo reporte de mantenimiento en el sistema. Este método
     * delega la operación a la capa de acceso a datos a través de la fachada.
     *
     * @param reporte El DTO que contiene la información del reporte a
     * registrar.
     */
    public void registrarReporte(ReporteDTO reporte) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.registrarReporte(reporte);
    }
}
