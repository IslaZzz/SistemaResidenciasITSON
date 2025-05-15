package implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import dto.ResidenteDTO;
import entities.Habitacion;
import entities.Residente;
import enums.TipoResidente;
import interfaz.IResidentesDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Implementación de la interfaz IResidentesDAO para gestionar la persistencia
 * de residentes en la base de datos MongoDB.
 */
public class ResidentesDAOImp implements IResidentesDAO {

    /**
     * Registra un nuevo residente en la base de datos.
     *
     * @param residenteDTO El DTO que contiene los datos del residente a
     * registrar.
     * @return El objeto Residente que ha sido registrado.
     */
    @Override
    public Residente registrarResidente(ResidenteDTO residenteDTO) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Residente residente = parsearResidenteDTO(residenteDTO);
        residentes.insertOne(residente);
        return residente;
    }

    /**
     * Obtiene un residente de la base de datos utilizando su matrícula.
     *
     * @param matricula La matrícula del residente a buscar.
     * @return Un objeto ResidenteDTO con los datos del residente encontrado, o
     * null si no se encuentra.
     */
    @Override
    public ResidenteDTO obtenerResidente(String matricula) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Residente residente = residentes.find(eq("_id", matricula)).first();
        if (residente != null) {
            return parsearResidente(residente);
        }
        return null;
    }

    /**
     * Obtiene la colección de residentes desde la base de datos.
     *
     * @return La colección de residentes.
     */
    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }

    /**
     * Convierte un objeto ResidenteDTO en un objeto Residente para ser
     * almacenado en la base de datos.
     *
     * @param dto El DTO que contiene la información del residente.
     * @return Un objeto Residente con los datos de dto.
     */
    private Residente parsearResidenteDTO(ResidenteDTO dto) {
        Residente residente = new Residente();
        residente.setMatricula(dto.getMatricula());
        residente.setNombreCompleto(dto.getNombreCompleto());
        residente.setGenero(dto.getGenero());
        residente.setSemestre(dto.getSemestre());
        residente.setCarrera(dto.getCarrera());
        residente.setCorreo(dto.getCorreo());
        residente.setTelefono(dto.getTelefono());
        residente.setDireccion(dto.getDireccion());
        residente.setNombreContactoEmergencia(dto.getNombreContactoEmergencia());
        residente.setTelefonoContactoEmergencia(dto.getTelefonoContactoEmergencia());
        if (dto.getTipoResidente() != null) {
            residente.setTipoResidente(parsearTipoResidente(dto.getTipoResidente()));
        }
        return residente;
    }

    /**
     * Convierte un objeto Residente en un objeto ResidenteDTO para ser
     * utilizado en la capa de negocio.
     *
     * @param residente El objeto Residente a convertir.
     * @return Un objeto ResidenteDTO con los datos del residente.
     */
    private ResidenteDTO parsearResidente(Residente residente) {
        ResidenteDTO residenteDTO = new ResidenteDTO(
                residente.getMatricula(),
                residente.getNombreCompleto(),
                residente.getGenero(),
                residente.getSemestre(),
                residente.getCarrera(),
                residente.getCorreo(),
                residente.getTelefono(),
                residente.getDireccion(),
                residente.getNombreContactoEmergencia(),
                residente.getTelefonoContactoEmergencia()
        );
        if (residente.getTipoResidente() != null) {
            residenteDTO.setTipoResidente(residente.getTipoResidente().toString());
        }
        if (residente.getHabitacion() != null) {
            residenteDTO.setIdHabitacion(residente.getHabitacion());
        }
        return residenteDTO;
    }

    /**
     * Convierte una cadena que representa el tipo de residente en un valor del
     * enum TipoResidente.
     *
     * @param tipo La cadena que representa el tipo de residente.
     * @return Un valor de TipoResidente que corresponde al tipo proporcionado.
     * @throws IllegalArgumentException Si el tipo no es válido.
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

}
