/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import org.bson.types.ObjectId;



/**
 *La clase representa al fiador del residente, responsable de llevar a cabo los pagos correspondientes
 * de la estancia del estudiante.
 */
 
public class Fiador {
    
    /**
     * Identificador único del fiador
     */
    private ObjectId id;
    
    /**
     * Nombre del fiador del residente
     */
    private String nombreCompleto;
    
    /**
     * Ocupación del fiador 
     */
    private String ocupacion;
    
    /**
     * Dirección del fiador (Puede ser distinta a la del residente)
     */
    private String direccion;
    
    /**
     * Número telefónico (móvil) del fiador 
     */
    private String telefono;
    
    /**
     * Relación del fiador con el residente 
     */
    private String relacionResidente;
    
    /**
     * Constructor por defecto
     */
    public Fiador(){}
    
    /**
     * Constructor de fiador
     * @param nombreCompleto
     * @param ocupacion
     * @param relacionResidente 
     */
    public Fiador(String nombreCompleto, String ocupacion, String relacionResidente) {
        this.nombreCompleto = nombreCompleto;
        this.ocupacion = ocupacion;
        this.relacionResidente = relacionResidente;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRelacionResidente() {
        return relacionResidente;
    }

    public void setRelacionResidente(String relacionResidente) {
        this.relacionResidente = relacionResidente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
