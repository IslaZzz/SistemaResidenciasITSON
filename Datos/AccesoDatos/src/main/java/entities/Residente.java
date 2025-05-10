package entities;

import org.bson.codecs.pojo.annotations.BsonId;

import enums.TipoResidente;

public class Residente {
    
    @BsonId
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
    private TipoResidente tipoResidente;
    private String habitacion;
    
    public Residente(){}

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

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    public TipoResidente getTipoResidente() {
        return tipoResidente;
    }

    public void setTipoResidente(TipoResidente tipoResidente) {
        this.tipoResidente = tipoResidente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
    
    @Override
    public String toString() {
        return "Residente [matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", genero="
                + genero + ", semestre=" + semestre + ", carrera=" + carrera + ", correo=" + correo + ", telefono="
                + telefono + ", direccion=" + direccion + ", nombreContactoEmergencia=" + nombreContactoEmergencia
                + ", telefonoContactoEmergencia=" + telefonoContactoEmergencia + ", tipoResidente=" + tipoResidente
                + ", habitacion=" + habitacion + "]";
    }
}
