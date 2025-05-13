package conexiones.excepciones;

/**
 * Excepción que se lanza cuando ocurre un error al comunicarse con el servidor CIA.
 * Puede deberse a una caída del servidor, errores de red, o respuestas no válidas.
 */
public class ServidorExcepcion extends Exception {

    /**
     * Constructor por defecto sin mensaje.
     */
    public ServidorExcepcion() {
    }

    /**
     * Constructor que permite especificar un mensaje de error.
     * 
     * @param message Mensaje descriptivo del error ocurrido.
     */
    public ServidorExcepcion(String message) {
        super(message);
    }
}
