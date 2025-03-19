package dto;

/**
 * DTO (Data Transfer Object) que representa un residente.
 * Esta clase se utiliza para transferir datos relativos a un residente, 
 * como su identificador único.
 */
public class ResidenteDTO {
    /** Identificador único del residente. */
    private String matricula;
    private String nombreCompleto;
    private char genero;
    private int semestre;
    private String carrera;
    private String telefono;
    private String direccion;
    private String nombreContactoEmergencia;
    private String telefonoContactoEmergencia;
    private String tipoResidente;
    private int idHabitacion;
    
    /**
     * Construye una instancia de {@code ResidenteDTO} con el identificador especificado.
     * @param matricula el identificador único del residente.
     */
    public ResidenteDTO(String matricula) {
        this.matricula = matricula;
    }
    
    /**
     * Construye una instancia de {@code ResidenteeDTO} con el identificador del estudiante
     * y sus datos, obtenidos de una comunicación con el Centro de Información Academica
     * @param matricula
     * @param nombreCompleto
     * @param genero
     * @param semestre
     * @param carrera
     * @param telefono
     * @param direccion 
     */
    public ResidenteDTO(String matricula, String nombreCompleto, char genero, int semestre, String carrera, String telefono, String direccion) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.semestre = semestre;
        this.carrera = carrera;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    
    /**
     * Obtiene el identificador del residente.
     * @return el identificador único del residente.
     */
    public String getMatricula() {
        return matricula;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public char getGenero() {
        return genero;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public String getTipoResidente() {
        return tipoResidente;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setTipoResidente(String tipoResidente) {
        this.tipoResidente = tipoResidente;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    
    
    
    @Override
    public String toString() {
        return "ResidenteDTO{idResidente=" + matricula + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResidenteDTO that = (ResidenteDTO) obj;
        return matricula == that.matricula;
    }

}
