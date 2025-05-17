
package administradorGenerarContrato;

import DTO_Infraestructura.ContratoInfoDTO;
import controlConexiones.ControlJasperReports;
import dto.FiadorDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosnegocio.ContratoBO;

/**
 *
 * @author abrilislas
 */
public class AdministradorGenerarContratoFachada implements IAdministradorGenerarContrato {
    
    ContratoBO contratoBO =ContratoBO.getInstance();
    
    /**
     * Se genera un reporte en caso de cumplir las reglas de negocio
     * @param residenteDTO recibe el residente al cual se le genera el contrato
     * @param archivoDestino donde se almacenara el archivo
     * @return retorna el DTO con la informacion necesaria para la generacion del reporte
     * @throws NegocioException en caso de tener valores nulos
     */
    @Override
    public File generarContrato(ResidenteDTO residenteDTO, File archivoDestino) throws NegocioException {
        ContratoInfoDTO contratoInfo = construirContratoInfo(residenteDTO);
        try{
        contratoInfo = contratoBO.generarReporte(contratoInfo);
        }catch(NegocioException ex){
            ex.getMessage();
        }
        try {
            File contratoResidente = generarArchivo(contratoInfo, archivoDestino);
            return contratoResidente;
        } catch (Exception ex) {
            Logger.getLogger(AdministradorGenerarContratoFachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Construye el objeto DTO con los datos del contrato
     * @param residenteDTO recibe como parametro el residente correspondiente
     * @return 
     */
    private ContratoInfoDTO construirContratoInfo(ResidenteDTO residenteDTO){
        FiadorDTO fiadorDTO = residenteDTO.getFiador();
        String idResidente= residenteDTO.getMatricula();
        String carrera=residenteDTO.getCarrera();
        String nombreResidente=residenteDTO.getNombreCompleto();
        String habitacionResidente = residenteDTO.getIdHabitacion();
        String direccionResidente = residenteDTO.getDireccion();
        String ubicacionHabitacion;
        String nombreFiador = fiadorDTO.getNombreCompleto();
        String direccionFiador= fiadorDTO.getDireccion();
        String adeudo = residenteDTO.getAdeudo();
        String piso = "1";
        
        if ("M".equals(residenteDTO.getGenero())) {
            ubicacionHabitacion = "izquierda";
        }else{
            ubicacionHabitacion = "derecha";
        }
        ContratoInfoDTO contratoDTO = new ContratoInfoDTO(idResidente, carrera, nombreResidente, habitacionResidente, direccionResidente,  ubicacionHabitacion, nombreFiador, direccionFiador, adeudo, piso);
        return null;
    }
    
    private File generarArchivo(ContratoInfoDTO contratoInfo, File archivoDestino) throws Exception{
        ControlJasperReports controlContrato = new ControlJasperReports();
       return controlContrato.generarReporte(contratoInfo, archivoDestino);
    }
    
    //agregar metodo privado para enviar el dto a infraestructura, de ahi se crea el contrato
    //con el respectivo ReporteInfDTO e infraestructura se comunica con presentacion
    
    //metodo para comunicarse con presentacion y generar un pdf utilizando JFileChooser
}
