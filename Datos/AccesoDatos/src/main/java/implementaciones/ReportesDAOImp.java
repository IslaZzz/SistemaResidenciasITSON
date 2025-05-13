/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.ReporteDTO;
import entities.Reporte;

/**
 *
 * @author rauln
 */
public class ReportesDAOImp implements interfaz.IReportesDAO {

    @Override
    public Reporte registrarReporte(ReporteDTO reporte) {
        MongoCollection<Reporte> coleccion = obtenerColeccion();
        Reporte nuevoReporte = new Reporte(
                reporte.getPiso(),
                reporte.getHabitacion(),
                reporte.getResidente(),
                reporte.getHorarioVisita(),
                reporte.getDescripcionProblema(),
                reporte.getFechaHoraReporte()
        );
        coleccion.insertOne(nuevoReporte);
        return nuevoReporte;
    }

    private MongoCollection<Reporte> obtenerColeccion() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Reporte> reporte = db.getCollection("reporte", Reporte.class);
        return reporte;
    }

}
