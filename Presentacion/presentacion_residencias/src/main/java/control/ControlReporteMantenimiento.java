/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import presentacion.FrmReporteMantenimiento;

/**
 *
 * @author rauln
 */
public class ControlReporteMantenimiento {
    private FrmReporteMantenimiento frameReporteMantenimiento;
    
    public ControlReporteMantenimiento(){
        frameReporteMantenimiento = new FrmReporteMantenimiento();
    }
    
    public void iniciarFlujo(){
        frameReporteMantenimiento.setVisible(true);
        frameReporteMantenimiento.setResizable(false);
        frameReporteMantenimiento.setLocationRelativeTo(null);
        
    }
    
    
}
