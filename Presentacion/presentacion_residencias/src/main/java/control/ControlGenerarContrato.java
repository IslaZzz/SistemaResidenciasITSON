/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dto.ResidenteDTO;
import presentacion.cuGenerarContrato.FrmContratoGeneradoExitosamente;
import presentacion.cuGenerarContrato.FrmError;
import presentacion.cuGenerarContrato.FrmIngresarIDResidente;
import presentacion.cuGenerarContrato.FrmPreviewResidente;
import presentacion.cuGenerarContrato.FrmRegistroFiador;

/**
 *
 * @author abrilislas
 */
public class ControlGenerarContrato {
    
    FrmIngresarIDResidente frmIngresarID = new FrmIngresarIDResidente(this);
    FrmPreviewResidente frmPreviewResidente = new FrmPreviewResidente(this);
    FrmRegistroFiador frmRegistroFiador = new FrmRegistroFiador(this);
    FrmContratoGeneradoExitosamente frmContratoExitoso = new FrmContratoGeneradoExitosamente(this);
    FrmError frmError = new FrmError(this);
    
    public void iniciarFlujo(){
        frmIngresarID.setVisible(true);
        frmIngresarID.limpiarCampoTextoID();
    }
    
    public void terminarFlujoExitoso(){
        frmContratoExitoso.dispose();
        ControlFlujo.iniciarFlujo();
    }
    
    public void previewResidente(ResidenteDTO residenteDTO){
        frmPreviewResidente.setVisible(true);
    
    }

    public void registrarFiador(){
        frmRegistroFiador.setVisible(true);
    }
    
    
    
}
