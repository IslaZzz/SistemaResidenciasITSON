package conexiones.excepciones;

public class ServidorExcepcion extends Exception{
    public ServidorExcepcion() {
    }

    public ServidorExcepcion(String message) {
        super(message);
    }
}
