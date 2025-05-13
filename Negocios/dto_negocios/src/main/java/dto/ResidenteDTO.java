package dto;

/**
 * DTO (Data Transfer Object) que representa un residente. Esta clase se utiliza
 * para transferir datos relativos a un residente, como su identificador único.
 */
public class ResidenteDTO {

    /**
     * Identificador único del residente.
     */
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
     * Construye una instancia de {@code ResidenteDTO} con el identificador
     * especificado.
     *
     * @param matricula el identificador único del residente.
     */
    public ResidenteDTO(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Construye una instancia de {@code ResidenteeDTO} con el identificador del
     * estudiante y sus datos, obtenidos de una comunicación con el Centro de
     * Información Academica
     *
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
     * Construye una instancia de {@code ResidenteDTO} con todos los datos del
     * residente.
     *
     * @param matricula el identificador único del residente.
     * @param nombreCompleto el nombre completo del residente.
     * @param genero el género del residente.
     * @param semestre el semestre en el que se encuentra el residente.
     * @param carrera la carrera que estudia el residente.
     * @param correo el correo electrónico del residente.
     * @param telefono el número de teléfono del residente.
     * @param direccion la dirección del residente.
     * @param nombreContactoEmergencia el nombre de la persona de contacto en
     * caso de emergencia.
     * @param telefonoContactoEmergencia el número de teléfono de la persona de
     * contacto en caso de emergencia.
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
     *
     * @return el identificador único del residente.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devuelve el nombre completo del residente.
     *
     * @return el nombre completo.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Devuelve el género del residente.
     *
     * @return el género representado como un carácter (por ejemplo, 'M' para
     * masculino, 'F' para femenino).
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Devuelve el semestre actual que cursa el residente.
     *
     * @return el número de semestre.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Devuelve la carrera que cursa el residente.
     *
     * @return el nombre de la carrera.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Devuelve la dirección de correo electrónico del residente.
     *
     * @return el correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Devuelve el número de teléfono del residente.
     *
     * @return el número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Devuelve la dirección del domicilio del residente.
     *
     * @return la dirección del residente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Devuelve el nombre del contacto de emergencia del residente.
     *
     * @return el nombre del contacto de emergencia.
     */
    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    /**
     * Devuelve el número de teléfono del contacto de emergencia del residente.
     *
     * @return el teléfono del contacto de emergencia.
     */
    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    /**
     * Devuelve el tipo de residente (por ejemplo, permanente, temporal, etc.).
     *
     * @return el tipo de residente.
     */
    public String getTipoResidente() {
        return tipoResidente;
    }

    /**
     * Devuelve el identificador de la habitación.
     *
     * @return el identificador de la habitación.
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Establece el identificador de la habitación.
     *
     * @param idHabitacion el identificador único de la habitación.
     */
    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * Establece el tipo de residente (por ejemplo, permanente, temporal, etc.).
     *
     * @param tipoResidente el tipo de residente asociado a la habitación.
     */
    public void setTipoResidente(String tipoResidente) {
        this.tipoResidente = tipoResidente;
    }

    /**
     * Establece el nombre del contacto de emergencia del residente.
     *
     * @param nombreContactoEmergencia el nombre del contacto de emergencia.
     */
    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    /**
     * Establece el número de teléfono del contacto de emergencia del residente.
     *
     * @param telefonoContactoEmergencia el teléfono del contacto de emergencia.
     */
    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    @Override
    public String toString() {
        return "ResidenteDTO{idResidente=" + matricula + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ResidenteDTO that = (ResidenteDTO) obj;
        return matricula == that.matricula;
    }

}
