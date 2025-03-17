package dto;

/**
 * DTO (Data Transfer Object) que representa una habitación.
 * Esta clase se utiliza para transferir datos relativos a una habitación,
 * como su identificador y su estado de ocupación.
 */
public class HabitacionDTO {

    /**
     * Identificador único de la habitación.
     */
    private int idHabitacion;
    
    /**
     * Indica el estado de ocupación de la habitación.
     * {@codetrue} si la habitación está ocupada, {@code false} si está libre.
     */
    private boolean ocupada;

    /**
     * Construye una instancia de {@code HabitacionDTO} con el identificador
     * y el estado de ocupación especificados.
     * @param idHabitacion el identificador único de la habitación.
     * @param ocupada      el estado de ocupación de la habitación; {@code true} si está ocupada,
       {@code false} en caso contrario.
     */
    public HabitacionDTO(int idHabitacion, boolean ocupada) {
        this.idHabitacion = idHabitacion;
        this.ocupada = ocupada;
    }

    /**
     * Obtiene el identificador de la habitación.
     * @return el identificador único de la habitación.
     */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Asigna el identificador a la habitación.
     * @param idHabitacion el identificador único que se asignará a la habitación.
     */
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * Verifica si la habitación se encuentra ocupada.
     * @return {@code true} si la habitación está ocupada, {@code false} si está libre.
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * Establece el estado de ocupación de la habitación.
     * @param ocupada el nuevo estado de ocupación; {@code true} para ocupada, {@code false} para libre.
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
