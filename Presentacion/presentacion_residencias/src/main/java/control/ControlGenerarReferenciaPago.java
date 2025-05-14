package control;

import administradorReferenciasPago.AdministradorReferenciasPagoFachada;
import administradorReferenciasPago.IAdministradorReferenciasPago;
import dto.ReferenciaPagoDTO;
import excepciones.NegocioException;
import presentacion.FrmIngresarIDReferenciaPago;
import presentacion.FrmRefPago;
import presentacion.FrmRefPagoEnviada;

public class ControlGenerarReferenciaPago {

    private FrmIngresarIDReferenciaPago frameIngresarID;
    private FrmRefPago frameReferenciaPago;
    private FrmRefPagoEnviada framePagoEnviada;

    ReferenciaPagoDTO referencia;

    public ControlGenerarReferenciaPago() {
        frameIngresarID = new FrmIngresarIDReferenciaPago(this);
        frameReferenciaPago = new FrmRefPago(this);
        framePagoEnviada = new FrmRefPagoEnviada(this);
    }

    public void iniciarFlujo() {
        frameIngresarID.setVisible(true);
        frameIngresarID.setResizable(false);
        frameIngresarID.setLocationRelativeTo(null);
        frameIngresarID.limpiarCampoTextoID();
    }

    public void acabarCaso() {
        frameIngresarID.dispose();
        framePagoEnviada.dispose();
        ControlFlujo.iniciarFlujo();
    }

    public void volverIngresarIDEstudiante() {
        if (frameReferenciaPago.isVisible()) {
            frameReferenciaPago.dispose();
        } else {
            framePagoEnviada.dispose();
        }
        frameIngresarID.setVisible(true);
        frameIngresarID.setResizable(false);
        frameIngresarID.setLocationRelativeTo(null);
        frameIngresarID.limpiarCampoTextoID();
    }

    public void mostrarReferenciaPago(ReferenciaPagoDTO referencia) {
        frameIngresarID.dispose();
        frameReferenciaPago.setVisible(true);
        frameReferenciaPago.setResizable(false);
        frameReferenciaPago.setLocationRelativeTo(null);
        frameReferenciaPago.cargarReferenciaPago(referencia);
    }

    public void setReferencia(ReferenciaPagoDTO referencia) {
        this.referencia = referencia;
    }
    
    public void enviarReferencia(){
        if (frameReferenciaPago.isVisible()) {
            frameReferenciaPago.dispose();
        } else {
            frameIngresarID.dispose();
        }
        // implementar
        
        framePagoEnviada.setVisible(true);
        framePagoEnviada.setResizable(false);
        framePagoEnviada.setLocationRelativeTo(null);
    }

    public ReferenciaPagoDTO generarReferencia(String matricula) throws NegocioException {
        IAdministradorReferenciasPago adminReferenciasPago = new AdministradorReferenciasPagoFachada();
        ReferenciaPagoDTO referencia = new ReferenciaPagoDTO();
        referencia.setMatriculaResidente(matricula);
        return adminReferenciasPago.getReferencia(referencia);
    }

}
