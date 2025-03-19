package control;

import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import presentacion.FrmAsignarHabitacion;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;
import presentacion.FrmTipoResidente;

public class ControlAltaResidente {
    
    FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    FrmInfoEstudiante frameInfoEstudiante;
    FrmTipoResidente frameTipoResidente;
    FrmAsignarHabitacion frameAsignarHabitacion;
    IAdministradorResidentes administradorResidentes;
    
    public ControlAltaResidente(){
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this);
        administradorResidentes = new AdministradorResidentesFachada();
        frameInfoEstudiante = new FrmInfoEstudiante(this);
        
        
    }
    public void iniciarFlujo(){
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
    }
    
    public void mostrarInfoEstudiante(ResidenteDTO estudiante){
        frameIngresarIDEstudiante.dispose();
        frameInfoEstudiante.setVisible(true);
        frameInfoEstudiante.setResizable(false);
        frameInfoEstudiante.setLocationRelativeTo(null);
        frameInfoEstudiante.cargarEstudiante(estudiante);
        
    }
    
    public ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        return administradorResidentes.getEstudiante(matricula);
    }
    
}
