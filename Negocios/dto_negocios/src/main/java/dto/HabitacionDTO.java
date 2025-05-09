package dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa una habitación.
 * Esta clase se utiliza para transferir datos relativos a una habitación,
 * como su identificador y la lista de residentes actuales y anteriores.
 */
public class HabitacionDTO {

    /** Identificador único de la habitación. */
    private String idHabitacion;

    /** Piso donde se ubica la habitación     */
    private int piso;
    
    /** Numero de la habitación  */
    private int numero;
    
    /** Lista de residentes actuales en la habitación (máximo 2). */
    private List<String> residentesActualesIds;

    /**
     * Construye una instancia de {@code HabitacionDTO} con el identificador especificado.
     * Inicialmente, la habitación está vacía.
     * @param idHabitacion el identificador único de la habitación.
     */
    public HabitacionDTO(String idHabitacion, int piso, int numero, List<String> residentesActualesIds) {
        this.idHabitacion = idHabitacion;
        this.piso = piso;
        this.numero = numero;
        this.residentesActualesIds = residentesActualesIds;
    }

    public HabitacionDTO(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene el identificador de la habitación.
     * @return el identificador único de la habitación.
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Establece el identificador de la habitación.
     * @param idHabitacion el nuevo identificador único de la habitación.
     */
    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * Obtiene la lista de residentes actuales en la habitación.
     * @return lista inmutable de residentes actuales.
     */
    public List<String> getResidentesActualesIds() {
        return residentesActualesIds;
    }

}
