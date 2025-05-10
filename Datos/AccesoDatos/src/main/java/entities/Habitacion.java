package entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Habitacion {
    
    private ObjectId id;
    private int piso;
    private int numero;
    
    private List<String> residentesActuales;
    
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

    public List<String> getResidentesActuales() {
        return residentesActuales;
    }

    public void setResidentesActuales(List<String> residentesActuales) {
        this.residentesActuales = residentesActuales;
    }

    public void addResidente(String residenteId) {
        if(this.residentesActuales == null) {
            this.residentesActuales = new ArrayList<>();
        }
        this.residentesActuales.add(residenteId);
    }
    
}
