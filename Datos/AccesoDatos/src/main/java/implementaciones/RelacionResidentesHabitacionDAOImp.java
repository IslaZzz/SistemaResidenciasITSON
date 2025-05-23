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
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz IRelacionResidentesHabitacionDAO para gestionar
 * la asignación y desasignación de habitaciones a residentes.
 */
public class RelacionResidentesHabitacionDAOImp implements IRelacionResidentesHabitacionDAO {

    /**
     * Asigna una habitación a un residente. Actualiza tanto la información del
     * residente como la habitación.
     *
     * @param residente El residente al que se le asignará la habitación.
     * @param habitacion La habitación que se asignará al residente.
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        ResidenteDTO residenteObtenido = obtenerResidente(residente);
        HabitacionDTO habitacionObtenida = obtenerHabitacionDTO(habitacion);
        if (residenteObtenido != null && habitacionObtenida != null) {
            residentes.updateOne(
                    Filters.eq("_id", residenteObtenido.getMatricula()),
                    Updates.set("habitacion", habitacionObtenida.getIdHabitacion()));
            habitaciones.updateOne(
                    Filters.eq("_id", new ObjectId(habitacionObtenida.getIdHabitacion())),
                    Updates.addToSet("residentesActuales", residenteObtenido.getMatricula())
            );
        }
    }

    /**
     * Obtiene la información de un residente a partir de su matrícula.
     *
     * @param residente El residente cuyo dato será obtenido.
     * @return El objeto ResidenteDTO con la información del residente, o null
     * si no se encuentra.
     */
    private ResidenteDTO obtenerResidente(ResidenteDTO residente) {
        IResidentesDAO residentesDAO = new ResidentesDAOImp();
        return residentesDAO.obtenerResidente(residente.getMatricula());
    }

    /**
     * Obtiene la información de una habitación a partir del DTO de la
     * habitación.
     *
     * @param habitacion El DTO de la habitación que se desea obtener.
     * @return El objeto HabitacionDTO con la información de la habitación, o
     * null si no se encuentra.
     */
    private HabitacionDTO obtenerHabitacionDTO(HabitacionDTO habitacion) {
        IHabitacionesDAO habitacionesDAO = new HabitacionesDAOImp();
        return habitacionesDAO.obtenerHabitacion(habitacion);
    }

    /**
     * Obtiene la colección de residentes desde la base de datos.
     *
     * @return La colección de residentes.
     */
    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }

    /**
     * Obtiene la colección de habitaciones desde la base de datos.
     *
     * @return La colección de habitaciones.
     */
    private MongoCollection<Habitacion> obtenerColeccionHabitaciones() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("habitaciones", Habitacion.class);
    }

    /**
     * Desasigna una habitación de un residente, eliminando la referencia de la
     * habitación del residente y removiendo al residente de la lista de
     * residentes de la habitación.
     *
     * @param residente El residente cuya habitación se desasignará.
     */
    @Override
    public void desasignarHabitacion(ResidenteDTO residente) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        habitaciones.updateOne(
                Filters.eq("_id", new ObjectId(residente.getIdHabitacion())),
                Updates.pull("residentesActuales", residente.getMatricula())
        );
    }

    /**
     * Metodo que obtiene una habitacion perteneciente a un residente
     *
     * @param residente Recibe como parametro un residenteDTO cuya habitacion se
     * desee encontrar
     * @return Regresa un objeto de tipo HabitacionDTO con sus detalles
     */
    @Override
    public HabitacionDTO obtenerHabitacionDeResidente(ResidenteDTO residente) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();

        // Obtener el residente
        Residente residenteEncontrado = residentes.find(Filters.eq("_id", residente.getMatricula())).first();

        if (residenteEncontrado != null && residenteEncontrado.getHabitacion() != null) {
            // Obtener la habitación por su ID (guardado como String en el residente)
            Habitacion habitacion = habitaciones.find(Filters.eq("_id", new ObjectId(residenteEncontrado.getHabitacion()))).first();
            if (habitacion != null) {
                return parsearHabitacion(habitacion);
            }
        }

        return null;
    }

    /**
     * Metodo que convierte una habitacion en su respectivo objeto de tipo DTO
     *
     * @param habitacion Recibe un objeto de tipo habitacion
     * @return Retorna un objeto de tipo HabitacionDTO
     */
    @Override
    public HabitacionDTO parsearHabitacion(Habitacion habitacion) {
        return new HabitacionDTO(habitacion.getPiso(), habitacion.getNumero());
    }

    /**
     * Obtiene una lista con los nombres completos de los residentes que ocupan
     * una habitación específica, identificada por su piso y número.
     *
     * @param piso el número de piso donde se encuentra la habitación.
     * @param numero el número de la habitación.
     * @return una lista de nombres completos de los residentes asociados a la
     * habitación. Si la habitación no existe, se retorna una lista vacía.
     */
   @Override
    public List<String> obtenerResidentesPorHabitacion(int piso, int numero) {
        MongoCollection<Habitacion> habitaciones = obtenerColeccionHabitaciones();
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Habitacion habitacion = habitaciones.find(
                Filters.and(
                        Filters.eq("piso", piso),
                        Filters.eq("numero", numero)
                )
        ).first();
        if (habitacion == null) {
            return new ArrayList<>();
        }
        ObjectId idHabitacion = habitacion.getId();
        List<String> listaNombres = new ArrayList<>();
        String idHabitacionStr = idHabitacion.toHexString();
        for (Residente r : residentes.find(Filters.eq("habitacion", idHabitacionStr))) {
            listaNombres.add(r.getNombreCompleto());
        }
        return listaNombres;
    }

}
