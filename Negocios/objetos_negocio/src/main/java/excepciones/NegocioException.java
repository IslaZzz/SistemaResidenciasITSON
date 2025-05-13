package excepciones;

/**
 * {@code NegocioException} es una excepción personalizada que representa errores
 * relacionados con la lógica de negocio en la aplicación.
 * 
 * <p>Esta clase extiende {@code Exception}, lo que permite que sea utilizada
 * como una excepción comprobada (checked exception). Es útil para señalar
 * condiciones de error previsibles que se deben manejar de forma controlada
 * en las capas superiores del sistema.</p>
 * 
 * <p>Por ejemplo, puede utilizarse para indicar reglas de negocio violadas,
 * datos inválidos, o situaciones no permitidas en el flujo de una operación.</p>
 * 
 */
public class NegocioException extends Exception {

    /**
     * Crea una nueva instancia de {@code NegocioException} sin mensaje detallado.
     */
    public NegocioException() {
        super();
    }

    /**
     * Crea una nueva instancia de {@code NegocioException} con un mensaje detallado.
     *
     * @param message El mensaje que describe la causa de la excepción.
     */
    public NegocioException(String message) {
        super(message);
    }
}


