/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Infraestructura;

/**
 *
 * @author abrilislas
 */
public class ContratoInfoDTO {
    
    //datos del residente
    private String idResidente;
    private String carrera;
    private String semestreActual;
    private String nombreResidente;
    private String habitacionResidente;
    private String direccionResidente;
    private String ubicacionEdificio;
    
    //datos del fiador (pensar que onda con el periodo de alojamiento)
    private String nombreFiador;
    private String direccionFiador;
    private String adeudo;
    private String fecha;
    private String piso;
    
    /**
     * Default constructor 
     */
    public ContratoInfoDTO(){}
    
    /**
     * 
     * @param idResidente identificador del residente 
     * @param carrera programa educativo del residente
     * @param semestreActual semestre a cursar
     * @param nombreResidente nombre completo del residente
     * @param habitacionResidente habitacion para contrato
     * @param direccionResidente direccion del residente
     * @param ubicacionHabitacion ubicacion de la habitacion
     * @param nombreFiador nombre del fiador relacionado al residente
     * @param direccionFiador direccion del fiador
     * @param adeudo adeudo del residente
     * @param piso del residente
     */
    public ContratoInfoDTO(String idResidente, String carrera, String semestreActual, String nombreResidente, String habitacionResidente, String direccionResidente, String ubicacionHabitacion, String nombreFiador, String direccionFiador, String adeudo, String piso) {
        this.idResidente = idResidente;
        this.carrera = carrera;
        this.semestreActual = semestreActual;
        this.nombreResidente = nombreResidente;
        this.habitacionResidente = habitacionResidente;
        this.direccionResidente = direccionResidente;
        this.ubicacionEdificio = ubicacionHabitacion;
        this.nombreFiador = nombreFiador;
        this.direccionFiador = direccionFiador;
        this.adeudo = adeudo;
        this.piso=piso;
    }
    
    //getters y setters 
    
    public String getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(String idResidente) {
        this.idResidente = idResidente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(String semestreActual) {
        this.semestreActual = semestreActual;
    }

    public String getNombreResidente() {
        return nombreResidente;
    }

    public void setNombreResidente(String nombreResidente) {
        this.nombreResidente = nombreResidente;
    }

    public String getHabitacionResidente() {
        return habitacionResidente;
    }

    public void setHabitacionResidente(String habitacionResidente) {
        this.habitacionResidente = habitacionResidente;
    }

    public String getDireccionResidente() {
        return direccionResidente;
    }

    public void setDireccionResidente(String direccionResidente) {
        this.direccionResidente = direccionResidente;
    }

    public String getubicacionEdificio() {
        return ubicacionEdificio;
    }

    public void setubicacionEdificio(String ubicacionEdificio) {
        this.ubicacionEdificio = ubicacionEdificio;
    }

    public String getNombreFiador() {
        return nombreFiador;
    }

    public void setNombreFiador(String nombreFiador) {
        this.nombreFiador = nombreFiador;
    }

    public String getDireccionFiador() {
        return direccionFiador;
    }

    public void setDireccionFiador(String direccionFiador) {
        this.direccionFiador = direccionFiador;
    }

    public String getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(String adeudo) {
        this.adeudo = adeudo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
}
