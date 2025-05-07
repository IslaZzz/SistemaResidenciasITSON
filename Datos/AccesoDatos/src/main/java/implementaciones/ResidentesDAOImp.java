package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import entities.Residente;
import interfaz.IResidentesDAO;

public class ResidentesDAOImp implements IResidentesDAO {

    @Override
    public Residente registrarResidente(Residente residente) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        residentes.insertOne(residente);
        return residente;
    }

    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }
    
}
