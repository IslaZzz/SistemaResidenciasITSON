package dto;

import java.util.Date;

/**
 * Clase que representa una actividad de limpieza realizada en una zona específica
 * por un miembro del personal en un intervalo de tiempo determinado.
 */
public class ActividadLimpiezaDTO {

    /**
     * Identificador único de la actividad de limpieza.
     */
    private String idActividad;

    /**
     * Identificador de la zona donde se realiza la actividad de limpieza.
     */
    private String idZona;

    /**
     * Identificador del personal encargado de la actividad de limpieza.
     */
    private String idPersonal;

    /**
     * Fecha y hora de inicio de la actividad de limpieza.
     */
    private Date fechaInicio;

    /**
     * Fecha y hora de finalización de la actividad de limpieza.
     */
    private Date fechaFin;

    /**
     * Constructor vacío para inicializar una instancia de ActividadLimpiezaDTO sin datos.
     */
    public ActividadLimpiezaDTO() {
    }

    /**
     * Constructor para inicializar una instancia de ActividadLimpiezaDTO con datos específicos.
     *
     * @param idActividad Identificador único de la actividad de limpieza.
     * @param idZona Identificador de la zona donde se realiza la actividad.
     * @param idPersonal Identificador del personal encargado de la actividad.
     * @param fechaInicio Fecha y hora de inicio de la actividad.
     * @param fechaFin Fecha y hora de finalización de la actividad.
     */
    public ActividadLimpiezaDTO(String idActividad, String idZona, String idPersonal, Date fechaInicio, Date fechaFin) {
        this.idActividad = idActividad;
        this.idZona = idZona;
        this.idPersonal = idPersonal;
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
    public String getIdZona() {
        return idZona;
    }

    /**
     * Obtiene el identificador del personal encargado de la actividad.
     *
     * @return El identificador del personal.
     */
    public String getIdPersonal() {
        return idPersonal;
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