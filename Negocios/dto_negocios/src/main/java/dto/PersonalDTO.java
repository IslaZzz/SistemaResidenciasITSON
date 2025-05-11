package dto;

/**
 * Clase que representa a un miembro del personal dentro del sistema.
 * Cada miembro del personal tiene un identificador único, un nombre y un puesto asignado.
 */
public class PersonalDTO {

    /**
     * Identificador único del miembro del personal.
     */
    private String id;

    /**
     * Nombre del miembro del personal.
     */
    private String nombre;

    /**
     * Puesto del miembro del personal.
     */
    private String puesto;

    /**
     * Constructor vacío para inicializar una instancia de Personal sin datos.
     */
    public PersonalDTO() {}

    public PersonalDTO(String id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    /**
     * Constructor para inicializar una instancia de Personal con datos específicos.
     *
     * @param nombre Nombre del miembro del personal.
     * @param puesto Puesto asignado al miembro del personal.
     */
    public PersonalDTO(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    /**
     * Obtiene el identificador único del miembro del personal.
     *
     * @return El identificador único del miembro del personal.
     */
    public String getId() {
        return id;
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
     * Obtiene el puesto asignado al miembro del personal.
     *
     * @return El puesto del miembro del personal.
     */
    public String getPuesto() {
        return puesto;
    }

}