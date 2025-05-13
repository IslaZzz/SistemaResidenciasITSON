package entities;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Representa un reporte de mantenimiento generado por un residente.
 * Contiene información como la ubicación, el residente, la descripción del problema
 * y el horario preferido para la visita de mantenimiento.
 */
public class Reporte {

    /**
     * Identificador único del reporte en la base de datos.
     */
    @BsonId
    private ObjectId id;

    /**
     * Piso donde se encuentra la habitación reportada.
     */
    private String piso;

    /**
     * Número o identificador de la habitación.
     */
    private String habitacion;

    /**
     * Nombre del residente que generó el reporte.
     */
    private String residente;

    /**
     * Horario preferido en el que el residente desea que se realice la visita.
     */
    private String horarioVisita;

    /**
     * Descripción del problema o inconveniente reportado.
     */
    private String descripcionProblema;

    /**
     * Fecha y hora en que se generó el reporte.
     */
    private Date fechaHoraReporte;

    /**
     * Constructor por defecto.
     */
    public Reporte() {
    }

    /**
     * Obtiene el identificador del reporte.
     *
     * @return El {@link ObjectId} del reporte.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del reporte.
     *
     * @param id El {@link ObjectId} que se asignará.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el piso donde se encuentra la habitación.
     *
     * @return El piso como cadena de texto.
     */
    public String getPiso() {
        return piso;
    }

    /**
     * Establece el piso donde se encuentra la habitación.
     *
     * @param piso El valor del piso.
     */
    public void setPiso(String piso) {
        this.piso = piso;
    }

    /**
     * Obtiene el número o identificador de la habitación.
     *
     * @return La habitación como cadena.
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * Establece el número o identificador de la habitación.
     *
     * @param habitacion El valor de la habitación.
     */
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Obtiene el nombre del residente que generó el reporte.
     *
     * @return El nombre del residente.
     */
    public String getResidente() {
        return residente;
    }

    /**
     * Establece el nombre del residente que generó el reporte.
     *
     * @param residente El nombre del residente.
     */
    public void setResidente(String residente) {
        this.residente = residente;
    }

    /**
     * Obtiene el horario preferido de visita del residente.
     *
     * @return El horario de visita.
     */
    public String getHorarioVisita() {
        return horarioVisita;
    }

    /**
     * Establece el horario preferido de visita del residente.
     *
     * @param horarioVisita El horario deseado.
     */
    public void setHorarioVisita(String horarioVisita) {
        this.horarioVisita = horarioVisita;
    }

    /**
     * Obtiene la descripción del problema reportado.
     *
     * @return La descripción del problema.
     */
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    /**
     * Establece la descripción del problema reportado.
     *
     * @param descripcionProblema La descripción del problema.
     */
    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    /**
     * Obtiene la fecha y hora en que se generó el reporte.
     *
     * @return La fecha y hora del reporte.
     */
    public Date getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    /**
     * Establece la fecha y hora en que se generó el reporte.
     *
     * @param fechaHoraReporte La fecha y hora del reporte.
     */
    public void setFechaHoraReporte(Date fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }
}
