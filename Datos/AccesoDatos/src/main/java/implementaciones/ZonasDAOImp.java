package implementaciones;

import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dto.ZonaDTO;
import entities.Zona;
import exceptions.NoEncontradoException;
import interfaz.IZonasDAO;

/**
 * Implementación de la interfaz ZonasDAO para la gestión de zonas en el
 * sistema.
 */
public class ZonasDAOImp implements IZonasDAO {

    /**
     * Agrega una nueva zona al sistema.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a
     * agregar.
     * @return Un objeto Zona que representa la zona agregada, incluyendo su
     * identificador único.
     */
    @Override
    public Zona agregarZona(ZonaDTO zona) {
        MongoCollection<Zona> zonas = obtenerColeccionZonas();
        Zona nuevaZona = new Zona(zona.getPiso(), zona.getNombre());
        zonas.insertOne(nuevaZona);
        return nuevaZona;
    }

    ;

    /**
     * Elimina una zona existente del sistema.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a eliminar.
     */
    @Override
    public void eliminarZona(ZonaDTO zona) throws NoEncontradoException {
        MongoCollection<Zona> zonas = obtenerColeccionZonas();
        ZonaDTO zonaAEliminar = obtenerZona(zona);
        zonas.deleteOne(Filters.eq("_id", new ObjectId(zonaAEliminar.getId())));
    }

    ;

    /**
     * Obtiene una zona específica del sistema.
     * Este método recibe un objeto ZonaDTO sin identificador (id) y busca en la base de datos
     * una zona que coincida con los datos proporcionados. Si se encuentra, devuelve un
     * objeto ZonaDTO que incluye el identificador único de la zona.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a buscar (sin id).
     * @return Un objeto ZonaDTO que representa la zona encontrada, incluyendo su identificador único.
     */
    @Override
    public ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException {
        if (zona.getId() != null) {
            return obtenerZonaPorId(zona.getId());
        } else {
            return obtenerZonaPorPisoYNombre(zona.getPiso(), zona.getNombre());
        }
    }

    ;

    /**
     * Obtiene una zona específica del sistema
     * a partir de su identificador único.
     * @param id Identificador único de la zona
     * @return ZonaDTO que representa la zona encontrada
     * @throws NoEncontradoException Si no se encuentra la zona
     */
    private ZonaDTO obtenerZonaPorId(String id) throws NoEncontradoException {
        MongoCollection<Zona> zonas = obtenerColeccionZonas();
        Zona zona = zonas.find(Filters.eq("_id", new ObjectId(id))).first();
        if (zona != null) {
            return new ZonaDTO(zona.getId().toString(), zona.getPiso(), zona.getNombre());
        } else {
            throw new NoEncontradoException("Zona no encontrada con id: " + id);
        }
    }

    /**
     * Obtiene una zona específica del sistema a partir del piso y el nombre
     * proporcionados.
     *
     * @param piso Piso de la zona
     * @param nombre Nombre de la zona
     * @return ZonaDTO que representa la zona encontrada
     * @throws NoEncontradoException Si no se encuentra la zona
     */
    private ZonaDTO obtenerZonaPorPisoYNombre(int piso, String nombre) throws NoEncontradoException {
        MongoCollection<Zona> zonas = obtenerColeccionZonas();
        Zona zona = zonas.find(Filters.and(Filters.eq("piso", piso), Filters.eq("nombre", nombre))).first();
        if (zona != null) {
            return new ZonaDTO(zona.getId().toString(), zona.getPiso(), zona.getNombre());
        } else {
            throw new NoEncontradoException("Zona no encontrada con piso: " + piso + " y nombre: " + nombre);
        }
    }

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema.
     *
     * @return Una lista de objetos ZonaDTO que representan todas las zonas
     * registradas.
     */
    @Override
    public List<ZonaDTO> obtenerZonas() {
        MongoCollection<Zona> zonas = obtenerColeccionZonas();
        FindIterable<Zona> zonasEncontradas = zonas.find();
        List<ZonaDTO> listaZonas = new LinkedList<>();
        for (Zona zona : zonasEncontradas) {
            ZonaDTO zonaDTO = new ZonaDTO(zona.getId().toString(), zona.getPiso(), zona.getNombre());
            listaZonas.add(zonaDTO);
        }
        return listaZonas;
    }

    
    /**
     * Obtiene la colección de zonas de la base de datos.
     * 
     * @return La colección de zonas en la base de datos.
     */
    private MongoCollection<Zona> obtenerColeccionZonas() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("zonas", Zona.class);
    }

}
