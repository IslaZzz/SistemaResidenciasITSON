package implementaciones;

import java.util.List;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import entities.Residente;
import interfaz.IAccesoDatos;
import interfaz.IHabitacionesDAO;
import interfaz.IResidentesDAO;

public class AccesoDatosFachada implements IAccesoDatos{

    /**
     * DAO para manejar los datos de los residentes en la base de datos
     */
    private IResidentesDAO residentesDAO;
    
    /**
     * DAO para manejar los datos de las habitaciones en la base de datos
     */
    private IHabitacionesDAO habitacionesDAO;
    
    /**
     * Constructor de la fachada de acceso a datos
     */
    public AccesoDatosFachada(){
        this.residentesDAO = new ResidentesDAOImp();
        this.habitacionesDAO = new HabitacionesDAOImp();
    }
    
    /**
     * Registra un nuevo residente en la base de datos
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
     * @param residenteDTO residente a asignar en la habitación
     * @param habitacionDTO habitacion a asignar
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion){
        this.residentesDAO.asignarHabitacion(residente.getMatricula(), habitacion.getIdHabitacion());
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

    
    
}
