/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administradorFiador.AdministradorFiadorFachada;
import administradorFiador.IAdministradorFiador;
import administradorGenerarContrato.AdministradorGenerarContratoFachada;
import administradorGenerarContrato.IAdministradorGenerarContrato;
import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.FiadorDTO;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.io.File;
import javax.swing.JOptionPane;
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
    public void previewResidente(ResidenteDTO residenteDTO) throws Exception{
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
     /**
     * Abre una pantalla de error en caso de no poder generar el contrato
     */
    public void abrirPantallaError(){
        frmRegistroFiador.dispose();
        frmContratoExitoso.dispose();
        frmError.setVisible(true);
    }
    
    /**
     * Abre la pantalla de descarga para la seleccion de la ruta de almacenamiento
     * @param residenteDTO Recibe el residente del cual se generará el contrato
     */
    public void abrirPantallaDescarga(ResidenteDTO residenteDTO){
        frmRegistroFiador.dispose();
        this.residenteDTO=residenteDTO; //actualiza al residente
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
     * Busca la habitacion del residente especificado
     * @param residenteDTO el residente del cual se desea recuperar la habitacion
     * @return retorna un objeto de tipo HabitacionDTO con los datos de la habitacion
     * @throws Exception 
     */
    public HabitacionDTO buscarHabitacion(ResidenteDTO residenteDTO) throws Exception{
        HabitacionDTO habitacionDTO = new HabitacionDTO(residenteDTO.getIdHabitacion());
        IAdministradorHabitaciones administradorHabitaciones = new AdministradorHabitacionesFachada();
        return administradorHabitaciones.obtenerHabitacion(habitacionDTO);
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
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * 
     * @param archivoDestino 
     * @return
     * @throws NegocioException 
     */
    public File generarContratoPDF(File archivoDestino) throws NegocioException, Exception{
        IAdministradorGenerarContrato adminGenerarContrato = new AdministradorGenerarContratoFachada();
        try{
            HabitacionDTO habitacionDTO =  buscarHabitacion(residenteDTO);
            adminGenerarContrato.recibirHabitacion(habitacionDTO);
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
