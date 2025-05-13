package DTO_Infraestructura;

/**
 * Clase DTO (Data Transfer Object) que representa los datos de un alumno dentro
 * del sistema de infraestructura. Esta clase se utiliza para transportar
 * información del alumno entre diferentes capas de la aplicación.
 */
public class AlumnoInfDTO {

    /**
     * Matrícula del alumno
     */
    private String matricula;

    /**
     * Nombre completo del alumno
     */
    private String nombreCompleto;

    /**
     * Género del alumno (por ejemplo, 'M' o 'F')
     */
    private char genero;

    /**
     * Semestre actual del alumno
     */
    private int semestre;

    /**
     * Carrera que cursa el alumno
     */
    private String carrera;

    /**
     * Correo electrónico del alumno
     */
    private String correo;

    /**
     * Número de teléfono del alumno
     */
    private String telefono;

    /**
     * Dirección física del alumno
     */
    private String direccion;

    /**
     * Constructor vacío. Útil para frameworks que requieren un constructor por
     * defecto.
     */
    public AlumnoInfDTO() {
    }

    /**
     * Constructor que inicializa el DTO solo con la matrícula.
     *
     * @param matricula La matrícula del alumno.
     */
    public AlumnoInfDTO(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Constructor completo que inicializa todos los campos del DTO.
     *
     * @param matricula Matrícula del alumno
     * @param nombreCompleto Nombre completo del alumno
     * @param genero Género del alumno (carácter)
     * @param semestre Semestre que cursa el alumno
     * @param carrera Carrera del alumno
     * @param correo Correo electrónico del alumno
     * @param telefono Número de teléfono del alumno
     * @param direccion Dirección física del alumno
     */
    public AlumnoInfDTO(String matricula, String nombreCompleto, char genero, int semestre, String carrera, String correo, String telefono, String direccion) {
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
     * Obtiene la matrícula del alumno.
     *
     * @return Matrícula del alumno.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del alumno.
     *
     * @param matricula Nueva matrícula a asignar.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el nombre completo del alumno.
     *
     * @return Nombre completo del alumno.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del alumno.
     *
     * @param nombreCompleto Nuevo nombre completo a asignar.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el género del alumno.
     *
     * @return Género del alumno.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género del alumno.
     *
     * @param genero Nuevo género a asignar.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el semestre que cursa el alumno.
     *
     * @return Semestre actual del alumno.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre que cursa el alumno.
     *
     * @param semestre Nuevo semestre a asignar.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene la carrera del alumno.
     *
     * @return Carrera del alumno.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del alumno.
     *
     * @param carrera Nueva carrera a asignar.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el correo electrónico del alumno.
     *
     * @return Correo del alumno.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del alumno.
     *
     * @param correo Nuevo correo a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número telefónico del alumno.
     *
     * @return Teléfono del alumno.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número telefónico del alumno.
     *
     * @param telefono Nuevo teléfono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del alumno.
     *
     * @return Dirección del alumno.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del alumno.
     *
     * @param direccion Nueva dirección a asignar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
