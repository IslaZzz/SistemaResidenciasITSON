package implementaciones;

import dto.ResidenteDTO;
import entities.Residente;
import interfaz.IAccesoDatos;
import interfaz.IResidentesDAO;

public class AccesoDatosFachada implements IAccesoDatos{

    /**
     * DAO para manejar los datos de los residentes en la base de datos
     */
    private IResidentesDAO residentesDAO;
    
    /**
     * Constructor de la fachada de acceso a datos
     */
    public AccesoDatosFachada(){
        this.residentesDAO = new ResidentesDAOImp();
    }
    
    /**
     * Registra un nuevo residente en la base de datos
     */
    @Override
    public Residente registrarResidente(ResidenteDTO residente) {
        return this.residentesDAO.registrarResidente(residente);
    }

    /**
     * Obtiene un residente a partir de su matricula
     * @param matricula Matricula del residente
     * @return DTO con los datos del residente
     */
    @Override
    public ResidenteDTO obtenerResidente(String matricula) {
        return this.residentesDAO.obtenerResidente(matricula);
    }
    
}
