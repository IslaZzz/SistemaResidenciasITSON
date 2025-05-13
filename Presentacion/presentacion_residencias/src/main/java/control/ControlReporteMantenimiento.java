/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import java.util.List;
import presentacion.FrmReporteMantenimiento;

/**
 * Controlador para gestionar el flujo de reportes de mantenimiento.
 * Administra la interaccion con la pantalla de reportes y consulta informacion
 * de pisos disponibles a traves de la fachada de administrador de habitaciones.
 * @author rauln
 */
public class ControlReporteMantenimiento {

    /**
     * Ventana para gestionar reportes de mantenimiento.
     */
    private FrmReporteMantenimiento frameReporteMantenimiento;

    /**
     * Constructor que inicializa la pantalla de reportes de mantenimiento.
     * Crea una instancia de FrmReporteMantenimiento asociada a este controlador.
     */
    public ControlReporteMantenimiento() {
        frameReporteMantenimiento = new FrmReporteMantenimiento(this);
    }

    /**
     * Inicia el flujo mostrando la pantalla de reportes de mantenimiento.
     * Configura la ventana como no redimensionable y centrada en la pantalla.
     */
    public void iniciarFlujo() {
        frameReporteMantenimiento.setVisible(true);
        frameReporteMantenimiento.setResizable(false);
        frameReporteMantenimiento.setLocationRelativeTo(null);

    }

    /**
     * Obtiene una lista de todos los pisos disponibles.
     * @return Lista de numeros de pisos disponibles
     */
    public List<Integer> obtenerPisos(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

     
}
