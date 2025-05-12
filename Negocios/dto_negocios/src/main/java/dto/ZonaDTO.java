package dto;

/**
 * Clase que representa una zona dentro del edificio de residenciaas.
 * Cada zona está asociada a un piso y tiene un nombre que la identifica.
 */
public class ZonaDTO {

    /**
     * Identificador único de la zona.
     */
    private String id;

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
    public ZonaDTO() {}

    /**
     * Constructor para inicializar una instancia de Zona con un identificador único.
     *
     * @param id Identificador único de la zona.
     */
    public ZonaDTO(String id) {
        this.id = id;
    }

    /**
     * Constructor para inicializar una instancia de Zona con datos específicos.
     *
     * @param id Identificador único de la zona.
     * @param piso Número del piso al que pertenece la zona.
     * @param nombre Nombre de la zona.
     */
    public ZonaDTO(String id, int piso, String nombre) {
        this.id = id;
        this.piso = piso;
        this.nombre = nombre;
    }
    
    /**
     * Constructor para inicializar una instancia de Zona con datos específicos.
     *
     * @param piso Número del piso al que pertenece la zona.
     * @param nombre Nombre de la zona.
     */
    public ZonaDTO(int piso, String nombre) {
        this.piso = piso;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único de la zona.
     *
     * @return El identificador único de la zona.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la zona.
     *
     * @param id El nuevo identificador único de la zona.
     */
    public void setId(String id){
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
     * Obtiene el nombre de la zona.
     *
     * @return El nombre de la zona.
     */
    public String getNombre() {
        return nombre;
    }

}