package implementaciones;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class ManejadorConexiones {
    
    /**
     * URI de la conexión con MongoDB, en este caso es una conexión local.
     */
    private static final String URI = "mongodb://localhost:27017/?retryWrites=true&loadBalanced=false&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000";
    
    /**
     * Nombre de la base de datos de prueba
     */
    private static final String TEST_DB_NAME = "residenciasTest";
    /**
     * Nombre de la base de datos del sistema
     */
    private static final String DB_NAME = "residenciasBD";
    
    /**
     * Modo de pruebas.
     */
    public static boolean testMode = false;
    
    /**
     * Metodo que regresa un objeto del tipo MongoOperations con el que se manejan operaciones en MONGODB
     * Revisa si la conexión es un test o no y crea una conexión dependiendo del resultado.
     * @return objeto MongoOperations para operar con la base de datos.
     */
    public static MongoOperations obtenerConexion(){
        if(isTestMode()){
            return new MongoTemplate(MongoClients.create(URI), TEST_DB_NAME);
        } else {
            return new MongoTemplate(MongoClients.create(URI), DB_NAME);
        }
        
    }
    
    /**
     * Activa el modo de pruebas
     */
    public static void activateTestMode(){
        testMode = true;
    }
    
    /**
     * Desactiva el modo de pruebas
     */
    public static void deactivateTestMode(){
        testMode = false;
    }

    /**
     * Obtiene el valor de modo de pruebas
     * @return True si el modo de preubas está activo, false si no
     */
    public static boolean isTestMode() {
        return testMode;
    }
    
}
