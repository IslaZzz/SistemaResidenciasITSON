/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTO_Infraestructura.AlumnoInfDTO;
import administradorHabitaciones.AdministradorHabitacionesFachada;
import administradorHabitaciones.IAdministradorHabitaciones;
import administradorResidentes.AdministradorResidentesDosFachada;
import administradorResidentes.IAdministradorResidentes;
import administradorResidentes.IAdministradorResidentesDos;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;
import presentacion.FrmReporteMantenimiento;

/**
 * Controlador para gestionar el flujo de reportes de mantenimiento. Administra
 * la interaccion con la pantalla de reportes y consulta informacion de pisos
 * disponibles a traves de la fachada de administrador de habitaciones.
 *
 * @author rauln
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
     * @return Lista de numeros de pisos disponibles
     */
    public List<Integer> obtenerPisos() {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerTodosLosPisos();
    }

    public List<Integer> obtenerHabitacionesPorPiso(Integer piso) {
        IAdministradorHabitaciones adminHabitaciones = new AdministradorHabitacionesFachada();
        return adminHabitaciones.obtenerHabitacionesDisponiblesEnPiso(piso);
    }

    public List<String> obtenerResidentesPorHabitacion(Integer piso, Integer habitacion) {
        // Crea una instancia de la fachada
        IAdministradorResidentesDos adminResidentes = new AdministradorResidentesDosFachada();

        // Llama al método de la fachada y retorna la lista de residentes
        return adminResidentes.obtenerResidentesPorHabitacion(piso, habitacion);
    }

    public List<String> generarHorarios() {
        List<String> horarios = new ArrayList<>();
        for (int hora = 7; hora <= 18; hora++) {
            horarios.add(String.format("%02d:00", hora));
        }
        return horarios;
    }

    public List<String> obtenerHorariosPosteriores(String horaReferencia) {
        int horaInt = Integer.parseInt(horaReferencia.split(":")[0]);
        List<String> horariosPosteriores = new ArrayList<>();
        for (int hora = horaInt + 1; hora <= 18; hora++) {
            horariosPosteriores.add(String.format("%02d:00", hora));
        }
        return horariosPosteriores;
    }

    public String fusionarHorarios(String inicio, String fin) {
        return inicio + " A " + fin;
    }
}
