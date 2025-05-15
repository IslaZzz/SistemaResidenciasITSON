package control;

import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesFachada;
import administradorResidentes.IAdministradorResidentes;
import dto.ReporteDTO;
import entities.Reporte;
import excepciones.NegocioException;
import itson.negocios_administradorreportes.AdministradorReportesFachada;
import itson.negocios_administradorreportes.IAdministradorReportes;
import java.util.ArrayList;
import java.util.List;
import presentacion.FrmReporteMantenimiento;

/**
 * Controlador para gestionar el flujo de reportes de mantenimiento. Administra
 * la interacción con la pantalla de reportes y consulta información de pisos,
 * habitaciones y residentes, así como el registro de reportes.
 *
 * Se comunica con las fachadas correspondientes para manejar la lógica de
 * negocio y acceder a los datos necesarios.
 *
 * Este controlador forma parte del patrón MVC, actuando como intermediario
 * entre la vista y el modelo.
 *
 */
public class ControlReporteMantenimiento {

    /**
     * Ventana para gestionar reportes de mantenimiento.
     */
    private FrmReporteMantenimiento frameReporteMantenimiento;

    /**
     * Constructor que inicializa la pantalla de reportes de mantenimiento. Crea
     * una instancia de FrmReporteMantenimiento asociada a este controlador.
     */
    public ControlReporteMantenimiento() {
        frameReporteMantenimiento = new FrmReporteMantenimiento(this);
    }

    /**
     * Inicia el flujo mostrando la pantalla de reportes de mantenimiento.
     * Configura la ventana como no redimensionable y centrada en la pantalla.
     */
    public void iniciarFlujo() {
        frameReporteMantenimiento.setVisible(true);
        frameReporteMantenimiento.setResizable(false);
        frameReporteMantenimiento.setLocationRelativeTo(null);
    }

    /**
     * Obtiene una lista de todos los pisos disponibles.
     *
     * @return lista de números de pisos disponibles.
     */
    public List<Integer> obtenerPisos() {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    /**
     * Obtiene una lista de habitaciones disponibles en un piso específico.
     *
     * @param piso el número del piso.
     * @return lista de números de habitaciones disponibles en el piso.
     */
    public List<Integer> obtenerHabitacionesPorPiso(Integer piso) {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesEnPiso(piso);
    }

    /**
     * Obtiene los nombres de los residentes asignados a una habitación
     * específica.
     *
     * @param piso el número de piso.
     * @param habitacion el número de habitación.
     * @return lista de nombres de los residentes.
     */
    public List<String> obtenerResidentesPorHabitacion(Integer piso, Integer habitacion) {
        IAdministradorResidentes adminResidentes = new AdministradorResidentesFachada();
        return adminResidentes.obtenerResidentesPorHabitacion(piso, habitacion);
    }

    /**
     * Genera una lista de horarios posibles para seleccionar como hora de
     * inicio.
     *
     * @return lista de horarios en formato "HH:00" desde las 07:00 hasta las
     * 18:00.
     */
    public List<String> generarHorarios() {
        List<String> horarios = new ArrayList<>();
        for (int hora = 7; hora <= 18; hora++) {
            horarios.add(String.format("%02d:00", hora));
        }
        return horarios;
    }

    /**
     * Obtiene una lista de horarios posteriores a una hora de inicio
     * específica. Utilizado para limitar las opciones de hora de fin.
     *
     * @param horaReferencia la hora de inicio seleccionada (formato "HH:00").
     * @return lista de horarios posteriores en formato "HH:00".
     */
    public List<String> obtenerHorariosPosteriores(String horaReferencia) {
        int horaInt = Integer.parseInt(horaReferencia.split(":")[0]);
        List<String> horariosPosteriores = new ArrayList<>();
        for (int hora = horaInt + 1; hora <= 18; hora++) {
            horariosPosteriores.add(String.format("%02d:00", hora));
        }
        return horariosPosteriores;
    }

    /**
     * Une dos horarios para formar un rango, usado en el campo de horario
     * preferente.
     *
     * @param inicio la hora de inicio (formato "HH:00").
     * @param fin la hora de fin (formato "HH:00").
     * @return cadena con el formato "HH:00 A HH:00".
     */
    public String fusionarHorarios(String inicio, String fin) {
        return inicio + " A " + fin;
    }

    /**
     * Intenta registrar un nuevo reporte de mantenimiento usando la fachada de
     * reportes.
     *
     * @param reporte el objeto {@link ReporteDTO} con los datos del reporte.
     * @return 
     * @throws NegocioException si ya existe un reporte pendiente o ocurre un
     * error lógico.
     */
    public ReporteDTO registrarReporte(ReporteDTO reporte) throws NegocioException {
        IAdministradorReportes adminReportes = new AdministradorReportesFachada();
        ReporteDTO nuevoReporte = adminReportes.registrarReporte(reporte);
        return nuevoReporte;
    }
    
    public void enviarReportePorWhatsapp(ReporteDTO reporteDTO) throws NegocioException{
        IAdministradorReportes adminireportes = new AdministradorReportesFachada();
        adminireportes.enviarReportePorWhatsapp(reporteDTO);
    }

    /**
     * Termina el flujo actual, cierra la ventana de reporte y regresa al flujo
     * principal.
     */
    public void acabarCaso() {
        frameReporteMantenimiento.dispose();
        ControlFlujo.iniciarFlujo();
    }
    
}
