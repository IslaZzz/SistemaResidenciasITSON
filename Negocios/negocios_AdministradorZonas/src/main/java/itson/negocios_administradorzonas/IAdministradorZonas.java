package itson.negocios_administradorzonas;

import dto.ZonaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de zonas en
 * el sistema. Proporciona métodos para obtener zonas específicas o una lista
 * completa de todas las zonas registradas.
 */
public interface IAdministradorZonas {

    /**
     * Obtiene una zona específica del sistema.
     *
     * @param zona ZonaDTO que representa la zona a buscar.
     * @return ZonaDTO que representa la zona encontrada.
     * @throws excepciones.NegocioException
     */
    ZonaDTO obtenerZona(ZonaDTO zona) throws NegocioException;

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema.
     *
     * @return Una lista de zonas.
     */
    List<ZonaDTO> obtenerZonas();

}
