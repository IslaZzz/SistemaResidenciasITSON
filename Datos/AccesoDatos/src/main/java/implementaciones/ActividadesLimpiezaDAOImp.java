package implementaciones;

import java.util.LinkedList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import exceptions.NoEncontradoException;
import interfaz.IAccesoDatos;
import interfaz.IActividadesLimpiezaDAO;

/**
 * Implementación de la interfaz IActividadesLimpiezaDAO para gestionar las operaciones
 * relacionadas con las actividades de limpieza en la base de datos MongoDB.
 */
public class ActividadesLimpiezaDAOImp implements IActividadesLimpiezaDAO {

    /**
     * Registra una nueva actividad de limpieza en la base de datos.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a registrar.
     * @param zona El objeto ZonaDTO que representa la zona donde se realizará la actividad.
     * @param personal El objeto PersonalDTO que representa al personal encargado de la actividad.
     * @return Un objeto ActividadLimpieza que representa la actividad registrada, incluyendo su identificador único.
     * @throws NoEncontradoException Si no se encuentra la zona o el personal especificado.
     */
    @Override
    public ActividadLimpieza registrarActividadLimpieza(ActividadLimpiezaDTO actividad, ZonaDTO zona,
            PersonalDTO personal) throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ZonaDTO zonaExistente = accesoDatos.obtenerZona(zona);
        PersonalDTO personalExistente = accesoDatos.obtenerPersonal(personal);
        if (zonaExistente != null && personalExistente != null) {
            ActividadLimpieza actividadLimpieza = new ActividadLimpieza(
                zonaExistente.getId(),
                personalExistente.getId(),
                actividad.getFechaInicio(),
                actividad.getFechaFin()
            );
            actividadesLimpieza.insertOne(actividadLimpieza);
            return actividadLimpieza;
        }
        return null;
    }

    /**
     * Elimina una actividad de limpieza existente de la base de datos.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     * @throws NoEncontradoException Si no se encuentra la actividad con los datos especificados.
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
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a buscar.
     * @return Un objeto ActividadLimpieza que representa la actividad encontrada.
     * @throws NoEncontradoException Si no se encuentra la actividad con los datos especificados.
     */
    @Override
    public ActividadLimpieza obtenerActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        ActividadLimpieza actividadLimpieza = actividadesLimpieza.find().first();
        if (actividadLimpieza == null) {
            throw new NoEncontradoException("No se encontró la actividad de limpieza con los datos especificados");
        }
        return actividadLimpieza;
    }

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en la base de datos.
     *
     * @return Una lista de objetos ActividadLimpieza que representan todas las actividades registradas.
     */
    @Override
    public List<ActividadLimpieza> obtenerActividadesLimpieza() {
        MongoCollection<ActividadLimpieza> actividadesLimpieza = obtenerColeccionActividadesLimpieza();
        List<ActividadLimpieza> actividades = actividadesLimpieza.find().into(new LinkedList<>());
        return actividades;
    }

    /**
     * Obtiene la colección de actividades de limpieza desde la base de datos MongoDB.
     *
     * @return La colección MongoCollection que representa la colección "actividadesLimpieza".
     */
    private MongoCollection<ActividadLimpieza> obtenerColeccionActividadesLimpieza() {
        MongoDatabase database = ManejadorConexiones.obtenerConexion();
        return database.getCollection("actividadesLimpieza", ActividadLimpieza.class);
    }
}