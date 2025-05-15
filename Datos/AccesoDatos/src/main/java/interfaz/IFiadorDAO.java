/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import exceptions.NoEncontradoException;

/**
 *
 * @author abrilislas
 */
public interface IFiadorDAO {
    
    public abstract Fiador registrarFiador(FiadorDTO fiador, ResidenteDTO residenteDTO)throws Exception;
    public abstract FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws NoEncontradoException;
    //public abstract void setResidente(FiadorDTO fiador,ResidenteDTO residenteDTO) throws NoEncontradoException;
   
}
