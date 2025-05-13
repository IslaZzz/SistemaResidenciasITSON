package objetosnegocio;

import DTO_Infraestructura.AlumnoInfDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;
import dto.ResidenteDTO;
import excepciones.CIAExcepcion;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import implementaciones.ComunicacionCIAFachada;
import interfaz.IAccesoDatos;

/**
 * Clase que administra la lógica de negocio relacionada con los Residentes del
 * sistema. Se encarga de gestionar la obtención, registro y asignación de
 * residentes en las habitaciones disponibles, así como de proporcionar
 * recomendaciones y validaciones según el género del residente.
 *
 * Implementa el patrón Singleton para asegurar que exista una única instancia
 * de la lógica de negocio relacionada con los residentes.
 */
public class ResidenteBO {

    /**
     * Instancia Singleton del objeto negocio de residente.
     */
    private static ResidenteBO residenteBO;

    /**
     * Metodo que obtiene la instancia del objeto negocio de residente.
     *
     * @return Instancia del objeto negocio de residente
     */
    public static ResidenteBO getInstance() {
        if (residenteBO == null) {
            residenteBO = new ResidenteBO();
        }
        return residenteBO;
    }

    /**
     * Metodo que busca la información del estudiante en el sistema CIA y la
     * convierte a un objeto ResidenteDTO.
     *
     * @param alumno DTO que contiene la matricula del alumno a buscar
     * @return
     * @throws NegocioException
     */
    public ResidenteDTO getEstudianteCIA(AlumnoInfDTO alumno) throws NegocioException {
        if (alumno.getMatricula().length() != 11) {
            throw new NegocioException("La longitud de la matricula debe ser de 11 numeros");
        }
        IComunicacionCIA comunicacionCIA = new ComunicacionCIAFachada();
        try {
            AlumnoInfDTO alumnoObtenido = comunicacionCIA.getEstudiante(alumno);
            if (alumnoObtenido != null) {
                return new ResidenteDTO(alumnoObtenido.getMatricula(), alumnoObtenido.getNombreCompleto(), alumnoObtenido.getGenero(), alumnoObtenido.getSemestre(), alumnoObtenido.getCarrera(), alumnoObtenido.getCorreo(), alumnoObtenido.getTelefono(), alumnoObtenido.getDireccion());
            } else {
                throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
            }
        } catch (CIAExcepcion e) {
            throw new NegocioException("Error al conectarse con el servidor CIA");
        }

    }

    /**
     * Obtiene la información de un residente a partir de su matrícula.
     *
     * @param matricula la matrícula única del residente
     * @return el objeto {@link ResidenteDTO} correspondiente al residente
     */
    public ResidenteDTO getResidente(String matricula) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ResidenteDTO residente = accesoDatos.obtenerResidente(matricula);
        return residente;

    }

    /**
     * Registra un nuevo residente en el sistema.
     *
     * @param residente el objeto {@link ResidenteDTO} que contiene los datos
     * del residente a registrar
     */
    public void registrarResidente(ResidenteDTO residente) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.registrarResidente(residente);
    }

}
