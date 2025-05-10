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
    private String correo;
    private String telefono;
    private String direccion;
    private String nombreContactoEmergencia;
    private String telefonoContactoEmergencia;
    private String tipoResidente;
    private String idHabitacion;
    
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
    public ResidenteDTO(String matricula, String nombreCompleto, char genero, int semestre, String carrera, String correo, String telefono, String direccion) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.semestre = semestre;
        this.carrera = carrera;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     * Construye una instancia de {@code ResidenteDTO} con todos los datos del residente.
     * @param matricula el identificador único del residente.
     * @param nombreCompleto el nombre completo del residente.
     * @param genero el género del residente.
     * @param semestre el semestre en el que se encuentra el residente.
     * @param carrera la carrera que estudia el residente.
     * @param correo el correo electrónico del residente.
     * @param telefono el número de teléfono del residente.
     * @param direccion la dirección del residente.
     * @param nombreContactoEmergencia el nombre de la persona de contacto en caso de emergencia.
     * @param telefonoContactoEmergencia el número de teléfono de la persona de contacto en caso de emergencia.
     */
    public ResidenteDTO(String matricula, String nombreCompleto, char genero, int semestre, String carrera, String correo, String telefono, String direccion, String nombreContactoEmergencia, String telefonoContactoEmergencia) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.semestre = semestre;
        this.carrera = carrera;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
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

    public String getCorreo(){
        return correo;
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

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
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
