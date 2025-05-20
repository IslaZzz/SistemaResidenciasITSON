package excepciones;

/**
 * Excepción comprobada lanzada cuando ocurre un problema al enviar o recibir
 * mensajes dentro de la capa de mensajería del sistema.
 */
public class MensajeriaException extends Exception {

    /**
     * Crea una nueva instancia sin mensaje de detalle.
     */
    public MensajeriaException() {
    }

    /**
     * Crea una nueva instancia con el mensaje de detalle especificado.
     *
     * @param message mensaje que describe la causa concreta del error
     */
    public MensajeriaException(String message) {
        super(message);
    }
}
