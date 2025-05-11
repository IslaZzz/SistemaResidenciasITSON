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
import presentacion.FrmAsignarHabitacionManual;
import presentacion.FrmAsignarHabitacion;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;
import presentacion.FrmResidenteAltaExitosa;
import presentacion.FrmTipoResidente;

public class ControlAltaResidente {
    
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmTipoResidente frameTipoResidente;
    private FrmAsignarHabitacionManual frameAsignarHabitacionManual;
    private FrmResidenteAltaExitosa frameAltaExitosa;
    private ResidenteDTO residente;
    private FrmAsignarHabitacion frameAsignarHabitacion;

    
    public ControlAltaResidente(){
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this);
        frameInfoEstudiante = new FrmInfoEstudiante(this);
        frameTipoResidente = new FrmTipoResidente(this);
        frameAltaExitosa = new FrmResidenteAltaExitosa(this);
        frameAsignarHabitacionManual = new FrmAsignarHabitacionManual(this);
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
        if(frameAsignarHabitacion == null) {
            frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        }
        frameAsignarHabitacion.setVisible(true);
        frameAsignarHabitacion.setLocationRelativeTo(null);
        frameAsignarHabitacion.setResizable(false);

    }
 
      public void mostrarAsignarHabitacionManual(){
        frameTipoResidente.dispose();
        frameAsignarHabitacionManual.setVisible(true);
        frameAsignarHabitacionManual.setLocationRelativeTo(null);
        frameAsignarHabitacionManual.setResizable(false);
      }


        public void mostrarAltaExitosa(){
        frameAsignarHabitacion.dispose();
        frameAltaExitosa.setVisible(true);
        frameAltaExitosa.setLocationRelativeTo(null);
        frameAltaExitosa.setResizable(false);
    }

    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesParaResidente(residente, piso);
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
        adminHabitaciones.asignarHabitacion(residente, habitacion);
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

    public List<Integer> getPisosDisponibles(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    public List<HabitacionDTO> getHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesRecomendadas(residente, piso);
    }
}