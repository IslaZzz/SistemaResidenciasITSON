package implementaciones;

import interfaz.IAccesoDatos;
import interfaz.IResidentesDAO;
import pojo.Residente;

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
