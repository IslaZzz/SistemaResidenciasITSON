package implementaciones;

import java.util.LinkedList;
import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.FiadorDTO;
import dto.HabitacionDTO;
import dto.PersonalDTO;
import dto.ReferenciaPagoDTO;
import dto.ReporteDTO;
import dto.ResidenteDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import entities.Fiador;
import entities.Personal;
import entities.ReferenciaPago;
import entities.Residente;
import entities.Zona;
import enums.Puesto;
import exceptions.NoEncontradoException;
import interfaz.IAccesoDatos;
import interfaz.IActividadesLimpiezaDAO;
import interfaz.IFiadorDAO;
import interfaz.IHabitacionesDAO;
import interfaz.IPersonalDAO;
import interfaz.IReferenciasPagoDAO;
import interfaz.IRelacionResidentesHabitacionDAO;
import interfaz.IReportesDAO;
import interfaz.IResidentesDAO;
import interfaz.IZonasDAO;

/**
 * Implementación de la fachada de acceso a los datos. Esta clase maneja la
 * interacción con los diferentes DAO (Data Access Objects) para realizar
 * operaciones relacionadas con residentes, habitaciones, zonas, personal y
 * actividades de limpieza en la base de datos.
 * <p>
 * Proporciona una capa de abstracción sobre los DAO y centraliza las
 * operaciones de acceso a datos que involucran múltiples entidades. Los métodos
 * de esta clase se encargan de coordinar la ejecución de tareas a través de los
 * diferentes objetos de acceso a datos para las operaciones CRUD (crear, leer,
 * actualizar, eliminar).
 * </p>
 * Implementa la interfaz {@link IAccesoDatos}.
 */
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
     * DAO para manejar los datos de los reportes en la base de datos.
     */
    private final IReportesDAO reporteDAO = new ReportesDAOImp();

    /**
     * DAO para manejar los datos de las referencias de pago en la base de
     * datos.
     */
    private final IReferenciasPagoDAO referenciasDAO = new ReferenciasPagoDAOImp();

    /**
     * Registra un nuevo residente en la base de datos
     *
     * @param residente Residente a registrar
     * @return Residente registrado.
     */
    /**
     * DAO para manejar los datos del fiador en la base de datos
     */
    private final IFiadorDAO fiadorDAO = new FiadorDAO();

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
     * @param residente residente a asignar en la habitación
     * @param habitacion habitacion a asignar
     */
    @Override
    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        this.relacionResidentesHabitacionDAO.asignarHabitacion(residente, habitacion);
    }

    /**
     * Registra de manera masiva las habitaciones en la base de datos. Este
     * método utiliza el DAO de habitaciones para registrar un número de
     * habitaciones en función de la cantidad de pisos y habitaciones por piso
     * proporcionados.
     *
     * @param numeroPisos Número de pisos a registrar.
     * @param numeroHabitacionesPorPiso Número de habitaciones por piso.
     */
    @Override
    public void registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso) {
        this.habitacionesDAO.registrarHabitacionesMasivo(numeroPisos, numeroHabitacionesPorPiso);
    }

    /**
     * Obtiene la cantidad total de habitaciones en la base de datos. Este
     * método consulta el DAO de habitaciones para obtener el número total de
     * habitaciones registradas en el sistema.
     *
     * @return La cantidad total de habitaciones registradas en la base de
     * datos.
     */
    @Override
    public Long obtenerCantidadHabitaciones() {
        return this.habitacionesDAO.obtenerCantidadHabitaciones();
    }

    /**
     * Obtiene una habitación específica a partir de los datos proporcionados en
     * el DTO. Este método consulta el DAO de habitaciones para obtener los
     * detalles de una habitación con base en el DTO proporcionado.
     *
     * @param habitacion El DTO que contiene los datos de la habitación a
     * consultar.
     * @return El DTO con los detalles de la habitación solicitada.
     */
    @Override
    public HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion) {
        return this.habitacionesDAO.obtenerHabitacion(habitacion);
    }

    /**
     * Obtiene una lista de habitaciones disponibles en un piso específico. Este
     * método consulta el DAO de habitaciones para obtener todas las
     * habitaciones disponibles en el piso indicado.
     *
     * @param piso El número del piso para consultar las habitaciones
     * disponibles.
     * @return Una lista de DTOs de habitaciones disponibles en el piso
     * indicado.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso) {
        return this.habitacionesDAO.obtenerHabitacionesDisponiblesPorPiso(piso);
    }

    /**
     * Obtiene una lista de los pisos disponibles en el sistema. Este método
     * consulta el DAO de habitaciones para obtener todos los pisos que
     * contienen habitaciones disponibles.
     *
     * @return Una lista de enteros representando los pisos disponibles.
     */
    @Override
    public List<Integer> obtenerPisosDisponibles() {
        return this.habitacionesDAO.obtenerPisosDisponibles();
    }

    /**
     * Desasigna una habitación de un residente específico. Este método utiliza
     * el DAO de relaciones entre residentes y habitaciones para eliminar la
     * asignación de una habitación a un residente.
     *
     * @param residente El DTO del residente a desasignar de la habitación.
     */
    @Override
    public void deasignarHabitacion(ResidenteDTO residente) {
        this.relacionResidentesHabitacionDAO.desasignarHabitacion(residente);
    }

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente en un
     * piso específico. Este método consulta el DAO de habitaciones para obtener
     * las habitaciones recomendadas para el residente según el piso
     * proporcionado.
     *
     * @param residente El DTO del residente para el cual se buscan habitaciones
     * recomendadas.
     * @param piso El número del piso donde se buscan las habitaciones
     * recomendadas.
     * @return Una lista de DTOs de habitaciones recomendadas para el residente
     * en el piso indicado.
     */
    @Override
    public List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso) {
        return this.habitacionesDAO.obtenerHabitacionesRecomendadas(residente, piso);
    }

    /**
     * Registra una nueva zona en el sistema. Este método consulta el DAO de
     * zonas para agregar una nueva zona al sistema.
     *
     * @param zona El DTO que contiene los datos de la zona a registrar.
     * @return El objeto Zona con los datos del registro realizado.
     */
    @Override
    public Zona registrarZona(ZonaDTO zona) {
        return this.zonasDAO.agregarZona(zona);
    }

    /**
     * Obtiene los datos de una zona específica a partir de su DTO. Este método
     * consulta el DAO de zonas para obtener la información de una zona. Si la
     * zona no se encuentra, se lanza una excepción
     * {@link NoEncontradoException}.
     *
     * @param zona El DTO de la zona a obtener.
     * @return El DTO con los datos de la zona.
     * @throws NoEncontradoException Si no se encuentra la zona solicitada.
     */
    @Override
    public ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException {
        return this.zonasDAO.obtenerZona(zona);
    }

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema. Este
     * método consulta el DAO de zonas para obtener todas las zonas disponibles.
     *
     * @return Una lista de DTOs de todas las zonas registradas.
     */
    @Override
    public List<ZonaDTO> obtenerZonas() {
        return this.zonasDAO.obtenerZonas();
    }

    /**
     * Registra un nuevo personal en el sistema. Este método utiliza el DAO de
     * personal para registrar los datos del personal y luego devuelve un DTO
     * con la información del personal registrado.
     *
     * @param personal El DTO que contiene los datos del personal a registrar.
     * @return El DTO con los datos del personal registrado.
     */
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

    /**
     * Obtiene los datos de un personal específico a partir de su DTO. Este
     * método consulta el DAO de personal para obtener la información de un pers
     * public PersonalDTO registrarPersonal(PersonalDTO personal) { Personal
     * personalRegistrado = personalDAO.registrarPersonal(personal); PersonalDTO
     * personalDTO = new PersonalDTO( personalRegistrado.getId().toString(),
     * personalRegistrado.getNombre(),
     * personalRegistrado.getPuesto().toString(),
     * personalRegistrado.getTelefono(), personalRegistrado.getCorreo()); return
     * personalDTO; }onal. Si el personal no se encuentra, se lanza una
     * excepción {@link NoEncontradoException}.
     *
     * @param personal El DTO del personal a obtener.
     * @return El DTO con los datos del personal.
     * @throws NoEncontradoException Si no se encuentra el personal solicitado.
     */
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

    /**
     * Obtiene una lista de todos los personal registrados en el sistema con un
     * puesto específico. Este método consulta el DAO de personal para obtener
     * todos los personal asociados con el puesto proporcionado.
     *
     * @param puesto El puesto del personal a buscar (como "LIMPIEZA",
     * "MANTENIMIENTO", etc.).
     * @return Una lista de DTOs de personal que coinciden con el puesto
     * proporcionado.
     */
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

    /**
     * Registra una nueva actividad de limpieza en el sistema. Este método
     * consulta el DAO de actividades de limpieza para registrar la actividad
     * junto con la zona y el personal asociados. Si alguna de las entidades no
     * se encuentra, se lanza una excepción {@link NoEncontradoException}.
     *
     * @param actividadLimpieza El DTO con los datos de la actividad de limpieza
     * a registrar.
     * @param zona La zona en la que se realizará la actividad de limpieza.
     * @param personal El personal encargado de la actividad de limpieza.
     * @return El DTO con los datos de la actividad de limpieza registrada.
     * @throws NoEncontradoException Si la zona o el personal no se encuentran
     * registrados en el sistema.
     */
    @Override
    public ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza)
            throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaRegistrada = actividadesLimpiezaDAO
                .registrarActividadLimpieza(actividadLimpieza);
        ZonaDTO zona = new ZonaDTO(
                actividadLimpiezaRegistrada.getZona().getId().toString(),
                actividadLimpiezaRegistrada.getZona().getPiso(),
                actividadLimpiezaRegistrada.getZona().getNombre());
        PersonalDTO personal = new PersonalDTO(
                actividadLimpiezaRegistrada.getPersonal().getId().toString(),
                actividadLimpiezaRegistrada.getPersonal().getNombre()
        );
        ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                actividadLimpiezaRegistrada.getId().toString(),
                zona,
                personal,
                actividadLimpiezaRegistrada.getFechaInicio(),
                actividadLimpiezaRegistrada.getFechaFin());
        return actividadLimpiezaDTO;
    }

    /**
     * Obtiene los datos de una actividad de limpieza registrada en el sistema.
     * Este método consulta el DAO de actividades de limpieza para obtener la
     * información de la actividad solicitada. Si la actividad no se encuentra,
     * se lanza una excepción {@link NoEncontradoException}.
     *
     * @param actividadLimpieza El DTO de la actividad de limpieza a obtener.
     * @return El DTO con los datos de la actividad de limpieza obtenida.
     * @throws NoEncontradoException Si la actividad de limpieza solicitada no
     * se encuentra registrada.
     */
    @Override
    public ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza)
            throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaObtenida = actividadesLimpiezaDAO.obtenerActividad(actividadLimpieza);
        ZonaDTO zona = new ZonaDTO(
                actividadLimpiezaObtenida.getZona().getId().toString(),
                actividadLimpiezaObtenida.getZona().getPiso(),
                actividadLimpiezaObtenida.getZona().getNombre());
        PersonalDTO personal = new PersonalDTO(
                actividadLimpiezaObtenida.getPersonal().getId().toString(),
                actividadLimpiezaObtenida.getPersonal().getNombre()
        );
        ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                actividadLimpiezaObtenida.getId().toString(),
                zona,
                personal,
                actividadLimpiezaObtenida.getFechaInicio(),
                actividadLimpiezaObtenida.getFechaFin());
        return actividadLimpiezaDTO;
    }

    /**
     * Obtiene todas las actividades de limpieza registradas en el sistema. Este
     * método consulta el DAO de actividades de limpieza para recuperar todas
     * las actividades registradas y las convierte en una lista de objetos DTO.
     *
     * @return Una lista de DTOs con los datos de las actividades de limpieza
     * obtenidas.
     */
    @Override
    public List<ActividadLimpiezaDTO> obtenerActividadesLimpieza() {
        List<ActividadLimpieza> actividadesLimpiezaObtenidas = actividadesLimpiezaDAO.obtenerActividadesLimpieza();
        List<ActividadLimpiezaDTO> listaActividadesLimpieza = new LinkedList<>();
        for (ActividadLimpieza actividad : actividadesLimpiezaObtenidas) {
            ZonaDTO zona = new ZonaDTO(
                    actividad.getZona().getId().toString(),
                    actividad.getZona().getPiso(),
                    actividad.getZona().getNombre());
            PersonalDTO personal = new PersonalDTO(
                    actividad.getPersonal().getId().toString(),
                    actividad.getPersonal().getNombre()
            );
            ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                    actividad.getId().toString(),
                    zona,
                    personal,
                    actividad.getFechaInicio(),
                    actividad.getFechaFin());
            listaActividadesLimpieza.add(actividadLimpiezaDTO);
        }
        return listaActividadesLimpieza;
    }

    /**
     * Elimina una actividad de limpieza registrada en el sistema. Este método
     * consulta el DAO de actividades de limpieza para eliminar la actividad
     * indicada. Si la actividad no se encuentra, se lanza una excepción
     * {@link NoEncontradoException}.
     *
     * @param actividadLimpieza El DTO de la actividad de limpieza a eliminar.
     * @return true si la actividad fue eliminada exitosamente, false en caso
     * contrario.
     * @throws NoEncontradoException Si la actividad de limpieza solicitada no
     * se encuentra registrada.
     */
    @Override
    public boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException {
        return actividadesLimpiezaDAO.eliminarActividad(actividadLimpieza);
    }

    /**
     * Obtiene una actividad de limpieza asociada a un personal y a una hora
     * específica. Este método consulta el DAO de actividades de limpieza para
     * obtener la actividad registrada que coincida con el personal y la hora
     * proporcionados. Si la actividad no se encuentra, devuelve null.
     *
     * @param actividadLimpieza El DTO de la actividad de limpieza que contiene
     * la información de la zona y personal.
     * @return El DTO de la actividad de limpieza correspondiente, o null si no
     * se encuentra la actividad.
     * @throws NoEncontradoException Si no se encuentra la actividad de limpieza
     * asociada.
     */
    @Override
    public ActividadLimpiezaDTO obtenerActividadSolapada(ActividadLimpiezaDTO actividadLimpieza)
            throws NoEncontradoException {
        ActividadLimpieza actividadLimpiezaObtenida = actividadesLimpiezaDAO
                .obtenerActividadSolapada(actividadLimpieza);
        if (actividadLimpiezaObtenida != null) {
            ZonaDTO zona = new ZonaDTO(
                    actividadLimpiezaObtenida.getZona().getId().toString(),
                    actividadLimpiezaObtenida.getZona().getPiso(),
                    actividadLimpiezaObtenida.getZona().getNombre());
            PersonalDTO personalObtenido = new PersonalDTO(
                    actividadLimpiezaObtenida.getPersonal().getId().toString(),
                    actividadLimpiezaObtenida.getPersonal().getNombre()
            );
            ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                    actividadLimpiezaObtenida.getId().toString(),
                    zona,
                    personalObtenido,
                    actividadLimpiezaObtenida.getFechaInicio(),
                    actividadLimpiezaObtenida.getFechaFin());
            return actividadLimpiezaDTO;
        } else {
            return null;
        }
    }

    /**
     * Registra un nuevo reporte de mantenimiento en el sistema. Este método
     * delega el almacenamiento del reporte al DAO correspondiente y luego crea
     * un DTO con la información registrada para retornar al llamador.
     *
     * @param reporte El DTO con los datos del reporte a registrar.
     * @return Un DTO con los datos del reporte registrado, incluyendo el ID
     * generado.
     */
    @Override
    public ReporteDTO registrarReporte(ReporteDTO reporte) {

        // Registrar el reporte solo si no hay ninguno pendiente
        ReporteDTO reporteRegistrado = reporteDAO.registrarReporte(reporte);

        // Convertir el reporte registrado a un ReporteDTO para retornarlo
        ReporteDTO reporteDTO = new ReporteDTO(
                reporteRegistrado.getPiso(),
                reporteRegistrado.getHabitacion(),
                reporteRegistrado.getResidente(),
                reporteRegistrado.getHorarioVisita(),
                reporteRegistrado.getDescripcionProblema(),
                reporteRegistrado.getFechaHoraReporte(),
                reporteRegistrado.getEstadoReporte());

        return reporteDTO;
    }

    /**
     * Verifica si existen reportes pendientes en el sistema.
     *
     * @param reporte
     * @return true si existen reportes pendientes, false en caso contrario.
     */
    @Override
    public boolean verificarExistenciaDeReportePendiente(ReporteDTO reporte) {
        return reporteDAO.verificarExistenciaReportePendiente(reporte);
    }

    /**
     * Registra una nueva referencia de pago en el sistema.
     *
     * @param referencia Objeto ReferenciaPagoDTO con los datos completos de la
     * referencia
     * @return ReferenciaPago entidad persistida con ID generado
     */
    @Override
    public ReferenciaPago registrarReferenciaPago(ReferenciaPagoDTO referencia) {
        return this.referenciasDAO.registrarReferenciaPago(referencia);
    }

    /**
     * Obtiene la información de la habitación asignada a un residente.
     *
     * @param residente Objeto ResidenteDTO con los datos del residente
     * @return HabitacionDTO con los datos de la habitación asignada
     */
    @Override
    public HabitacionDTO obtenerHabitacionDeResidente(ResidenteDTO residente) {
        return this.relacionResidentesHabitacionDAO.obtenerHabitacionDeResidente(residente);
    }

    /**
     * Verifica si el residente asociado a la referencia tiene una referencia
     * activa.
     *
     * @param referencia Objeto ReferenciaPagoDTO con los datos de la referencia
     * @return true si existe una referencia activa, false en caso contrario
     */
    @Override
    public boolean existeReferenciaActiva(ReferenciaPagoDTO referencia) {
        return this.referenciasDAO.existeReferenciaActiva(referencia);
    }

    /**
     * Busca la referencia de pago asociada a un residente por su matrícula.
     *
     * @param residenteDTO Objeto ResidenteDTO que contiene la matrícula del
     * residente
     * @return Objeto ReferenciaPago encontrado o null si no existe
     */
    @Override
    public ReferenciaPagoDTO buscarReferenciaPorMatricula(ResidenteDTO residenteDTO) {
        ReferenciaPago referencia = referenciasDAO.buscarReferenciaPorMatricula(residenteDTO);

        if (referencia != null) {
            ReferenciaPagoDTO referenciaDTO = new ReferenciaPagoDTO();

            // Datos principales de la referencia
            referenciaDTO.setFolio(referencia.getFolio());
            referenciaDTO.setReferencia(referencia.getReferencia());
            referenciaDTO.setConcepto(referencia.getConcepto());
            referenciaDTO.setFechaGeneracion(referencia.getFechaGeneracion());
            referenciaDTO.setFechaVencimiento(referencia.getFechaVencimiento());
            referenciaDTO.setImporte(referencia.getImporte());

            // Datos del residente
            if (referencia.getResidente() != null) {
                referenciaDTO.setMatriculaResidente(referencia.getResidente().getMatricula());
                referenciaDTO.setNombreResidente(referencia.getResidente().getNombreCompleto());
                referenciaDTO.setCorreoResidente(referencia.getResidente().getCorreo());
                referenciaDTO.setCarreraResidente(referencia.getResidente().getCarrera());
                referenciaDTO.setTipoResidente(referencia.getResidente().getTipoResidente().toString());
                referenciaDTO.setGeneroResidente(referencia.getResidente().getGenero());
                referenciaDTO.setSemestreResidente(referencia.getResidente().getSemestre());
            }

            // Datos de la habitación
            if (referencia.getHabitacion() != null) {
                referenciaDTO.setHabitacion(referencia.getHabitacion().getNumero());
                referenciaDTO.setPiso(referencia.getHabitacion().getPiso());
            }

            return referenciaDTO;
        }

        return null;
    }

    /**
     * Obtiene una lista con los nombres completos de los residentes que se
     * encuentran en una habitación específica, identificada por su número de
     * piso y número de habitación.
     *
     * @param piso El número del piso donde se encuentra la habitación.
     * @param habitacion El número de la habitación que se desea consultar.
     * @return Una lista de nombres completos de los residentes registrados en
     * esa habitación. La lista estará vacía si no hay residentes registrados.
     */
    @Override
    public List<String> obtenerResidentePorHabitacion(Integer piso, Integer habitacion) {
        List<String> residentesDeLaHabitacion = relacionResidentesHabitacionDAO.obtenerResidentesPorHabitacion(piso,
                habitacion);
        return residentesDeLaHabitacion;
    }

    @Override
    public Fiador registrarFiador(FiadorDTO fiador, ResidenteDTO residenteDTO) {
        try {
            return this.fiadorDAO.registrarFiador(fiador, residenteDTO);
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws NoEncontradoException {
        try {
            return this.fiadorDAO.consultarFiador(residenteDTO);
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }

    @Override
    public List<ActividadLimpiezaDTO> obtenerActividadesPorFiltro(String filtro) {
        List<ActividadLimpieza> actividadesLimpiezaObtenidas = actividadesLimpiezaDAO.obtenerActividadesPorFiltro(filtro);
        List<ActividadLimpiezaDTO> listaActividadesLimpieza = new LinkedList<>();
        for (ActividadLimpieza actividad : actividadesLimpiezaObtenidas) {
            ZonaDTO zona = new ZonaDTO(
                    actividad.getZona().getId().toString(),
                    actividad.getZona().getPiso(),
                    actividad.getZona().getNombre());
            PersonalDTO personal = new PersonalDTO(
                    actividad.getPersonal().getId().toString(),
                    actividad.getPersonal().getNombre()
            );
            ActividadLimpiezaDTO actividadLimpiezaDTO = new ActividadLimpiezaDTO(
                    actividad.getId().toString(),
                    zona,
                    personal,
                    actividad.getFechaInicio(),
                    actividad.getFechaFin());
            listaActividadesLimpieza.add(actividadLimpiezaDTO);
        }
        return listaActividadesLimpieza;
    }

    @Override
    public void actualizarResidente(ResidenteDTO residente) {
        this.residentesDAO.actualizarResidente(residente);
    }
    
    @Override
    public void actualizarAdeudo(ResidenteDTO residenteDTO, String cantidad){
        this.residentesDAO.actualizarAdeudo(residenteDTO, cantidad);
    }

    /**
     * Delegación de la operación de registro masivo de residentes al DAO
     * correspondiente.
     *
     * Este método permite registrar automáticamente un conjunto de residentes
     * simulados en la base de datos, típicamente utilizado para pruebas o carga
     * inicial.
     *
     * La lógica de generación de datos se encuentra implementada dentro del DAO
     * (`ResidentesDAO`).
     */
    @Override
    public void registrarResidentesMasivo() {
        this.residentesDAO.registrarResidentesMasivo();
    }
    
    @Override
    public Long obtenerCantidadResidentes(){
       return this.residentesDAO.obtenerCantidadResidentes();
    }
}
