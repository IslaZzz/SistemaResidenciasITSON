package control;

import DTO_Infraestructura.AlumnoInfDTO;
import java.util.List;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import presentacion.FrmAsignarHabitacion;
import presentacion.FrmAsignarHabitacionPrueba;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;
import presentacion.FrmResidenteAltaExitosa;
import presentacion.FrmTipoResidente;

public class ControlAltaResidente {
    
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmTipoResidente frameTipoResidente;
    private FrmAsignarHabitacion frameAsignarHabitacion;
    private FrmResidenteAltaExitosa frameAltaExitosa;
    private ResidenteDTO residente;
    private List<HabitacionDTO> habitacionesDisponibles;
    private FrmAsignarHabitacionPrueba frameAsignarHabitacionPrueba;

    
    public ControlAltaResidente(){
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this);
        frameInfoEstudiante = new FrmInfoEstudiante(this);
        frameTipoResidente = new FrmTipoResidente(this);
        frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        frameAltaExitosa = new FrmResidenteAltaExitosa(this);
        
        
    }
    public void iniciarFlujo(){
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
        frameIngresarIDEstudiante.limpiarCampoTextoID();
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
        if(frameInfoEstudiante.isVisible()){
            frameInfoEstudiante.dispose();
        } else {
            frameAltaExitosa.dispose();
        }
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
        frameIngresarIDEstudiante.limpiarCampoTextoID();
    }
    
    public void acabarCaso(){
        frameIngresarIDEstudiante.dispose();
        frameAltaExitosa.dispose();
        ControlFlujo.iniciarFlujo();
    }
     public void mostrarAsignarHabitacion() throws NegocioException{
        frameTipoResidente.dispose();
        //frameAsignarHabitacion.cargarInfo(residente);
        frameAsignarHabitacion.setVisible(true);
        frameAsignarHabitacion.setLocationRelativeTo(null);
        frameAsignarHabitacion.setResizable(false);
        habitacionesDisponibles = obtenerHabitacionesDisponibles(residente);
        frameAsignarHabitacion.cargarPisos();

    }
 
      public void mostrarAsignarHabitacionPrueba(ResidenteDTO residente) throws NegocioException{
        frameTipoResidente.dispose();
        frameAsignarHabitacionPrueba.cargarInfo(residente);
        habitacionesDisponibles = obtenerHabitacionesDisponibles(residente);
     //   frameAsignarHabitacionPrueba = obtenerHabitacionesDisponibles(residente);
        frameAsignarHabitacionPrueba.habitacionesDisponibles(habitacionesDisponibles);
        //frameAsignarHabitacionPrueba.cargarPisos(habitacionesDisponibles);
      }


        public void mostrarAltaExitosa(){
        frameAsignarHabitacion.dispose();
        frameAltaExitosa.setVisible(true);
        frameAltaExitosa.setLocationRelativeTo(null);
        frameAltaExitosa.setResizable(false);
    }
    
    
    

    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponibles(residente);
    }

    public List<Integer> obtenerPisosDisponibles(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesEnPiso(piso);
    }
    public ResidenteDTO getResidente() {
        return residente;
    }

    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        adminHabitaciones.asignarHabitacion(residente.getMatricula(), habitacion);
    }
    
    public List<HabitacionDTO> getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }
      
    public void setResidente(ResidenteDTO residente){
        this.residente = residente;
    }
    
    public void registrarResidente(ResidenteDTO residente){
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        adminResidentes.registrarResidente(residente);
    }

    public void asignarTipo(String tipo){
        this.residente.setTipoResidente(tipo);
    }
    
    public void asignarTipo(ResidenteDTO residenteDTO, String tipo){
        residenteDTO.setTipoResidente(tipo);
    }
    

    public ResidenteDTO getResidente(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.getResidente(matricula);
    }
    
    public ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        AlumnoInfDTO alumno = new AlumnoInfDTO(matricula);
        return adminResidentes.fetchEstudianteCIA(alumno);
    }
}