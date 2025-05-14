package entities;

import java.math.BigDecimal;
import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;

public class ReferenciaPago {

    @BsonId
    private String folio;

    private String referencia;
    private String concepto;
    private Date fechaGeneracion;
    private Date fechaVencimiento;
    private BigDecimal importe;
    
    //anidados
    private Residente residente;
    private Habitacion habitacion;
    private Fiador fiador;
    
    // ======= CONSTRUCTORES =======

    public ReferenciaPago() {
    }

    public ReferenciaPago(String folio, String referencia, String concepto, Date fechaGeneracion, Date fechaVencimiento, BigDecimal importe, Residente residente, Habitacion habitacion) {
        this.folio = folio;
        this.referencia = referencia;
        this.concepto = concepto;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaVencimiento = fechaVencimiento;
        this.importe = importe;
        this.residente = residente;
        this.habitacion = habitacion;
    }
    
    
    // ======= GETTERS Y SETTERS =======

    public String getFolio() {
        return folio;
    }

    public void setFolio(String Folio) {
        this.folio = Folio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String Referencia) {
        this.referencia = Referencia;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
}
