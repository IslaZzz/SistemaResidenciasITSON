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

/**
 * Controlador para gestionar el flujo de registro de un nuevo residente.
 * Coordina las interacciones entre pantallas para ingresar ID, mostrar informacion,
 * asignar tipo de residente, asignar habitacion y confirmar el registro exitoso.
 */
public class ControlAltaResidente {
    
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmTipoResidente frameTipoResidente;
    private FrmAsignarHabitacionManual frameAsignarHabitacionManual;
    private FrmResidenteAltaExitosa frameAltaExitosa;
    private ResidenteDTO residente;
    private FrmAsignarHabitacion frameAsignarHabitacion;

    /**
     * Constructor que inicializa los frames necesarios para el flujo de registro.
     * Crea instancias de las pantallas asociadas a este controlador.
     */
    public ControlAltaResidente(){
        // Para FrmIngresarIDEstudiante, tipo = 0 (alta)
        frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this, FrmTipoResidente.TIPO_ALTA);
        // Para FrmInfoEstudiante, tipo = "registrar" (alta)
        frameInfoEstudiante = new FrmInfoEstudiante(this, FrmTipoResidente.TIPO_ALTA);
        frameTipoResidente = new FrmTipoResidente(this, FrmTipoResidente.TIPO_ALTA);
        frameAltaExitosa = new FrmResidenteAltaExitosa(this);
        frameAsignarHabitacionManual = new FrmAsignarHabitacionManual(this);
    }

    /**
     * Inicia el flujo mostrando la pantalla para ingresar el ID del residente.
     * Configura la ventana como no redimensionable, centrada y con el campo de texto limpio.
     */
    public void iniciarFlujo(){
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
        frameIngresarIDEstudiante.limpiarCampoTextoID();
    }
    
    /**
     * Muestra la pantalla con la informacion del estudiante.
     * Cierra la pantalla de ingreso de ID y carga los datos del estudiante en la nueva ventana.
     * 
     * @param estudiante DTO con la informacion del residente
     */
    public void mostrarInfoEstudiante(ResidenteDTO estudiante){
        frameIngresarIDEstudiante.dispose();
        frameInfoEstudiante.setVisible(true);
        frameInfoEstudiante.setResizable(false);
        frameInfoEstudiante.setLocationRelativeTo(null);
        frameInfoEstudiante.cargarEstudiante(estudiante);
    }
    
    /**
     * Muestra la pantalla para seleccionar el tipo de residente.
     * Cierra la pantalla de informacion y carga los datos del residente en la nueva ventana.
     */
    public void mostrarTipoResidente(){
        frameInfoEstudiante.dispose();
        frameTipoResidente.setVisible(true);
        frameTipoResidente.setResizable(false);
        frameTipoResidente.setLocationRelativeTo(null);
        frameTipoResidente.cargarInfo(residente);
    }
    
    /**
     * Regresa a la pantalla de ingreso de ID.
     * Cierra la pantalla de informacion o la de alta exitosa y reinicia el campo de texto.
     */
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
    
    /**
     * Finaliza el caso de uso y regresa al flujo principal.
     * Cierra las pantallas abiertas y llama al metodo iniciarFlujo de ControlFlujo.
     */
    public void acabarCaso(){
        frameIngresarIDEstudiante.dispose();
        frameAltaExitosa.dispose();
        ControlFlujo.iniciarFlujo();
    }
    
    /**
     * Muestra la pantalla para asignar una habitacion automaticamente.
     * Cierra la pantalla de tipo de residente y crea la ventana si no existe.
     * @throws NegocioException Si hay un error al cargar las habitaciones
     */
    public void mostrarAsignarHabitacion() throws NegocioException{
        frameTipoResidente.dispose();
        if(frameAsignarHabitacion == null) {
            frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        }
        frameAsignarHabitacion.setVisible(true);
        frameAsignarHabitacion.setLocationRelativeTo(null);
        frameAsignarHabitacion.setResizable(false);
    }
 
    /**
     * Muestra la pantalla para asignar una habitacion manualmente.
     * Cierra la pantalla de tipo de residente y configura la nueva ventana.
     */
    public void mostrarAsignarHabitacionManual(){
        frameTipoResidente.dispose();
        frameAsignarHabitacionManual.setVisible(true);
        frameAsignarHabitacionManual.setLocationRelativeTo(null);
        frameAsignarHabitacionManual.setResizable(false);
    }

    /**
     * Muestra la pantalla de confirmacion de registro exitoso.
     * Cierra la pantalla de asignacion de habitacion y configura la nueva ventana.
     */
    public void mostrarAltaExitosa(){
        frameAsignarHabitacion.dispose();
        frameAltaExitosa.setVisible(true);
        frameAltaExitosa.setLocationRelativeTo(null);
        frameAltaExitosa.setResizable(false);
    }

    /**
     * Obtiene una lista de habitaciones disponibles para un residente en un piso especifico.
     * @param residente DTO del residente
     * @param piso Numero del piso
     * @return Lista de DTOs de habitaciones disponibles
     * @throws NegocioException Si hay un error al consultar las habitaciones
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesParaResidente(residente, piso);
    }

    /**
     * Obtiene una lista de todos los pisos disponibles.
     * @return Lista de numeros de pisos
     */
    public List<Integer> obtenerPisosDisponibles(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    /**
     * Obtiene una lista de habitaciones disponibles en un piso especifico.
     * @param piso Numero del piso
     * @return Lista de numeros de habitaciones disponibles
     */
    public List<Integer> obtenerHabitacionesDisponiblesEnPiso(int piso){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesEnPiso(piso);
    }
    
    /**
     * Obtiene el DTO del residente actual.
     * @return DTO del residente, o null si no se ha establecido
     */
    public ResidenteDTO getResidente() {
        return residente;
    }

    /**
     * Asigna una habitacion a un residente. 
     * @param residente DTO del residente
     * @param habitacion DTO de la habitacion
     * @throws NegocioException Si hay un error al asignar la habitacion
     */
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        adminHabitaciones.asignarHabitacion(residente, habitacion);
    }
    
    /**
     * Establece el DTO del residente actual.
     * @param residente DTO del residente
     */
    public void setResidente(ResidenteDTO residente){
        this.residente = residente;
    }
    
    /**
     * Registra un residente en el sistema.
     * @param residente DTO del residente
     */
    public void registrarResidente(ResidenteDTO residente){
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        adminResidentes.registrarResidente(residente);
    }

    /**
     * Asigna un tipo de residente al residente actual.
     * @param tipo Tipo de residente
     */
    public void asignarTipo(String tipo){
        this.residente.setTipoResidente(tipo);
    }
    
    /**
     * Obtiene un residente por su matricula.
     * @param matricula Matricula del residente
     * @return DTO del residente
     * @throws NegocioException Si el residente no existe o hay un error
     */
    public ResidenteDTO getResidente(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.getResidente(matricula);
    }
    
    /**
     * Obtiene un estudiante desde el sistema CIA por su matricula.
     * @param matricula Matricula del estudiante
     * @return DTO del residente
     * @throws NegocioException Si el estudiante no existe o hay un error
     */
    public ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        AlumnoInfDTO alumno = new AlumnoInfDTO(matricula);
        return adminResidentes.fetchEstudianteCIA(alumno);
    }

    /**
     * Obtiene una lista de todos los pisos disponibles. 
     * @return Lista de numeros de pisos
     */
    public List<Integer> getPisosDisponibles(){
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente en un piso especifico.
     * @param residente DTO del residente
     * @param piso Numero del piso
     * @return Lista de DTOs de habitaciones recomendadas
     * @throws NegocioException Si hay un error al consultar las habitaciones
     */
    public List<HabitacionDTO> getHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException{
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesRecomendadas(residente, piso);
    }

    
}