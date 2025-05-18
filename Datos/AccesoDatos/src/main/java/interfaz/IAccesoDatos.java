package interfaz;

import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.FiadorDTO;
import dto.HabitacionDTO;
import dto.PersonalDTO;
import dto.ReferenciaPagoDTO;
import dto.ReporteDTO;
import dto.ResidenteDTO;
import dto.ZonaDTO;
import entities.Fiador;
import entities.ReferenciaPago;
import entities.Residente;
import entities.Zona;
import exceptions.NoEncontradoException;

/**
 * Interfaz que define los métodos para el acceso a los datos relacionados con
 * los residentes, habitaciones, zonas, personal y actividades de limpieza en el
 * sistema.
 */
public interface IAccesoDatos {

    /**
     * Registra un nuevo residente en el sistema.
     *
     * @param residente El objeto ResidenteDTO con los datos del residente a
     * registrar.
     * @return Un objeto Residente que representa al residente registrado.
     */
    public abstract Residente registrarResidente(ResidenteDTO residente);

    /**
     * Obtiene un residente a partir de su matrícula.
     *
     * @param matricula La matrícula del residente a obtener.
     * @return Un objeto ResidenteDTO que representa al residente encontrado.
     */
    public abstract ResidenteDTO obtenerResidente(String matricula);

