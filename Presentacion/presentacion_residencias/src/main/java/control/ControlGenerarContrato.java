/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorFiador.AdministradorFiadorFachada;
import administradorFiador.IAdministradorFiador;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.FiadorDTO;
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
    
    private static ControlGenerarContrato instance;
    
    FrmIngresarIDResidente frmIngresarID = new FrmIngresarIDResidente(this);
    FrmPreviewResidente frmPreviewResidente = new FrmPreviewResidente(this);
    FrmRegistroFiador frmRegistroFiador = new FrmRegistroFiador(this);
    FrmContratoGeneradoExitosamente frmContratoExitoso = new FrmContratoGeneradoExitosamente(this);
    FrmError frmError = new FrmError(this);
    ResidenteDTO residenteDTO;
    
    
    public static ControlGenerarContrato getInstance() {
        if (instance == null) {
            instance = new ControlGenerarContrato();
        }
        return instance;
    }
    
    /**
     * Metodo para iniciar el CU de generar contrato
     * invoca la pantalla para ingresar el ID del residente
     */
    public void iniciarFlujo(){
        frmIngresarID.setVisible(true);
        frmIngresarID.limpiarCampoTextoID();
    }
    /**
     * Metodo que invoca a la pantalla de descarga del PDF con el contrato
     * 
     */
    public void terminarFlujoExitoso(){
        frmContratoExitoso.setVisible(true);
    }
     /**
     * Metodo que invoca a una pantalla con una vista previa del residente 
     *recibe como parametro el DTO obtenido con el metodo buscar residente 
     * 
     * @param residenteDTO 
     */
    public void previewResidente(ResidenteDTO residenteDTO){
        frmIngresarID.dispose();
        frmPreviewResidente.setVisible(true);
        frmPreviewResidente.cargarResidente(residenteDTO);
        this.residenteDTO=residenteDTO;
    
    }
    /**
     * metodo para invocar a la pantalla de registro del fiador
     */
    public void abrirFormularioFiador(){
        frmPreviewResidente.dispose();
        frmRegistroFiador.setVisible(true);
        frmRegistroFiador.obtenerResidente(residenteDTO);
    }
    /**
     * Accedemos al subsistema de administrador residentes para recuperar la informacion del residente
     * @param matricula
     * @return 
     */
    public ResidenteDTO buscarResidente(String matricula) throws Exception {
        IAdministradorResidentes administradorResidentes = new AdministradorResidentesFachada();
        return administradorResidentes.getResidente(matricula);
    } 
    
    /**
     * 
     * @param fiadorDTO 
     */
    public void registrarFiador(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO){
        IAdministradorFiador administradorFiador = new AdministradorFiadorFachada();
        try{
        administradorFiador.registrarFiador(fiadorDTO, residenteDTO);
        }catch(Exception ex){
            ex.getMessage();
        
        }
    
    }
}
