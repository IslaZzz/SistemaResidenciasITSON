package implementaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;
import entities.Residente;
import interfaz.IHabitacionesDAO;
import interfaz.IRelacionResidentesHabitacionDAO;
import interfaz.IResidentesDAO;
import java.util.List;

public class RelacionResidentesHabitacionDAOImpTest {

    IRelacionResidentesHabitacionDAO relacionResidentesHabitacionDAO = new RelacionResidentesHabitacionDAOImp();
    IResidentesDAO residentesDAO = new ResidentesDAOImp();
    IHabitacionesDAO habitacionesDAO = new HabitacionesDAOImp();
    private static final String MATRICULA = "00000252687";
    Residente residenteGuardado;
    Habitacion habitacionGuardada;

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    @AfterAll
    public static void desactivarModoPruebas() {
        ManejadorConexiones.deactivateTestMode();
    }

    @AfterEach
    public void limpiarBD() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        db.getCollection("residentes").deleteOne(Filters.eq("_id", MATRICULA));
        db.getCollection("habitaciones").deleteOne(Filters.eq("_id", habitacionGuardada.getId()));
    }

    @Test
    public void testAsignarHabitacion() {
        ResidenteDTO residente = new ResidenteDTO(
                MATRICULA,
                "John Doe",
                'H',
                4,
                "Ingenieria en Software",
                "john@example.com",
                "6441231231",
                "John St 1234");
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        residenteGuardado = residentesDAO.registrarResidente(residente);
        habitacionGuardada = habitacionesDAO.registrarHabitacion(habitacion);
        relacionResidentesHabitacionDAO.asignarHabitacion(residente, habitacion);
        ResidenteDTO residenteObtenido = residentesDAO.obtenerResidente(residenteGuardado.getMatricula());
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(new HabitacionDTO(habitacionGuardada.getId().toString()));
        assertNotNull(residenteObtenido);
        assertNotNull(habitacionObtenida);
        assertEquals(residenteObtenido.getIdHabitacion(), habitacionGuardada.getId().toString());
        assertTrue(habitacionObtenida.getResidentesActualesIds().contains(residenteGuardado.getMatricula()));
    }

    @Test
    public void testDeasignarHabitacion() {
        ResidenteDTO residente = new ResidenteDTO(
                MATRICULA,
                "John Doe",
                'H',
                4,
                "Ingenieria en Software",
                "john@example.com",
                "6441231231",
                "John St 1234");
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        residenteGuardado = residentesDAO.registrarResidente(residente);
        habitacionGuardada = habitacionesDAO.registrarHabitacion(habitacion);
        relacionResidentesHabitacionDAO.asignarHabitacion(residente, habitacion);
        ResidenteDTO residenteObtenido = residentesDAO.obtenerResidente(residenteGuardado.getMatricula());
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(new HabitacionDTO(habitacionGuardada.getId().toString()));
        assertNotNull(residenteObtenido);
        assertNotNull(habitacionObtenida);
        assertEquals(residenteObtenido.getIdHabitacion(), habitacionGuardada.getId().toString());
        assertTrue(habitacionObtenida.getResidentesActualesIds().contains(residenteGuardado.getMatricula()));
        relacionResidentesHabitacionDAO.desasignarHabitacion(residenteObtenido);
        residenteObtenido = residentesDAO.obtenerResidente(residenteGuardado.getMatricula());
        habitacionObtenida = habitacionesDAO.obtenerHabitacion(new HabitacionDTO(habitacionGuardada.getId().toString()));
        assertNotNull(residenteObtenido);
        assertNotNull(habitacionObtenida);
        assertFalse(habitacionObtenida.getResidentesActualesIds().contains(residenteGuardado.getMatricula()));
    }

    @Test
    public void testObtenerResidentesPorHabitacion() {
        ResidenteDTO residente = new ResidenteDTO(
                MATRICULA,
                "John Doe",
                'H',
                4,
                "Ingenieria en Software",
                "john@example.com",
                "6441231231",
                "John St 1234"
        );
        residenteGuardado = residentesDAO.registrarResidente(residente);
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        habitacionGuardada = habitacionesDAO.registrarHabitacion(habitacion);
        relacionResidentesHabitacionDAO.asignarHabitacion(residente, habitacion);
        List<String> nombresResidentes = relacionResidentesHabitacionDAO.obtenerResidentesPorHabitacion(1, 1);
        assertNotNull(nombresResidentes, "La lista no debe ser nula");
        assertTrue(nombresResidentes.contains("John Doe"), "La lista debe contener el nombre del residente asignado");
        
    }

}
