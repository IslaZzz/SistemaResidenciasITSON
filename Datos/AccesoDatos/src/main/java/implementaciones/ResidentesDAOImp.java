package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;

import dto.ResidenteDTO;
import entities.Residente;
import enums.TipoResidente;
import interfaz.IResidentesDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        residente.setAdeudo(dto.getAdeudo());
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
        residenteDTO.setAdeudo(residente.getAdeudo());
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

    /**
     * Actualiza la información de un residente existente en la base de datos.
     *
     * @param residenteDTO El DTO con los datos actualizados del residente.
     */
    @Override
    public void actualizarResidente(ResidenteDTO residenteDTO) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        residentes.updateOne(
                eq("_id", residenteDTO.getMatricula()),
                Updates.combine(
                        Updates.set("nombreContactoEmergencia", residenteDTO.getNombreContactoEmergencia()),
                        Updates.set("telefonoContactoEmergencia", residenteDTO.getTelefonoContactoEmergencia()),
                        Updates.set("tipoResidente", parsearTipoResidente(residenteDTO.getTipoResidente()))
                ),
                new UpdateOptions().upsert(false)
        ).getModifiedCount();
    }

    /**
     * Registra de manera masiva un total de 20 residentes, distribuidos en 10
     * habitaciones, con 2 residentes por habitación.
     *
     * Cada residente tiene datos simulados (matrícula, carrera, correo, etc.)
     * generados dinámicamente con base en el número de habitación. Este método
     * está diseñado para facilitar pruebas o carga inicial de datos en el
     * sistema.
     *
     * Requiere que las habitaciones del piso "1" con números del 1 al 10 ya
     * existan en la base de datos. De lo contrario, se lanzará una
     * NullPointerException al intentar obtener el ID de una habitación
     * inexistente.
     */
    @Override
    public void registrarResidentesMasivo() {
        HabitacionesDAOImp habitacionDAO = new HabitacionesDAOImp();
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        List<Residente> listaResidentes = new ArrayList<>();

        for (int habitacion = 1; habitacion <= 10; habitacion++) {
            String idHabitacion = habitacionDAO
                    .obtenerHabitacionPorPisoYNumero("1", String.valueOf(habitacion))
                    .getId().toString();

            // Primer residente
            Residente r1 = new Residente();
            r1.setMatricula(String.format("000002528%02d", habitacion * 2 - 1));
            r1.setCarrera("Ingeniería en Software");
            r1.setCorreo("residente" + (habitacion * 2 - 1) + "@potros.itson.edu.mx");
            r1.setDireccion("Calle Uno #" + habitacion);
            r1.setGenero('H');
            r1.setNombreCompleto("Residente Uno " + habitacion);
            r1.setNombreContactoEmergencia("Contacto Uno " + habitacion);
            r1.setSemestre(2 + (habitacion % 6));
            r1.setTelefono("64400000" + habitacion);
            r1.setTelefonoContactoEmergencia("64410000" + habitacion);
            r1.setTipoResidente(TipoResidente.NUEVO_INGRESO);
            r1.setHabitacion(idHabitacion);
            listaResidentes.add(r1);

            // Segundo residente
            Residente r2 = new Residente();
            r2.setMatricula(String.format("000002528%02d", habitacion * 2));
            r2.setCarrera("Ingeniería en Sistemas");
            r2.setCorreo("residente" + (habitacion * 2) + "@potros.itson.edu.mx");
            r2.setDireccion("Calle Dos #" + habitacion);
            r2.setGenero('M');
            r2.setNombreCompleto("Residente Dos " + habitacion);
            r2.setNombreContactoEmergencia("Contacto Dos " + habitacion);
            r2.setSemestre(3 + (habitacion % 6));
            r2.setTelefono("64411111" + habitacion);
            r2.setTelefonoContactoEmergencia("64422222" + habitacion);
            r2.setTipoResidente(TipoResidente.NUEVO_INGRESO);
            r2.setHabitacion(idHabitacion);
            listaResidentes.add(r2);
        }

        residentes.insertMany(listaResidentes);
    }

    /**
     * Obtiene la cantidad total de residentes registrados en la base de datos.
     *
     * @return la cantidad de documentos (residentes) existentes en la colección
     * correspondiente.
     */
    public Long obtenerCantidadResidentes() {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Long cantidadResidentes = residentes.countDocuments();
        return cantidadResidentes;
    }
}
