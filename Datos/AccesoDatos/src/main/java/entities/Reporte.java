package entities;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Representa un reporte de mantenimiento generado por un residente. Contiene
 * información como la ubicación, el residente, la descripción del problema y el
 * horario preferido para la visita de mantenimiento.
 */
public class Reporte {

    /**
     * Identificador único del reporte en la base de datos.
     */
    @BsonId
    private ObjectId id;
    /**
     * Habitacion a la que corresponde el reporte.
     */
    private Habitacion habitacion;

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
     * Estado actual del reporte (por ejemplo, "Pendiente", "En proceso",
     * "Resuelto").
     */
    private String estadoReporte;

    /**
     * Constructor por defecto. Requerido para la deserialización.
     */
    public Reporte() {
    }

    /**
     * Crea un nuevo reporte de mantenimiento con los datos especificados.
     *
     * @param piso Piso donde se encuentra la habitación.
     * @param habitacion Identificador de la habitación.
     * @param residente Nombre del residente que generó el reporte.
     * @param horarioVisita Horario preferido para la visita del personal de
     * mantenimiento.
     * @param descripcionProblema Descripción del problema reportado.
     * @param fechaHoraReporte Fecha y hora en que se generó el reporte.
     * @param estadoReporte Estado actual del reporte.
     */
    public Reporte(String piso, Habitacion habitacion, String residente, String horarioVisita, String descripcionProblema, Date fechaHoraReporte, String estadoReporte) {
        this.habitacion = habitacion;
        this.residente = residente;
        this.horarioVisita = horarioVisita;
        this.descripcionProblema = descripcionProblema;
        this.fechaHoraReporte = fechaHoraReporte;
        this.estadoReporte = estadoReporte;
    }

    /**
     * Obtiene el identificador único del reporte.
     *
     * @return el ID del reporte.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del reporte.
     *
     * @param id el ID a establecer.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }



    /**
     * Obtiene el identificador de la habitación.
     *
     * @return el número de la habitación.
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    /**
     * Establece el identificador de la habitación.
     *
     * @param habitacion el número de la habitación.
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Obtiene el nombre del residente que generó el reporte.
     *
     * @return el nombre del residente.
     */
    public String getResidente() {
        return residente;
    }

    /**
     * Establece el nombre del residente que generó el reporte.
     *
     * @param residente el nombre del residente.
     */
    public void setResidente(String residente) {
        this.residente = residente;
    }

    /**
     * Obtiene el horario preferido para la visita de mantenimiento.
     *
     * @return el horario preferido.
     */
    public String getHorarioVisita() {
        return horarioVisita;
    }

    /**
     * Establece el horario preferido para la visita de mantenimiento.
     *
     * @param horarioVisita el horario deseado por el residente.
     */
    public void setHorarioVisita(String horarioVisita) {
        this.horarioVisita = horarioVisita;
    }

    /**
     * Obtiene la descripción del problema reportado.
     *
     * @return la descripción del problema.
     */
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    /**
     * Establece la descripción del problema reportado.
     *
     * @param descripcionProblema la descripción del inconveniente.
     */
    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    /**
     * Obtiene la fecha y hora en que se generó el reporte.
     *
     * @return la fecha y hora del reporte.
     */
    public Date getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    /**
     * Establece la fecha y hora en que se generó el reporte.
     *
     * @param fechaHoraReporte la fecha y hora a establecer.
     */
    public void setFechaHoraReporte(Date fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }

    /**
     * Obtiene el estado actual del reporte.
     *
     * @return el estado del reporte.
     */
    public String getEstadoReporte() {
        return estadoReporte;
    }

    /**
     * Establece el estado actual del reporte.
     *
     * @param estadoReporte el nuevo estado del reporte.
     */
    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Reporte.
     *
     * @return una cadena que representa el contenido del reporte.
     */
    @Override
    public String toString() {
        return "Reporte{"
                + "id=" + id
                + ", habitacion='" + habitacion + '\''
                + ", residente='" + residente + '\''
                + ", horarioVisita='" + horarioVisita + '\''
                + ", descripcionProblema='" + descripcionProblema + '\''
                + ", fechaHoraReporte=" + fechaHoraReporte
                + ", estadoReporte=" + estadoReporte
                + '}';
    }
}
