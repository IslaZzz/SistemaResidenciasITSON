/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import dto.ReporteDTO;
import entities.Habitacion;
import entities.Reporte;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.conversions.Bson;

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
    public ReporteDTO registrarReporte(ReporteDTO reporte) {
        MongoCollection<Reporte> coleccion = obtenerColeccion();
        String estadoDefault = "PENDIENTE";
        HabitacionesDAOImp habitacionDAO = new HabitacionesDAOImp();
        Habitacion habitacion = habitacionDAO.obtenerHabitacionPorPisoYNumero(reporte.getPiso(), reporte.getHabitacion());
        Reporte nuevoReporte = new Reporte(
                reporte.getPiso(),
                habitacion,
                reporte.getResidente(),
                reporte.getHorarioVisita(),
                reporte.getDescripcionProblema(),
                reporte.getFechaHoraReporte(),
                estadoDefault
        );
        coleccion.insertOne(nuevoReporte);

        ReporteDTO reporteCopia = new ReporteDTO(
                String.valueOf(habitacion.getPiso()),
                String.valueOf(habitacion.getNumero()),
                nuevoReporte.getResidente(),
                nuevoReporte.getHorarioVisita(),
                nuevoReporte.getDescripcionProblema(),
                nuevoReporte.getFechaHoraReporte(),
                nuevoReporte.getEstadoReporte()
        );
        return reporteCopia;
    }

    /**
     * Comprueba si ya existe **algún** reporte de mantenimiento con estado
     * {@code "PENDIENTE"} para la misma habitación (piso y número) indicada en
     * el {@link ReporteDTO} recibido.
     *
     * @param reporte objeto {@code ReporteDTO} que incluye el piso y el número
     * de la habitación a verificar.
     * @return {@code true} si se encontró al menos un reporte pendiente para
     * esa habitación; {@code false} en caso contrario.
     */
    @Override
    public boolean verificarExistenciaReportePendiente(ReporteDTO reporte) {
        MongoCollection<Reporte> coleccion = obtenerColeccion();

        List<Bson> pipeline = Arrays.asList(
                // 1. Filtrar por ubicación (piso y número de habitación)
                Aggregates.match(Filters.and(
                        Filters.eq("habitacion.piso", Integer.parseInt(reporte.getPiso())),
                        Filters.eq("habitacion.numero", Integer.parseInt(reporte.getHabitacion()))
                )),
                // 2. Filtrar por estado pendiente
                Aggregates.match(Filters.eq("estadoReporte", "PENDIENTE")),
                // 3. Optimización: solo queremos saber si existe uno
                Aggregates.limit(1)
        );

        // Ejecutar el pipeline y verificar si hay resultados
        AggregateIterable<Reporte> resultados = coleccion.aggregate(pipeline, Reporte.class);

        return resultados.iterator().hasNext();
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
