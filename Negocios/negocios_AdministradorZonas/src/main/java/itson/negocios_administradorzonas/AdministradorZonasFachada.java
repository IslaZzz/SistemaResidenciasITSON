package itson.negocios_administradorzonas;

import dto.ZonaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ZonasBO;

public class AdministradorZonasFachada implements IAdministradorZonas {

    /**
     * Instancia de la clase ZonaBO que maneja la lógica de negocio relacionada con las zonas.
     */
    private ZonasBO zonaBO = ZonasBO.getInstance();
    
    /**
     * Método que obtiene una zona específica del sistema.
     *
     * @return ZonaDTO que representa la zona encontrada.
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
     * Método que obtiene una lista de todas las zonas registradas en el sistema.
     * 
     * @return Una lista de zonas.
     */
    @Override
    public List<ZonaDTO> obtenerZonas() {
        return zonaBO.obtenerZonas();
    }

}
