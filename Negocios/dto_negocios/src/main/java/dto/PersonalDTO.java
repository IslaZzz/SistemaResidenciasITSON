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
     * Teléfono de contacto del miembro del personal.
     */
    private String telefono;

    /**
     * Correo electrónico del miembro del personal.
     */
    private String correo;

    /**
     * Constructor vacío para inicializar una instancia de Personal sin datos.
     */
    public PersonalDTO() {}

    /**
     * Constructor para inicializar una instancia de Personal con datos específicos
     * @param id Identificador único del miembro del personal
     * @param nombre Nombre del miembro del personal
     * @param puesto Puesto asignado al miembro del personal
     * @param telefono Telefono de contacto del miembro del personal
     * @param correo Correo electrónico del miembro del personal.
     */
    public PersonalDTO(String id, String nombre, String puesto, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Constructor para inicializar una instancia de Personal con datos específicos.
     *
     * @param nombre Nombre del miembro del personal.
     * @param puesto Puesto asignado al miembro del personal.
     * @param telefono Telefono del personal
     * @param correo Correo del personal.
     */
    public PersonalDTO(String nombre, String puesto, String telefono, String correo) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Constructor para inicializar una instancia de Personal con su nombre.
     * @param nombre Nombre del personal
     */
    public PersonalDTO(String nombre) {
        this.nombre = nombre;
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
     * Establece el identificador único del miembro del personal.
     *
     * @param id El nuevo identificador único del miembro del personal.
     */
    public void setId(String id) {
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
     * Obtiene el puesto asignado al miembro del personal.
     *
     * @return El puesto del miembro del personal.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Obtiene el telefono del miembro del personal
     * @return Telefono del miembro del personal
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del miembro del personal
     * @return Correo electrónico del miembro del personal
     */
    public String getCorreo() {
        return correo;
    }
}