/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administradorFiador;

import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import excepciones.NegocioException;

/**
 *
 * @author abrilislas
 */
public interface IAdministradorFiador {
    
    /**
     * Registra a un fiador relacionado con un residente
     * 
     * @param fiadorDTO fiador a registrar
     * @param residenteDTO residente correspondiente al fiador
     */
    public Fiador registrarFiador(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO) throws NegocioException;
    
    /**
     * Busca el fiador relacionado al residente, el cual ya tiene un fiador vinculado
     * @param residenteDTO 
     */
    public FiadorDTO buscarFiadorResidente(ResidenteDTO residenteDTO) throws NegocioException;
    
    /**
     * Elimina la relacion actual del residente con el fiador asignado  
     * @param residenteDTO 
     */
}