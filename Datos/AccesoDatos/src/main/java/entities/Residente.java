package entities;

import org.bson.codecs.pojo.annotations.BsonId;

import enums.TipoResidente;

/**
 * Clase que representa un residente dentro de un sistema de gestión de
 * alojamientos o residencias. Incluye información sobre el residente, como su
 * matrícula, datos personales, información de contacto de emergencia y la
 * habitación asignada.
 */
public class Residente {

    /**
     * Identificador único del residente, que corresponde a la matrícula del
     * estudiante.
     */
    @BsonId
    private String matricula;

    /**
     * Nombre completo del residente.
     */
    private String nombreCompleto;

    /**
     * Género del residente, representado por un carácter (por ejemplo, 'M' para
     * masculino, 'F' para femenino).
     */
    private char genero;

    /**
     * Semestre académico en el que se encuentra el residente.
     */
    private int semestre;

    /**
     * Carrera académica que cursa el residente.
     */
    private String carrera;

    /**
     * Correo electrónico del residente.
     */
    private String correo;

    /**
     * Número de teléfono del residente.
     */
    private String telefono;

    /**
     * Dirección de residencia del residente.
     */
    private String direccion;

    /**
     * Nombre del contacto de emergencia del residente.
     */
    private String nombreContactoEmergencia;

    /**
     * Número de teléfono del contacto de emergencia del residente.
     */
    private String telefonoContactoEmergencia;

    /**
     * Tipo de residente (puede ser estudiante, personal, visitante, etc.).
     */
    private TipoResidente tipoResidente;

    /**
     * Identificador de la habitación asignada al residente.
     */
    private String habitacion;
    
    /**
     * Identificador del fiador del residente
     */
    private String fiador;

    /**
     * Constructor vacío de la clase {@link Residente}. Inicializa el objeto sin
     * valores específicos.
     */
    public Residente() {
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del residente.
     *
     * @param matricula La matrícula del residente.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el nombre completo del residente.
     *
     * @return El nombre completo del residente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del residente.
     *
     * @param nombreCompleto El nombre completo del residente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el género del residente.
     *
     * @return El género del residente (un carácter).
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género del residente.
     *
     * @param genero El género del residente (un carácter).
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el semestre en el que se encuentra el residente.
     *
     * @return El semestre del residente.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre del residente.
     *
     * @param semestre El semestre del residente.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene la carrera del residente.
     *
     * @return La carrera del residente.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del residente.
     *
     * @param carrera La carrera del residente.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el correo electrónico del residente.
     *
     * @return El correo electrónico del residente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del residente.
     *
     * @param correo El correo electrónico del residente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono del residente.
     *
     * @return El número de teléfono del residente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del residente.
     *
     * @param telefono El número de teléfono del residente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del residente.
     *
     * @return La dirección del residente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del residente.
     *
     * @param direccion La dirección del residente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del contacto de emergencia del residente.
     *
     * @return El nombre del contacto de emergencia.
     */
    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    /**
     * Establece el nombre del contacto de emergencia del residente.
     *
     * @param nombreContactoEmergencia El nombre del contacto de emergencia.
     */
    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    /**
     * Obtiene el número de teléfono del contacto de emergencia del residente.
     *
     * @return El número de teléfono del contacto de emergencia.
     */
    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    /**
     * Establece el número de teléfono del contacto de emergencia del residente.
     *
     * @param telefonoContactoEmergencia El número de teléfono del contacto de
     * emergencia.
     */
    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    /**
     * Obtiene el tipo de residente.
     *
     * @return El tipo de residente (estudiante, personal, etc.).
     */
    public TipoResidente getTipoResidente() {
        return tipoResidente;
    }

    /**
     * Establece el tipo de residente.
     *
     * @param tipoResidente El tipo de residente.
     */
    public void setTipoResidente(TipoResidente tipoResidente) {
        this.tipoResidente = tipoResidente;
    }

    /**
     * Obtiene la habitación asignada al residente.
     *
     * @return El identificador de la habitación asignada al residente.
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * Establece la habitación asignada al residente.
     *
     * @param habitacion El identificador de la habitación asignada al
     * residente.
     */
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Devuelve una representación en forma de cadena de texto del residente.
     *
     * @return La representación en cadena del residente.
     */
    @Override
    public String toString() {
        return "Residente [matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", genero="
                + genero + ", semestre=" + semestre + ", carrera=" + carrera + ", correo=" + correo + ", telefono="
                + telefono + ", direccion=" + direccion + ", nombreContactoEmergencia=" + nombreContactoEmergencia
                + ", telefonoContactoEmergencia=" + telefonoContactoEmergencia + ", tipoResidente=" + tipoResidente
                + ", habitacion=" + habitacion + "]";
    }
}
