package excepciones;

public class NegocioException extends Exception{

    public NegocioException() {
        super();
    }
    
    public NegocioException(String message){
        super(message);
    }
}
