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
 * Implementación de la interfaz {@link interfaz.IReportesDAO} que permite
 * registrar reportes de mantenimiento en una base de datos MongoDB.
 *
 * Esta clase se encarga de mapear un objeto {@link ReporteDTO} a un objeto
 * {@link entities.Reporte} y almacenarlo en la colección correspondiente.
 *
 * @author rauln
 */
public class ReportesDAOImp implements interfaz.IReportesDAO {

    /**
     * Registra un nuevo reporte de mantenimiento en la base de datos.
     *
     * @param reporte Objeto {@link ReporteDTO} que contiene los datos del
     * reporte.
     * @return El objeto {@link Reporte} que fue insertado en la base de datos.
     */
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

    /**
     * Obtiene la colección {@code reporte} desde la base de datos MongoDB.
     *
     * @return La colección de objetos {@link Reporte}.
     */
    private MongoCollection<Reporte> obtenerColeccion() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        MongoCollection<Reporte> reporte = db.getCollection("reporte", Reporte.class);
        return reporte;
    }
}
