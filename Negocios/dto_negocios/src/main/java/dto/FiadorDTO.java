/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * DTO (Data Transfer Object) que representa un fiador. Se utiliza para transefrir 
 * los datos del fiador relacionado con un residente.
 */
public class FiadorDTO {
 
    /**
     * Identificador único del fiador
     */
    private String id;
    
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
     private String numeroTelefono;
    /**
     * Relación del fiador con el residente 
     */
    private String relacionResidente;
   
    
    /**
     * Constructor por defecto
     */
    public FiadorDTO(){}

    public FiadorDTO(String nombreCompleto, String ocupacion, String direccion, String numeroTelefono, String relacionResidente) {
        this.nombreCompleto = nombreCompleto;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.relacionResidente = relacionResidente;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    

}
