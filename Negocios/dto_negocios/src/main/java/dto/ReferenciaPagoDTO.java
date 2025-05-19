package dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReferenciaPagoDTO {

    private String folio;
    private String referencia;
    private String concepto;
    private Date fechaGeneracion;
    private Date fechaVencimiento;
    private BigDecimal importe;
    private String matriculaResidente;
    private String nombreResidente;
    private String correoResidente;
    private String carreraResidente;
    private String tipoResidente;
    private int semestreResidente;
    private int habitacion;
    private int piso;

    public ReferenciaPagoDTO() {
    }

    public ReferenciaPagoDTO(String folio, String referencia, String concepto, Date fechaGeneracion, Date fechaVencimiento, BigDecimal importe, String matriculaResidente, String nombreResidente, String correoResidente, String carreraResidente, String tipoResidente, int habitacion) {
        this.folio = folio;
        this.referencia = referencia;
        this.concepto = concepto;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaVencimiento = fechaVencimiento;
        this.importe = importe;
        this.matriculaResidente = matriculaResidente;
        this.nombreResidente = nombreResidente;
        this.correoResidente = correoResidente;
        this.carreraResidente = carreraResidente;
        this.tipoResidente = tipoResidente;
        this.habitacion = habitacion;
    }

    

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public String getMatriculaResidente() {
        return matriculaResidente;
    }

    public void setMatriculaResidente(String matriculaResidente) {
        this.matriculaResidente = matriculaResidente;
    }

    public String getNombreResidente() {
        return nombreResidente;
    }

    public void setNombreResidente(String nombreResidente) {
        this.nombreResidente = nombreResidente;
    }

    public String getCorreoResidente() {
        return correoResidente;
    }

    public void setCorreoResidente(String correoResidente) {
        this.correoResidente = correoResidente;
    }

    public String getCarreraResidente() {
        return carreraResidente;
    }

    public void setCarreraResidente(String carreraResidente) {
        this.carreraResidente = carreraResidente;
    }

    public String getTipoResidente() {
        return tipoResidente;
    }

    public void setTipoResidente(String tipoResidente) {
        this.tipoResidente = tipoResidente;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getSemestreResidente() {
        return semestreResidente;
    }

    public void setSemestreResidente(int semestreResidente) {
        this.semestreResidente = semestreResidente;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    
    
    

}
