package implementaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import entities.Personal;
import entities.Zona;
import enums.Puesto;
import exceptions.NoEncontradoException;

public class ActividadesLimpiezaDAOImpTest {

    private ActividadesLimpiezaDAOImp actividadesLimpiezaDAO;
    private ActividadLimpieza actividadGuardada;

    private ZonasDAOImp zonasDAO;
    private Zona zonaGuardada;

    private PersonalDAOImp personalDAO;
    private Personal personalGuardado;

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    @BeforeEach
    public void setUp() {
        actividadesLimpiezaDAO = new ActividadesLimpiezaDAOImp();
        zonasDAO = new ZonasDAOImp();
        personalDAO = new PersonalDAOImp();
        actividadGuardada = null;
    }

    @AfterEach
    public void tearDown() {
        if (actividadGuardada != null) {
            try {
                actividadesLimpiezaDAO.eliminarActividad(new ActividadLimpiezaDTO(
                        actividadGuardada.getId().toString(),
                        actividadGuardada.getIdZona().toString(),
                        actividadGuardada.getIdPersonal().toString(),
                        actividadGuardada.getFechaInicio(),
                        actividadGuardada.getFechaFin()));
                zonasDAO.eliminarZona(new ZonaDTO(
                        zonaGuardada.getId().toString(),
                        zonaGuardada.getPiso(),
                        zonaGuardada.getNombre()));
                personalDAO.eliminarPersonal(new PersonalDTO(
                        personalGuardado.getId().toString(),
                        personalGuardado.getNombre(),
                        personalGuardado.getPuesto().toString(),
                        personalGuardado.getTelefono(),
                        personalGuardado.getCorreo()
                ));
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
    public void testRegistrarActividadLimpieza() throws NoEncontradoException {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Cocina");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        zonaDTO.setId(zonaGuardada.getId().toString());
        PersonalDTO personalDTO = new PersonalDTO("Luis García", Puesto.LIMPIEZA.toString(), "5566778899", "luis@correo.com");
        personalGuardado = personalDAO.registrarPersonal(personalDTO);
        personalDTO.setId(personalGuardado.getId().toString());
        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
                null,
                null,
                null,
                new Date(),
                new Date(System.currentTimeMillis() + 3600000)); // 1 hora después

        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO, zonaDTO, personalDTO);

        assertNotNull(actividad);
        assertNotNull(actividad.getId());
        assertEquals(zonaDTO.getId(), actividad.getIdZona());
        assertEquals(personalDTO.getId(), actividad.getIdPersonal());
        assertEquals(actividadDTO.getFechaInicio(), actividad.getFechaInicio());
        assertEquals(actividadDTO.getFechaFin(), actividad.getFechaFin());

        actividadGuardada = actividad;
    }

    @Test
    public void testObtenerActividad() throws NoEncontradoException {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Sala de Estar");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        zonaDTO.setId(zonaGuardada.getId().toString());
        PersonalDTO personalDTO = new PersonalDTO("Ana López", Puesto.LIMPIEZA.toString(), "0987654321", "ana@correo.com");
        personalGuardado = personalDAO.registrarPersonal(personalDTO);
        personalDTO.setId(personalGuardado.getId().toString());
        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
                null,
                null,
                null,
                new Date(),
                new Date(System.currentTimeMillis() + 7200000)); // 2 horas después

        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO, zonaDTO, personalDTO);
        actividadGuardada = actividad;

        ActividadLimpieza actividadObtenida = actividadesLimpiezaDAO.obtenerActividad(new ActividadLimpiezaDTO(
                actividad.getId().toString(),
                null,
                null,
                null,
                null));

        assertNotNull(actividadObtenida);
        assertEquals(actividad.getId(), actividadObtenida.getId());
        assertEquals(actividad.getIdZona(), actividadObtenida.getIdZona());
        assertEquals(actividad.getIdPersonal(), actividadObtenida.getIdPersonal());
        assertEquals(actividad.getFechaInicio(), actividadObtenida.getFechaInicio());
        assertEquals(actividad.getFechaFin(), actividadObtenida.getFechaFin());
    }

    @Test
    public void testEliminarActividad() throws NoEncontradoException {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Pasillo Principal");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        zonaDTO.setId(zonaGuardada.getId().toString());
        PersonalDTO personalDTO = new PersonalDTO("Carlos Ruiz", Puesto.LIMPIEZA.toString(), "1122334455", "carlos@correo.com");
        personalGuardado = personalDAO.registrarPersonal(personalDTO);
        personalDTO.setId(personalGuardado.getId().toString());
        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
                null,
                null,
                null,
                new Date(),
                new Date(System.currentTimeMillis() + 1800000)); // 30 minutos después

        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO, zonaDTO, personalDTO);
        actividadGuardada = actividad;

        boolean eliminado = actividadesLimpiezaDAO.eliminarActividad(new ActividadLimpiezaDTO(
                actividad.getId().toString(),
                null,
                null,
                null,
                null));

        assertTrue(eliminado);

        assertThrows(NoEncontradoException.class, () -> {
            actividadesLimpiezaDAO.obtenerActividad(new ActividadLimpiezaDTO(
                    actividad.getId().toString(),
                    null,
                    null,
                    null,
                    null));
        });

        actividadGuardada = null; // Evitar que se intente eliminar nuevamente en tearDown
    }

    @Test
    public void testObtenerActividadesLimpieza() throws NoEncontradoException{
        ZonaDTO zonaDTO1 = new ZonaDTO(1, "Recepción");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO1);
        zonaDTO1.setId(zonaGuardada.getId().toString());
        PersonalDTO personalDTO = new PersonalDTO("María Torres", Puesto.LIMPIEZA.toString(), "6677889900", "maria@correo.com");
        personalGuardado = personalDAO.registrarPersonal(personalDTO);
        personalDTO.setId(personalGuardado.getId().toString());
        ActividadLimpiezaDTO actividadDTO1 = new ActividadLimpiezaDTO(
                null,
                null,
                null,
                new Date(),
                new Date(System.currentTimeMillis() + 3600000)); // 1 hora después
        ActividadLimpiezaDTO actividadDTO2 = new ActividadLimpiezaDTO(
                null,
                null,
                null,
                new Date(),
                new Date(System.currentTimeMillis() + 7200000)); // 2 horas después

        ActividadLimpieza actividad1 = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO1, zonaDTO1, personalDTO);
        ActividadLimpieza actividad2 = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO2, zonaDTO1, personalDTO);

        List<ActividadLimpieza> actividades = actividadesLimpiezaDAO.obtenerActividadesLimpieza();

        assertNotNull(actividades);
        assertTrue(actividades.size() >= 2);
        assertTrue(actividades.stream().anyMatch(a -> a.getId().equals(actividad1.getId())));
        assertTrue(actividades.stream().anyMatch(a -> a.getId().equals(actividad2.getId())));

        actividadGuardada = actividad1;
        try {
            actividadesLimpiezaDAO.eliminarActividad(new ActividadLimpiezaDTO(
                    actividad2.getId().toString(),
                    null,
                    null,
                    null,
                    null));
        } catch (NoEncontradoException e) {
            e.printStackTrace();
        }
    }
}