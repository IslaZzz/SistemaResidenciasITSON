package entities;

import java.util.List;

import org.bson.types.ObjectId;

public class Habitacion {
    
    private ObjectId id;
    
    private int piso;
    private int numero;
    
    private List<Residente> residentesActuales;
    
    public Habitacion(){}
    
    public Habitacion(int piso, int numero){
        this.piso = piso;
        this.numero = numero;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Residente> getResidentesActuales() {
        return residentesActuales;
    }

    public void setResidentesActuales(List<Residente> residentesActuales) {
        this.residentesActuales = residentesActuales;
    }
    
}
