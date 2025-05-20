//package implementaciones;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//import dto.ResidenteDTO;
//import enums.TipoResidente; // Ensure this import is correct
//
//import static com.mongodb.client.model.Filters.eq;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterAll;
//
//import entities.Residente;
//
//public class ResidentesDAOImpTest {
//
//    public ResidentesDAOImpTest() {
//    }
//
//    private final ResidentesDAOImp residentesDAO = new ResidentesDAOImp();
//    private static Residente residenteGuardado; 
//    private static ResidenteDTO residenteDTO_Base; 
//
//    private static final String MATRICULA_TEST = "00000252687";
//    private static final String NOMBRE_COMPLETO_TEST = "John Doe";
//    private static final char GENERO_TEST = 'H';
//    private static final String CORREO_TEST = "johndoe.123@gmail.com";
//    private static final String CARRERA_TEST = "Ingenieria en Software";
//    private static final String TELEFONO_TEST = "6441231231";
//    private static final int SEMESTRE_TEST = 4;
//    private static final String DIRECCION_TEST = "John St 1234";
//    private static final String NOMBRE_CONTACTO_EMERGENCIA_TEST = "Jane Doe";
//    private static final String TELEFONO_CONTACTO_EMERGENCIA_TEST = "6443213210";
//    private static final String TIPO_RESIDENTE_TEST = TipoResidente.NUEVO_INGRESO.toString();
//    private static final String ADEUDO_TEST = "0.00";
//
//    @BeforeAll
//    public static void activarModoPruebasYConfigurarBaseDTO() {
//        ManejadorConexiones.activateTestMode();
//        residenteDTO_Base = new ResidenteDTO(
//                MATRICULA_TEST,
//                NOMBRE_COMPLETO_TEST,
//                GENERO_TEST,
//                SEMESTRE_TEST,
//                CARRERA_TEST,
//                CORREO_TEST,
//                TELEFONO_TEST,
//                DIRECCION_TEST,
//                NOMBRE_CONTACTO_EMERGENCIA_TEST,
//                TELEFONO_CONTACTO_EMERGENCIA_TEST
//        );
//        residenteDTO_Base.setTipoResidente(TIPO_RESIDENTE_TEST);
//        residenteDTO_Base.setAdeudo(ADEUDO_TEST);
//    }
//
//    @AfterAll
//    public static void desactivarModoPruebas() {
//        ManejadorConexiones.deactivateTestMode();
//    }
//
//    @AfterEach
//    public void limpiarDB() {
//        MongoDatabase db = ManejadorConexiones.obtenerConexion();
//        MongoCollection<Residente> residentes = db.getCollection("residentes", Residente.class);
//        residentes.deleteOne(eq("_id", MATRICULA_TEST));
//        residentes.deleteOne(eq("_id", "MATRICULA_ACTUALIZAR")); 
//        if (residenteGuardado != null && !residenteGuardado.getMatricula().equals(MATRICULA_TEST) && !residenteGuardado.getMatricula().equals("MATRICULA_ACTUALIZAR")) {
//            residentes.deleteOne(eq("_id", residenteGuardado.getMatricula()));
//        }
//        residenteGuardado = null; 
//    }
//
//    @Test
//    public void testRegistrarResidente() {
//        System.out.println("registrarResidente");
//        residenteGuardado = residentesDAO.registrarResidente(residenteDTO_Base);
//
//        assertNotNull(residenteGuardado, "El residente guardado no debería ser nulo.");
//        assertEquals(MATRICULA_TEST, residenteGuardado.getMatricula());
//        assertEquals(NOMBRE_COMPLETO_TEST, residenteGuardado.getNombreCompleto());
//        assertEquals(GENERO_TEST, residenteGuardado.getGenero());
//        assertEquals(SEMESTRE_TEST, residenteGuardado.getSemestre());
//        assertEquals(CARRERA_TEST, residenteGuardado.getCarrera());
//        assertEquals(CORREO_TEST, residenteGuardado.getCorreo());
//        assertEquals(TELEFONO_TEST, residenteGuardado.getTelefono());
//        assertEquals(DIRECCION_TEST, residenteGuardado.getDireccion());
//        assertEquals(NOMBRE_CONTACTO_EMERGENCIA_TEST, residenteGuardado.getNombreContactoEmergencia());
//        assertEquals(TELEFONO_CONTACTO_EMERGENCIA_TEST, residenteGuardado.getTelefonoContactoEmergencia());
//        assertEquals(TipoResidente.valueOf(TIPO_RESIDENTE_TEST), residenteGuardado.getTipoResidente());
//        assertEquals(ADEUDO_TEST, residenteGuardado.getAdeudo());
//    }
//
//    @Test
//    public void testObtenerResidente_Existente() {
//        System.out.println("obtenerResidente_Existente");
//        residentesDAO.registrarResidente(residenteDTO_Base);
//
//        ResidenteDTO obtenidoDTO = residentesDAO.obtenerResidente(MATRICULA_TEST);
//
//        assertNotNull(obtenidoDTO, "El ResidenteDTO obtenido no debería ser nulo.");
//        assertEquals(MATRICULA_TEST, obtenidoDTO.getMatricula());
//        assertEquals(NOMBRE_COMPLETO_TEST, obtenidoDTO.getNombreCompleto());
//        assertEquals(GENERO_TEST, obtenidoDTO.getGenero());
//        assertEquals(SEMESTRE_TEST, obtenidoDTO.getSemestre());
//        assertEquals(CARRERA_TEST, obtenidoDTO.getCarrera());
//        assertEquals(CORREO_TEST, obtenidoDTO.getCorreo());
//        assertEquals(TELEFONO_TEST, obtenidoDTO.getTelefono());
//        assertEquals(DIRECCION_TEST, obtenidoDTO.getDireccion());
//        assertEquals(NOMBRE_CONTACTO_EMERGENCIA_TEST, obtenidoDTO.getNombreContactoEmergencia());
//        assertEquals(TELEFONO_CONTACTO_EMERGENCIA_TEST, obtenidoDTO.getTelefonoContactoEmergencia());
//        assertEquals(TIPO_RESIDENTE_TEST, obtenidoDTO.getTipoResidente());
//    }
//
//    @Test
//    public void testObtenerResidente_NoExistente() {
//        System.out.println("obtenerResidente_NoExistente");
//        ResidenteDTO obtenidoDTO = residentesDAO.obtenerResidente("MATRICULA_INEXISTENTE");
//        assertNull(obtenidoDTO, "Obtener un residente no existente debería devolver nulo.");
//    }
//
//    @Test
//    public void testActualizarResidente() {
//        System.out.println("actualizarResidente");
//        // Arrange: Register an initial resident
//        ResidenteDTO dtoOriginal = new ResidenteDTO(
//                "MATRICULA_ACTUALIZAR", 
//                "Original Name", 'F', 2, "LCI", "original@mail.com", "111222333", "Original Address",
//                "Original Emergency Contact", "999888777"
//        );
//        dtoOriginal.setTipoResidente(TipoResidente.DEPORTISTA.toString());
//        dtoOriginal.setAdeudo("100.00");
//        residenteGuardado = residentesDAO.registrarResidente(dtoOriginal); 
//
//        ResidenteDTO dtoActualizado = new ResidenteDTO("MATRICULA_ACTUALIZAR");
//        String nuevoNombreEmergencia = "Updated Emergency Contact";
//        String nuevoTelefonoEmergencia = "000111222";
//        String nuevoTipoResidente = TipoResidente.EXTRANJERO.toString();
//        dtoActualizado.setNombreContactoEmergencia(nuevoNombreEmergencia);
//        dtoActualizado.setTelefonoContactoEmergencia(nuevoTelefonoEmergencia);
//        dtoActualizado.setTipoResidente(nuevoTipoResidente);
//
//        residentesDAO.actualizarResidente(dtoActualizado);
//
//        ResidenteDTO residenteVerificadoDTO = residentesDAO.obtenerResidente("MATRICULA_ACTUALIZAR");
//        assertNotNull(residenteVerificadoDTO, "El residente verificado no debería ser nulo después de actualizar.");
//        assertEquals(nuevoNombreEmergencia, residenteVerificadoDTO.getNombreContactoEmergencia(), "El nombre del contacto de emergencia no se actualizó correctamente.");
//        assertEquals(nuevoTelefonoEmergencia, residenteVerificadoDTO.getTelefonoContactoEmergencia(), "El teléfono del contacto de emergencia no se actualizó correctamente.");
//        assertEquals(nuevoTipoResidente, residenteVerificadoDTO.getTipoResidente(), "El tipo de residente no se actualizó correctamente.");
//
//        assertEquals(dtoOriginal.getNombreCompleto(), residenteVerificadoDTO.getNombreCompleto());
//    }
//}