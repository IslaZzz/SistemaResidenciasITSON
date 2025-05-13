package itson.negocios_administradorzonas;

import dto.ZonaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ZonasBO;

/**
 * Fachada que implementa la interfaz {@link IAdministradorZonas} para gestionar
 * las operaciones relacionadas con las zonas en el sistema. Esta clase actúa
 * como intermediario entre la capa de negocio y la capa de acceso a datos,
 * delegando las acciones correspondientes a la implementación de la lógica de
 * negocio en la clase {@link ZonasBO}.
 *
 * La clase proporciona métodos para obtener información sobre las zonas,
 * incluyendo obtener una zona específica o todas las zonas registradas en el
 * sistema.
 */
public class AdministradorZonasFachada implements IAdministradorZonas {

    /**
     * Instancia de la clase ZonaBO que maneja la lógica de negocio relacionada
     * con las zonas.
     */
    private ZonasBO zonaBO = ZonasBO.getInstance();

    /**
     * Método que obtiene una zona específica del sistema.
     *
     * @return ZonaDTO que representa la zona encontrada.
     * @throws excepciones.NegocioException
     */
    @Override
    public ZonaDTO obtenerZona(ZonaDTO zona) throws NegocioException {
        try {
            return zonaBO.obtenerZona(zona);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al obtener la zona: " + e.getMessage());
        }
    }

    /**
     * Método que obtiene una lista de todas las zonas registradas en el
     * sistema.
     *
     * @return Una lista de zonas.
     */
    @Override
    public List<ZonaDTO> obtenerZonas() {
        return zonaBO.obtenerZonas();
    }

}
