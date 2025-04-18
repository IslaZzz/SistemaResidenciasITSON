package objetosnegocio;

import DTO_Infraestructura.EstudianteDTO;
import com.mycompany.comunicacioncia.interfaz.IComunicacionCIA;
import dto.ResidenteDTO;
import excepciones.CIAExcepcion;
import excepciones.NegocioException;
import implementaciones.ComunicacionCIAFachada;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ResidenteBO {
    
    //Lista Mock de estudiantes de donde obtener id (Para pruebas)
    private List<ResidenteDTO> estudiantesMock;
    //Lista Mock de los residentes registrados en el sistema
    private List<ResidenteDTO> residentes;
        
    /**
     * Instancia Singleton del objeto negocio de residente.
     */
    private static ResidenteBO residenteBO;

    /**
     * constructor privado del residenteBO, crea la lista MOCK de estudiantes.
     */
    private ResidenteBO(){
        this.estudiantesMock = new LinkedList<>();
        estudiantesMock.add(new ResidenteDTO(
                "00000252274",
                "Jorge Cuevas Gastelum",
                'H',
                4,
                "Ingeniería en Software",
                "jorge@potros.itson.edu.mx",
                "6441222916",
                "Av. Antonio Caso 1354"
        ));
        estudiantesMock.add(new ResidenteDTO(
                "00000252687",
                "Pedro Luna Esquer",
                'H',
                4,
                "Ingeniería en Software",
                "pedro@potros.itson.edu.mx",
                "6442531964",
                "Av. Yaqui 1124"
        ));
        this.residentes = new LinkedList<>();
        residentes.add(new ResidenteDTO(
            "00000252825",
            "Ari Raul Montoya Navarro",
            'H',
            4,
            "Ingeniería en Software",
            "ari@potros.itson.edu.mx",
            "6441231231",
            "Av. Morelos 1231"
        ));
    }
    
    public static ResidenteBO getInstance(){
        if(residenteBO == null){
            residenteBO = new ResidenteBO();
        }
        return residenteBO;
    }

    public ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        if(matricula.length() != 11){
            throw new NegocioException("La longitud de la matricula debe ser de 11 numeros");
        }
        ResidenteDTO residente = getResidente(matricula);
        if(residente != null){
            throw new NegocioException("El estudiante con la matricula: "+matricula+", ya se encuentra registrado");
        }
        boolean encontrado = this.estudiantesMock.stream().anyMatch( (a) -> a.getMatricula().equals(matricula));
        if(encontrado){
             List<ResidenteDTO> estudiante = this.estudiantesMock.stream().filter( (a) -> a.getMatricula().equals(matricula)).collect(Collectors.toList());
             if(estudiante.size()> 1){
                 throw new NegocioException("Se encontró más de un estudiante con la matricula especificada");
             }
             return estudiante.getFirst();
        } else {
            throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
        }
    }
    
    public ResidenteDTO getEstudianteCIA(String matricula) throws NegocioException{
        if(matricula.length() != 11){
            throw new NegocioException("La longitud de la matricula debe ser de 11 numeros");
        }
        IComunicacionCIA comunicacionCIA = new ComunicacionCIAFachada();
        try{
            EstudianteDTO alumnoObtenido = comunicacionCIA.getEstudiante(matricula);
            if(alumnoObtenido != null){
            //convierte de entidad estudiante a residente -- probablemente se tenga que cambiar a futuro para agregar nuevos atributos
            return new ResidenteDTO(alumnoObtenido.getMatricula(), alumnoObtenido.getNombreCompleto(), alumnoObtenido.getGenero(), alumnoObtenido.getSemestre(), alumnoObtenido.getCarrera(), alumnoObtenido.getCorreo(), alumnoObtenido.getTelefono(), alumnoObtenido.getDireccion());
        }
        else{
            throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
        }
        }
        catch (CIAExcepcion e) {
            throw new NegocioException("Error al obtener el estudiante desde CIA: " + e.getMessage());
        }
        
        
    }

    public ResidenteDTO getResidente(String matricula){
        boolean encontrado = this.residentes.stream().anyMatch( (a) -> a.getMatricula().equals(matricula));
        if(encontrado){
            List<ResidenteDTO> residente = this.residentes.stream().filter( (a) -> a.getMatricula().equals(matricula)).collect(Collectors.toList());
            if(residente.size()> 1){
                return null;
            }
            return residente.getFirst();
        }
        return null;

    }
    
    public ResidenteDTO asignarTipo(ResidenteDTO residente, String tipo){
        ResidenteDTO residenteEnSistema = getResidente(residente.getMatricula());
        if(residenteEnSistema!= null){
            residenteEnSistema.setTipoResidente("tipo");
        }
        return residente;
    }

    public void registrarResidente(ResidenteDTO residente){
        this.residentes.add(residente);
    }
}
