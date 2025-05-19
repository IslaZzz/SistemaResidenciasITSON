package objetosnegocio;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import dto.FiadorDTO;
import dto.HabitacionDTO;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
import excepciones.MensajeriaException;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import implementaciones.MensajeriaFachada;
import interfaz.IAccesoDatos;
import interfaz.IMensajeria;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReferenciasPagoBO {

    /**
     * Instancia Singleton del objeto negocio de referenciaPago.
     */
    private static ReferenciasPagoBO referenciaBO;

    /**
     * Metodo que obtiene la instancia del objeto negocio de ReferenciasPagoBO
     *
     * @return Instancia del objeto negocio de ReferenciasPagoBO
     */
    public static ReferenciasPagoBO getInstance() {
        if (referenciaBO == null) {
            referenciaBO = new ReferenciasPagoBO();
        }
        return referenciaBO;
    }

    /**
     * Genera una referencia de pago para un residente con todos los datos
     * requeridos. Incluye generación de referencia, fechas, folio único y
     * validación de existencia previa.
     *
     * @param referencia DTO con al menos la matrícula del residente
     * @return ReferenciaPagoDTO completado con todos los campos
     * @throws NegocioException Si no existe el residente o ya tiene una
     * referencia activa
     */
    public ReferenciaPagoDTO generarReferencia(ReferenciaPagoDTO referencia) throws NegocioException {

        ResidenteDTO residente = getResidente(referencia.getMatriculaResidente());
        if (residente == null) {
            throw new NegocioException("No se encuentra registrado un residente con esa matricula");
        }
        HabitacionDTO habitacion = getHabitacion(residente);
        if (habitacion == null) {
            throw new NegocioException("El residente no cuenta con habitacion");
        }
//        try {
//            FiadorDTO fiador = getFiador(residente);
//            if (fiador == null) {
//            throw new NegocioException("El Residente no cuenta con un contrato generado");
//            }
        referencia.setReferencia(residente.getNombreCompleto().substring(0, 3).toUpperCase() + "-" + residente.getMatricula().substring(5, 8) + "-" + "HAB" + habitacion.getNumero());
        referencia.setConcepto("Residencias ITSON - Habitacion: " + habitacion.getNumero());

        //BigDecimal importe = new BigDecimal(residente.getAdeudo());
        referencia.setImporte(new BigDecimal("100000"));

        referencia.setNombreResidente(residente.getNombreCompleto());
        referencia.setCarreraResidente(residente.getCarrera());
        referencia.setTipoResidente(residente.getTipoResidente());
        referencia.setCorreoResidente(residente.getCorreo());
        referencia.setMatriculaResidente(residente.getMatricula());
        referencia.setSemestreResidente(residente.getSemestre());
        referencia.setGeneroResidente(residente.getGenero());

        Date fechaGeneracion = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaGeneracion);
        calendar.add(Calendar.DAY_OF_YEAR, 14);

        Date fechaVencimiento = calendar.getTime();

        referencia.setFechaGeneracion(fechaGeneracion);
        referencia.setFechaVencimiento(fechaVencimiento);

        if (existeReferenciaActiva(referencia)) {
            throw new NegocioException("El Residente ya cuenta con una referencia de pago activa");
        }

        referencia.setHabitacion(habitacion.getNumero());
        referencia.setPiso(habitacion.getPiso());

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String fecha = sdf.format(new Date());
        String folio = "REF-" + fecha + "-" + residente.getMatricula();
        referencia.setFolio(folio);

        return referencia;
//        } catch (NoEncontradoException ex) {
//            throw new NegocioException("El Residente no cuenta con un contrato generado");
//        }
//        
    }

    /**
     * Obtiene los datos de un residente mediante su matrícula.
     *
     * @param matricula Matrícula del residente (formato de 11 digitos)
     * @return ResidenteDTO con los datos del residente o null si no existe
     */
    public ResidenteDTO getResidente(String matricula) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ResidenteDTO residente = accesoDatos.obtenerResidente(matricula);
        return residente;
    }

    /**
     * Obtiene la información de la habitación asignada a un residente.
     *
     * @param residente DTO con los datos del residente
     * @return HabitacionDTO con número de habitación y piso asignados
     */
    public HabitacionDTO getHabitacion(ResidenteDTO residente) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.obtenerHabitacionDeResidente(residente);
    }

    public FiadorDTO getFiador(ResidenteDTO residente) throws NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.consultarFiador(residente);
    }

    /**
     * Registra una referencia de pago en el sistema de persistencia.
     *
     * @param referencia DTO completo con todos los datos de la referencia
     */
    public void registrarReferencia(ReferenciaPagoDTO referencia) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.registrarReferenciaPago(referencia);
    }

    /**
     * Verifica si existe una referencia de pago activa para el residente.
     *
     * @param referencia DTO con los datos de la referencia a validar
     * @return true si existe una referencia activa, false en caso contrario
     */
    public boolean existeReferenciaActiva(ReferenciaPagoDTO referencia) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.existeReferenciaActiva(referencia);
    }

    /**
     * Busca una referencia de pago asociada a la matrícula de un residente.
     * Este método utiliza una fachada de acceso a datos para realizar la
     * búsqueda.
     *
     * @param residente El objeto ResidenteDTO que contiene los datos del
     * residente, especialmente su matrícula, para buscar su referencia de pago.
     * @return ReferenciaPagoDTO La referencia de pago encontrada.
     * @throws NegocioException Si no se encuentra la referencia de pago
     * asociada a la matrícula o si ocurre un error durante la consulta.
     */
    public ReferenciaPagoDTO buscarReferenciaPorMatricula(ResidenteDTO residente) throws NegocioException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ReferenciaPagoDTO referencia = accesoDatos.buscarReferenciaPorMatricula(residente);
        if (referencia != null) {
            return referencia;
        } else {
            throw new NegocioException("No se encontro la referencia");
        }
    }

    /**
     * Envía una referencia de pago por correo electrónico al residente. Utiliza
     * una fachada de mensajería para realizar el envío.
     *
     * @param referencia El objeto ReferenciaPagoInfDTO que contiene los datos
     * de la referencia de pago a enviar, incluyendo el correo del destinatario.
     * @return verdadero si el correo se envió correctamente, falso si falló el
     * envío.
     * @throws NegocioException Si ocurre un error durante el proceso de envío
     * del correo, como problemas de conexión o datos inválidos.
     */
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws NegocioException {
        IMensajeria mensajeria = new MensajeriaFachada();
        try {
            return mensajeria.enviarReferenciaCorreo(referencia);
        } catch (MensajeriaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}
