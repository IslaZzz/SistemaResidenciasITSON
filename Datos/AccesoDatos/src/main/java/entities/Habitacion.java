package entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

/**
 * Clase que representa una habitación en un sistema de gestión de residencias o
 * alojamiento. Contiene información sobre el piso, número de la habitación, y
 * los residentes actuales.
 */
public class Habitacion {

    /**
     * Identificador único de la habitación.
     */
    private ObjectId id;

    /**
     * Número de piso en el que se encuentra la habitación.
     */
    private int piso;

    /**
     * Número de la habitación.
     */
    private int numero;

    /**
     * Lista de identificadores de los residentes actuales de la habitación.
     */
    private List<String> residentesActuales;

    /**
     * Constructor vacío de la clase {@link Habitacion}. Inicializa la
     * habitación sin valores específicos.
     */
    public Habitacion() {
    }

    /**
     * Constructor de la clase {@link Habitacion} que inicializa el piso y el
     * número de habitación.
     *
     * @param piso El número de piso de la habitación.
     * @param numero El número de la habitación.
     */
    public Habitacion(int piso, int numero) {
        this.piso = piso;
        this.numero = numero;
    }

    /**
     * Obtiene el identificador único de la habitación.
     *
     * @return El identificador de la habitación.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la habitación.
     *
     * @param id El identificador de la habitación.
     */
    public void setId(final ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el número de piso de la habitación.
     *
     * @return El número de piso.
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece el número de piso de la habitación.
     *
     * @param piso El número de piso.
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Obtiene el número de la habitación.
     *
     * @return El número de la habitación.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     *
     * @param numero El número de la habitación.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la lista de los residentes actuales de la habitación.
     *
     * @return Una lista con los identificadores de los residentes actuales.
     */
    public List<String> getResidentesActuales() {
        return residentesActuales;
    }

    /**
     * Establece la lista de los residentes actuales de la habitación.
     *
     * @param residentesActuales La lista de identificadores de los residentes.
     */
    public void setResidentesActuales(List<String> residentesActuales) {
        this.residentesActuales = residentesActuales;
    }

    /**
     * Añade un residente a la habitación. Si la lista de residentes no ha sido
     * inicializada, se crea una nueva lista.
     *
     * @param residenteId El identificador del residente a añadir.
     */
    public void addResidente(String residenteId) {
        if (this.residentesActuales == null) {
            this.residentesActuales = new ArrayList<>();
        }
        this.residentesActuales.add(residenteId);
    }

}
