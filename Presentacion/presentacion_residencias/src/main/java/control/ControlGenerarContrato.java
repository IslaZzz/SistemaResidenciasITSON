/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorFiador.AdministradorFiadorFachada;
import administradorFiador.IAdministradorFiador;
import administradorGenerarContrato.AdministradorGenerarContratoFachada;
import administradorGenerarContrato.IAdministradorGenerarContrato;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.FiadorDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.io.File;
import presentacion.cuGenerarContrato.FrmContratoGeneradoExitosamente;
import presentacion.cuGenerarContrato.FrmError;
import presentacion.cuGenerarContrato.FrmFiadorEncontrado;
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
    ResidenteDTO residenteDTO;
    FrmError frmError = new FrmError(this);
    FrmContratoGeneradoExitosamente frmContratoExitoso = new FrmContratoGeneradoExitosamente(this);
    FrmFiadorEncontrado frmFiadorEncontrado = new FrmFiadorEncontrado(this);

    
    
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
     * Metodo que invoca a una pantalla con una vista previa del residente 
     *recibe como parametro el DTO obtenido con el metodo buscar residente 
     * 
     * @param residenteDTO 
     */
    public void previewResidente(ResidenteDTO residenteDTO){
        this.residenteDTO=residenteDTO;
        frmIngresarID.dispose();
        frmPreviewResidente.setVisible(true);
        frmPreviewResidente.cargarResidente(residenteDTO);
        this.residenteDTO=residenteDTO;
        validacionFiador(residenteDTO);
        //verificacion para ver si ya tiene un fiador registrado
    
    }
    
    private void validacionFiador(ResidenteDTO residenteDTO){
        if(residenteDTO.getFiador()!=null){
            abrirPantallaFiadorEncontrado(residenteDTO);
        }
    
    }
    
    /**
     * Metodo que invoca a la pantalla de descarga del PDF con el contrato
     * 
     */
    public void terminarFlujoExitoso(){
        frmContratoExitoso.setVisible(true);
    }
    /**
     * metodo para invocar a la pantalla de registro del fiador
     * @param residente recibe el residente con el cual se vinculara el contrato
     */
    public void abrirFormularioFiador(ResidenteDTO residente){
        frmPreviewResidente.dispose();
        frmRegistroFiador.setVisible(true);
        frmRegistroFiador.obtenerResidente(residente);
    }
    
    public void abrirPantallaError(){
        frmRegistroFiador.dispose();
        frmContratoExitoso.dispose();
        frmError.setVisible(true);
    }
    
    public void abrirPantallaDescarga(ResidenteDTO residenteDTO){
        frmRegistroFiador.dispose();
        frmContratoExitoso.enviarResidenteDTO(residenteDTO);
        frmContratoExitoso.setVisible(true);
        
    
    }
    
    public void abrirPantallaFiadorEncontrado(ResidenteDTO residente){
        frmFiadorEncontrado.setVisible(true);
    }
    
    
    /**
     * Accedemos al subsistema de administrador residentes para recuperar la informacion del residente
     * @param matricula
     * @return 
     * @throws java.lang.Exception 
     */
    public ResidenteDTO buscarResidente(String matricula) throws Exception {
        IAdministradorResidentes administradorResidentes = new AdministradorResidentesFachada();
        return administradorResidentes.getResidente(matricula);
    } 
    
    /**
     * 
     * @param fiadorDTO fiador a registrar
     * @param residenteDTO residente correspondiente al fiador
     */
    public void registrarFiador(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO) {
        IAdministradorFiador administradorFiador = new AdministradorFiadorFachada();
        try {
            administradorFiador.registrarFiador(fiadorDTO, residenteDTO);

            FiadorDTO fiadorActualizado = administradorFiador.buscarFiadorResidente(residenteDTO);
            residenteDTO.setFiador(fiadorActualizado); 
            this.residenteDTO = residenteDTO;
            this.abrirPantallaDescarga(this.residenteDTO);
        } catch (NegocioException ex) {
            ex.getMessage(); 
        }
    }

    public File generarContratoPDF(File archivoDestino) throws NegocioException{
        IAdministradorGenerarContrato adminGenerarContrato = new AdministradorGenerarContratoFachada();
        try{
            File contratoPDF = adminGenerarContrato.generarContrato(residenteDTO, archivoDestino);
         //   frmContratoExitoso.enviarResidenteDTO(residenteDTO);
            return contratoPDF;

        }catch(NegocioException ex){
            ex.getMessage();
            abrirPantallaError();
        }
        return null;
    }
    
}
