package interfaz;

import java.util.List;

import dto.ZonaDTO;
import entities.Zona;
import exceptions.NoEncontradoException;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de zonas
 * en el sistema. Proporciona métodos para agregar, eliminar, obtener y listar zonas.
 */
public interface IZonasDAO {

    /**
     * Agrega una nueva zona al sistema.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a agregar.
     * @return Un objeto Zona que representa la zona agregada, incluyendo su identificador único.
     */
    public abstract Zona agregarZona(ZonaDTO zona);

    /**
     * Elimina una zona existente del sistema.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a eliminar.
     */
    public abstract void eliminarZona(ZonaDTO zona) throws NoEncontradoException;

    /**
     * Obtiene una zona específica del sistema.
     * Este método recibe un objeto ZonaDTO sin identificador (id) y busca en la base de datos
     * una zona que coincida con los datos proporcionados. Si se encuentra, devuelve un
     * objeto ZonaDTO que incluye el identificador único de la zona.
     *
     * @param zona El objeto ZonaDTO que contiene los datos de la zona a buscar (sin id).
     * @return Un objeto ZonaDTO que representa la zona encontrada, incluyendo su identificador único.
     */
    public abstract ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException;

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema.
     *
     * @return Una lista de objetos ZonaDTO que representan todas las zonas registradas.
     */
    public abstract List<ZonaDTO> obtenerZonas();
}