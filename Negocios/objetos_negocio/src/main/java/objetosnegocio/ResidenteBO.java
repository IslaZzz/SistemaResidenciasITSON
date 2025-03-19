package objetosnegocio;

import dto.ResidenteDTO;
import excepciones.NegocioException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ResidenteBO {
    
    //Lista de estudiantes de donde obtener id (Para pruebas)
    private List<ResidenteDTO> estudiantes_mock;
    
    public ResidenteBO(){
        this.estudiantes_mock = new LinkedList<>();
        estudiantes_mock.add(new ResidenteDTO(
                "00000252274",
                "Jorge Cuevas Gastelum",
                'H',
                4,
                "Ingeniería en Software",
                "6441222916",
                "Av. Antonio Caso 1354"
        ));
        estudiantes_mock.add(new ResidenteDTO(
                "00000252687",
                "Pedro Luna Esquer",
                'H',
                4,
                "Ingeniería en Software",
                "6442531964",
                "Av. Yaqui 1124"
        ));
    }
    
    public ResidenteDTO getEstudiante(String matricula) throws NegocioException{
        if(matricula.length() != 11){
            throw new NegocioException("La longitud de la matricula debe ser de 11 numeros");
        }
        boolean encontrado = this.estudiantes_mock.stream().anyMatch( (a) -> a.getMatricula().equals(matricula));
        if(encontrado){
             List<ResidenteDTO> estudiante = this.estudiantes_mock.stream().filter( (a) -> a.getMatricula().equals(matricula)).collect(Collectors.toList());
             if(estudiante.size()> 1){
                 throw new NegocioException("Se encontró más de un estudiante con la matricula especificada");
             }
             return estudiante.getFirst();
        } else {
            throw new NegocioException("No se encontró ningun estudiante con la matricula especificada");
        }
    }
}
