package implementaciones;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dto.HabitacionDTO;
import entities.Habitacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pc
 */
public class HabitacionesDAOImpTest {
    

    private final HabitacionesDAOImp habitacionesDAO = new HabitacionesDAOImp();
    // Lista para almacenar las habitaciones guardadas durante las pruebas
    private static List<Habitacion> habitacionesGuardadas = new LinkedList<>(); 


    public HabitacionesDAOImpTest() { }
    
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
        if(habitacionesGuardadas != null) {
            for(Habitacion habitacion : habitacionesGuardadas) {
                HabitacionDTO habitacionDTO = new HabitacionDTO(habitacion.getPiso(), habitacion.getNumero());
                habitacionDTO.setIdHabitacion(habitacion.getId().toString());
                habitacionesDAO.eliminarHabitacion(habitacionDTO);
            }
        }
    }

    @Test
    public void testRegistrarHabitacionesMasivo() {
        System.out.println("registrarHabitacionesMasivo");
        int numeroPisos = 3;
        int numeroHabitacionesPorPiso = 25;
        List<Habitacion> habitacionesRegistradas = habitacionesDAO.registrarHabitacionesMasivo(numeroPisos, numeroHabitacionesPorPiso);
        habitacionesGuardadas.addAll(habitacionesRegistradas);
        int expResult = 75;
        int result = habitacionesDAO.obtenerCantidadHabitaciones().intValue();
        assertEquals(expResult, result);

    }

    @Test
    public void testRegistrarHabitacion() {
        System.out.println("registrarHabitacion");
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        Habitacion nuevaHabitacion = habitacionesDAO.registrarHabitacion(habitacion);
        habitacionesGuardadas.add(nuevaHabitacion);
        assertNotNull(nuevaHabitacion.getId());
        assertEquals(habitacion.getPiso(), nuevaHabitacion.getPiso());
        assertEquals(habitacion.getNumero(), nuevaHabitacion.getNumero());
    }

    @Test
    public void testEliminarHabitacion() {
        System.out.println("eliminarHabitacion");
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        Habitacion nuevaHabitacion = habitacionesDAO.registrarHabitacion(habitacion);
        habitacion.setIdHabitacion(nuevaHabitacion.getId().toString());
        boolean resultado = habitacionesDAO.eliminarHabitacion(habitacion);
        assertTrue(resultado);
    }

    /**
     * Test of obtenerCantidadHabitaciones method, of class HabitacionesDAOImp.
     */
    @Test
    public void testObtenerCantidadHabitaciones() {
        System.out.println("obtenerCantidadHabitaciones");
        Long expResult = 0L;
        Long result = habitacionesDAO.obtenerCantidadHabitaciones();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerHabitacionPorId() {
        System.out.println("obtenerHabitacionPorId");;
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        Habitacion nuevaHabitacion = habitacionesDAO.registrarHabitacion(habitacion);
        habitacionesGuardadas.add(nuevaHabitacion);
        habitacion.setIdHabitacion(nuevaHabitacion.getId().toString());
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(habitacion);
        assertNotNull(habitacionObtenida);
        assertEquals(habitacion.getIdHabitacion(), habitacionObtenida.getIdHabitacion());
        assertEquals(habitacion.getPiso(), habitacionObtenida.getPiso());
        assertEquals(habitacion.getNumero(), habitacionObtenida.getNumero());
    }

    @Test
    public void testObtenerHabitacionPorPisoYNumero() {
        System.out.println("obtenerHabitacionPorPisoYNumero");;
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        Habitacion nuevaHabitacion = habitacionesDAO.registrarHabitacion(habitacion);
        habitacionesGuardadas.add(nuevaHabitacion);
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(habitacion);
        assertNotNull(habitacionObtenida);
        assertEquals(nuevaHabitacion.getId().toString(), habitacionObtenida.getIdHabitacion());
        assertEquals(habitacion.getPiso(), habitacionObtenida.getPiso());
        assertEquals(habitacion.getNumero(), habitacionObtenida.getNumero());
    }

    @Test
    public void testObtenerHabitacionNoExistente() {
        System.out.println("obtenerHabitacionNoExistente");;
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(habitacion);
        assertNull(habitacionObtenida);
    }
}
