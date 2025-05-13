package objetosnegocio;

import java.util.List;

import dto.ZonaDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 * Clase que administra la lógica de negocio relacionada con las Zonas del
 * sistema. Se encarga de gestionar las zonas disponibles en los diferentes
 * pisos, asegurando que estas sean correctamente registradas e inicializadas si
 * es necesario. También permite obtener información sobre zonas específicas a
 * través de la interacción con la capa de acceso a datos.
 *
 * Implementa el patrón Singleton para asegurar que exista una única instancia
 * de la lógica de negocio relacionada con las zonas.
 */
public class ZonasBO {

    /**
     * Instancia singleton de la clase ZonasBO.
     */
    private static ZonasBO instance = null;

    /**
     * Constructor privado para evitar la creación de instancias externas.
     * Inicializa las zonas del sistema si es necesario.
     */
    private ZonasBO() {
        inicializarZonas();
    }

    /**
     * Método que obtiene la instancia única de ZonasBO.
     *
     * @return la instancia de ZonasBO.
     */
    public static ZonasBO getInstance() {
        if (instance == null) {
            instance = new ZonasBO();
        }
        return instance;
    }

    /**
     * Inicializa las zonas del sistema si no se han registrado previamente.
     * Este método verifica si ya existen zonas en la base de datos y, si no,
     * registra las zonas predeterminadas para cada piso.
     */
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

    /**
     * Obtiene una zona específica basada en los datos proporcionados en el
     * objeto {@code ZonaDTO}. Si la zona no existe, lanza una excepción de tipo
     * {@code NoEncontradoException}.
     *
     * @param zona el objeto {@link ZonaDTO} que contiene los datos de la zona a
     * obtener.
     * @return la zona correspondiente al objeto {@link ZonaDTO} proporcionado.
     * @throws NoEncontradoException si no se encuentra la zona especificada.
     */
    public ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerZona(zona);
    }

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema.
     *
     * @return una lista de objetos {@link ZonaDTO} que representa todas las
     * zonas en el sistema.
     */
    public List<ZonaDTO> obtenerZonas() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerZonas();
    }

}
