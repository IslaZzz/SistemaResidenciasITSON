//package implementaciones;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.mongodb.client.MongoDatabase;
//
//import dto.ActividadLimpiezaDTO;
//import dto.PersonalDTO;
//import dto.ZonaDTO;
//import entities.ActividadLimpieza;
//import entities.Personal;
//import entities.Zona;
//import enums.Puesto;
//import exceptions.NoEncontradoException;
//
//public class ActividadesLimpiezaDAOImpTest {
//
//    private ActividadesLimpiezaDAOImp actividadesLimpiezaDAO;
//    private ActividadLimpieza actividadGuardada;
//
//    private ZonasDAOImp zonasDAO;
//    private Zona zonaGuardada;
//
//    private PersonalDAOImp personalDAO;
//    private Personal personalGuardado;
//
//    @BeforeAll
//    public static void activarModoPruebas() {
//        ManejadorConexiones.activateTestMode();
//    }
//
//    @BeforeEach
//    public void setUp() {
//        actividadesLimpiezaDAO = new ActividadesLimpiezaDAOImp();
//        zonasDAO = new ZonasDAOImp();
//        personalDAO = new PersonalDAOImp();
//        actividadGuardada = null;
//    }
//
//    @AfterEach
//    public void tearDown() {
//
//        MongoDatabase database = ManejadorConexiones.obtenerConexion();
//        if (actividadGuardada != null) {
//            database.getCollection("actividadesLimpieza").drop();
//        }
//        if (zonaGuardada != null) {
//            database.getCollection("zonas").drop();
//        }
//        if (personalGuardado != null) {
//            database.getCollection("personal").drop();
//        }
//    }
//
//    @AfterAll
//    public static void desactivarModoPruebas() {
//        ManejadorConexiones.deactivateTestMode();
//    }
//
//    @Test
//    public void testRegistrarActividadLimpieza() throws NoEncontradoException {
//        ZonaDTO zonaDTO = new ZonaDTO(1, "Cocina");
//        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
//        zonaDTO.setId(zonaGuardada.getId().toString());
//        PersonalDTO personalDTO = new PersonalDTO("Luis García", Puesto.LIMPIEZA.toString(), "5566778899",
//                "luis@correo.com");
//        personalGuardado = personalDAO.registrarPersonal(personalDTO);
//        personalDTO.setId(personalGuardado.getId().toString());
//        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, "Luis García"),
//                new Date(),
//                new Date(System.currentTimeMillis() + 3600000)); // 1 hora después
//
//        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO);
//
//        assertNotNull(actividad);
//        assertNotNull(actividad.getId());
//        assertEquals(zonaDTO.getId(), actividad.getZona().getId().toString());
//        assertEquals(personalDTO.getId(), actividad.getPersonal().getId().toString());
//        assertEquals(actividadDTO.getFechaInicio(), actividad.getFechaInicio());
//        assertEquals(actividadDTO.getFechaFin(), actividad.getFechaFin());
//
//        actividadGuardada = actividad;
//    }
//
//    @Test
//    public void testObtenerActividad() throws NoEncontradoException {
//        ZonaDTO zonaDTO = new ZonaDTO(1, "Sala de Estar");
//        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
//        zonaDTO.setId(zonaGuardada.getId().toString());
//        PersonalDTO personalDTO = new PersonalDTO("Ana López", Puesto.LIMPIEZA.toString(), "0987654321",
//                "ana@correo.com");
//        personalGuardado = personalDAO.registrarPersonal(personalDTO);
//        personalDTO.setId(personalGuardado.getId().toString());
//        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(),
//                new Date(System.currentTimeMillis() + 7200000)); // 2 horas después
//
//        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO);
//        actividadGuardada = actividad;
//
//        ActividadLimpieza actividadObtenida = actividadesLimpiezaDAO.obtenerActividad(new ActividadLimpiezaDTO(
//                actividad.getId().toString(),
//                null,
//                null,
//                null,
//                null));
//
//        assertNotNull(actividadObtenida);
//        assertEquals(actividad.getId(), actividadObtenida.getId());
//        assertEquals(zonaDTO.getId(), actividad.getZona().getId().toString());
//        assertEquals(personalDTO.getId(), actividad.getPersonal().getId().toString());
//        assertEquals(actividad.getFechaInicio(), actividadObtenida.getFechaInicio());
//        assertEquals(actividad.getFechaFin(), actividadObtenida.getFechaFin());
//    }
//
//    @Test
//    public void testEliminarActividad() throws NoEncontradoException {
//        ZonaDTO zonaDTO = new ZonaDTO(1, "Pasillo Principal");
//        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
//        zonaDTO.setId(zonaGuardada.getId().toString());
//        PersonalDTO personalDTO = new PersonalDTO("Carlos Ruiz", Puesto.LIMPIEZA.toString(), "1122334455",
//                "carlos@correo.com");
//        personalGuardado = personalDAO.registrarPersonal(personalDTO);
//        personalDTO.setId(personalGuardado.getId().toString());
//        ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(),
//                new Date(System.currentTimeMillis() + 1800000)); // 30 minutos después
//
//        ActividadLimpieza actividad = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO);
//        actividadGuardada = actividad;
//
//        boolean eliminado = actividadesLimpiezaDAO.eliminarActividad(new ActividadLimpiezaDTO(
//                actividad.getId().toString(),
//                null,
//                null,
//                null,
//                null));
//
//        assertTrue(eliminado);
//
//        assertThrows(NoEncontradoException.class, () -> {
//            actividadesLimpiezaDAO.obtenerActividad(new ActividadLimpiezaDTO(
//                    actividad.getId().toString(),
//                    null,
//                    null,
//                    null,
//                    null));
//        });
//
//        actividadGuardada = null; // Evitar que se intente eliminar nuevamente en tearDown
//    }
//
//    @Test
//    public void testObtenerActividadesLimpieza() throws NoEncontradoException {
//        ZonaDTO zonaDTO1 = new ZonaDTO(1, "Recepción");
//        zonaGuardada = zonasDAO.agregarZona(zonaDTO1);
//        zonaDTO1.setId(zonaGuardada.getId().toString());
//        PersonalDTO personalDTO = new PersonalDTO("María Torres", Puesto.LIMPIEZA.toString(), "6677889900",
//                "maria@correo.com");
//        personalGuardado = personalDAO.registrarPersonal(personalDTO);
//        personalDTO.setId(personalGuardado.getId().toString());
//        ActividadLimpiezaDTO actividadDTO1 = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(),
//                new Date(System.currentTimeMillis() + 3600000)); // 1 hora después
//        ActividadLimpiezaDTO actividadDTO2 = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(),
//                new Date(System.currentTimeMillis() + 7200000)); // 2 horas después
//
//        ActividadLimpieza actividad1 = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO1);
//        ActividadLimpieza actividad2 = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO2);
//
//        List<ActividadLimpieza> actividades = actividadesLimpiezaDAO.obtenerActividadesLimpieza();
//
//        assertNotNull(actividades);
//        assertTrue(actividades.size() >= 2);
//        assertTrue(actividades.stream().anyMatch(a -> a.getId().equals(actividad1.getId())));
//        assertTrue(actividades.stream().anyMatch(a -> a.getId().equals(actividad2.getId())));
//
//        actividadGuardada = actividad1;
//        try {
//            actividadesLimpiezaDAO.eliminarActividad(new ActividadLimpiezaDTO(
//                    actividad2.getId().toString(),
//                    null,
//                    null,
//                    null,
//                    null));
//        } catch (NoEncontradoException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//public void testObtenerActividadSolapada() throws NoEncontradoException {
//    // Preparar los datos de prueba
//    ZonaDTO zonaDTO = new ZonaDTO(1, "Biblioteca");
//    zonaGuardada = zonasDAO.agregarZona(zonaDTO);
//    PersonalDTO personalDTO = new PersonalDTO(null, "Ana López");
//    personalGuardado = personalDAO.registrarPersonal(new PersonalDTO("Ana López", Puesto.LIMPIEZA.toString(), "6677889900", "ana@mail.com"));    
//
//    // Registrar una actividad inicial
//    Date fechaInicio = new Date();
//    Date fechaFin = new Date(System.currentTimeMillis() + 3600000); // 1 hora después
//    ActividadLimpiezaDTO actividadInicial = new ActividadLimpiezaDTO(
//        null,
//        zonaDTO,
//        personalDTO,
//        fechaInicio,
//        fechaFin
//    );
//    actividadGuardada = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadInicial);
//
//    // Crear una actividad que se solapa en tiempo
//    Date fechaInicioSolapa = new Date(fechaInicio.getTime() + 1800000); // 30 minutos después
//    Date fechaFinSolapa = new Date(fechaInicioSolapa.getTime() + 3600000); // 1 hora después
//    ActividadLimpiezaDTO actividadSolapa = new ActividadLimpiezaDTO(
//        null,
//        zonaDTO,
//        personalDTO,
//        fechaInicioSolapa,
//        fechaFinSolapa
//    );
//
//    // Buscar la actividad solapada
//    ActividadLimpieza actividadEncontrada = actividadesLimpiezaDAO.obtenerActividadSolapada(actividadSolapa);
//
//    // Verificaciones
//    assertNotNull(actividadEncontrada, "Debería encontrar una actividad solapada");
//    assertEquals(actividadGuardada.getId(), actividadEncontrada.getId(), 
//        "La actividad encontrada debería ser la misma que se registró inicialmente");
//    assertEquals(zonaGuardada.getId(), actividadEncontrada.getZona().getId(), 
//        "La zona de la actividad debería coincidir");
//    assertEquals(personalGuardado.getId(), actividadEncontrada.getPersonal().getId(), 
//        "El personal de la actividad debería coincidir");
//
//    // Verificar que no encuentra solapamiento en horario diferente
//    Date fechaInicioNoSolapa = new Date(fechaFin.getTime() + 3600000); // 1 hora después de la actividad inicial
//    Date fechaFinNoSolapa = new Date(fechaInicioNoSolapa.getTime() + 3600000);
//    ActividadLimpiezaDTO actividadNoSolapa = new ActividadLimpiezaDTO(
//        null,
//        zonaDTO,
//        personalDTO,
//        fechaInicioNoSolapa,
//        fechaFinNoSolapa
//    );
//
//    ActividadLimpieza actividadNoEncontrada = actividadesLimpiezaDAO.obtenerActividadSolapada(actividadNoSolapa);
//    assertNull(actividadNoEncontrada, "No debería encontrar actividad solapada en horario diferente");
//}
//
//    @Test
//    public void testObtenerActividadesPorFiltro() throws NoEncontradoException {
//        // Preparar los datos de prueba
//        ZonaDTO zonaDTO = new ZonaDTO(3, "Sala de Estudio");
//        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
//        zonaDTO.setId(zonaGuardada.getId().toString());
//
//        PersonalDTO personalDTO = new PersonalDTO("Ana García", Puesto.LIMPIEZA.toString(), "5544332211",
//                "ana@correo.com");
//        personalGuardado = personalDAO.registrarPersonal(personalDTO);
//        personalDTO.setId(personalGuardado.getId().toString());
//
//        // Crear y registrar dos actividades
//        ActividadLimpiezaDTO actividadDTO1 = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(),
//                new Date(System.currentTimeMillis() + 3600000));
//
//        ActividadLimpiezaDTO actividadDTO2 = new ActividadLimpiezaDTO(
//                null,
//                new ZonaDTO(zonaGuardada.getPiso(), zonaGuardada.getNombre()),
//                new PersonalDTO(null, personalGuardado.getNombre()),
//                new Date(System.currentTimeMillis() + 7200000),
//                new Date(System.currentTimeMillis() + 10800000));
//
//        actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO1);
//        actividadGuardada = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadDTO2);
//
//        // Buscar actividades por diferentes filtros
//        List<ActividadLimpieza> actividadesPorZona = actividadesLimpiezaDAO.obtenerActividadesPorFiltro("Sala");
//        List<ActividadLimpieza> actividadesPorPersonal = actividadesLimpiezaDAO.obtenerActividadesPorFiltro("Ana");
//
//        // Verificar resultados
//        assertNotNull(actividadesPorZona);
//        assertFalse(actividadesPorZona.isEmpty());
//        assertTrue(actividadesPorZona.size() >= 2);
//
//        assertNotNull(actividadesPorPersonal);
//        assertFalse(actividadesPorPersonal.isEmpty());
//        assertTrue(actividadesPorPersonal.size() >= 2);
//
//        // Verificar que las actividades encontradas son las correctas
//        assertTrue(actividadesPorZona.stream()
//                .allMatch(a -> a.getZona().getNombre().contains("Sala")));
//        assertTrue(actividadesPorPersonal.stream()
//                .allMatch(a -> a.getPersonal().getNombre().contains("Ana")));
//    }
//}