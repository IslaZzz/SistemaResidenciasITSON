package administradorReferenciasPago;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import objetosnegocio.ReferenciasPagoBO;

public class AdministradorReferenciasPagoFachada implements IAdministradorReferenciasPago {

    /**
     * Objeto de negocio responsable de la lógica relacionada con referencias de
     * pago.
     */
    private ReferenciasPagoBO referenciaBO = ReferenciasPagoBO.getInstance();

    /**
     * Genera y registra una nueva referencia de pago para un residente.
     *
     * @param referencia Objeto ReferenciaPagoDTO que debe contener al menos la
     * matrícula del residente
     * @return ReferenciaPagoDTO con todos los datos completos de la referencia
     * generada
     * @throws NegocioException Si ocurre algún error en la lógica de negocio: -
     * Residente no encontrado - Referencia activa ya existente - Error al
     * generar la referencia
     */
    @Override
    public ReferenciaPagoDTO getReferencia(ReferenciaPagoDTO referencia) throws NegocioException {
        try {
            ReferenciaPagoDTO referenciaNueva = referenciaBO.generarReferencia(referencia);
            registrarReferencia(referenciaNueva);
        } catch (NegocioException ex) {
            throw new NegocioException(ex.getMessage());
        }

        return referencia;
    }

    /**
     * Registra una referencia de pago en el sistema de persistencia. Delega la
     * operación al objeto de negocio ReferenciasPagoBO.
     *
     * @param referencia Objeto ReferenciaPagoDTO completo con todos los datos
     * de la referencia (debe incluir todos los campos requeridos por el
     * sistema)
     */
    @Override
    public void registrarReferencia(ReferenciaPagoDTO referencia) {
        referenciaBO.registrarReferencia(referencia);
    }

    /**
     * Busca la referencia de pago asociada a la matrícula de un residente.
     *
     * @param residente Objeto ResidenteDTO que contiene la información del
     * residente cuya referencia de pago se desea buscar
     * @return ReferenciaPagoDTO con la información de la referencia de pago
     * encontrada
     * @throws NegocioException Si ocurre algún error durante el proceso de
     * búsqueda
     */
    @Override
    public ReferenciaPagoDTO buscarReferenciaPorMatricula(ResidenteDTO residente) throws NegocioException {
        return referenciaBO.buscarReferenciaPorMatricula(residente);
    }

    /**
     * Envía por correo electrónico la referencia de pago al residente.
     *
     * @param referencia Objeto ReferenciaPagoInfDTO que contiene la información
     * de la referencia de pago a enviar
     * @return true si el correo fue enviado exitosamente, false en caso
     * contrario
     * @throws NegocioException Si ocurre algún error durante el proceso de
     * envío del correo
     */
    @Override
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws NegocioException {
        return referenciaBO.enviarReferenciaCorreo(referencia);
    }

}
