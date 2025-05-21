/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administradorGenerarContrato;

import DTO_Infraestructura.ContratoInfoDTO;
import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.io.File;

/**
 *
 * @author abrilislas
 */
public interface IAdministradorGenerarContrato {
    
    File generarContrato(ResidenteDTO residenteDTO, File archivoDestino) throws NegocioException;
    
    void recibirHabitacion(HabitacionDTO habitacionDTO);
}
