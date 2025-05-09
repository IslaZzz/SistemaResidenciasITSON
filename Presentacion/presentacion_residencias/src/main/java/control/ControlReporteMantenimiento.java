/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.util.List;
import presentacion.FrmReporteMantenimiento;

/**
 *
 * @author rauln
 */
public class ControlReporteMantenimiento {

    private FrmReporteMantenimiento frameReporteMantenimiento;

    public ControlReporteMantenimiento() {
        frameReporteMantenimiento = new FrmReporteMantenimiento(this);
    }

    public void iniciarFlujo() {
        frameReporteMantenimiento.setVisible(true);
        frameReporteMantenimiento.setResizable(false);
        frameReporteMantenimiento.setLocationRelativeTo(null);

    }

    public List<String> obtenerPisos(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerPisos();
    }

     
}
