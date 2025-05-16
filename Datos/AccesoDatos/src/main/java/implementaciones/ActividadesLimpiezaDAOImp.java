package implementaciones;

import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import entities.Personal;
import entities.Zona;
import exceptions.NoEncontradoException;
import interfaz.IAccesoDatos;
import interfaz.IActividadesLimpiezaDAO;
import interfaz.IZonasDAO;

/**
 * Implementación de la interfaz IActividadesLimpiezaDAO para gestionar las
 * operaciones
 * relacionadas con las actividades de limpieza en la base de datos MongoDB.
 */
public class ActividadesLimpiezaDAOImp implements IActividadesLimpiezaDAO {

    /**
     * Registra una nueva actividad de limpieza en la base de datos.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la
     *                  actividad a registrar.
     * @param zona      El objeto ZonaDTO que representa la zona donde se realizará
     *                  la actividad.
     * @param personal  El objeto PersonalDTO que representa al personal encargado
     *                  de la actividad.
     * @return Un objeto ActividadLimpieza que representa la actividad registrada,
     *         incluyendo su identificador único.
     * @throws NoEncontradoException Si no se encuentra la zona o el personal
     *                               especificado.
     */
    @Override
    public ActividadLimpieza registrarActividadLimpieza(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        IAccesoDatos accesoDatos = new AccesoDatosFachada();

        // Validar si la zona existe
        ZonaDTO zonaExistente = accesoDatos.obtenerZona(actividad.getZona());
        if (zonaExistente == null) {
            throw new NoEncontradoException("La zona especificada no existe.");
        }

        // Validar si el personal existe
        PersonalDTO personalExistente = accesoDatos.obtenerPersonal(actividad.getPersonal());
        if (personalExistente == null) {
            throw new NoEncontradoException("El personal especificado no existe.");
        }

        Zona zona = new Zona(new ObjectId(zonaExistente.getId()), zonaExistente.getPiso(), zonaExistente.getNombre());
        Personal personal = new Personal(new ObjectId(personalExistente.getId()), personalExistente.getNombre());

        // Registrar la actividad si no hay solapamientos
        ActividadLimpieza actividadLimpieza = new ActividadLimpieza(
                zona,
                personal,
                actividad.getFechaInicio(),
                actividad.getFechaFin());
        actividadesLimpieza.insertOne(actividadLimpieza);
        return actividadLimpieza;
    }

    /**
     * Elimina una actividad de limpieza existente de la base de datos.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la
     *                  actividad a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso
     *         contrario.
     * @throws NoEncontradoException Si no se encuentra la actividad con los datos
     *                               especificados.
     */
    @Override
    public boolean eliminarActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        ActividadLimpieza actividadLimpieza = obtenerActividad(actividad);
        DeleteResult resultado = actividadesLimpieza.deleteOne(Filters.eq("_id", actividadLimpieza.getId()));
        return resultado.wasAcknowledged();
    }

    /**
     * Obtiene una actividad de limpieza específica de la base de datos.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la
     *                  actividad a buscar.
     * @return Un objeto ActividadLimpieza que representa la actividad encontrada.
     * @throws NoEncontradoException Si no se encuentra la actividad con los datos
     *                               especificados.
     */
    @Override
    public ActividadLimpieza obtenerActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        ActividadLimpieza actividadLimpieza = actividadesLimpieza.find(
                Filters.eq("_id", new ObjectId(actividad.getIdActividad()))
        ).first();
        if (actividadLimpieza == null) {
            throw new NoEncontradoException("No se encontró la actividad de limpieza con los datos especificados");
        }
        return actividadLimpieza;
    }

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en la base
     * de datos.
     *
     * @return Una lista de objetos ActividadLimpieza que representan todas las
     *         actividades registradas.
     */
    @Override
    public List<ActividadLimpieza> obtenerActividadesLimpieza() {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        List<ActividadLimpieza> actividades = actividadesLimpieza.find().into(new LinkedList<>());
        return actividades;
    }

    /**
     * Obtiene la colección de actividades de limpieza desde la base de datos
     * MongoDB.
     *
     * @return La colección MongoCollection que representa la colección
     *         "actividadesLimpieza".
     */
    private MongoCollection<ActividadLimpieza> obtenerColeccionActividadesLimpieza() {
        MongoDatabase database = ManejadorConexiones.obtenerConexion();
        return database.getCollection("actividadesLimpieza", ActividadLimpieza.class);
    }

    /**
     * Obtiene una actividad de limpieza específica de la base de datos
     * en función del personal y la hora especificados.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la
     *                  actividad a buscar.
     * @return Un objeto ActividadLimpieza que representa la actividad encontrada.
     */
    @Override
    public ActividadLimpieza obtenerActividadSolapada(ActividadLimpiezaDTO actividad)
            throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ZonaDTO zonaDTO = accesoDatos.obtenerZona(actividad.getZona());
        PersonalDTO personal = accesoDatos.obtenerPersonal(actividad.getPersonal());

        ActividadLimpieza actividadLimpieza = actividadesLimpieza.find(
                Filters.and(
                        Filters.or(
                                Filters.eq("zona._id", new ObjectId(zonaDTO.getId())),
                                Filters.eq("personal._id", new ObjectId(personal.getId()))
                        ),
                        Filters.or(
                                Filters.and(
                                        Filters.lte("fechaInicio", actividad.getFechaInicio()),
                                        Filters.gte("fechaFin", actividad.getFechaInicio())),
                                Filters.and(
                                        Filters.lte("fechaInicio", actividad.getFechaFin()),
                                        Filters.gte("fechaFin", actividad.getFechaFin())),
                                Filters.and(
                                        Filters.gte("fechaInicio", actividad.getFechaInicio()),
                                        Filters.lte("fechaFin", actividad.getFechaFin())))))
                .first();
        return actividadLimpieza;
    }


    @Override
    public List<ActividadLimpieza> obtenerActividadesPorFiltro(String filtro) {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        List<ActividadLimpieza> actividades = actividadesLimpieza.find(
                Filters.or(
                        Filters.regex("zona.nombre", filtro),
                        Filters.regex("personal.nombre", filtro),
                        Filters.regex("fechaInicio", filtro),
                        Filters.regex("fechaFin", filtro)))
                .into(new LinkedList<>());
        return actividades;
    }
}