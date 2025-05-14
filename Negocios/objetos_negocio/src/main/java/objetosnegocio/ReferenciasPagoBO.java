package objetosnegocio;

import dto.HabitacionDTO;
import dto.ReferenciaPagoDTO;
import dto.ResidenteDTO;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReferenciasPagoBO {

    /**
     * Instancia Singleton del objeto negocio de residente.
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

        referencia.setReferencia(residente.getNombreCompleto().substring(0, 3).toUpperCase() + "-" + residente.getMatricula().substring(5, 8) + "-" + "HAB" + habitacion.getNumero());
        referencia.setConcepto("Residencias ITSON - Habitacion: " + habitacion.getNumero());

        //conseguir de fiador o manejar precio fijo
        referencia.setImporte(new BigDecimal("1000"));

        referencia.setNombreResidente(residente.getNombreCompleto());
        referencia.setCarreraResidente(residente.getCarrera());
        referencia.setTipoResidente(residente.getTipoResidente());
        referencia.setCorreoResidente(residente.getCorreo());
        referencia.setMatriculaResidente(residente.getMatricula());
        referencia.setSemestreResidente(residente.getSemestre());

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

}
