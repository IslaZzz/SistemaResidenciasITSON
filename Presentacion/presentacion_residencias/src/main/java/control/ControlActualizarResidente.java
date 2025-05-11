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


public class ControlActualizarResidente {
    private FrmIngresarIDEstudiante frameIngresarIDEstudiante;
    private FrmInfoEstudiante frameInfoEstudiante;
    private FrmActualizarResidente frameActualizarResidente;
    private ResidenteDTO residente;
    
    /**
     * Constructor que inicializa los frames.
     */
    public ControlActualizarResidente() {
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
     * Actualiza los datos del contacto de emergencia del residente
     * @param id ID del residente
     * @param nombreContactoEmergencia Nombre del contacto de emergencia
     * @param telefonoContactoEmergencia Teléfono del contacto de emergencia
     * @throws NegocioException Si hay un error
     */
    public void actualizarDatos(String id, String nombreContactoEmergencia, String telefonoContactoEmergencia) throws NegocioException {
        // Validaciones
        if (nombreContactoEmergencia.isEmpty() || telefonoContactoEmergencia.isEmpty()) {
            throw new NegocioException("Todos los campos del contacto de emergencia deben estar llenos.");
        }
        if (!telefonoContactoEmergencia.matches("^\\d{10}$")) {
            throw new NegocioException("El número de contacto de emergencia debe tener 10 dígitos.");
        }

        // Actualización del contacto de emergencia
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        ResidenteDTO residente = adminResidentes.getResidente(id);
        if (residente != null) {
            residente.setNombreContactoEmergencia(nombreContactoEmergencia);
            residente.setTelefonoContactoEmergencia(telefonoContactoEmergencia);
            adminResidentes.registrarResidente(residente);
            System.out.println("Actualización exitosa para el residente con ID: " + id);
        } else {
            throw new NegocioException("Residente con ID " + id + " no encontrado.");
        }

        // Regresar a la pantalla de ingreso de ID
        volverIngresarIDEstudiante();
    }
}
