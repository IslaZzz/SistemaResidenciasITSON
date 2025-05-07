package implementaciones;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dto.ResidenteDTO;

import static com.mongodb.client.model.Filters.eq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

import entities.Residente;

/**
 *
 * @author pc
 */
public class ResidentesDAOImpTest {
    
    public ResidentesDAOImpTest() {
    }
    
    private final ResidentesDAOImp residentesDAO = new ResidentesDAOImp();
    private static Residente residenteGuardado;
    private static ResidenteDTO residenteDTO;
    
    @BeforeAll
    public static void activarModoPruebas(){
        ManejadorConexiones.activateTestMode();
    }

    @AfterAll
    public static void desactivarModoPruebas(){
        ManejadorConexiones.deactivateTestMode();
    }
    
    private static final String NOMBRE_COMPLETO = "John Doe";
    private static final String MATRICULA = "00000252687";
    private static final char GENERO = 'H';
    private static final String CORREO = "johndoe.123@gmail.com";
    private static final String CARRERA = "Ingenieria en Software";
    private static final String TELEFONO = "6441231231";
    private static final int SEMESTRE = 4;
    private static final String DIRECCION = "John St 1234";
    
    @BeforeAll
    public static void configurarResidente(){
        residenteDTO = new ResidenteDTO(
                MATRICULA,
                NOMBRE_COMPLETO,
                GENERO,
                SEMESTRE,
                CARRERA,
                CORREO,
                TELEFONO,
                DIRECCION
        );
    }
    
    
    @AfterEach
    public void limpiarDB(){
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Residente> residentes = db.getCollection("residentes", Residente.class);
        residentes.deleteOne(eq("_id", residenteGuardado.getId()));
    }
    
    /**
     * Test of registrarResidente method, of class ResidentesDAOImp.
     */
    @Test
    public void testRegistrarResidente() {
        System.out.println("registrarResidente");
        residenteGuardado = residentesDAO.registrarResidente(residenteDTO);
        assertNotNull(residenteGuardado);
        assertEquals(NOMBRE_COMPLETO, residenteGuardado.getNombreCompleto());
        assertEquals(MATRICULA, residenteGuardado.getMatricula());
        assertEquals(GENERO, residenteGuardado.getGenero());
        assertEquals(CORREO, residenteGuardado.getCorreo());
        assertEquals(CARRERA, residenteGuardado.getCarrera());
        assertEquals(TELEFONO, residenteGuardado.getTelefono());
        assertEquals(SEMESTRE, residenteGuardado.getSemestre());
        assertEquals(DIRECCION, residenteGuardado.getDireccion());
    }
    
}
