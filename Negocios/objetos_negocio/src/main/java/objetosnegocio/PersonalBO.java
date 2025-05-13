package objetosnegocio;

import java.util.List;

import dto.PersonalDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

/**
 * Clase que administra la lógica de negocio relacionada con el personal del
 * sistema. Se encarga de inicializar registros de personal y obtener personal
 * por puesto.
 */
public class PersonalBO {

    /**
     * Instancia singleton de la clase PersonalBO.
     */
    private static PersonalBO instance;

    /**
     * Constructor privado que inicializa el personal si no existe en la base de
     * datos.
     */
    private PersonalBO() {
        inicializarPersonal();
    }

    /**
     * Devuelve la instancia singleton de PersonalBO.
     *
     * @return instancia única de PersonalBO
     */
    public static PersonalBO getInstance() {
        if (instance == null) {
            instance = new PersonalBO();
        }
        return instance;
    }

    /**
     * Inicializa el personal predeterminado si no existen registros por puesto.
     */
    private void inicializarPersonal() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        if (accesoDatos.obtenerPersonalPorPuesto("ADMINISTRATIVO").isEmpty()
                && accesoDatos.obtenerPersonalPorPuesto("LIMPIEZA").isEmpty()
                && accesoDatos.obtenerPersonalPorPuesto("MANTENIMIENTO").isEmpty()) {

            // Registrar personal administrativo
            accesoDatos.registrarPersonal(
                    new PersonalDTO("Juan Pérez", "ADMINISTRATIVO", "1234567890", "juan.perez@correo.com"));
            accesoDatos.registrarPersonal(
                    new PersonalDTO("Ana López", "ADMINISTRATIVO", "0987654321", "ana.lopez@correo.com"));

            // Registrar personal de limpieza
            accesoDatos.registrarPersonal(
                    new PersonalDTO("Luis García", "LIMPIEZA", "1122334455", "luis.garcia@correo.com"));
            accesoDatos.registrarPersonal(
                    new PersonalDTO("María Torres", "LIMPIEZA", "6442531964", "maria.torres@correo.com"));

            // Registrar personal de mantenimiento
            accesoDatos.registrarPersonal(
                    new PersonalDTO("Carlos Ruiz", "MANTENIMIENTO", "3344556677", "carlos.ruiz@correo.com"));
            accesoDatos.registrarPersonal(
                    new PersonalDTO("Sofía Martínez", "MANTENIMIENTO", "4455667788", "sofia.martinez@correo.com"));
        }
    }

    /**
     * Obtiene un miembro del personal a partir de su información básica.
     *
     * @param personal objeto PersonalDTO con los datos de búsqueda
     * @return el objeto {@link PersonalDTO} correspondiente
     * @throws NoEncontradoException si no se encuentra el personal
     */
    public PersonalDTO obtenerPersonal(PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerPersonal(personal);
    }

    /**
     * Obtiene una lista de miembros del personal que tienen un puesto
     * específico.
     *
     * @param puesto puesto del personal (ej. ADMINISTRATIVO, LIMPIEZA,
     * MANTENIMIENTO)
     * @return lista de objetos {@link PersonalDTO} con ese puesto
     */
    public List<PersonalDTO> obtenerPersonalPorPuesto(String puesto) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerPersonalPorPuesto(puesto);
    }

}
