package implementaciones;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;

import com.mongodb.client.model.Filters;

import dto.HabitacionDTO;
import entities.Habitacion;
import interfaz.IHabitacionesDAO;

public class HabitacionesDAOImp implements IHabitacionesDAO {

    private MongoCollection<Habitacion> obtenerColeccionHabitaciones() {
        return ManejadorConexiones.obtenerConexion().getCollection("habitaciones", Habitacion.class);
    }

    @Override
    public List<Habitacion> registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso) {
        List<Habitacion> habitaciones = new LinkedList<>();
        for (int i = 1; i <= numeroPisos; i++) {
            for (int j = 1; j <= numeroHabitacionesPorPiso; j++) {
                HabitacionDTO habitacion = new HabitacionDTO(i,j);
                habitaciones.add(registrarHabitacion(habitacion));
            }
        }
        return habitaciones;
    }

    @Override
    public Habitacion registrarHabitacion(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Habitacion nuevaHabitacion = new Habitacion(habitacion.getPiso(), habitacion.getNumero());
        habitaciones.insertOne(nuevaHabitacion);
        return nuevaHabitacion;
    }

    @Override
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) {
        if(habitacion.getIdHabitacion() != null){
            return buscarHabitacionPorId(habitacion);
        } else {
            return buscarHabitacionPorPisoYNumero(habitacion);
        }
    }

    private HabitacionDTO buscarHabitacionPorId(HabitacionDTO habitacion){
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ObjectId idHabitacion = new ObjectId(habitacion.getIdHabitacion());
            Document filtro = new Document("_id", idHabitacion);
            Habitacion habitacionEncontrada = habitaciones.find(filtro).first();
            if(habitacionEncontrada != null) {
                return parsearHabitacion(habitacionEncontrada);
            } else {
                return null;
            }
    }

    private HabitacionDTO buscarHabitacionPorPisoYNumero(HabitacionDTO habitacion){
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Document filtro = new Document("piso", habitacion.getPiso())
            .append("numero", habitacion.getNumero());
        Habitacion habitacionEncontrada = habitaciones.find(filtro).first();
        if(habitacionEncontrada != null) {
            return parsearHabitacion(habitacionEncontrada);
        } else {
            return null;
        }
    }

    private HabitacionDTO parsearHabitacion(Habitacion habitacion) {
        List<String> residentesActuales = new LinkedList<>();
        if(habitacion.getResidentesActuales()!= null) {
            for (ObjectId idResidente : habitacion.getResidentesActuales()) {
                residentesActuales.add(idResidente.toString());
            }
        }
        HabitacionDTO habitacionDTO = new HabitacionDTO(
            habitacion.getId().toString(),
            habitacion.getPiso(), 
            habitacion.getNumero(),
            residentesActuales
        );
        return habitacionDTO;
    }

    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso) {
        final int NUM_MAX_RESIDENTES_POR_HABITACION = 2;
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        FindIterable<Habitacion> habitacionesDisponibles = habitaciones.find(
            Filters.and(
                Filters.eq("piso", piso),
                Filters.or(
                    Filters.lt("residentesActuales", NUM_MAX_RESIDENTES_POR_HABITACION),
                    Filters.exists("residentesActuales", false)
                )
            )
        );

        List<HabitacionDTO> habitacionesDTO = new LinkedList<>();
        for (Habitacion habitacion : habitacionesDisponibles) {
            habitacionesDTO.add(parsearHabitacion(habitacion));
        }
        return habitacionesDTO;
    }

    @Override
    public Long obtenerCantidadHabitaciones() {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Long cantidadHabitaciones = habitaciones.countDocuments();
        return cantidadHabitaciones;
    }

    @Override
    public boolean eliminarHabitacion(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ObjectId idHabitacion = new ObjectId(habitacion.getIdHabitacion());
        DeleteResult resultado = habitaciones.deleteOne(new Document("_id", idHabitacion));
        return resultado.wasAcknowledged();
    }

}
