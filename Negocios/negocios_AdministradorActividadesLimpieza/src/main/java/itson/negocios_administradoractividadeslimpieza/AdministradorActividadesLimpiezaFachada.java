package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ActividadLimpiezaBO;

public class AdministradorActividadesLimpiezaFachada implements IAdministradorActividadesLimpieza {

    private ActividadLimpiezaBO actividadLimpiezaBO = ActividadLimpiezaBO.getInstance();
    private FetcherActividadLimpieza fetcherActividadLimpieza = new FetcherActividadLimpieza(actividadLimpiezaBO);

    @Override
    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpiezaDTO, ZonaDTO zonaDTO, PersonalDTO personalDTO) throws NegocioException{
        try{
            return actividadLimpiezaBO.registrarActividadLimpieza(actividadLimpiezaDTO, zonaDTO, personalDTO);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al registrar la actividad de limpieza: " + e.getMessage());
        }
    }

    @Override
    public boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException {
        try {
            return actividadLimpiezaBO.eliminarActividad(actividadLimpiezaDTO);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al eliminar la actividad de limpieza: " + e.getMessage());
        }
    }

    @Override
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        return fetcherActividadLimpieza.obtenerActividadesLimpieza();    
    }

    @Override
    public ActividadLimpiezaDTO obtenerActividad(ActividadLimpiezaDTO actividadLimpiezaDTO) throws NegocioException {
        try {
            return fetcherActividadLimpieza.obtenerActividadLimpieza(actividadLimpiezaDTO);
        } catch (NegocioException e) {
            throw new NegocioException("Error al obtener la actividad de limpieza: " + e.getMessage());
        }
    }

}
