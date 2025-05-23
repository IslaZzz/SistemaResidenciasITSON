package objetosnegocio;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que administra la lógica de negocio relacionada con las habitaciones.
 * Se encarga de agregar, obtener, asignar y liberar residentes en las
 * habitaciones.
 *
 * <p>
 * Esta clase utiliza el patrón Singleton para asegurar una única instancia en
 * toda la aplicación.</p>
 *
 * <p>
 * Además, delega las operaciones de persistencia a una fachada de acceso a
 * datos y realiza validaciones de negocio como la disponibilidad de
 * habitaciones por género y piso.</p>
 */
public class HabitacionBO {

    /**
     * Constante para NUM_MIN_HABITACIONES_MUJER
     */
    private final int NUM_MIN_HABITACIONES_MUJER = 1;
    /**
     * Constante para NUM_MAX_HABITACIONES_MUJER
     */
    private final int NUM_MAX_HABITACIONES_MUJER = 13;
    /**
     * Constante para NUM_MIN_HABITACIONES_HOMBRE
     */
    private final int NUM_MIN_HABITACIONES_HOMBRE = 14;
    /**
     * Constante para NUM_MAX_HABITACIONES_HOMBRE
     */
    private final int NUM_MAX_HABITACIONES_HOMBRE = 25;

    /**
     * Instancia singleton del objeto negocio de habitacion
     */
    private static HabitacionBO habitacionBO;

    /**
     * Devuelve la instancia única de {@code HabitacionBO}.
     *
     * @return la instancia única.
     */
    public static HabitacionBO getInstace() {
        if (habitacionBO == null) {
            habitacionBO = new HabitacionBO();
        }
        return habitacionBO;
    }

    /**
     * Construye una instancia de {@code HabitacionBO} e inicializa el mapa de
     * habitaciones.
     */
    private HabitacionBO() {
        inicializarHabitaciones();
    }

    /**
     * Inicializa las habitaciones en el sistema si no se ha registrado ninguna.
     */
    private void inicializarHabitaciones() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        Long cantidadHabitaciones = accesoDatos.obtenerCantidadHabitaciones();
        if (cantidadHabitaciones == 0) {
            accesoDatos.registrarHabitacionesMasivo(3, 25);
        }
    }

    /**
     * Obtiene la habitación correspondiente a los datos proporcionados.
     *
     * @param habitacion
     * @return el objeto {@link HabitacionDTO} asociado, o {@code null} si no
     * existe.
     * @throws excepciones.NegocioException
     */
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) throws NegocioException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        HabitacionDTO habitacionObtenida = accesoDatos.obtenerHabitacion(habitacion);
        if (habitacionObtenida != null) {
            return habitacionObtenida;
        } else {
            throw new NegocioException("No se encontró ninguna habitación con los datos especificados.");
        }
    }

    /**
     * Obtiene una lista de habitaciones disponibles para un residente.
     *
     * @param residente el objeto {@code ResidenteDTO} que se utilizará para
     * filtrar las habitaciones.
     * @return una lista de objetos {@link HabitacionDTO} disponibles para el
     * residente.
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesParaResidente(ResidenteDTO residente, int piso)
            throws NegocioException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        List<HabitacionDTO> habitacionesDisponibles = accesoDatos.obtenerHabitacionesDisponiblesPorPiso(piso);
        List<HabitacionDTO> habitacionesFiltradas = habitacionesDisponibles.stream()
                .filter(habitacion -> {
                    // Filtrar por género del residente
                    if (residente.getGenero() == 'M') {
                        return habitacion.getNumero() >= NUM_MIN_HABITACIONES_MUJER
                                && habitacion.getNumero() <= NUM_MAX_HABITACIONES_MUJER;
                    } else if (residente.getGenero() == 'H') {
                        return habitacion.getNumero() >= NUM_MIN_HABITACIONES_HOMBRE
                                && habitacion.getNumero() <= NUM_MAX_HABITACIONES_HOMBRE;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        if (habitacionesFiltradas.isEmpty()) {
            throw new NegocioException("No hay habitaciones disponibles");
        } else {
            return habitacionesFiltradas;
        }
    }

    /**
     * Asigna una habitación a un residente.
     *
     * @param residente el residente a asignar.
     * @param habitacion la habitación a asignar.
     */
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.asignarHabitacion(residente, habitacion);
    }

    /**
     * Libera a un residente de una habitación específica.
     *
     * @param residente Residente a liberar
     */
    public void desasignarHabitacion(ResidenteDTO residente) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.deasignarHabitacion(residente);
    }

    /**
     * Obtiene los números de habitación disponibles en un piso específico.
     *
     * @param piso el piso del que se desean obtener los números de habitación.
     * @return una lista de números de habitación disponibles en el piso
     * especificado.
     */
    public List<Integer> obtenerNumerosHabitacionDisponibles(int piso) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        List<HabitacionDTO> habitacionesDisponibles = accesoDatos.obtenerHabitacionesDisponiblesPorPiso(piso);
        return habitacionesDisponibles.stream()
                .map(HabitacionDTO::getNumero)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los pisos registrados en el sistema.
     *
     * @return una lista de pisos únicos registrados.
     */
    public List<Integer> obtenerTodosLosPisos() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerPisosDisponibles();
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente en un
     * piso específico.
     *
     * @param residente el objeto {@code ResidenteDTO} que se utilizará para
     * filtrar las habitaciones.
     * @param piso el piso del que se desean obtener las habitaciones
     * recomendadas.
     * @return una lista de objetos {@link HabitacionDTO} recomendadas para el
     * residente.
     */
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        List<HabitacionDTO> habitaciones = accesoDatos.obtenerHabitacionesRecomendadas(residente, piso);
        List<HabitacionDTO> habitacionesFiltradas = habitaciones.stream()
                .filter(habitacion -> {
                    // Filtrar por género del residente
                    if (residente.getGenero() == 'M') {
                        return habitacion.getNumero() >= NUM_MIN_HABITACIONES_MUJER
                                && habitacion.getNumero() <= NUM_MAX_HABITACIONES_MUJER;
                    } else if (residente.getGenero() == 'H') {
                        return habitacion.getNumero() >= NUM_MIN_HABITACIONES_HOMBRE
                                && habitacion.getNumero() <= NUM_MAX_HABITACIONES_HOMBRE;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return habitacionesFiltradas;
    }

}
