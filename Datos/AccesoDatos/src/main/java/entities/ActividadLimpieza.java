package entities;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Clase que representa una actividad de limpieza realizada en una zona específica
 * por un miembro del personal en un intervalo de tiempo determinado.
 */
public class ActividadLimpieza {

    /**
     * Identificador único de la actividad de limpieza.
     */
    @BsonId
    private ObjectId id;

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
    public ActividadLimpieza() {
    }

    /**
     * Constructor para inicializar una instancia de ActividadLimpiezaDTO con datos específicos.
     *
     * @param idZona Identificador de la zona donde se realiza la actividad.
     * @param idPersonal Identificador del personal encargado de la actividad.
     * @param fechaInicio Fecha y hora de inicio de la actividad.
     * @param fechaFin Fecha y hora de finalización de la actividad.
     */
    public ActividadLimpieza(String idZona, String idPersonal, Date fechaInicio, Date fechaFin) {
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
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la actividad de limpieza.
     * @param id El identificador de la actividad.
     */
    public void setId(ObjectId id) {
        this.id = id;
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
     * Establece el identificador de la zona donde se realiza la actividad.
     *
     * @param idZona El identificador de la zona.
     */
    public void setIdZona(String idZona) {
        this.idZona = idZona;
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
     * Establece el identificador del personal encargado de la actividad.
     * @param idPersonal El identificador del personal.
     */
    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
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
     * Establece la fecha y hora de inicio de la actividad de limpieza.
     *
     * @param fechaInicio La fecha y hora de inicio.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha y hora de finalización de la actividad de limpieza.
     *
     * @return La fecha y hora de finalización.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha y hora de finalización de la actividad de limpieza.
     *
     * @param fechaFin La fecha y hora de finalización.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}