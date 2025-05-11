package entities;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import enums.Puesto;

/**
 * Clase que representa a un miembro del personal dentro del sistema.
 * Cada miembro del personal tiene un identificador único, un nombre y un puesto asignado.
 */
public class Personal {

    /**
     * Identificador único del miembro del personal.
     */
    @BsonId
    private ObjectId id;

    /**
     * Nombre del miembro del personal.
     */
    private String nombre;

    /**
     * Puesto del miembro del personal.
     */
    private Puesto puesto;

    /**
     * Constructor vacío para inicializar una instancia de Personal sin datos.
     */
    public Personal() {}

    /**
     * Constructor para inicializar una instancia de Personal con datos específicos.
     *
     * @param nombre Nombre del miembro del personal.
     * @param puesto Puesto asignado al miembro del personal.
     */
    public Personal(String nombre, Puesto puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    /**
     * Obtiene el identificador único del miembro del personal.
     *
     * @return El identificador único del miembro del personal.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del miembro del personal.
     *
     * @param id El identificador único del miembro del personal.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del miembro del personal.
     *
     * @return El nombre del miembro del personal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del miembro del personal.
     *
     * @param nombre El nombre del miembro del personal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el puesto asignado al miembro del personal.
     *
     * @return El puesto del miembro del personal.
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto asignado al miembro del personal.
     *
     * @param puesto El puesto del miembro del personal.
     */
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
}