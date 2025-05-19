package administradorReferenciasPago;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
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
    
    /**
     * Metodo que busca una referencia de pago con la matricula dada del residente
     * @param residente recibe como parametro una dto con la matricula del residente
     * @return retorna una referencia de pago DTO o null en caso de no ser encontrada
     */
    ReferenciaPagoDTO buscarReferenciaPorMatricula(ResidenteDTO residente) throws NegocioException;
    
    /**
     * Metodo que enviar por correo la referencia activa
     * @param referencia Recibe como parametro una DTO de infraestructura de referencia con todos sus respectivos atributos
     * @return regresa un valor booleano
     * @throws NegocioException Lanza la excepcion en caso de que no fue posible generar el documento pdf
     */
    boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws NegocioException;
}
