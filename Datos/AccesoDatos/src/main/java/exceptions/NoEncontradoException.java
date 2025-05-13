package exceptions;

/**
 * Excepción personalizada que se lanza cuando un elemento no es encontrado.
 * Esta excepción puede ser utilizada para situaciones en las que se espera
 * encontrar un objeto o entidad, pero no se encuentra en el sistema.
 */
public class NoEncontradoException extends Exception {

    /**
     * Constructor de la clase NoEncontradoException.
     *
     * @param mensaje Mensaje de error que describe la excepción.
     */
    public NoEncontradoException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor de la clase NoEncontradoException.
     *
     * @param mensaje Mensaje de error que describe la excepción.
     * @param causa Causa de la excepción.
     */
    public NoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
