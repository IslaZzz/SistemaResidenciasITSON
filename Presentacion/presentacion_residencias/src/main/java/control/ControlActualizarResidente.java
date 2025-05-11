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
 *
 * @author victoria
 */
public class ControlActualizarResidente {
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmActualizarResidente frameActualizarResidente;
    private ResidenteDTO residente;
    
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
        frameInfoEstudiante.cargarEstudiante(residente);
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

    /**
     * Obtiene el residente actual
     * @return DTO del residente
     */
    public ResidenteDTO getResidente() {
        return residente;
    }

    /**
     * Establece el residente actual
     * @param residente DTO del residente
     */
    public void setResidente(ResidenteDTO residente) {
        this.residente = residente;
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
     * Actualiza el contacto de emergencia de un residente
     * @param id del residente
     * @param nombreContactoEmergencia Nombre del contacto de emergencia
     * @param telefonoContactoEmergencia Telefono del contacto de emergencia
     * @throws NegocioException Si pasa un error
     */
    public void actualizarContactoEmergencia(String id, String nombreContactoEmergencia, String telefonoContactoEmergencia) throws NegocioException {
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        try {
            ResidenteDTO residente = adminResidentes.getResidente(id);
            if (residente != null) {
                // actualiza solo el contacto de emergencia
                residente.setNombreContactoEmergencia(nombreContactoEmergencia);
                residente.setTelefonoContactoEmergencia(telefonoContactoEmergencia);
                adminResidentes.registrarResidente(residente); 
            } else {
                throw new NegocioException("Residente con ID " + id + " no encontrado.");
            }
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el contacto de emergencia: " + e.getMessage());
        }
    }
}
