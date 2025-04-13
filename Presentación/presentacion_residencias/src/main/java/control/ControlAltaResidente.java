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
    private ResidenteDTO residente;
    private List<HabitacionDTO> habitacionesDisponibles;
    
    public ControlAltaResidente(){
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this);
        frameInfoEstudiante = new FrmInfoEstudiante(this);
        frameTipoResidente = new FrmTipoResidente(this);
        frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        
        
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
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponibles(residente);
    }

    public List<String> obtenerPisosDisponibles(List<HabitacionDTO> habitaciones){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerPisosDisponibles(habitaciones);
    }

    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(List<HabitacionDTO> habitaciones, String piso){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesEnPiso(habitaciones, piso);
    }
    public ResidenteDTO getResidente() {
        return residente;
    }

    public void asignarHabitacion(ResidenteDTO residente, String piso, int numeroHabitacion) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        adminHabitaciones.asignarHabitacion(residente.getMatricula(), piso, numeroHabitacion);
    }
    
    public List<HabitacionDTO> getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }
    
    
    
    public void setResidente(ResidenteDTO residente){
        this.residente = residente;
    }
    
    public ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo){
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.asignarTipo(residente, tipo);
    }
    
    public ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.fetchEstudiante(matricula);
    }
    
    public ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.fetchEstudianteCIA(matricula);
    }
    
}
