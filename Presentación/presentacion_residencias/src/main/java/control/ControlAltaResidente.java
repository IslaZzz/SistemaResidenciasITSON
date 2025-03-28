package control;

import java.util.List;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import presentacion.FrmAsignarHabitacion;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;
import presentacion.FrmTipoResidente;

public class ControlAltaResidente {
    
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmTipoResidente frameTipoResidente;
    private FrmAsignarHabitacion frameAsignarHabitacion;
    private IAdministradorResidentes administradorResidentes;
    private IAdministradorHabitaciones administradorHabitaciones;
    private ResidenteDTO residente;
    private List<HabitacionDTO> habitacionesDisponibles;
    
    public ControlAltaResidente(){
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this);
        administradorResidentes = new AdministradorResidentesFachada();
        frameInfoEstudiante = new FrmInfoEstudiante(this);
        frameTipoResidente = new FrmTipoResidente(this);
        frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        administradorHabitaciones = new AdministradorHabitacionesFachada();
        
        
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
    
    public void mostrarTipoResidente(){
        frameInfoEstudiante.dispose();
        frameTipoResidente.setVisible(true);
        frameTipoResidente.setResizable(false);
        frameTipoResidente.setLocationRelativeTo(null);
        frameTipoResidente.cargarInfo(residente);
    }
    public void volverIngresarIDEstudiante(){
        frameInfoEstudiante.dispose();
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
    }

    public void mostrarAsignarHabitacion() throws NegocioException{
        frameTipoResidente.dispose();
        frameAsignarHabitacion.setVisible(true);
        frameAsignarHabitacion.setResizable(false);
        frameAsignarHabitacion.setLocationRelativeTo(null);
        habitacionesDisponibles = obtenerHabitacionesDisponibles(residente);
        frameAsignarHabitacion.cargarPisos(habitacionesDisponibles);

    }
    

    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException{
        return administradorHabitaciones.obtenerHabitacionesDisponibles(residente);
    }

    public List<String> obtenerPisosDisponibles(List<HabitacionDTO> habitaciones){
        return administradorHabitaciones.obtenerPisosDisponibles(habitaciones);
    }

    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(List<HabitacionDTO> habitaciones, String piso){
        return administradorHabitaciones.obtenerHabitacionesDisponiblesEnPiso(habitaciones, piso);
    }
    public ResidenteDTO getResidente() {
        return residente;
    }

    public void asignarHabitacion(ResidenteDTO residente, String piso, int numeroHabitacion) throws NegocioException{
        administradorHabitaciones.asignarHabitacion(residente.getMatricula(), piso, numeroHabitacion);
    }
    
    public List<HabitacionDTO> getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }
    
    
    
    public void setResidente(ResidenteDTO residente){
        this.residente = residente;
    }
    
    public ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo){
        return administradorResidentes.asignarTipo(residente, tipo);
    }
    
    public ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        return administradorResidentes.getEstudiante(matricula);
    }
    
    public ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        return administradorResidentes.getEstudianteCIA(matricula);
    }
    
}
