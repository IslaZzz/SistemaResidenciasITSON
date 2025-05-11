package implementaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.PersonalDTO;
import entities.Personal;
import enums.Puesto;
import exceptions.NoEncontradoException;

public class PersonalDAOImpTest {

    private PersonalDAOImp personalDAO;
    private PersonalDTO personalGuardado;

    @BeforeAll
    public static void activarModoPruebas(){
        ManejadorConexiones.activateTestMode();
    }

    @BeforeEach
    public void setUp() {
        personalDAO = new PersonalDAOImp();
        personalGuardado = null;
    }

    @AfterEach
    public void tearDown() {
        if (personalGuardado != null) {
            try {
                personalDAO.eliminarPersonal(personalGuardado);
            } catch (NoEncontradoException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterAll
    public static void desactivarModoPruebas() {
        ManejadorConexiones.deactivateTestMode();
    }

    @Test
    public void testRegistrarPersonal() {
        PersonalDTO personalDTO = new PersonalDTO("Juan Pérez", Puesto.ADMINISTRATIVO.toString(), "1234567890", "juan@correo.com");
        Personal personal = personalDAO.registrarPersonal(personalDTO);

        assertNotNull(personal);
        assertNotNull(personal.getId());
        assertEquals(personalDTO.getNombre(), personal.getNombre());
        assertEquals(Puesto.ADMINISTRATIVO, personal.getPuesto());
        assertEquals(personalDTO.getTelefono(), personal.getTelefono());
        assertEquals(personalDTO.getCorreo(), personal.getCorreo());

        personalGuardado = new PersonalDTO(personal.getId().toString(), personal.getNombre(), personal.getPuesto().toString(), personal.getTelefono(), personal.getCorreo());
    }

    @Test
    public void testObtenerPersonalPorId() throws NoEncontradoException {
        PersonalDTO personalDTO = new PersonalDTO("Ana López", Puesto.LIMPIEZA.toString(), "0987654321", "ana@correo.com");
        Personal personal = personalDAO.registrarPersonal(personalDTO);
        personalGuardado = new PersonalDTO(personal.getId().toString(), personal.getNombre(), personal.getPuesto().toString(), personal.getTelefono(), personal.getCorreo());

        Personal personalObtenido = personalDAO.obtenerPersonal(personalGuardado);

        assertNotNull(personalObtenido);
        assertEquals(personal.getId(), personalObtenido.getId());
        assertEquals(personal.getNombre(), personalObtenido.getNombre());
        assertEquals(personal.getPuesto(), personalObtenido.getPuesto());
        assertEquals(personal.getTelefono(), personalObtenido.getTelefono());
        assertEquals(personal.getCorreo(), personalObtenido.getCorreo());
    }

    @Test
    public void testEliminarPersonal() throws NoEncontradoException {
        PersonalDTO personalDTO = new PersonalDTO("Carlos Ruiz", Puesto.MANTENIMIENTO.toString(), "1122334455", "carlos@correo.com");
        Personal personal = personalDAO.registrarPersonal(personalDTO);
        personalGuardado = new PersonalDTO(personal.getId().toString(), personal.getNombre(), personal.getPuesto().toString(), personal.getTelefono(), personal.getCorreo());

        boolean eliminado = personalDAO.eliminarPersonal(personalGuardado);

        assertTrue(eliminado);

        assertThrows(NoEncontradoException.class, () -> {
            personalDAO.obtenerPersonal(personalGuardado);
        });

        personalGuardado = null; // Evitar que se intente eliminar nuevamente en tearDown
    }

    @Test
    public void testObtenerPersonalPorPuesto() {
        PersonalDTO personalDTO1 = new PersonalDTO("Luis García", Puesto.LIMPIEZA.toString(), "5566778899", "luis@correo.com");
        PersonalDTO personalDTO2 = new PersonalDTO("María Torres", Puesto.LIMPIEZA.toString(), "6677889900", "maria@correo.com");

        Personal personal1 = personalDAO.registrarPersonal(personalDTO1);
        Personal personal2 = personalDAO.registrarPersonal(personalDTO2);

        List<Personal> personalLimpieza = personalDAO.obtenerPersonalPorPuesto(Puesto.LIMPIEZA);

        assertNotNull(personalLimpieza);
        assertTrue(personalLimpieza.size() >= 2);
        assertTrue(personalLimpieza.stream().anyMatch(p -> p.getId().equals(personal1.getId())));
        assertTrue(personalLimpieza.stream().anyMatch(p -> p.getId().equals(personal2.getId())));

        personalGuardado = new PersonalDTO(personal1.getId().toString(), personal1.getNombre(), personal1.getPuesto().toString(), personal1.getTelefono(), personal1.getCorreo());
        try {
            personalDAO.eliminarPersonal(new PersonalDTO(personal2.getId().toString(), personal2.getNombre(), personal2.getPuesto().toString(), personal2.getTelefono(), personal2.getCorreo()));
        } catch (NoEncontradoException e) {
            e.printStackTrace();
        }
    }
}