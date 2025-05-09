package entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Habitacion {
    
    private ObjectId id;
    private int piso;
    private int numero;
    
    private List<ObjectId> residentesActuales;
    
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

    public List<ObjectId> getResidentesActuales() {
        return residentesActuales;
    }

    public void setResidentesActuales(List<ObjectId> residentesActuales) {
        this.residentesActuales = residentesActuales;
    }

    public void addResidente(ObjectId residenteId) {
        if(this.residentesActuales == null) {
            this.residentesActuales = new ArrayList<>();
        }
        this.residentesActuales.add(residenteId);
    }
    
}
