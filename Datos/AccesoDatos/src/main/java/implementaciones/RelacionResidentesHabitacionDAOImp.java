package implementaciones;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;
import entities.Residente;
import interfaz.IHabitacionesDAO;
import interfaz.IRelacionResidentesHabitacionDAO;
import interfaz.IResidentesDAO;

public class RelacionResidentesHabitacionDAOImp implements IRelacionResidentesHabitacionDAO {

    /**
     * Implementación para asignar una habitación a un residente
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ResidenteDTO residenteObtenido = obtenerResidente(residente);
        HabitacionDTO habitacionObtenida = obtenerHabitacionDTO(habitacion);
        if(residenteObtenido != null && habitacionObtenida != null) {
            residentes.updateOne(
                Filters.eq("_id", residenteObtenido.getMatricula()),
                Updates.set("habitacion", habitacionObtenida.getIdHabitacion()));
            habitaciones.updateOne(
                Filters.eq("_id", new ObjectId(habitacionObtenida.getIdHabitacion())),
                Updates.addToSet("residentesActuales", residenteObtenido.getMatricula())
            );
        }
    }

    private ResidenteDTO obtenerResidente(ResidenteDTO residente) {
        IResidentesDAO residentesDAO = new ResidentesDAOImp();
        return residentesDAO.obtenerResidente(residente.getMatricula());
    }

    private HabitacionDTO obtenerHabitacionDTO(HabitacionDTO habitacion) {
        IHabitacionesDAO habitacionesDAO = new HabitacionesDAOImp();
        return habitacionesDAO.obtenerHabitacion(habitacion);
    }


    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }

    private MongoCollection<Habitacion> obtenerColeccionHabitaciones() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("habitaciones", Habitacion.class);
    }

    @Override
    public void desasignarHabitacion(ResidenteDTO residente) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        residentes.updateOne(
            Filters.eq("_id", residente.getMatricula()),
            Updates.unset("habitacion"));
        habitaciones.updateOne(
            Filters.eq("_id", new ObjectId(residente.getIdHabitacion())),
            Updates.pull("residentesActuales", residente.getMatricula())
        );    
    }

}
