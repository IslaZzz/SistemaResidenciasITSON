package interfaz;

import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
import entities.ReferenciaPago;

public interface IReferenciasPagoDAO {

    /**
     * Metodo que registra una nueva referencia de pago con todos sus
     * respectivos atributos
     *
     * @param referencia recibe como parametro una DTO de referencia de pago
     * @return regresa la referencia registrada
     */
    public abstract ReferenciaPago registrarReferenciaPago(ReferenciaPagoDTO referencia);

    /**
     * Metodo que valida si existe una referencia activa para el usuario que
     * solicita una nueva
     *
     * @param referencia Recibe como parametro una dto de referencia de pago con
     * sus respectivos atributos
     * @return regresa un valor booleano
     */
    public abstract boolean existeReferenciaActiva(ReferenciaPagoDTO referencia);

    /**
     * Busca la referencia de pago asociada a un residente por su matrícula.
     *
     * @param residenteDTO Objeto ResidenteDTO que contiene la matrícula del
     * residente
     * @return Objeto ReferenciaPago encontrado o null si no existe
     */
    public abstract ReferenciaPago buscarReferenciaPorMatricula(ResidenteDTO residenteDTO);

}
