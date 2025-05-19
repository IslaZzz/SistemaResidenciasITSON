/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dto.ReporteDTO;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author rauln
 */
public class ReportesDAOImpTest {

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
        db.getCollection("reportes").deleteOne(Filters.eq("_id", "s"));
        
    }
    

}
