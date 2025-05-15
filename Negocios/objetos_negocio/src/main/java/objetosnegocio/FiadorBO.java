/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 *
 * @author abrilislas
 */
public class FiadorBO {
    /**
     * Instancia singleton
     */
    private static FiadorBO instance;
    
        public FiadorBO(){
            FiadorBO.getInstance();
        
        }
        
    public static FiadorBO getInstance() {
        if (instance == null) {
            instance = new FiadorBO();
        }
        return instance;
    }
    
        /**
         * metodo para registrar fiador
         * @param fiador
         * @param residenteDTO
         * @return
         * @throws NoEncontradoException 
         */
        public Fiador registrarFiador(FiadorDTO fiador, ResidenteDTO residenteDTO) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.registrarFiador(fiador, residenteDTO);
        }
        /**
         * Metodo para consultar el fiador de un residente
         * @param residenteDTO
         * @return
         * @throws Exception 
         */
        public FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws Exception{
            IAccesoDatos accesoDatos = new AccesoDatosFachada();
            return accesoDatos.consultarFiador(residenteDTO);
 
        }
}
