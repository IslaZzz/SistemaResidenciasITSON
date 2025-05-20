/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import presentacion.FrmActualizarResidente;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import implementaciones.RelacionResidentesHabitacionDAOImp;
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
    private ResidenteDTO residente;
    private RelacionResidentesHabitacionDAOImp relacionDAO = new RelacionResidentesHabitacionDAOImp();

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
     * Actualiza los datos del contacto de emergencia del residente y la habitación si se especifica.
     * 
     * @param id del residente
     * @param nombreContactoEmergencia  
     * @param telefonoContactoEmergencia 
     * @param piso de la nueva habitacion
     * @param numero de la nueva habitacion 
     * @throws NegocioException Si hay un error
     */
    public void actualizarDatos(String id, String nombreContactoEmergencia, String telefonoContactoEmergencia,
            Integer piso, Integer numero) throws NegocioException {
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

        // Actualizar datos del contacto de emergencia
        residente.setNombreContactoEmergencia(nombreContactoEmergencia);
        residente.setTelefonoContactoEmergencia(telefonoContactoEmergencia);
        adminResidentes.actualizarResidente(residente);

        // Manejar la asignación de habitación si se proporcionó
        if (piso != null && numero != null) {
            HabitacionDTO nuevaHabitacion = new HabitacionDTO(piso, numero);

            // Obtener la habitación actual del residente
            HabitacionDTO habitacionActual = relacionDAO.obtenerHabitacionDeResidente(residente);
            boolean esNuevaHabitacionDiferente = true;
            if (habitacionActual != null) {
                esNuevaHabitacionDiferente = habitacionActual.getPiso() != piso || habitacionActual.getNumero() != numero;
            }

            // Si la nueva habitación es diferente a la actual
            if (esNuevaHabitacionDiferente) {
                // Desasignar la habitación actual si existe
                if (residente.getIdHabitacion() != null) {
                    relacionDAO.desasignarHabitacion(residente);
                }

                // Asignar la nueva habitación
                relacionDAO.asignarHabitacion(residente, nuevaHabitacion);
            }
        }

        System.out.println("Residente actualizado con éxito: " + residente.getMatricula());
        this.residente = residente; // Sincronizar con el controlador

        // Regresar a la pantalla de ingreso de ID
        this.volverIngresarIDEstudiante();
    }

    /**
     * Asigna tipo de residente
     * @param tipo 
     */
    public void asignarTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de residente no puede ser nulo o vacío");
        }
        this.residente.setTipoResidente(tipo);
    }

    /**
     * Actualiza la informacion de un residente en el sistema.
     * @param residenteDTO DTO del residente
     */
    public void actualizarResidente(ResidenteDTO residenteDTO) {
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        adminResidentes.actualizarResidente(residenteDTO);
    }

    public void mostrarAsignarHabitacion() {
    }
}
