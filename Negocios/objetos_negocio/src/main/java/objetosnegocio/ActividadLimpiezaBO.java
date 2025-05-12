package objetosnegocio;

import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

public class ActividadLimpiezaBO {

    private static ActividadLimpiezaBO instance;

    private ActividadLimpiezaBO() { }

    public static ActividadLimpiezaBO getInstance() {
        if (instance == null) {
            instance = new ActividadLimpiezaBO();
        }
        return instance;
    }

    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividad, ZonaDTO zona, PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.registrarActividadLimpieza(actividad, zona, personal);
    }

    public boolean eliminarActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.eliminarActividad(actividad);
    }

    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividad) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpieza(actividad);
    }

    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorPersonalYHora(ActividadLimpiezaDTO actividad, PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpiezaPorPersonalYHora(actividad, personal);
    }

    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorZonaYHora(ActividadLimpiezaDTO actividad, ZonaDTO zona) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadLimpiezaPorZonaYHora(actividad, zona);
    }
    

    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerActividadesLimpieza();
    }

}
