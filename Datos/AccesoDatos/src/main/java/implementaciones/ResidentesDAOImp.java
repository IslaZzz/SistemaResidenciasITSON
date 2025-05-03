package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import interfaz.IResidentesDAO;
import org.springframework.data.mongodb.core.MongoOperations;
import pojo.Residente;

public class ResidentesDAOImp implements IResidentesDAO {

    @Override
    public Residente registrarResidente(Residente residente) {
        MongoOperations mongoOps = ManejadorConexiones.obtenerConexion();
        Residente result = mongoOps.insert(residente);
        if(result != null){
            System.out.println("Residente registrado con éxito");
        }
        return result;
    }
    
}
