package excepciones;

/**
 * Clase que representa una excepción específica para el sistema de comunicación 
 * con la Central de Información Académica (CIA).
 * 
 * Esta clase extiende de {@link Exception} y se utiliza para manejar errores
 * relacionados con el procesamiento de datos de estudiantes o cualquier otro
 * problema específico que ocurra durante la comunicación con el sistema CIA.
 */
public class CIAExcepcion extends Exception {

    /**
     * Constructor por defecto de la excepción. Crea una nueva instancia de
     * {@link CIAExcepcion} sin un mensaje de error.
     */
    public CIAExcepcion() {
    }

    /**
     * Constructor que crea una nueva instancia de {@link CIAExcepcion} con un
     * mensaje de error específico.
     *
     * @param message El mensaje de error que describe el detalle del problema.
     */
    public CIAExcepcion(String message) {
        super(message);
    }
}
