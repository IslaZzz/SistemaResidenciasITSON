package DTO_Infraestructura;

public class AlumnoInfDTO {

    private String matricula;
    private String nombreCompleto;
    private char genero;
    private int semestre;
    private String carrera;
    private String correo;
    private String telefono;
    private String direccion;

    public AlumnoInfDTO() {
    }

    public AlumnoInfDTO(String matricula) {
        this.matricula = matricula;
    }
    
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
