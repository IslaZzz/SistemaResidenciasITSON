package dto;

import java.util.Date;

/**
 * Clase que representa una actividad de limpieza realizada en una zona
 * específica por un miembro del personal en un intervalo de tiempo determinado.
 */
public class ActividadLimpiezaDTO {

    /**
     * Identificador único de la actividad de limpieza.
     */
    private String idActividad;

    /**
     * zona donde se realiza la actividad de limpieza.
     */
    private ZonaDTO zona;

    /**
     * personal encargado de la actividad de limpieza.
     */
    private PersonalDTO personal;

    /**
     * Fecha y hora de inicio de la actividad de limpieza.
     */
    private Date fechaInicio;

    /**
     * Fecha y hora de finalización de la actividad de limpieza.
     */
    private Date fechaFin;

    /**
     * Constructor vacío para inicializar una instancia de ActividadLimpiezaDTO
     * sin datos.
     */
    public ActividadLimpiezaDTO() {
    }

    /**
     * Constructor para inicializar una instancia de ActividadLimpiezaDTO con
     * datos específicos.
     *
     * @param idActividad Identificador único de la actividad de limpieza.
     * @param zona Identificador de la zona donde se realiza la actividad.
     * @param personal Identificador del personal encargado de la actividad.
     * @param fechaInicio Fecha y hora de inicio de la actividad.
     * @param fechaFin Fecha y hora de finalización de la actividad.
     */
    public ActividadLimpiezaDTO(String idActividad, ZonaDTO zona, PersonalDTO personal, Date fechaInicio, Date fechaFin) {
        this.idActividad = idActividad;
        this.zona = zona;
        this.personal = personal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Crea una nueva instancia de {@code ActividadLimpiezaDTO} con la zona y el
     * personal especificados.
     *
     * @param zona zona donde se realiza la actividad de limpieza.
     * @param personal personal encargado de la actividad.
     * @param fechaInicio Fecha y hora de inicio de la actividad.
     * @param fechaFin Fecha y hora de finalización de la actividad.
     */
    public ActividadLimpiezaDTO(ZonaDTO zona, PersonalDTO personal, Date fechaInicio, Date fechaFin) {
        this.zona = zona;
        this.personal = personal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Crea una nueva instancia de {@code ActividadLimpiezaDTO} con el
     * identificador de la actividad especificado.
     * @param idActividad el identificador único de la actividad de limpieza.
     */
    public ActividadLimpiezaDTO(String idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * Crea una nueva instancia de {@code ActividadLimpiezaDTO} con las fechas
     * de inicio y fin especificadas.
     *
     * @param fechaInicio la fecha en que comienza la actividad de limpieza.
     * @param fechaFin la fecha en que finaliza la actividad de limpieza.
     */
    public ActividadLimpiezaDTO(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el identificador único de la actividad de limpieza.
     *
     * @return El identificador de la actividad.
     */
    public String getIdActividad() {
        return idActividad;
    }

    /**
     * Obtiene el identificador de la zona donde se realiza la actividad.
     *
     * @return El identificador de la zona.
     */
    public ZonaDTO getZona() {
        return zona;
    }

    /**
     * Obtiene el identificador del personal encargado de la actividad.
     *
     * @return El identificador del personal.
     */
    public PersonalDTO getPersonal() {
        return personal;
    }

    /**
     * Obtiene la fecha y hora de inicio de la actividad de limpieza.
     *
     * @return La fecha y hora de inicio.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene la fecha y hora de finalización de la actividad de limpieza.
     *
     * @return La fecha y hora de finalización.
     */
    public Date getFechaFin() {
        return fechaFin;
    }
}
