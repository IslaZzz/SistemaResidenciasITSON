package dto;

import java.util.Date;

/**
 * Clase de transferencia de datos (DTO) que representa un reporte de
 * mantenimiento generado por un residente. Esta clase se utiliza para
 * transportar los datos entre las distintas capas del sistema, como la vista,
 * controlador y capa de persistencia.
 *
 * Contiene información del piso, habitación, residente, horario de visita,
 * descripción del problema y la fecha de creación del reporte.
 *
 * @author rauln
 */
public class ReporteDTO {

    /**
     * Identificador único del reporte.
     */
    private String id;

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
     * Estado del reporte.
     */
    private String estadoReporte;

    /**
     * Constructor por defecto.
     */
    public ReporteDTO() {
    }

    /**
     * Constructor que inicializa todos los campos del reporte, incluyendo el
     * identificador.
     *
     * @param id Identificador único del reporte.
     * @param piso Piso donde se encuentra la habitación.
     * @param habitacion Número o identificador de la habitación.
     * @param residente Nombre del residente que generó el reporte.
     * @param horarioVisita Horario preferido para la visita.
     * @param descripcionProblema Descripción del problema reportado.
     * @param fechaHoraReporte Fecha y hora en que se generó el reporte.
     * @param estadoReporte Estado del reporte.
     */
    public ReporteDTO(String id, String piso, String habitacion, String residente, String horarioVisita, String descripcionProblema, Date fechaHoraReporte, String estadoReporte) {
        this.id = id;
        this.piso = piso;
        this.habitacion = habitacion;
        this.residente = residente;
        this.horarioVisita = horarioVisita;
        this.descripcionProblema = descripcionProblema;
        this.fechaHoraReporte = fechaHoraReporte;
        this.estadoReporte = estadoReporte;
    }

    /**
     * Constructor que inicializa todos los campos del reporte, incluyendo el
     * identificador.
     *
     * @param piso Piso donde se encuentra la habitación.
     * @param habitacion Número o identificador de la habitación.
     * @param residente Nombre del residente que generó el reporte.
     * @param horarioVisita Horario preferido para la visita.
     * @param descripcionProblema Descripción del problema reportado.
     * @param fechaHoraReporte Fecha y hora en que se generó el reporte.
     */
    public ReporteDTO(String piso, String habitacion, String residente, String horarioVisita, String descripcionProblema, Date fechaHoraReporte) {
        this.piso = piso;
        this.habitacion = habitacion;
        this.residente = residente;
        this.horarioVisita = horarioVisita;
        this.descripcionProblema = descripcionProblema;
        this.fechaHoraReporte = fechaHoraReporte;
    }

    /**
     * Obtiene el identificador único del reporte.
     *
     * @return Identificador del reporte.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del reporte.
     *
     * @param id Identificador del reporte.
     */
    public void setId(String id) {
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

    /**
     * Obtiene el estado del reporte.
     *
     * @return Estado del reporte.
     */
    public String getEstadoReporte() {
        return estadoReporte;
    }

    /**
     * Establece el estado del reporte.
     *
     * @param estadoReporte
     */
    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

}
