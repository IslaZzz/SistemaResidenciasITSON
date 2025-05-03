package implementaciones;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.data.mongodb.core.MongoOperations;
import pojo.Residente;

/**
 *
 * @author pc
 */
public class ResidentesDAOImpTest {
    
    public ResidentesDAOImpTest() {
    }
    
    private final ResidentesDAOImp residentesDAO = new ResidentesDAOImp();
    private static final Residente residente = new Residente();
    
    @BeforeAll
    public static void activarModoPruebas(){
        ManejadorConexiones.activateTestMode();
    }
    
    private static final String NOMBRE_COMPLETO = "John Doe";
    private static final String MATRICULA = "00000252687";
    private static final char GENERO = 'H';
    private static final String CORREO = "johndoe.123@gmail.com";
    private static final String CARRERA = "Ingenieria en Software";
    private static final String TELEFONO = "6441231231";
    private static final int SEMESTRE = 4;
    private static final String DIRECCION = "John St 1234";
    private static final String NOMBRE_CONTACTO_EMERGENCIA = "Jean Doe";
    private static final String TELEFONO_CONTACTO_EMERGENCIA = "6441231232";
    
    @BeforeAll
    public static void configurarResidente(){
        residente.setNombreCompleto(NOMBRE_COMPLETO);
        residente.setMatricula(MATRICULA);
        residente.setGenero(GENERO);
        residente.setCorreo(CORREO);
        residente.setCarrera(CARRERA);
        residente.setTelefono(TELEFONO);
        residente.setSemestre(SEMESTRE);
        residente.setDireccion(DIRECCION);
        residente.setNombreContactoEmergencia(NOMBRE_CONTACTO_EMERGENCIA);
        residente.setTelefonoContactoEmergencia(TELEFONO_CONTACTO_EMERGENCIA);
    }
    
    
    @AfterEach
    public void limpiarDB(){
        MongoOperations mongoOps = ManejadorConexiones.obtenerConexion();
        mongoOps.dropCollection(Residente.class);
    }
    
    /**
     * Test of registrarResidente method, of class ResidentesDAOImp.
     */
    @Test
    public void testRegistrarResidente() {
        System.out.println("registrarResidente");
        Residente resultado = residentesDAO.registrarResidente(residente);
        assertNotNull(resultado);
        assertEquals(residente.getNombreCompleto(), NOMBRE_COMPLETO);
        assertEquals(residente.getMatricula(), MATRICULA);
        assertEquals(residente.getGenero(), GENERO);
        assertEquals(residente.getCorreo(), CORREO);
        assertEquals(residente.getCarrera(), CARRERA);
        assertEquals(residente.getTelefono(), TELEFONO);
        assertEquals(residente.getSemestre(), SEMESTRE);
        assertEquals(residente.getDireccion(), DIRECCION);
        assertEquals(residente.getNombreContactoEmergencia(), NOMBRE_CONTACTO_EMERGENCIA);
        assertEquals(residente.getTelefonoContactoEmergencia(), TELEFONO_CONTACTO_EMERGENCIA);
        
    }
    
}
