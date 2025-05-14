package administradorReferenciasPago;

import dto.ReferenciaPagoDTO;
import excepciones.NegocioException;

public interface IAdministradorReferenciasPago {
    /**
     * Metodo que genera una nueva referencia de pago con los datos que se tienen del residente
     * @param referencia recibe como parametro una referencia de pago DTO.
     * @return regresa una referencia de pago creada con sus respectivos atributos
     * @throws NegocioException Lanza esta excepcion en caso de que se encontro una referencia existe
     * para el residente.
     */
    ReferenciaPagoDTO getReferencia(ReferenciaPagoDTO referencia) throws NegocioException;
    
    /**
     * Metodo que registra en el sistema la referencia posteriormente creada con sus respectivos atributos.
     * @param referencia Recibe como parametro un objeto DTO de tipo referencia de pago.
     */
    void registrarReferencia(ReferenciaPagoDTO referencia);
}
