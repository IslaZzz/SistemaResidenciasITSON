package control;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import java.util.List;
import excepciones.NegocioException;
import presentacion.FrmAsignarHabitacion;
import presentacion.FrmAsignarHabitacionManual;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;
import presentacion.FrmTipoResidente;

/**
 * Controlador para gestionar el flujo de actualizacion de datos de un
 * residente.
 * Coordina las interacciones entre las pantallas de ingreso de ID,
 * visualizacion de datos
 * y actualizacion de informacion del residente, utilizando la fachada de
 * administrador de residentes.
 */
public class ControlActualizarResidente {
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmTipoResidente frameTipoResidente;
    private FrmAsignarHabitacion frameAsignarHabitacion;
    private FrmAsignarHabitacionManual frameAsignarHabitacionManual;
    private ResidenteDTO residente;

    /**
     * Constructor que inicializa los frames para el flujo de actualizacion.
     */
    public ControlActualizarResidente() {
        this.frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this, FrmIngresarIDEstudiante.TIPO_ACTUALIZAR);
        this.frameInfoEstudiante = new FrmInfoEstudiante(this, FrmInfoEstudiante.TIPO_ACTUALIZAR);
        this.frameTipoResidente = new FrmTipoResidente(this, FrmTipoResidente.TIPO_ACTUALIZAR);
    }

    /**
     * Inicia el flujo mostrando la pantalla de ingreso de ID
     */
    public void iniciarFlujo() {
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
        frameIngresarIDEstudiante.limpiarCampoTextoID();
    }

    /**
     * Muestra la pantalla de datos del residente
     * 
     * @param residente DTO con la info del residente
     */
    public void mostrarDatosResidente(ResidenteDTO residente) {
        this.residente = residente;
        frameIngresarIDEstudiante.dispose();
        frameInfoEstudiante.setVisible(true);
        frameInfoEstudiante.setResizable(false);
        frameInfoEstudiante.setLocationRelativeTo(null);
        frameInfoEstudiante.cargarResidente(residente);
    }

    public void mostrarTipoResidente() {
        frameInfoEstudiante.dispose();
        frameTipoResidente.setVisible(true);
        frameTipoResidente.setResizable(false);
        frameTipoResidente.setLocationRelativeTo(null);
        frameTipoResidente.cargarInfo(residente);
    }

    /**
     * Vuelve a la pantalla de ingreso de ID
     */
    public void volverIngresarIDEstudiante() {
        if (frameInfoEstudiante.isVisible()) {
            frameInfoEstudiante.dispose();
        }
        frameIngresarIDEstudiante.setVisible(true);
        frameIngresarIDEstudiante.setResizable(false);
        frameIngresarIDEstudiante.setLocationRelativeTo(null);
        frameIngresarIDEstudiante.limpiarCampoTextoID();
    }

    /**
     * Finaliza el actualizar y regresa al flujo principal
     */
    public void acabarCaso() {
        if (frameIngresarIDEstudiante.isVisible()) {
            frameIngresarIDEstudiante.dispose();
        }
        if (frameInfoEstudiante.isVisible()) {
            frameInfoEstudiante.dispose();
        }
        if (frameAsignarHabitacionManual != null && frameAsignarHabitacionManual.isVisible()) {
            frameAsignarHabitacionManual.dispose();
        }
        if (frameTipoResidente.isVisible()) {
            frameTipoResidente.dispose();
        }
        if (frameAsignarHabitacion.isVisible()) {
            frameAsignarHabitacion.dispose();
        }

        ControlFlujo.iniciarFlujo();
    }

    public void setResidente(ResidenteDTO residente) {
        System.out.println("Estableciendo residente: " + (residente != null ? residente.getMatricula() : "null"));
        if (residente == null) {
            throw new IllegalArgumentException("El residente no puede ser null");
        }
        this.residente = residente;
    }

    /**
     * Obtiene el residente actual
     * 
     * @return DTO del residente
     */
    public ResidenteDTO getResidente() {
        return residente;
    }

    /**
     * Consulta un residente por su ID
     * 
     * @param id del residente
     * @return DTO del residente
     * @throws NegocioException Si hay un error
     */
    public ResidenteDTO consultarResidentePorId(String id) throws NegocioException {
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.getResidente(id);
    }

    /**
     * Actualiza los datos del contacto de emergencia del residente
     * 
     * @param id                         ID del residente
     * @param nombreContactoEmergencia   Nombre del contacto de emergencia
     * @param telefonoContactoEmergencia Teléfono del contacto de emergencia
     * @throws NegocioException Si hay un error
     */
    public void actualizarDatos(String id, String nombreContactoEmergencia, String telefonoContactoEmergencia)
            throws NegocioException {
        System.out.println("Iniciando actualización de datos para residente con ID: " + id);

        // Validaciones
        if (id == null || id.trim().isEmpty()) {
            throw new NegocioException("El ID del residente es obligatorio.");
        }
        if (nombreContactoEmergencia == null || nombreContactoEmergencia.trim().isEmpty()) {
            throw new NegocioException("El nombre del contacto de emergencia es obligatorio.");
        }
        if (telefonoContactoEmergencia == null || !telefonoContactoEmergencia.matches("^\\d{10}$")) {
            throw new NegocioException("El número de contacto de emergencia debe tener 10 dígitos.");
        }

        // Obtener el residente desde la base de datos
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        ResidenteDTO residente = adminResidentes.getResidente(id);
        if (residente == null) {
            throw new NegocioException("Residente con ID " + id + " no encontrado.");
        }

        // Actualizar solo los campos de contacto de emergencia
        residente.setNombreContactoEmergencia(nombreContactoEmergencia);
        residente.setTelefonoContactoEmergencia(telefonoContactoEmergencia);

        // Guardar los cambios usando registrarResidente
        try {
            adminResidentes.actualizarResidente(residente);
            System.out.println("Residente actualizado con éxito: " + residente.getMatricula());
            this.residente = residente;
        } catch (Exception e) {
            System.out.println("Error al actualizar residente: " + e.getMessage());
            throw new NegocioException("Error al actualizar el residente: " + e.getMessage());
        }

        // Regresar a la pantalla de ingreso de ID
        this.volverIngresarIDEstudiante();
    }

    public void asignarTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de residente no puede ser nulo o vacío");
        }
        this.residente.setTipoResidente(tipo);
    }

    /**
     * Actualiza la informacion de un residente en el sistema.
     * 
     * @param residenteDTO DTO del residente
     */
    public void actualizarResidente(ResidenteDTO residenteDTO) {
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        adminResidentes.actualizarResidente(residenteDTO);
    }

    public void mostrarAsignarHabitacion() {
        if (frameTipoResidente.isVisible()) {
            frameTipoResidente.dispose();
        }
        if (frameAsignarHabitacion == null) {
            frameAsignarHabitacion = new FrmAsignarHabitacion(this);
        }
        frameAsignarHabitacion.setVisible(true);
        frameAsignarHabitacion.setLocationRelativeTo(null);
        frameAsignarHabitacion.setResizable(false);
    }

    public void actualizarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) throws NegocioException {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        adminHabitaciones.asignarHabitacion(residente, habitacion);
        adminHabitaciones.desasignarHabitacion(residente);
    }

    /**
     * Muestra la pantalla para asignar una habitacion manualmente.
     * Cierra la pantalla de tipo de residente y configura la nueva ventana.
     */
    public void mostrarAsignarHabitacionManual() {
        if (frameTipoResidente.isVisible()) {
            frameTipoResidente.dispose();
        }
        if (frameAsignarHabitacionManual == null) {
            frameAsignarHabitacionManual = new FrmAsignarHabitacionManual(this);
        }
        frameTipoResidente.dispose();
        frameAsignarHabitacionManual.setVisible(true);
        frameAsignarHabitacionManual.setLocationRelativeTo(null);
        frameAsignarHabitacionManual.setResizable(false);
    }

    public List<Integer> getPisosDisponibles() {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente en un piso
     * especifico.
     * 
     * @param residente DTO del residente
     * @param piso      Numero del piso
     * @return Lista de DTOs de habitaciones recomendadas
     * @throws NegocioException Si hay un error al consultar las habitaciones
     */
    public List<HabitacionDTO> getHabitacionesRecomendadas(ResidenteDTO residente, int piso) throws NegocioException {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesRecomendadas(residente, piso);
    }

    /**
     * Obtiene una lista de habitaciones disponibles para un residente en un piso
     * especifico.
     * 
     * @param residente DTO del residente
     * @param piso      Numero del piso
     * @return Lista de DTOs de habitaciones disponibles
     * @throws NegocioException Si hay un error al consultar las habitaciones
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso)
            throws NegocioException {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesParaResidente(residente, piso);
    }

}
