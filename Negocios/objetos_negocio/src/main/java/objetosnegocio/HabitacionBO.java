package objetosnegocio;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que administra la lógica de negocio relacionada con las habitaciones.
 * Se encarga de agregar, obtener, asignar y liberar residentes en las habitaciones.
 */
public class HabitacionBO {

    /**
     * Mapa que almacena las habitaciones registradas.
     * La clave es el identificador único de la habitación (idHabitacion).
     */
    private List<HabitacionDTO> habitacionesMock;

    /**
     * Construye una instancia de {@code HabitacionBO} e inicializa el mapa de habitaciones.
     */
    public HabitacionBO() {
        this.habitacionesMock = new LinkedList<>();
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j<= 25; j++){
                HabitacionDTO habitacion = new HabitacionDTO(Integer.toString(i), j);
                this.agregarHabitacion(habitacion);
            }
        }
    }

    /**
     * Agrega una habitación al sistema.
     * @param habitacion el objeto {@code HabitacionDTO} que se agregará.
     */
    private void agregarHabitacion(HabitacionDTO habitacion) {
        habitacionesMock.add(habitacion);
    }
    
    /**
     * Obtiene la habitación correspondiente a los datos proporcionados.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return el objeto {@link HabitacionDTO} asociado, o {@code null} si no existe.
     */
    public HabitacionDTO obtenerHabitacion(String piso, int numeroHabitacion) throws NegocioException {
        boolean encontrado = this.habitacionesMock.stream().anyMatch( (h) -> h.getPiso().equals(piso) && h.getNumeroHabitacion() == numeroHabitacion);
        if(encontrado){
             List<HabitacionDTO> habitacion = 
                     this.habitacionesMock.stream().
                             filter( (h) -> h.getPiso().equals(piso) && h.getNumeroHabitacion() == numeroHabitacion).collect(Collectors.toList());
             if(habitacion.size()> 1){
                 throw new NegocioException("Se encontró más de una habitación con las especifiaciones");
             }
             return habitacion.getFirst();
        } else {
            throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
        }
    }
        
    /**
     * Obtiene una lista de habitaciones disponibles para un residente.
     * @param residente el objeto {@code ResidenteDTO} que se utilizará para filtrar las habitaciones.
     * @return una lista de objetos {@link HabitacionDTO} disponibles para el residente.
     */
    public List<HabitacionDTO> obtenerHabitacionesDisponibles(ResidenteDTO residente){
        return this.habitacionesMock.stream()
            .filter(habitacion -> {
                // Filtrar por género del residente
                if (residente.getGenero() == 'M') {
                    return habitacion.getNumeroHabitacion() >= 1 && habitacion.getNumeroHabitacion() <= 13;
                } else if (residente.getGenero() == 'H') {
                    return habitacion.getNumeroHabitacion() >= 14 && habitacion.getNumeroHabitacion() <= 25;
                }
                return false;
            })
            .filter(habitacion -> habitacion.getResidentesActuales().size() < 2) // Filtrar habitaciones con menos de 2 residentes
            .collect(Collectors.toList());
    }

    /**
     * Asigna un residente a una habitación si no ha alcanzado su capacidad máxima.
     * @param idResidente la matrícula del residente.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return {@code true} si el residente fue asignado, {@code false} si la habitación está llena o no existe.
     */
    public boolean asignarResidente(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        HabitacionDTO habitacion = obtenerHabitacion(piso, numeroHabitacion);

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
    }

    /**
     * Libera a un residente de una habitación específica.
     * @param idResidente la matrícula del residente.
     * @param piso El piso de la habitación
     * @param numeroHabitacion El numero de la habitación
     * @return {@code true} si el residente fue removido, {@code false} si no se encontraba en la habitación.
     */
    public boolean liberarResidente(String idResidente, String piso, int numeroHabitacion) throws NegocioException {
        HabitacionDTO habitacion = obtenerHabitacion(piso, numeroHabitacion);

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
    }
}
