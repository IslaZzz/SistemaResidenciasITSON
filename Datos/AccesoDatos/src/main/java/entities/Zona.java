package entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase que representa una zona dentro de un edificio o instalación.
 * Cada zona está asociada a un piso y tiene un nombre único que la identifica.
 */
public class Zona {

    /**
     * Identificador único de la zona.
     */
    @BsonId
    private ObjectId id;

    /**
     * Número del piso al que pertenece la zona.
     */
    private int piso;

    /**
     * Nombre de la zona.
     */
    private String nombre;

    /**
     * Constructor vacío para inicializar una instancia de Zona sin datos.
     */
    public Zona() {}

    /**
     * Constructor para inicializar una instancia de Zona con datos específicos.
     *
     * @param piso Número del piso al que pertenece la zona.
     * @param nombre Nombre de la zona.
     */
    public Zona(int piso, String nombre) {
        this.piso = piso;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único de la zona.
     *
     * @return El identificador único de la zona.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la zona.
     *
     * @param id El identificador único de la zona.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el número del piso al que pertenece la zona.
     *
     * @return El número del piso.
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece el número del piso al que pertenece la zona.
     *
     * @param piso El número del piso.
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Obtiene el nombre de la zona.
     *
     * @return El nombre de la zona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la zona.
     *
     * @param nombre El nombre de la zona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}