package dto;

/**
 * DTO (Data Transfer Object) que representa un residente.
 * Esta clase se utiliza para transferir datos relativos a un residente, 
 * como su identificador único.
 */
public class ResidenteDTO {
    /** Identificador único del residente. */
    private int idResidente;

    /**
     * Construye una instancia de {@code ResidenteDTO} con el identificador especificado.
     * @param idResidente el identificador único del residente.
     */
    public ResidenteDTO(int idResidente) {
        this.idResidente = idResidente;
    }

    /**
     * Obtiene el identificador del residente.
     * @return el identificador único del residente.
     */
    public int getIdResidente() {
        return idResidente;
    }

    /**
     * Asigna el identificador al residente.
     * @param idResidente el identificador único que se asignará al residente.
     */
    public void setIdResidente(int idResidente) {
        this.idResidente = idResidente;
    }

    @Override
    public String toString() {
        return "ResidenteDTO{idResidente=" + idResidente + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResidenteDTO that = (ResidenteDTO) obj;
        return idResidente == that.idResidente;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idResidente);
    }
}
