
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import entities.Residente;
import exceptions.NoEncontradoException;
import interfaz.IFiadorDAO;
import org.bson.conversions.Bson;

/**
 * Implementación de la interfaz IFiadorDAO para anidar fiadores a residentes.
 */
    public class FiadorDAO implements IFiadorDAO {

    /**
     * Anida un fiador al documento de un residente existente.
     *
     * @param fiadorDTO   DTO con la información del fiador.
     * @param residenteDTO DTO con la información mínima del residente (matrícula).
     * @return El objeto Fiador registrado.
     * @throws Exception Si no se encuentra al residente o ocurre un error.
     */
    @Override
    public Fiador registrarFiador(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO) throws Exception{
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();

        //DTO a entidad
        Fiador fiador = parsearFiadorDTO(fiadorDTO);

        //Filtro para encontrar al residente por matrícula
        Bson filtro = eq("_id", residenteDTO.getMatricula());

        //Actualización para anidar el fiador
        Bson actualizacion = set("fiador", fiador);

        UpdateResult resultado = residentes.updateOne(filtro, actualizacion);

        if (resultado.getMatchedCount() == 0) {
            throw new Exception("No se encontró el residente con matrícula: " + residenteDTO.getMatricula());
        }

        return fiador;
    }

    /**
     * Devuelve la colección de residentes.
     */
    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }

    /**
     * Convierte un FiadorDTO a entidad Fiador.
     */
    private Fiador parsearFiadorDTO(FiadorDTO dto) {
        Fiador fiador = new Fiador();
        fiador.setNombreCompleto(dto.getNombreCompleto());
        fiador.setTelefono(dto.getNumeroTelefono());
        fiador.setDireccion(dto.getDireccion());
        return fiador;
    }

    /**
     * Convierte un Fiador a FiadorDTO.
     */
    private FiadorDTO parsearFiadorAFiadorDTO(Fiador fiador) {
        FiadorDTO fiadorDTO = new FiadorDTO();
        fiadorDTO.setNombreCompleto(fiador.getNombreCompleto());
        fiadorDTO.setNumeroTelefono(fiador.getTelefono());
        fiadorDTO.setDireccion(fiador.getDireccion());
        return fiadorDTO;
    }

    /**
     * Consulta el fiador anidado de un residente 
     * @param residenteDTO
     * @return 
     * @throws exceptions.NoEncontradoException
     */

    @Override
    public FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws NoEncontradoException {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();

        Residente residente = residentes.find(eq("_id", residenteDTO.getMatricula())).first();

        if (residente == null) {
            throw new NoEncontradoException("Residente no encontrado con matrícula: " + residenteDTO.getMatricula());
        }

        Fiador fiador = residente.getFiador();

        if (fiador == null) {
            throw new NoEncontradoException("El residente no tiene un fiador registrado.");
        }
        return parsearFiadorAFiadorDTO(fiador);
    }
}
