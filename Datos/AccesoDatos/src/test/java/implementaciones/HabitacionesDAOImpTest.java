package implementaciones;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Habitacion;
import entities.Residente;
import enums.TipoResidente;
import interfaz.IResidentesDAO;

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
    private static final List<Habitacion> habitacionesGuardadas = new LinkedList<>();

    private static final List<Residente> residentesGuardados = new LinkedList<>();

    public HabitacionesDAOImpTest() {
    }

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
        if (habitacionesGuardadas != null) {
            for (Habitacion habitacion : habitacionesGuardadas) {
                HabitacionDTO habitacionDTO = new HabitacionDTO(habitacion.getPiso(), habitacion.getNumero());
                habitacionDTO.setIdHabitacion(habitacion.getId().toString());
                habitacionesDAO.eliminarHabitacion(habitacionDTO);
            }
        }
        if (residentesGuardados != null) {
            for(Residente residente: residentesGuardados){
                MongoDatabase db = ManejadorConexiones.obtenerConexion();
                MongoCollection<Residente> coleccion = db.getCollection("residentes", Residente.class);
                coleccion.deleteOne(Filters.eq("_id", residente.getMatricula()));
            }
        }
    }

    @Test
    public void testRegistrarHabitacionesMasivo() {
        System.out.println("registrarHabitacionesMasivo");
        int numeroPisos = 3;
        int numeroHabitacionesPorPiso = 25;
        List<Habitacion> habitacionesRegistradas = habitacionesDAO.registrarHabitacionesMasivo(numeroPisos,
                numeroHabitacionesPorPiso);
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
        System.out.println("obtenerHabitacionPorId");
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
        System.out.println("obtenerHabitacionPorPisoYNumero");
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
        System.out.println("obtenerHabitacionNoExistente");
        HabitacionDTO habitacion = new HabitacionDTO(1, 1);
        HabitacionDTO habitacionObtenida = habitacionesDAO.obtenerHabitacion(habitacion);
        assertNull(habitacionObtenida);
    }

    @Test
    public void testObtenerHabitacionesDisponiblesPorPiso() {
        System.out.println("obtenerHabitacionesDisponiblesPorPiso");
        int numeroPisos = 3;
        int numeroHabitacionesPorPiso = 25;
        List<Habitacion> habitacionesRegistradas = habitacionesDAO.registrarHabitacionesMasivo(numeroPisos,
                numeroHabitacionesPorPiso);
        habitacionesGuardadas.addAll(habitacionesRegistradas);
        List<HabitacionDTO> habitacionesDisponibles = habitacionesDAO.obtenerHabitacionesDisponiblesPorPiso(1);
        assertNotNull(habitacionesDisponibles);
        assertEquals(numeroHabitacionesPorPiso, habitacionesDisponibles.size());
    }

    @Test
    public void testObtenerPisos() {
        System.out.println("obtenerPisos");
        int numeroPisos = 3;
        int numeroHabitacionesPorPiso = 25;
        List<Habitacion> habitacionesRegistradas = habitacionesDAO.registrarHabitacionesMasivo(numeroPisos,
                numeroHabitacionesPorPiso);
        habitacionesGuardadas.addAll(habitacionesRegistradas);
        List<Integer> pisos = habitacionesDAO.obtenerPisosDisponibles();
        assertNotNull(pisos);
        assertEquals(numeroPisos, pisos.size());
        for (int i = 1; i <= numeroPisos; i++) {
            assertTrue(pisos.contains(i));
        }
    }

    @Test
    public void testObtenerHabitacionesRecomendadas() {
        System.out.println("obtenerHabitacionesRecomendadas");

        // Crear habitaciones
        HabitacionDTO habitacion1 = new HabitacionDTO(1, 1);
        HabitacionDTO habitacion2 = new HabitacionDTO(1, 2);
        HabitacionDTO habitacion3 = new HabitacionDTO(1, 3);

        Habitacion nuevaHabitacion1 = habitacionesDAO.registrarHabitacion(habitacion1);
        Habitacion nuevaHabitacion2 = habitacionesDAO.registrarHabitacion(habitacion2);
        Habitacion nuevaHabitacion3 = habitacionesDAO.registrarHabitacion(habitacion3);

        habitacionesGuardadas.add(nuevaHabitacion1);
        habitacionesGuardadas.add(nuevaHabitacion2);
        habitacionesGuardadas.add(nuevaHabitacion3);

        IResidentesDAO residentesDAO = new ResidentesDAOImp();

        // Simular residentes
        ResidenteDTO residente1 = new ResidenteDTO("000001", "Residente 1", 'H', 4, "Ingenieria",
                "correo1@itson.edu.mx", "1234567890", "Direccion 1", "Contacto 1", "1234567890");
        residente1.setTipoResidente(TipoResidente.NUEVO_INGRESO.toString());
        residentesGuardados.add(residentesDAO.registrarResidente(residente1));
        
        ResidenteDTO residente2 = new ResidenteDTO("000002", "Residente 2", 'H', 4, "Ingenieria",
        "correo2@itson.edu.mx", "1234567890", "Direccion 2", "Contacto 2", "1234567890");
        residente2.setTipoResidente(TipoResidente.NUEVO_INGRESO.toString());
        residentesGuardados.add(residentesDAO.registrarResidente(residente2));

        ResidenteDTO residente3 = new ResidenteDTO("000003", "Residente 3", 'H', 4, "Ingenieria",
        "correo3@itson.edu.mx", "1234567890", "Direccion 3", "Contacto 3", "1234567890");
        residente3.setTipoResidente(TipoResidente.DEPORTISTA.toString());
        residentesGuardados.add(residentesDAO.registrarResidente(residente3));

        // Registrar residentes en las habitaciones
        RelacionResidentesHabitacionDAOImp relacionDAO = new RelacionResidentesHabitacionDAOImp();
        relacionDAO.asignarHabitacion(residente1, habitacion1);
        relacionDAO.asignarHabitacion(residente2, habitacion2);
        relacionDAO.asignarHabitacion(residente3, habitacion3);

        // Crear un residente para buscar recomendaciones
        ResidenteDTO residenteRecomendado = new ResidenteDTO("000004", "Residente 4", 'H', 4, "Ingenieria",
                "correo3@itson.edu.mx", "1234567890", "Direccion 4", "Contacto 3", "1234567890");
        residenteRecomendado.setTipoResidente(TipoResidente.NUEVO_INGRESO.toString());

        // Obtener habitaciones recomendadas
        List<HabitacionDTO> habitacionesRecomendadas = habitacionesDAO
                .obtenerHabitacionesRecomendadas(residenteRecomendado, 1);

        // Validar resultados
        assertEquals(2, habitacionesRecomendadas.size()); // Las habitaciones 1 y 2 deberían ser recomendadas
        assertTrue(habitacionesRecomendadas.stream().anyMatch(h -> h.getNumero() == habitacion1.getNumero()));
        assertTrue(habitacionesRecomendadas.stream().anyMatch(h -> h.getNumero() == habitacion2.getNumero()));
    }
}
