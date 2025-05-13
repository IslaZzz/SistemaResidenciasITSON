package DTO_Infraestructura;

/**
 * Clase DTO (Data Transfer Object) que representa los datos de un estudiante.
 */
public class EstudianteDTO {

    /**
     * Matrícula del estudiante
     */
    private String matricula;

    /**
     * Nombre completo del estudiante
     */
    private String nombreCompleto;

    /**
     * Género del estudiante (por ejemplo, 'M' o 'F')
     */
    private char genero;

    /**
     * Semestre actual que cursa el estudiante
     */
    private int semestre;

    /**
     * Carrera que cursa el estudiante
     */
    private String carrera;

    /**
     * Correo electrónico del estudiante
     */
    private String correo;

    /**
     * Teléfono del estudiante
     */
    private String telefono;

    /**
     * Dirección del estudiante
     */
    private String direccion;

    /**
     * Constructor que inicializa todos los atributos del estudiante.
     *
     * @param matricula Matrícula del estudiante.
     * @param nombreCompleto Nombre completo del estudiante.
     * @param genero Género del estudiante.
     * @param semestre Semestre actual del estudiante.
     * @param carrera Carrera que cursa el estudiante.
     * @param correo Correo electrónico del estudiante.
     * @param telefono Número telefónico del estudiante.
     * @param direccion Dirección del estudiante.
     */
    public EstudianteDTO(String matricula, String nombreCompleto, char genero, int semestre, String carrera, String correo, String telefono, String direccion) {
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
     * Obtiene la matrícula del estudiante.
     *
     * @return Matrícula del estudiante.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del estudiante.
     *
     * @param matricula Nueva matrícula a asignar.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el nombre completo del estudiante.
     *
     * @return Nombre completo del estudiante.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del estudiante.
     *
     * @param nombreCompleto Nuevo nombre a asignar.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el género del estudiante.
     *
     * @return Género del estudiante.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece el género del estudiante.
     *
     * @param genero Nuevo género a asignar.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el semestre actual del estudiante.
     *
     * @return Semestre del estudiante.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre del estudiante.
     *
     * @param semestre Nuevo semestre a asignar.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene la carrera que cursa el estudiante.
     *
     * @return Carrera del estudiante.
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera del estudiante.
     *
     * @param carrera Nueva carrera a asignar.
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Obtiene el correo electrónico del estudiante.
     *
     * @return Correo del estudiante.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del estudiante.
     *
     * @param correo Nuevo correo a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número telefónico del estudiante.
     *
     * @return Teléfono del estudiante.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número telefónico del estudiante.
     *
     * @param telefono Nuevo teléfono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del estudiante.
     *
     * @return Dirección del estudiante.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del estudiante.
     *
     * @param direccion Nueva dirección a asignar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
