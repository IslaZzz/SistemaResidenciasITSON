package control;

import presentacion.FrmIngresarIDReferenciaPago;
import presentacion.FrmRefPago;
import presentacion.FrmRefPagoEnviada;

public class ControlGenerarReferenciaPago {

    private FrmIngresarIDReferenciaPago frameIngresarID;
    private FrmRefPago frameReferenciaPago;
    private FrmRefPagoEnviada framePagoEnviada;

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

}
