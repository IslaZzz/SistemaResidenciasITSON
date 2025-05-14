package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dto.ReferenciaPagoDTO;
import entities.Habitacion;
import entities.ReferenciaPago;
import entities.Residente;
import enums.TipoResidente;
import interfaz.IReferenciasPagoDAO;
import java.util.Date;
import org.bson.conversions.Bson;

public class ReferenciasPagoDAOImp implements IReferenciasPagoDAO {

    /**
     * Registra una nueva referencia de pago en la base de datos MongoDB.
     *
     * @param referencia DTO con los datos de la referencia a registrar
     * @return Entidad ReferenciaPago persistida con su identificador generado
     */
    @Override
    public ReferenciaPago registrarReferenciaPago(ReferenciaPagoDTO referencia) {
        MongoCollection<ReferenciaPago> referencias = obtenerColeccionReferenciasPago();
        ReferenciaPago referenciaPago = parsearReferenciaDTO(referencia);
        referencias.insertOne(referenciaPago);
        return referenciaPago;
    }

    /**
     * Convierte un DTO de referencia de pago a su entidad equivalente para
     * persistencia.
     *
     * @param dto Objeto ReferenciaPagoDTO a convertir
     * @return Entidad ReferenciaPago lista para persistir
     */
    private ReferenciaPago parsearReferenciaDTO(ReferenciaPagoDTO dto) {
        ReferenciaPago referencia = new ReferenciaPago();
        referencia.setFolio(dto.getFolio());
        referencia.setReferencia(dto.getReferencia());
        referencia.setConcepto(dto.getConcepto());
        referencia.setFechaGeneracion(dto.getFechaGeneracion());
        referencia.setFechaVencimiento(dto.getFechaVencimiento());
        referencia.setImporte(dto.getImporte());
        referencia.setResidente(parsearResidenteDTO(dto));
        referencia.setHabitacion(parsearHabitacionDTO(dto));
        return referencia;
    }

    /**
     * Obtiene la colección MongoDB para las referencias de pago.
     *
     * @return MongoCollection<ReferenciaPago> configurada para la entidad
     */
    private MongoCollection<ReferenciaPago> obtenerColeccionReferenciasPago() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("referenciasPago", ReferenciaPago.class);
    }

    /**
     * Convierte los datos del residente del DTO a entidad persistente.
     *
     * @param dto Objeto ReferenciaPagoDTO que contiene los datos del residente
     * @return Entidad Residente para persistencia
     */
    private Residente parsearResidenteDTO(ReferenciaPagoDTO dto) {
        Residente residente = new Residente();
        residente.setMatricula(dto.getMatriculaResidente());
        residente.setNombreCompleto(dto.getNombreResidente());
        residente.setCarrera(dto.getCarreraResidente());
        residente.setCorreo(dto.getCorreoResidente());
        residente.setTipoResidente(parsearTipoResidente(dto.getTipoResidente()));
        residente.setSemestre(dto.getSemestreResidente());

        return residente;
    }

    /**
     * Convierte los datos de habitación del DTO a entidad persistente.
     *
     * @param dto Objeto ReferenciaPagoDTO que contiene los datos de habitación
     * @return Entidad Habitacion para persistencia
     */
    private Habitacion parsearHabitacionDTO(ReferenciaPagoDTO dto) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(dto.getHabitacion());
        habitacion.setPiso(dto.getPiso());
        return habitacion;
    }

    /**
     * Convierte el tipo de residente de String a enum.
     *
     * @param tipo Cadena que representa el tipo de residente
     * @return Valor del enum TipoResidente correspondiente
     * @throws IllegalArgumentException Si el tipo no es válido
     */
    private TipoResidente parsearTipoResidente(String tipo) {
        switch (tipo) {
            case "NUEVO_INGRESO":
                return TipoResidente.NUEVO_INGRESO;
            case "DEPORTISTA":
                return TipoResidente.DEPORTISTA;
            case "EXTRANJERO":
                return TipoResidente.EXTRANJERO;
            default:
                throw new IllegalArgumentException("Tipo de residente no válido: " + tipo);
        }
    }

    /**
     * Verifica si existe una referencia de pago activa para el residente.
     *
     * @param referencia DTO con los datos de la referencia a verificar
     * @return true si existe una referencia no vencida para el residente, false
     * en caso contrario
     */
    @Override
    public boolean existeReferenciaActiva(ReferenciaPagoDTO referencia) {
        MongoCollection<ReferenciaPago> referencias = obtenerColeccionReferenciasPago();

        // Filtro: residente con la matrícula dada y referencia no vencida
        Bson filtro = Filters.and(
                Filters.eq("residente._id", referencia.getMatriculaResidente()),
                Filters.gt("fechaVencimiento", new Date())
        );

        // Buscar si existe al menos una coincidencia
        ReferenciaPago referenciaActiva = referencias.find(filtro).first();

        return referenciaActiva != null;
    }

}
