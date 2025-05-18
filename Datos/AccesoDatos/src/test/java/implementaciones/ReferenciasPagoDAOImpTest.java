/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
import entities.ReferenciaPago;
import java.math.BigDecimal;
import java.util.Date;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jorge
 */
public class ReferenciasPagoDAOImpTest {

    private ReferenciasPagoDAOImp dao;
    private ReferenciaPagoDTO referencia;

    @BeforeEach
    public void setUp() {
        dao = new ReferenciasPagoDAOImp();
        referencia = new ReferenciaPagoDTO();
        referencia.setFolio("TEST-001");
        referencia.setReferencia("TEST-REF-001");
        referencia.setConcepto("Pago de prueba");
        referencia.setFechaGeneracion(new Date());
        referencia.setFechaVencimiento(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000));
        referencia.setImporte(new BigDecimal("1000"));

        referencia.setMatriculaResidente("00000252274");
        referencia.setNombreResidente("Juan Pérez");
        referencia.setCarreraResidente("Ingeniería");
        referencia.setCorreoResidente("juan@correo.com");
        referencia.setTipoResidente("NUEVO_INGRESO");
        referencia.setSemestreResidente(4);
        referencia.setGeneroResidente('H');

        referencia.setHabitacion(25);
        referencia.setPiso(1);
    }

    public ReferenciasPagoDAOImpTest() {
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
    public void tearDown() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Document> coleccion = db.getCollection("referenciasPago");
        coleccion.deleteMany(eq("residente._id", "00000252274"));
    }

    /**
     * Test of registrarReferenciaPago method, of class ReferenciasPagoDAOImp.
     */
    @Test
    public void testRegistrarReferenciaPago() {
        ReferenciaPago resultado = dao.registrarReferenciaPago(referencia);
        assertNotNull(resultado.getFolio());
        assertEquals("TEST-001", resultado.getFolio());
    }

    /**
     * Test of existeReferenciaActiva method, of class ReferenciasPagoDAOImp.
     */
    @Test
    public void testExisteReferenciaActiva() {
        dao.registrarReferenciaPago(referencia);
        boolean existe = dao.existeReferenciaActiva(referencia);
        assertTrue(existe);
    }

    /**
     * Test of buscarReferenciaPorMatricula method, of class
     * ReferenciasPagoDAOImp.
     */
    @Test
    public void testBuscarReferenciaPorMatricula() {
        dao.registrarReferenciaPago(referencia);
        ResidenteDTO residente = new ResidenteDTO("00000252274");
        ReferenciaPago encontrada = dao.buscarReferenciaPorMatricula(residente);
        assertNotNull(encontrada);
        assertEquals("00000252274", encontrada.getResidente().getMatricula());
    }

}
