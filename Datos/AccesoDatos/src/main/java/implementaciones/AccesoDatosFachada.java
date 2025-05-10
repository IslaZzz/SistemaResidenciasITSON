package implementaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Residente;
import interfaz.IAccesoDatos;
import interfaz.IHabitacionesDAO;
import interfaz.IRelacionResidentesHabitacionDAO;
import interfaz.IResidentesDAO;

public class AccesoDatosFachada implements IAccesoDatos{

    /**
     * DAO para manejar los datos de los residentes en la base de datos
     */
    private IResidentesDAO residentesDAO = new ResidentesDAOImp();
    
    /**
     * DAO para manejar los datos de las habitaciones en la base de datos
     */
    private final IHabitacionesDAO habitacionesDAO = new HabitacionesDAOImp();
    
    /**
     * DAO para manejar la relacion entre los residentes y las habitaciones
     */
    private final IRelacionResidentesHabitacionDAO relacionResidentesHabitacionDAO = new RelacionResidentesHabitacionDAOImp();

    /**
     * Registra un nuevo residente en la base de datos
     * @param residente Residente a registrar
     * @return Residente registrado.
     */
    @Override
    public Residente registrarResidente(ResidenteDTO residente) {
        return this.residentesDAO.registrarResidente(residente);
    }

    /**
     * Obtiene un residente a partir de su matricula
     * @param matricula Matricula del residente
     * @return DTO con los datos del residente
     */
    @Override
    public ResidenteDTO obtenerResidente(String matricula) {
        return this.residentesDAO.obtenerResidente(matricula);
    }

    /**
     * Asigna una habitacion a un residente
     * @param residente residente a asignar en la habitación
     * @param habitacion habitacion a asignar
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion){
        this.relacionResidentesHabitacionDAO.asignarHabitacion(residente, habitacion);
    }

    @Override
    public void registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso) {
        this.habitacionesDAO.registrarHabitacionesMasivo(numeroPisos, numeroHabitacionesPorPiso);
    }

    @Override
    public Long obtenerCantidadHabitaciones() {
        return this.habitacionesDAO.obtenerCantidadHabitaciones();
    }

    @Override
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) {
        return this.habitacionesDAO.obtenerHabitacion(habitacion);
    }

    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso) {
        return this.habitacionesDAO.obtenerHabitacionesDisponiblesPorPiso(piso);    
    }

    @Override
    public List<Integer> obtenerPisosDisponibles() {
        return this.habitacionesDAO.obtenerPisosDisponibles();
    }

    @Override
    public void deasignarHabitacion(ResidenteDTO residente) {
        this.relacionResidentesHabitacionDAO.desasignarHabitacion(residente);
    }

    
    
}
