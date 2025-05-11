package objetosnegocio;

import java.util.List;

import dto.PersonalDTO;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

public class PersonalBO {

    private static PersonalBO instance;

    private PersonalBO() {
        inicializarPersonal();
    }

    public static PersonalBO getInstance() {
        if (instance == null) {
            instance = new PersonalBO();
        }
        return instance;
    }

    private void inicializarPersonal() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        if (accesoDatos.obtenerPersonalPorPuesto("ADMINISTRATIVO").isEmpty() &&
                accesoDatos.obtenerPersonalPorPuesto("LIMPIEZA").isEmpty() &&
                accesoDatos.obtenerPersonalPorPuesto("MANTENIMIENTO").isEmpty()) {

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

    public PersonalDTO obtenerPersonal(PersonalDTO personal) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerPersonal(personal);
    }

    public List<PersonalDTO> obtenerPersonalPorPuesto(String puesto) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerPersonalPorPuesto(puesto);
    }



}
