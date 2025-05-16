package implementaciones;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Clase encargada de gestionar la conexión a la base de datos MongoDB. Permite
 * configurar la conexión dependiendo de si se está trabajando en modo de
 * pruebas o en modo de producción.
 */
public class ManejadorConexiones {

    /**
     * URI de la conexión con MongoDB, en este caso es una conexión local.
     */
    //private static final String URI = "mongodb://localhost:27017/?retryWrites=true&loadBalanced=false&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000";
      private static final String URI = "mongodb://localhost:27017";
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
     * Metodo que regresa un objeto del tipo MongoDatabase con el que se manejan
     * operaciones en MONGODB Revisa si la conexión es un test o no y crea una
     * conexión dependiendo del resultado.
     *
     * @return objeto MongoOperations para operar con la base de datos.
     */
    public static MongoDatabase obtenerConexion() {
        MongoClient client = MongoClients.create(getSettings());
        if (isTestMode()) {
            return client.getDatabase(TEST_DB_NAME);
        } else {
            return client.getDatabase(DB_NAME);
        }
    }

    private static CodecRegistry getPojoCodecRegistry() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return pojoCodecRegistry;
    }

    private static MongoClientSettings getSettings() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URI))
                .codecRegistry(getPojoCodecRegistry())
                .build();
        return settings;
    }

    /**
     * Activa el modo de pruebas
     */
    public static void activateTestMode() {
        testMode = true;
    }

    /**
     * Desactiva el modo de pruebas
     */
    public static void deactivateTestMode() {
        testMode = false;
    }

    /**
     * Obtiene el valor de modo de pruebas
     *
     * @return True si el modo de preubas está activo, false si no
     */
    public static boolean isTestMode() {
        return testMode;
    }

}
