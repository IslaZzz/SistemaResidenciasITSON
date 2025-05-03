package dto;

import java.util.Collections;
import java.util.LinkedList;
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
    private String piso;
    
    /** Numero de la habitación  */
    private int numeroHabitacion;
    
    /** Lista de residentes actuales en la habitación (máximo 2). */
    private List<ResidenteDTO> residentesActuales;

    /** Historial de residentes que han ocupado esta habitación. */
    private List<ResidenteDTO> historialResidentes;

    /**
     * Construye una instancia de {@code HabitacionDTO} con el identificador especificado.
     * Inicialmente, la habitación está vacía.
     * @param idHabitacion el identificador único de la habitación.
     */
    public HabitacionDTO(String idHabitacion) {
        this.idHabitacion = idHabitacion;
        this.residentesActuales = new LinkedList<>();
        this.historialResidentes = new LinkedList<>();
    }

    public HabitacionDTO(String piso, int numeroHabitacion) {
        this.piso = piso;
        this.numeroHabitacion = numeroHabitacion;
        this.residentesActuales = new LinkedList<>();
        this.historialResidentes = new LinkedList<>();
    }

    public String getPiso() {
        return piso;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
    
    
    /**
     * Obtiene el identificador de la habitación.
     * @return el identificador único de la habitación.
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Asigna el identificador a la habitación.
     * @param idHabitacion el identificador único que se asignará a la habitación.
     */
    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * Verifica si la habitación está ocupada.
     * @return {@code true} si tiene al menos un residente, {@code false} si está vacía.
     */
    public boolean isOcupada() {
        return !residentesActuales.isEmpty();
    }

    /**
     * Verifica si la habitación tiene espacio para más residentes.
     * @return {@code true} si hay espacio disponible, {@code false} si la habitación está llena.
     */
    public boolean tieneEspacio() {
        
        return residentesActuales.size() < 2;
    }

    /**
     * Obtiene la lista de residentes actuales en la habitación.
     * @return lista inmutable de residentes actuales.
     */
    public List<ResidenteDTO> getResidentesActuales() {
        return residentesActuales;
    }

    /**
     * Agrega un residente a la habitación si hay espacio disponible.
     * @param residente el residente a agregar.
     * @return {@code true} si el residente fue agregado, {@code false} si la habitación está llena.
     */
    public boolean agregarResidente(ResidenteDTO residente) {
        if (tieneEspacio()) {
            residentesActuales.add(residente);
            historialResidentes.add(residente); // Registrar en historial
            return true;
        }
        return false; // Habitación llena
    }

    /**
     * Elimina a un residente de la habitación.
     * @param residente el residente a remover.
     * @return {@code true} si fue removido, {@code false} si no estaba en la habitación.
     */
    public boolean removerResidente(ResidenteDTO residente) {
        return residentesActuales.remove(residente);
    }

    /**
     * Obtiene el historial de residentes que han ocupado la habitación.
     * @return lista inmutable de residentes anteriores.
     */
    public List<ResidenteDTO> getHistorialResidentes() {
        return Collections.unmodifiableList(historialResidentes);
    }
}
