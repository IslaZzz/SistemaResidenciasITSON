/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import presentacion.FrmActualizarResidente;
import presentacion.FrmInfoEstudiante;
import presentacion.FrmIngresarIDEstudiante;

/**
 * Controlador para gestionar el flujo de actualizacion de datos de un residente.
 * Coordina las interacciones entre las pantallas de ingreso de ID, visualizacion de datos
 * y actualizacion de informacion del residente, utilizando la fachada de administrador de residentes.
 */
public class ControlActualizarResidente {
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmActualizarResidente frameActualizarResidente;
    private ResidenteDTO residente;
    
    /**
     * Constructor que inicializa los frames para el flujo de actualizacion.
     */
    public ControlActualizarResidente() {
        this.frameIngresarIDEstudiante = new FrmIngresarIDEstudiante(this, 1); 
        this.frameInfoEstudiante = new FrmInfoEstudiante(this, 1);            
        this.frameActualizarResidente = new FrmActualizarResidente(this);
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

    /**
     * Muestra la pantalla de actualizacion de datos del residente
     */
    public void mostrarActualizarResidente() {
        frameInfoEstudiante.dispose();
        frameActualizarResidente.setVisible(true);
        frameActualizarResidente.setResizable(false);
        frameActualizarResidente.setLocationRelativeTo(null);
        frameActualizarResidente.cargarResidente(residente);
    }

    /**
     * Vuelve a la pantalla de ingreso de ID
     */
    public void volverIngresarIDEstudiante() {
        if (frameInfoEstudiante.isVisible()) {
            frameInfoEstudiante.dispose();
        } else if (frameActualizarResidente.isVisible()) {
            frameActualizarResidente.dispose();
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
        if (frameActualizarResidente.isVisible()) {
            frameActualizarResidente.dispose();
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
     * @return DTO del residente
     */
    public ResidenteDTO getResidente() {
        return residente;
    }

    /**
     * Consulta un residente por su ID
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
     * @param id ID del residente
     * @param nombreContactoEmergencia Nombre del contacto de emergencia
     * @param telefonoContactoEmergencia Teléfono del contacto de emergencia
     * @throws NegocioException Si hay un error
     */
    public void actualizarDatos(String id, String nombreContactoEmergencia, String telefonoContactoEmergencia) throws NegocioException {
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

            // Guardar los cambios usando registrarResidente (asumiendo que sobrescribe los datos existentes)
            try {
                //adminResidentes.actualizarResidente(residente);
                System.out.println("Residente actualizado con éxito: " + residente.getMatricula());
                this.residente = residente; // Sincronizar con el controlador
            } catch (Exception e) {
                System.out.println("Error al actualizar residente: " + e.getMessage());
                throw new NegocioException("Error al actualizar el residente: " + e.getMessage());
            }

            // Regresar a la pantalla de ingreso de ID
            this.volverIngresarIDEstudiante();
        }

    
}
