package pojo;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Habitacion {
    
    @Id
    private String id;
    
    private int piso;
    private int numero;
    
    private List<Residente> residentesActuales;
    
    public Habitacion(){}
    
    public Habitacion(int piso, int numero){
        this.piso = piso;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
