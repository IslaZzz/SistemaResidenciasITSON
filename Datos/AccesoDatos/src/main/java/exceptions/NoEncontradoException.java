package exceptions;

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
     * @param causa   Causa de la excepción.
     */
    public NoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    } 
    
}
