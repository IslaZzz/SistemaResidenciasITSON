package objetosnegocio;

import java.util.List;

import dto.ZonaDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

public class ZonasBO {

    private static ZonasBO instance = null;

    private ZonasBO() {
        inicializarZonas();
    }

    public static ZonasBO getInstance() {
        if (instance == null) {
            instance = new ZonasBO();
        }
        return instance;
    }

    private void inicializarZonas() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        if (accesoDatos.obtenerZonas().isEmpty()) {
            // Piso 1
            accesoDatos.registrarZona(new ZonaDTO(1, "Recepción"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Pasillo Principal"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Sala de Estar"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Cocina Principal"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Comedor"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Baños Comunes"));
            accesoDatos.registrarZona(new ZonaDTO(1, "Cuarto de Limpieza"));

            // Piso 2
            accesoDatos.registrarZona(new ZonaDTO(2, "Pasillo Este"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Pasillo Oeste"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Sala de Estudio A"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Sala de Estudio B"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Baños Comunes"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Sala de Juegos"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Cuarto de Lavado"));
            accesoDatos.registrarZona(new ZonaDTO(2, "Balcón Norte"));

            // Piso 3
            accesoDatos.registrarZona(new ZonaDTO(3, "Pasillo Este"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Pasillo Oeste"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Sala de Estudio C"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Sala de Estudio D"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Baños Comunes"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Terraza"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Gimnasio"));
            accesoDatos.registrarZona(new ZonaDTO(3, "Bodega"));
        }
    }

    public ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerZona(zona);
    }

    public List<ZonaDTO> obtenerZonas() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerZonas();
    }

}
