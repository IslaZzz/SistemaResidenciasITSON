package implementaciones;

import java.util.LinkedList;
import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.HabitacionDTO;
import dto.PersonalDTO;
import dto.ResidenteDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import entities.Personal;
import entities.Residente;
import entities.Zona;
import enums.Puesto;
import exceptions.NoEncontradoException;
import interfaz.IAccesoDatos;
import interfaz.IActividadesLimpiezaDAO;
import interfaz.IHabitacionesDAO;
import interfaz.IPersonalDAO;
import interfaz.IRelacionResidentesHabitacionDAO;
import interfaz.IResidentesDAO;
import interfaz.IZonasDAO;

public class AccesoDatosFachada implements IAccesoDatos {

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
     * DAO para manejar los datos de las zonas en la base de datos
     */
    private final IZonasDAO zonasDAO = new ZonasDAOImp();

    /**
     * DAO para manejar los datos del personal en la base de datos.
     */
    private final IPersonalDAO personalDAO = new PersonalDAOImp();

    /**
     * DAO para manejar las actividades de limpieza en la base de datos.
     */
    private final IActividadesLimpiezaDAO actividadesLimpiezaDAO = new ActividadesLimpiezaDAOImp();

    /**
     * Registra un nuevo residente en la base de datos
     * 
     * @param residente Residente a registrar
     * @return Residente registrado.
     */
    @Override
    public Residente registrarResidente(ResidenteDTO residente) {
        return this.residentesDAO.registrarResidente(residente);
    }

    /**
     * Obtiene un residente a partir de su matricula
     * 
     * @param matricula Matricula del residente
     * @return DTO con los datos del residente
     */
    @Override
    public ResidenteDTO obtenerResidente(String matricula) {
        return this.residentesDAO.obtenerResidente(matricula);
    }

    /**
     * Asigna una habitacion a un residente
     * 
     * @param residente  residente a asignar en la habitación
     * @param habitacion habitacion a asignar
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
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

    @Override
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) {
        return this.habitacionesDAO.obtenerHabitacionesRecomendadas(residente, piso);
    }

    @Override
    public Zona registrarZona(ZonaDTO zona) {
        return this.zonasDAO.agregarZona(zona);
    }

    @Override
    public ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException {
        return this.zonasDAO.obtenerZona(zona);
    }

    @Override
    public List<ZonaDTO> obtenerZonas() {
        return this.zonasDAO.obtenerZonas();
    }

    @Override
    public PersonalDTO registrarPersonal(PersonalDTO personal) {
        Personal personalRegistrado = personalDAO.registrarPersonal(personal);
        PersonalDTO personalDTO = new PersonalDTO(
                personalRegistrado.getId().toString(),
                personalRegistrado.getNombre(),
                personalRegistrado.getPuesto().toString(),
                personalRegistrado.getTelefono(),
                personalRegistrado.getCorreo());
        return personalDTO;
    }

    @Override
    public PersonalDTO obtenerPersonal(PersonalDTO personal) throws NoEncontradoException {
        Personal personalObtenido = personalDAO.obtenerPersonal(personal);
        PersonalDTO personalDTO = new PersonalDTO(
                personalObtenido.getId().toString(),
                personalObtenido.getNombre(),
                personalObtenido.getPuesto().toString(),
                personalObtenido.getTelefono(),
                personalObtenido.getCorreo());
        return personalDTO;
    }

    @Override
    public List<PersonalDTO> obtenerPersonalPorPuesto(String puesto) {
        List<Personal> personalObtenido = personalDAO.obtenerPersonalPorPuesto(Puesto.valueOf(puesto));
        List<PersonalDTO> listaPersonal = new LinkedList<>();
        for (Personal personal : personalObtenido) {
            PersonalDTO personalDTO = new PersonalDTO(
                    personal.getId().toString(),
                    personal.getNombre(),
                    personal.getPuesto().toString(),
                    personal.getTelefono(),
                    personal.getCorreo());
            listaPersonal.add(personalDTO);
        }
        return listaPersonal;
    }

    @Override
    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza, ZonaDTO zona, PersonalDTO personal) throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaRegistrada = actividadesLimpiezaDAO.registrarActividadLimpieza(actividadLimpieza, zona, personal);
        ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                actividadLimpiezaRegistrada.getId().toString(),
                actividadLimpiezaRegistrada.getIdZona().toString(),
                actividadLimpiezaRegistrada.getIdPersonal().toString(),
                actividadLimpiezaRegistrada.getFechaInicio(),
                actividadLimpiezaRegistrada.getFechaFin());
        return actividadLimpiezaDTO;
    }

    @Override
    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException{
        ActividadLimpieza actividadLimpiezaObtenida = actividadesLimpiezaDAO.obtenerActividad(actividadLimpieza);
        ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                actividadLimpiezaObtenida.getId().toString(),
                actividadLimpiezaObtenida.getIdZona().toString(),
                actividadLimpiezaObtenida.getIdPersonal().toString(),
                actividadLimpiezaObtenida.getFechaInicio(),
                actividadLimpiezaObtenida.getFechaFin());
        return actividadLimpiezaDTO;
    }

    @Override
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        List<ActividadLimpieza> actividadesLimpiezaObtenidas = actividadesLimpiezaDAO.obtenerActividadesLimpieza();
        List<ActividadLimpiezaDTO> listaActividadesLimpieza = new LinkedList<>();
        for (ActividadLimpieza actividad : actividadesLimpiezaObtenidas) {
            ActividadLimpiezaDTO actividadDTO = new ActividadLimpiezaDTO(
                    actividad.getId().toString(),
                    actividad.getIdZona().toString(),
                    actividad.getIdPersonal().toString(),
                    actividad.getFechaInicio(),
                    actividad.getFechaFin());
            listaActividadesLimpieza.add(actividadDTO);
        }
        return listaActividadesLimpieza;
    }

    @Override
    public boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException {
        return actividadesLimpiezaDAO.eliminarActividad(actividadLimpieza);
    }

    @Override
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorPersonalYHora(ActividadLimpiezaDTO actividadLimpieza, PersonalDTO personal) throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaObtenida = actividadesLimpiezaDAO.obtenerActividadPorPersonalYHora(actividadLimpieza, personal);
        if(actividadLimpiezaObtenida != null) {
            ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                    actividadLimpiezaObtenida.getId().toString(),
                    actividadLimpiezaObtenida.getIdZona().toString(),
                    actividadLimpiezaObtenida.getIdPersonal().toString(),
                    actividadLimpiezaObtenida.getFechaInicio(),
                    actividadLimpiezaObtenida.getFechaFin());
            return actividadLimpiezaDTO;
        } else {
            return null;
        }
    }

    @Override
    public ActividadLimpiezaDTO obtenerActividadLimpiezaPorZonaYHora(ActividadLimpiezaDTO actividadLimpieza, ZonaDTO zona) throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaObtenida = actividadesLimpiezaDAO.obtenerActividadPorZonaYHora(actividadLimpieza, zona);
        if(actividadLimpiezaObtenida != null) {
            ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                    actividadLimpiezaObtenida.getId().toString(),
                    actividadLimpiezaObtenida.getIdZona().toString(),
                    actividadLimpiezaObtenida.getIdPersonal().toString(),
                    actividadLimpiezaObtenida.getFechaInicio(),
                    actividadLimpiezaObtenida.getFechaFin());
            return actividadLimpiezaDTO;
        } else {
            return null;
        }
    }

}
