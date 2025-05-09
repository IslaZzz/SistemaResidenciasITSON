/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author rauln
 */
public class ReporteMantenimientoDTO {

    private String habitacion;
    private String residente;
    private String rangoVisitaUno;
    private String rangoVisitaDos;
    private String descripcion;
    private LocalDateTime fechaHoraReporte;

    public ReporteMantenimientoDTO() {
    }

    public ReporteMantenimientoDTO(String habitacion, String residente, String rangoVisitaUno, String rangoVisitaDos, String descripcion, LocalDateTime fechaHoraReporte) {
        this.habitacion = habitacion;
        this.residente = residente;
        this.rangoVisitaUno = rangoVisitaUno;
        this.rangoVisitaDos = rangoVisitaDos;
        this.descripcion = descripcion;
        this.fechaHoraReporte = fechaHoraReporte;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

    public String getRangoVisitaUno() {
        return rangoVisitaUno;
    }

    public void setRangoVisitaUno(String rangoVisitaUno) {
        this.rangoVisitaUno = rangoVisitaUno;
    }

    public String getRangoVisitaDos() {
        return rangoVisitaDos;
    }

    public void setRangoVisitaDos(String rangoVisitaDos) {
        this.rangoVisitaDos = rangoVisitaDos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    public void setFechaHoraReporte(LocalDateTime fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }

    @Override
    public String toString() {
        return String.format(
                "ReporteMantenimientoDTO {%n"
                + "  habitacion='%s',%n"
                + "  residente='%s',%n"
                + "  rangoVisitaUno='%s',%n"
                + "  rangoVisitaDos='%s',%n"
                + "  descripcion='%s',%n"
                + "  fechaHoraReporte='%s'%n"
                + "}",
                habitacion, residente, rangoVisitaUno, rangoVisitaDos, descripcion, fechaHoraReporte
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReporteMantenimientoDTO other = (ReporteMantenimientoDTO) obj;
        if (!Objects.equals(this.habitacion, other.habitacion)) {
            return false;
        }
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        if (!Objects.equals(this.rangoVisitaUno, other.rangoVisitaUno)) {
            return false;
        }
        if (!Objects.equals(this.rangoVisitaDos, other.rangoVisitaDos)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.fechaHoraReporte, other.fechaHoraReporte);
    }

}
