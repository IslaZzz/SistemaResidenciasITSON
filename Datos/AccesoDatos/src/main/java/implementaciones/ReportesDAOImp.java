/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import dto.ReporteDTO;
import entities.Habitacion;
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
     * Verifica si existe un reporte de mantenimiento con estado "PENDIENTE"
     * para la misma habitación y piso que el proporcionado en el
     * {@code ReporteDTO}.
     *
     * @param reporte el objeto {@link ReporteDTO} que contiene la información
     * de piso y habitación a verificar.
     * @return {@code true} si existe un reporte pendiente para esa ubicación,
     * {@code false} en caso contrario.
     */
    @Override
    public boolean verificarExistenciaReportePendiente(ReporteDTO reporte) {
        MongoCollection<Reporte> coleccion = obtenerColeccion();
        return coleccion.find(
                and(
                        eq("estadoReporte", "PENDIENTE"),
                        eq("piso", reporte.getPiso()),
                        eq("habitacion", reporte.getHabitacion())
                )
        ).first() != null;
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
