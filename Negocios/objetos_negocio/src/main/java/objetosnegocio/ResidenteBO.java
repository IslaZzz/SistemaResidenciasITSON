package objetosnegocio;

import DTO_Infraestructura.AlumnoInfDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;

import dto.HabitacionDTO;
import dto.ResidenteDTO;
import excepciones.CIAExcepcion;
import excepciones.NegocioException;
import implementaciones.AccesoDatosFachada;
import implementaciones.ComunicacionCIAFachada;
import interfaz.IAccesoDatos;

public class ResidenteBO {

    /**
     * Instancia Singleton del objeto negocio de residente.
     */
    private static ResidenteBO residenteBO;

    /**
     * Metodo que obtiene la instancia del objeto negocio de residente.
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
                //convierte de entidad estudiante a residente -- probablemente se tenga que cambiar a futuro para agregar nuevos atributos
                return new ResidenteDTO(alumnoObtenido.getMatricula(), alumnoObtenido.getNombreCompleto(), alumnoObtenido.getGenero(), alumnoObtenido.getSemestre(), alumnoObtenido.getCarrera(), alumnoObtenido.getCorreo(), alumnoObtenido.getTelefono(), alumnoObtenido.getDireccion());
            } else {
                throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
            }
        } catch (CIAExcepcion e) {
            throw new NegocioException("Error al obtener el estudiante desde CIA: " + e.getMessage());
        }
    }

    public ResidenteDTO getResidente(String matricula) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        ResidenteDTO residente = accesoDatos.obtenerResidente(matricula);
        return residente;

    }

    public void registrarResidente(ResidenteDTO residente) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.registrarResidente(residente);
    }

    public void asignarHabitacion(ResidenteDTO residente, HabitacionDTO habitacion) {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        accesoDatos.asignarHabitacion(residente, habitacion);
    }
}
