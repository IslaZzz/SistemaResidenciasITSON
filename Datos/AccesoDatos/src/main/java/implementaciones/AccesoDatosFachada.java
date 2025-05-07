package implementaciones;

import entities.Residente;
import interfaz.IAccesoDatos;
import interfaz.IResidentesDAO;

public class AccesoDatosFachada implements IAccesoDatos{

    private IResidentesDAO residentesDAO;
    
    public AccesoDatosFachada(){
        this.residentesDAO = new ResidentesDAOImp();
    }
    
    @Override
    public Residente registrarResidente(Residente residente) {
        return this.residentesDAO.registrarResidente(residente);
    }
    
}
