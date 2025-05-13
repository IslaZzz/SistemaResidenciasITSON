package implementaciones;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;
import interfaz.IHabitacionesDAO;

/**
 * Implementación de la interfaz IHabitacionesDAO para gestionar las
 * habitaciones dentro de la base de datos MongoDB. Proporciona operaciones como
 * registrar, obtener, eliminar habitaciones y obtener habitaciones disponibles.
 */
public class HabitacionesDAOImp implements IHabitacionesDAO {

    /**
     * Obtiene la colección de habitaciones de la base de datos.
     *
     * @return La colección de habitaciones.
     */
    private MongoCollection<Habitacion> obtenerColeccionHabitaciones() {
        return ManejadorConexiones.obtenerConexion().getCollection("habitaciones", Habitacion.class);
    }

    /**
     * Registra un conjunto de habitaciones de manera masiva en la base de
     * datos.
     *
     * @param numeroPisos El número de pisos en los que se distribuirán las
     * habitaciones.
     * @param numeroHabitacionesPorPiso El número de habitaciones por cada piso.
     * @return Lista de habitaciones registradas.
     */
    @Override
    public List<Habitacion> registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso) {
        List<Habitacion> habitaciones = new LinkedList<>();
        for (int i = 1; i <= numeroPisos; i++) {
            for (int j = 1; j <= numeroHabitacionesPorPiso; j++) {
                HabitacionDTO habitacion = new HabitacionDTO(i, j);
                habitaciones.add(registrarHabitacion(habitacion));
            }
        }
        return habitaciones;
    }

    /**
     * Registra una habitación en la base de datos.
     *
     * @param habitacion El DTO de la habitación a registrar.
     * @return La habitación registrada.
     */
    @Override
    public Habitacion registrarHabitacion(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Habitacion nuevaHabitacion = new Habitacion(habitacion.getPiso(), habitacion.getNumero());
        habitaciones.insertOne(nuevaHabitacion);
        return nuevaHabitacion;
    }

    /**
     * Obtiene una habitación en base al DTO de la habitación proporcionado. Si
     * se proporciona un ID, busca por ID, si no, busca por piso y número.
     *
     * @param habitacion El DTO de la habitación.
     * @return El DTO de la habitación encontrada.
     */
    @Override
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) {
        if (habitacion.getIdHabitacion() != null) {
            return buscarHabitacionPorId(habitacion);
        } else {
            return buscarHabitacionPorPisoYNumero(habitacion);
        }
    }

    /**
     * Busca una habitación por su ID en la base de datos.
     *
     * @param habitacion El DTO de la habitación con el ID proporcionado.
     * @return El DTO de la habitación encontrada, o null si no se encuentra.
     */
    private HabitacionDTO buscarHabitacionPorId(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ObjectId idHabitacion = new ObjectId(habitacion.getIdHabitacion());
        Document filtro = new Document("_id", idHabitacion);
        Habitacion habitacionEncontrada = habitaciones.find(filtro).first();
        if (habitacionEncontrada != null) {
            return parsearHabitacion(habitacionEncontrada);
        } else {
            return null;
        }
    }

    /**
     * Busca una habitación por piso y número en la base de datos.
     *
     * @param habitacion El DTO de la habitación con piso y número
     * proporcionados.
     * @return El DTO de la habitación encontrada, o null si no se encuentra.
     */
    private HabitacionDTO buscarHabitacionPorPisoYNumero(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Document filtro = new Document("piso", habitacion.getPiso())
                .append("numero", habitacion.getNumero());
        Habitacion habitacionEncontrada = habitaciones.find(filtro).first();
        if (habitacionEncontrada != null) {
            return parsearHabitacion(habitacionEncontrada);
        } else {
            return null;
        }
    }

    /**
     * Convierte una entidad Habitacion en un DTO de Habitacion.
     *
     * @param habitacion La entidad Habitacion.
     * @return El DTO de la habitación.
     */
    private HabitacionDTO parsearHabitacion(Habitacion habitacion) {
        List<String> residentesActuales = new LinkedList<>();
        if (habitacion.getResidentesActuales() != null) {
            for (String idResidente : habitacion.getResidentesActuales()) {
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

    /**
     * Obtiene una lista de habitaciones disponibles en un piso específico.
     *
     * @param piso El número del piso donde buscar habitaciones disponibles.
     * @return Lista de habitaciones disponibles en el piso proporcionado.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso) {
        final int NUM_MAX_RESIDENTES_POR_HABITACION = 2;
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        FindIterable<Habitacion> habitacionesDisponibles = habitaciones.find(
                Filters.and(
                        Filters.eq("piso", piso),
                        Filters.or(
                                Filters.expr(new Document("$lt", List.of(new Document("$size", "$residentesActuales"), NUM_MAX_RESIDENTES_POR_HABITACION))),
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

    /**
     * Obtiene la cantidad total de habitaciones registradas en la base de
     * datos.
     *
     * @return La cantidad total de habitaciones.
     */
    @Override
    public Long obtenerCantidadHabitaciones() {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        Long cantidadHabitaciones = habitaciones.countDocuments();
        return cantidadHabitaciones;
    }

    /**
     * Elimina una habitación de la base de datos.
     *
     * @param habitacion El DTO de la habitación a eliminar.
     * @return true si la eliminación fue exitosa, false si no.
     */
    @Override
    public boolean eliminarHabitacion(HabitacionDTO habitacion) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ObjectId idHabitacion = new ObjectId(habitacion.getIdHabitacion());
        DeleteResult resultado = habitaciones.deleteOne(new Document("_id", idHabitacion));
        return resultado.wasAcknowledged();
    }

    /**
     * Obtiene la lista de pisos disponibles en la base de datos.
     *
     * @return Lista de pisos disponibles.
     */
    @Override
    public List<Integer> obtenerPisosDisponibles() {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        List<Integer> pisosUnicos = habitaciones.distinct("piso", Integer.class).into(new LinkedList<>());
        return pisosUnicos;
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente en un
     * piso específico.
     *
     * @param residente El DTO del residente para el que se buscan las
     * habitaciones.
     * @param piso El número del piso donde se buscan las habitaciones
     * recomendadas.
     * @return Lista de habitaciones recomendadas para el residente.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) {
        final int NUM_MAX_RESIDENTES_POR_HABITACION = 2;
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        AggregateIterable<Habitacion> habitacionesDisponibles = habitaciones.aggregate(
                Arrays.asList(
                        Aggregates.match(
                                Filters.and(
                                        Filters.eq("piso", piso),
                                        Filters.or(
                                                Filters.expr(new Document("$lt", List.of(new Document("$size", "$residentesActuales"), NUM_MAX_RESIDENTES_POR_HABITACION))),
                                                Filters.exists("residentesActuales", false)
                                        )
                                )
                        ),
                        Aggregates.lookup(
                                "residentes",
                                "residentesActuales",
                                "_id",
                                "residente"
                        ),
                        Aggregates.match(
                                Filters.or(
                                        Filters.size("residente", 0),
                                        Filters.elemMatch("residente", Filters.eq("tipoResidente", residente.getTipoResidente()))
                                )
                        )
                )
        );

        List<HabitacionDTO> habitacionesDTO = new LinkedList<>();
        for (Habitacion habitacion : habitacionesDisponibles) {
            habitacionesDTO.add(parsearHabitacion(habitacion));
        }
        return habitacionesDTO;
    }

}
