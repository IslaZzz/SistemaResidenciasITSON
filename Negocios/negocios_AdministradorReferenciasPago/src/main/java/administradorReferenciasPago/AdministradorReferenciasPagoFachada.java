package administradorReferenciasPago;

import dto.ReferenciaPagoDTO;
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

}
