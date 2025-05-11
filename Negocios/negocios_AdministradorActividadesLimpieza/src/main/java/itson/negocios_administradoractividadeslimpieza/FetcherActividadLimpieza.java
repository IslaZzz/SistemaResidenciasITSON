package itson.negocios_administradoractividadeslimpieza;

import dto.ActividadLimpiezaDTO;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import java.util.List;
import objetosnegocio.ActividadLimpiezaBO;

public class FetcherActividadLimpieza {

    private ActividadLimpiezaBO actividadLimpiezaBO;

    public FetcherActividadLimpieza(ActividadLimpiezaBO actividadLimpiezaBO) {
        this.actividadLimpiezaBO = actividadLimpiezaBO;
    }

    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividad) throws NegocioException {
        try {
            return actividadLimpiezaBO.obtenerActividadLimpieza(actividad);
        } catch (NoEncontradoException e) {
            throw new NegocioException("Error al obtener la actividad de limpieza: " + e.getMessage());
        }
    }

    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        return actividadLimpiezaBO.obtenerActividadesLimpieza();
    }

}
