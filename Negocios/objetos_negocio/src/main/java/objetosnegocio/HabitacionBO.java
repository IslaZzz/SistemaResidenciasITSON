package objetosnegocio;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que administra la lógica de negocio relacionada con las habitaciones.
 * Se encarga de agregar, obtener, asignar y liberar residentes en las habitaciones.
 */
public class HabitacionBO {

    /**
     * Instancia singleton del objeto negocio de habitacion
     */
    private static HabitacionBO habitacionBO;
    
    public static HabitacionBO getInstace(){
        if(habitacionBO == null){
            habitacionBO = new HabitacionBO();
        }
        return habitacionBO;
    }

    /**
     * Construye una instancia de {@code HabitacionBO} e inicializa el mapa de habitaciones.
     */
    private HabitacionBO() {
        inicializarHabitaciones();
    }

    private void inicializarHabitaciones() {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        Long cantidadHabitaciones = accesoDatos.obtenerCantidadHabitaciones();
        if(cantidadHabitaciones == 0){
            accesoDatos.registrarHabitacionesMasivo(3, 75);
        }
    }
    
    /**
     * Obtiene la habitación correspondiente a los datos proporcionados.
     * @param habitacionDTO el objeto {@code HabitacionDTO} que contiene los datos de la habitación.
     * @return el objeto {@link HabitacionDTO} asociado, o {@code null} si no existe.
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
     * @param residente el objeto {@code ResidenteDTO} que se utilizará para filtrar las habitaciones.
     * @return una lista de objetos {@link HabitacionDTO} disponibles para el residente.
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente) throws NegocioException{
        /**
         * List<HabitacionDTO> habitacionesDisponibles = this.habitacionesMock.stream()
            .filter(habitacion -> {
                // Filtrar por género del residente
                if (residente.getGenero() == 'M') {
                    return habitacion.getNumeroHabitacion() >= 1 && habitacion.getNumeroHabitacion() <= 13;
                } else if (residente.getGenero() == 'H') {
                    return habitacion.getNumeroHabitacion() >= 14 && habitacion.getNumeroHabitacion() <= 25;
                }
                return false;
            })
            .filter(habitacion -> {
                if(habitacion.getResidentesActuales() == null){
                    return true;
                } else if(habitacion.getResidentesActuales().size() < 2){
                    return true;
                }
                return false;
            } ) // Filtrar habitaciones con menos de 2 residentes
            .collect(Collectors.toList());
        if(habitacionesDisponibles.isEmpty()){
            throw new NegocioException("No hay habitaciones disponibles");
        } else {
            return habitacionesDisponibles;
        }
            */
            //TODO: Cambiar la lógica para usar la base de datos.
            return new LinkedList<>();
    }

    /**
     * Asigna un residente a una habitación si no ha alcanzado su capacidad máxima.
     * @param idResidente la matrícula del residente.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return {@code true} si el residente fue asignado, {@code false} si la habitación está llena o no existe.
     */
    public boolean asignarResidente(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        /** HabitacionDTO habitacionObtenida = obtenerHabitacion(habitacion);

        if (habitacion != null) {
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            if (habitacion.agregarResidente(residente)) {
                System.out.println("Residente " + idResidente + " asignado a la habitación " + piso + numeroHabitacion);
                return true;
            } else {
                System.out.println("La habitación " + piso + numeroHabitacion + " está llena.");
                return false;
            }
        }
        
        System.out.println("La habitación " + piso + numeroHabitacion + " no existe.");
        return false;
        */
        //TODO: Cambiar la lógica para usar la base de datos.
        return false;
    }

    /**
     * Libera a un residente de una habitación específica.
     * @param idResidente la matrícula del residente.
     * @param habitacion Habitacion a liberar
     * @return {@code true} si el residente fue removido, {@code false} si no se encontraba en la habitación.
     */
    public boolean liberarResidente(String idResidente, HabitacionDTO habitacion) throws NegocioException {
        /**
         * HabitacionDTO habitacion = obtenerHabitacion(piso, numeroHabitacion);

        if (habitacion != null) {
            ResidenteDTO residente = new ResidenteDTO(idResidente);
            
            if (habitacion.removerResidente(residente)) {
                System.out.println("Residente " + idResidente + " liberado de la habitación " + piso + numeroHabitacion);
                return true;
            } else {
                System.out.println("El residente " + idResidente + " no estaba en la habitación " + piso + numeroHabitacion);
                return false;
            }
        }
        
        System.out.println("La habitación "  + piso + numeroHabitacion + " no existe.");
        return false;
        */
        //TODO: Cambiar la lógica para usar la base de datos.
        return false;
    }

    /**
     * Obtiene los números de habitación disponibles en un piso específico.
     * @param habitaciones la lista de habitaciones disponibles.
     * @param piso el piso del que se desean obtener los números de habitación.
     * @return una lista de números de habitación disponibles en el piso especificado.
     */
    public List<Integer> obtenerNumerosHabitacionDisponibles(int piso){
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        List<HabitacionDTO> habitacionesDisponibles = accesoDatos.obtenerHabitacionesDisponiblesPorPiso(piso);
        return habitacionesDisponibles.stream()
                .map(HabitacionDTO::getNumero)
                .distinct()
                .collect(Collectors.toList());
    }
    
     /**
     * Obtiene todos los pisos registrados en el sistema.
     * @return una lista de pisos únicos registrados.
     */
    public List<Integer> obtenerTodosLosPisos() {
        /**
         * return habitacionesMock.stream()
                .map(HabitacionDTO::getPiso)
                .distinct()
                .collect(Collectors.toList());
                */
                //TODO: Cambiar la lógica para usar la base de datos.
        return new LinkedList<>();
    }

}