    /**
     * Asigna una habitación a un residente.
     *
     * @param residente El objeto ResidenteDTO del residente al que se le
     * asignará la habitación.
     * @param habitacion El objeto HabitacionDTO que representa la habitación a
     * asignar.
     */
    public abstract void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion);

    /**
     * Desasigna la habitación de un residente.
     *
     * @param residente El objeto ResidenteDTO del residente cuya habitación
     * será desasignada.
     */
    public abstract void deasignarHabitacion(ResidenteDTO residente);

    /**
     * Registra habitaciones de forma masiva en el sistema.
     *
     * @param numeroPisos El número de pisos a registrar.
     * @param numeroHabitacionesPorPiso El número de habitaciones por cada piso.
     */
    public abstract void registrarHabitacionesMasivo(int numeroPisos, int numeroHabitacionesPorPiso);

    /**
     * Obtiene la cantidad total de habitaciones registradas en el sistema.
     *
     * @return La cantidad total de habitaciones.
     */
    public abstract Long obtenerCantidadHabitaciones();

    /**
     * Obtiene una habitación a partir de los datos proporcionados.
     *
     * @param habitacion El objeto HabitacionDTO que representa los datos de la
     * habitación a obtener.
     * @return Un objeto HabitacionDTO que representa la habitación encontrada.
     */
    public abstract HabitacionDTO obtenerHabitacion(HabitacionDTO habitacion);

    /**
     * Obtiene una lista de habitaciones disponibles en un piso específico.
     *
     * @param piso El número de piso en el que se buscan habitaciones
     * disponibles.
     * @return Una lista de objetos HabitacionDTO que representan las
     * habitaciones disponibles en el piso dado.
     */
    public abstract List<HabitacionDTO> obtenerHabitacionesDisponiblesPorPiso(int piso);

    /**
     * Obtiene una lista de pisos disponibles en el sistema.
     *
     * @return Una lista de números de pisos disponibles.
     */
    public abstract List<Integer> obtenerPisosDisponibles();

    /**
     * Obtiene una lista de habitaciones recomendadas para un residente
     * específico en un piso dado.
     *
     * @param residente El objeto ResidenteDTO que representa al residente.
     * @param piso El número de piso donde se buscan habitaciones recomendadas.
     * @return Una lista de objetos HabitacionDTO que representan las
     * habitaciones recomendadas.
     */
    public abstract List<HabitacionDTO> obtenerHabitacionesRecomendadas(ResidenteDTO residente, int piso);

    /**
     * Registra una nueva zona en el sistema.
     *
     * @param zona El objeto ZonaDTO con los datos de la zona a registrar.
     * @return Un objeto Zona que representa la zona registrada.
     */
    public abstract Zona registrarZona(ZonaDTO zona);

    /**
     * Obtiene una zona específica a partir de los datos proporcionados.
     *
     * @param zona El objeto ZonaDTO con los datos de la zona a obtener.
     * @return Un objeto ZonaDTO que representa la zona encontrada.
     * @throws NoEncontradoException Si la zona no se encuentra en el sistema.
     */
    public abstract ZonaDTO obtenerZona(ZonaDTO zona) throws NoEncontradoException;

    /**
     * Obtiene una lista de todas las zonas registradas en el sistema.
     *
     * @return Una lista de objetos ZonaDTO que representan todas las zonas
     * registradas.
     */
    public abstract List<ZonaDTO> obtenerZonas();

    /**
     * Registra un nuevo personal en el sistema.
     *
     * @param personal El objeto PersonalDTO con los datos del personal a
     * registrar.
     * @return Un objeto PersonalDTO que representa al personal registrado.
     */
    public abstract PersonalDTO registrarPersonal(PersonalDTO personal);

    /**
     * Obtiene un personal específico a partir de los datos proporcionados.
     *
     * @param personal El objeto PersonalDTO con los datos del personal a
     * obtener.
     * @return Un objeto PersonalDTO que representa al personal encontrado.
     * @throws NoEncontradoException Si el personal no se encuentra en el
     * sistema.
     */
    public abstract PersonalDTO obtenerPersonal(PersonalDTO personal) throws NoEncontradoException;

    /**
     * Obtiene una lista de personal por su puesto.
     *
     * @param puesto El puesto del personal a obtener.
     * @return Una lista de objetos PersonalDTO que representan al personal
     * encontrado por el puesto.
     */
    public abstract List<PersonalDTO> obtenerPersonalPorPuesto(String puesto);

    /**
     * Registra una nueva actividad de limpieza en el sistema.
     *
     * @param actividadLimpieza El objeto ActividadLimpiezaDTO con los datos de
     * la actividad de limpieza a registrar.
     * @param zona La zona donde se llevará a cabo la actividad.
     * @param personal El personal encargado de realizar la actividad de
     * limpieza.
     * @return Un objeto ActividadLimpiezaDTO que representa la actividad
     * registrada.
     * @throws NoEncontradoException Si no se encuentra la zona o el personal en
     * el sistema.
     */
    public abstract ActividadLimpiezaDTO registrarActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException;

    /**
     * Elimina una actividad de limpieza registrada en el sistema.
     *
     * @param actividadLimpieza El objeto ActividadLimpiezaDTO con los datos de
     * la actividad a eliminar.
     * @return Un valor booleano que indica si la actividad fue eliminada
     * exitosamente.
     * @throws NoEncontradoException Si la actividad de limpieza no se encuentra
     * en el sistema.
     */
    public abstract boolean eliminarActividad(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException;

    /**
     * Obtiene una actividad de limpieza registrada en el sistema.
     *
     * @param actividadLimpieza El objeto ActividadLimpiezaDTO con los datos de
     * la actividad a obtener.
     * @return Un objeto ActividadLimpiezaDTO que representa la actividad
     * encontrada.
     * @throws NoEncontradoException Si la actividad de limpieza no se encuentra
     * en el sistema.
     */
    public abstract ActividadLimpiezaDTO obtenerActividadLimpieza(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException;

    /**
     * Obtiene una actividad de limpieza registrada en el sistema, filtrando por
     * zona y hora o personal y hora.
     *
     * @param actividadLimpieza El objeto ActividadLimpiezaDTO con los datos de
     * la actividad a obtener.
     * @return Un objeto ActividadLimpiezaDTO que representa la actividad
     * encontrada.
     * @throws NoEncontradoException Si la actividad de limpieza no se encuentra
     * en el sistema.
     */
    public abstract ActividadLimpiezaDTO obtenerActividadSolapada(ActividadLimpiezaDTO actividadLimpieza) throws NoEncontradoException;

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en el
     * sistema.
     *
     * @return Una lista de objetos ActividadLimpiezaDTO que representan todas
     * las actividades de limpieza.
     */
    public abstract List<ActividadLimpiezaDTO> obtenerActividadesLimpieza();

    /**
     * Obtiene una lista de actividades de limpieza filtradas por un criterio
     * específico.
     *
     * @param filtro El criterio de filtro para las actividades de limpieza.
     * @return Una lista de objetos ActividadLimpiezaDTO que cumplen con el
     * criterio de filtro.
     */
    public abstract List<ActividadLimpiezaDTO> obtenerActividadesPorFiltro(String filtro);
    /**
     * Registra un nuevo reporte de mantenimiento en el sistema.
     *
     * @param reporte el objeto {@link ReporteDTO} que contiene la información
     * del reporte a ser almacenado, incluyendo piso, habitación, residente,
     * descripción del problema, horario de visita y estado.
     * @return un objeto {@link ReporteDTO} que representa el reporte
     * registrado, incluyendo información adicional como el ID generado y la
     * fecha de creación.
     */
    public abstract ReporteDTO registrarReporte(ReporteDTO reporte);

    /**
     * Verifica si ya existe un reporte de mantenimiento con estado "PENDIENTE"
     * para la misma habitación y piso especificados en el {@link ReporteDTO}.
     *
     * @param reporte el objeto {@link ReporteDTO} que contiene los datos de
     * piso y habitación a verificar.
     * @return {@code true} si ya existe un reporte pendiente para esa
     * ubicación, {@code false} en caso contrario.
     */
    public abstract boolean verificarExistenciaDeReportePendiente(ReporteDTO reporte);

    /**
     * Registra una nueva referencia de pago en el sistema.
     *
     * @param referencia Objeto ReferenciaPagoDTO con los datos completos de la
     * referencia
     * @return ReferenciaPago entidad persistida con ID generado
     */
    public abstract ReferenciaPago registrarReferenciaPago(ReferenciaPagoDTO referencia);

    /**
     * Obtiene la información de la habitación asignada a un residente.
     *
     * @param residente Objeto ResidenteDTO con los datos del residente
     * @return HabitacionDTO con los datos de la habitación asignada
     */
    public abstract HabitacionDTO obtenerHabitacionDeResidente(ResidenteDTO residente);

    /**
     * Verifica si el residente asociado a la referencia tiene una referencia
     * activa.
     *
     * @param referencia Objeto ReferenciaPagoDTO con los datos de la referencia
     * @return true si existe una referencia activa, false en caso contrario
     */
    public abstract boolean existeReferenciaActiva(ReferenciaPagoDTO referencia);

    /**
     * Obtiene el nombre completo del residente que se encuentra en una
     * habitación específica, identificada por su número de piso y habitación.
     *
     * @param piso El número del piso donde se encuentra la habitación.
     * @param habitacion El número de la habitación que se desea consultar.
     * @return El nombre completo del residente si se encuentra en esa
     * habitación, o null si no hay residente registrado en esa habitación.
     */
    public abstract List<String> obtenerResidentePorHabitacion(Integer piso, Integer habitacion);
    
        public abstract Fiador registrarFiador(FiadorDTO fiador, ResidenteDTO residenteDTO);
    
    /**
     * Se consulta si el residente recibido en el parametro cuenta con un fiador
     * @param residenteDTO
     * @return
     * @throws NoEncontradoException 
     */
    public abstract FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws NoEncontradoException;

    public void actualizarResidente(ResidenteDTO residente);

    /**
     * Le asigna el residente que recibe como parametro, correspondiente al fiador 
     * @param fiadorDTO
     * @param residenteDTO
     * @throws NoEncontradoException 
     
    public abstract void setResidente(FiadorDTO fiadorDTO, ResidenteDTO residenteDTO) throws NoEncontradoException;
    */

}
