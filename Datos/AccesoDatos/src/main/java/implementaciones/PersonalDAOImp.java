package implementaciones;

import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import dto.PersonalDTO;
import entities.Personal;
import enums.Puesto;
import exceptions.NoEncontradoException;
import interfaz.IPersonalDAO;

/**
 * Implementación de la interfaz IPersonalDAO para gestionar las operaciones
 * relacionadas con el personal en la base de datos MongoDB.
 */
public class PersonalDAOImp implements IPersonalDAO {

    /**
     * Registra un nuevo miembro del personal en la base de datos.
     *
     * @param personal El objeto PersonalDTO que contiene los datos del personal a registrar.
     * @return Un objeto Personal que representa al personal registrado, incluyendo su identificador único.
     */
    @Override
    public Personal registrarPersonal(PersonalDTO personal) {
        MongoCollection<Personal> coleccion = obtenerColeccion();
        Personal nuevoPersonal = new Personal(
                personal.getNombre(),
                Puesto.valueOf(personal.getPuesto()),
                personal.getTelefono(),
                personal.getCorreo());
        coleccion.insertOne(nuevoPersonal);
        return nuevoPersonal;
    }

    /**
     * Obtiene un miembro del personal de la base de datos.
     *
     * @param personal El objeto PersonalDTO que contiene los datos del personal a buscar.
     *                 Puede incluir el identificador único (id) o el nombre del personal.
     * @return Un objeto Personal que representa al personal encontrado.
     * @throws NoEncontradoException Si no se encuentra el personal con los datos especificados.
     */
    @Override
    public Personal obtenerPersonal(PersonalDTO personal) throws NoEncontradoException {
        MongoCollection<Personal> coleccion = obtenerColeccion();
        if (personal.getId() != null) {
            Personal p = coleccion.find(Filters.eq("_id", new ObjectId(personal.getId()))).first();
            if (p == null) {
                throw new NoEncontradoException("No se encontró el personal con los datos especificados");
            }
            return p;
        } else {
            Personal p = coleccion.find(Filters.eq("nombre", personal.getNombre())).first();
            if (p == null) {
                throw new NoEncontradoException("No se encontró el personal con los datos especificados");
            }
            return p;
        }
    }

    /**
     * Elimina un miembro del personal de la base de datos.
     *
     * @param personal El objeto PersonalDTO que contiene los datos del personal a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     * @throws NoEncontradoException Si no se encuentra el personal con los datos especificados.
     */
    @Override
    public boolean eliminarPersonal(PersonalDTO personal) throws NoEncontradoException {
        MongoCollection<Personal> coleccion = obtenerColeccion();
        Personal personalAEliminar = obtenerPersonal(personal);
        DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", personalAEliminar.getId()));
        return resultado.wasAcknowledged();
    }

    /**
     * Obtiene una lista de miembros del personal que tienen un puesto específico.
     *
     * @param puesto El puesto del personal a buscar.
     * @return Una lista de objetos Personal que representan al personal encontrado.
     */
    @Override
    public List<Personal> obtenerPersonalPorPuesto(Puesto puesto) {
        MongoCollection<Personal> coleccion = obtenerColeccion();
        FindIterable<Personal> personalEncontrado = coleccion.find(Filters.eq("puesto", puesto.toString()));
        return personalEncontrado.into(new LinkedList<>());
    }

    /**
     * Obtiene la colección de personal desde la base de datos MongoDB.
     *
     * @return La colección MongoCollection que representa la colección "personal".
     */
    private MongoCollection<Personal> obtenerColeccion() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Personal> personal = db.getCollection("personal", Personal.class);
        return personal;
    }
}