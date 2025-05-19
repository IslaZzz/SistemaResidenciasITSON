/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import dto.ReporteDTO;
import entities.Habitacion;
import entities.Reporte;
import interfaz.IAccesoDatos;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author rauln
 */
public class ReportesDAOImpTest {

    private ReportesDAOImp reportesDAOImp = new ReportesDAOImp();
    private static final HabitacionesDAOImp habitacionesDAOImp = new HabitacionesDAOImp();

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
        List<Habitacion> habitacionesParaPrueba = habitacionesDAOImp.registrarHabitacionesMasivo(3, 15);
    }

    @AfterAll
    public static void desactivarModoPruebas() {
        ManejadorConexiones.deactivateTestMode();
    }

    @AfterEach
    public void limpiarBD() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        db.getCollection("reporte").drop();
        db.getCollection("habitaciones").drop();

    }

    @Test
    public void testRegistrarReporteOk() {
        String piso = "2";
        String habitacion = "3";
        String residente = "Ari Raul Montoya Navarro";
        String horarioVisita = "10:00 A 17:00";
        String descripcionProblema = "Enchufe quemado";
        Date fechaHoraReporte = new Date();

        ReporteDTO dtoEntrada = new ReporteDTO(
                piso,
                habitacion,
                residente,
                horarioVisita,
                descripcionProblema,
                fechaHoraReporte
        );
        ReporteDTO dtoSalida = reportesDAOImp.registrarReporte(dtoEntrada);
        assertNotNull(dtoSalida, "Debe devolver un DTO no nulo");
        assertEquals(piso, dtoSalida.getPiso());
        assertEquals(habitacion, dtoSalida.getHabitacion());
        assertEquals(residente, dtoSalida.getResidente());
        assertEquals(horarioVisita, dtoSalida.getHorarioVisita());
        assertEquals(descripcionProblema, dtoSalida.getDescripcionProblema());
        assertEquals(fechaHoraReporte, dtoSalida.getFechaHoraReporte());
        assertEquals("PENDIENTE", dtoSalida.getEstadoReporte());
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Document> colRep = db.getCollection("reporte", Document.class);
        Document doc = colRep.find(and(
                eq("estadoReporte", "PENDIENTE"),
                eq("habitacion.piso", Integer.parseInt(piso)),
                eq("habitacion.numero", Integer.parseInt(habitacion))
        )).first();
        assertNotNull(doc, "El documento persistido no se encontró en la colección 'reporte'");
        // comparar campo a campo
        assertEquals(descripcionProblema, doc.getString("descripcionProblema"));
        assertEquals(horarioVisita, doc.getString("horarioVisita"));
        assertEquals(residente, doc.getString("residente"));
        Document habDoc = doc.get("habitacion", Document.class);
        assertEquals(Integer.parseInt(piso), habDoc.getInteger("piso"));
        assertEquals(Integer.parseInt(habitacion), habDoc.getInteger("numero"));
        assertEquals(
                fechaHoraReporte.getTime(),
                doc.getDate("fechaHoraReporte").getTime(),
                "La fecha/hora del reporte no coincide"
        );

    }

    @Test
    public void testVerificarExistenciaReportePendienteOk() {
        ReportesDAOImp dao = new ReportesDAOImp();
        ReporteDTO reporteExistente = new ReporteDTO(
                "2", // piso
                "3", // habitación
                "Ari Raul Montoya Navarro", // residente
                "10:00 A 17:00", // horario visita
                "Enchufe quemado", // descripción
                new Date() // fecha-hora
        );
        dao.registrarReporte(reporteExistente);
        boolean existePendiente = dao.verificarExistenciaReportePendiente(reporteExistente);
        assertTrue(existePendiente, "Debería existir un reporte pendiente para la habitación 3 del piso 2");
    }

    @Test
    public void testVerificarExistenciaReportePendienteNoExiste() {
        ReportesDAOImp dao = new ReportesDAOImp();
        ReporteDTO reporteNoExistente = new ReporteDTO(
                "5", // piso diferente
                "10", // habitación diferente
                "Otro Residente", // residente
                "09:00 A 12:00", // horario visita
                "Problema inexistente", // descripción
                new Date()
        );
        boolean existePendiente = dao.verificarExistenciaReportePendiente(reporteNoExistente);
        assertFalse(existePendiente, "No debería existir reporte pendiente para la habitación 10 del piso 5");
    }

}
