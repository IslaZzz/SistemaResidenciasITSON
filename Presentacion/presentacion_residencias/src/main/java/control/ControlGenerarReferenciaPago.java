package control;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import administradorReferenciasPago.AdministradorReferenciasPagoFachada;
import administradorReferenciasPago.IAdministradorReferenciasPago;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
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

    public boolean enviarReferencia() throws NegocioException {
        IAdministradorReferenciasPago adminReferenciasPago = new AdministradorReferenciasPagoFachada();
        if (frameReferenciaPago.isVisible()) {
            frameReferenciaPago.dispose();
            Boolean envio = adminReferenciasPago.enviarReferenciaCorreo(convertirReferenciaDTOaInfraestructuraDTO(referencia));
            if (envio) {
                framePagoEnviada.setVisible(true);
                framePagoEnviada.setResizable(false);
                framePagoEnviada.setLocationRelativeTo(null);
                return envio;
            } else {
                frameReferenciaPago.setVisible(true);
                frameReferenciaPago.setResizable(false);
                frameReferenciaPago.setLocationRelativeTo(null);
                frameReferenciaPago.cargarReferenciaPago(referencia);
                return envio;
            }
        }
        return false;
    }

    public boolean buscarYEnviarReferencia(String matricula) throws NegocioException {
        IAdministradorReferenciasPago adminReferenciasPago = new AdministradorReferenciasPagoFachada();
        frameIngresarID.dispose();
        ResidenteDTO residente = new ResidenteDTO(matricula);
        Boolean envio = adminReferenciasPago.enviarReferenciaCorreo(convertirReferenciaDTOaInfraestructuraDTO(adminReferenciasPago.buscarReferenciaPorMatricula(residente)));
        if (envio) {
            framePagoEnviada.setVisible(true);
            framePagoEnviada.setResizable(false);
            framePagoEnviada.setLocationRelativeTo(null);
            return envio;
        } else {
            frameIngresarID.setVisible(true);
            frameIngresarID.setResizable(false);
            frameIngresarID.setLocationRelativeTo(null);
            return envio;
        }
    }

    public ReferenciaPagoInfDTO convertirReferenciaDTOaInfraestructuraDTO(ReferenciaPagoDTO referencia) {
        ReferenciaPagoInfDTO referenciaInfDTO = new ReferenciaPagoInfDTO();

        referenciaInfDTO.setFolio(referencia.getFolio());
        referenciaInfDTO.setReferencia(referencia.getReferencia());
        referenciaInfDTO.setConcepto(referencia.getConcepto());
        referenciaInfDTO.setFechaGeneracion(referencia.getFechaGeneracion());
        referenciaInfDTO.setFechaVencimiento(referencia.getFechaVencimiento());
        referenciaInfDTO.setImporte(referencia.getImporte());
        referenciaInfDTO.setMatriculaResidente(referencia.getMatriculaResidente());
        referenciaInfDTO.setNombreResidente(referencia.getNombreResidente());
        referenciaInfDTO.setCorreoResidente(referencia.getCorreoResidente());
        referenciaInfDTO.setCarreraResidente(referencia.getCarreraResidente());
        referenciaInfDTO.setTipoResidente(referencia.getTipoResidente());
        referenciaInfDTO.setGeneroResidente(referencia.getGeneroResidente());
        referenciaInfDTO.setSemestreResidente(referencia.getSemestreResidente());
        referenciaInfDTO.setHabitacion(referencia.getHabitacion());
        referenciaInfDTO.setPiso(referencia.getPiso());
        return referenciaInfDTO;
    }

    public ReferenciaPagoDTO generarReferencia(String matricula) throws NegocioException {
        IAdministradorReferenciasPago adminReferenciasPago = new AdministradorReferenciasPagoFachada();
        ReferenciaPagoDTO referenciaMatricula = new ReferenciaPagoDTO();
        referenciaMatricula.setMatriculaResidente(matricula);
        this.referencia = adminReferenciasPago.getReferencia(referenciaMatricula);
        return referencia;
    }

}
