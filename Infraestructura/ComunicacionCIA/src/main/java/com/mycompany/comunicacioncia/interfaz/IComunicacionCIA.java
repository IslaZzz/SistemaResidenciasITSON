package com.mycompany.comunicacioncia.interfaz;

import DTO_Infraestructura.AlumnoInfDTO;
import excepciones.CIAExcepcion;
import org.json.JSONObject;

public interface IComunicacionCIA {
    AlumnoInfDTO getEstudiante(AlumnoInfDTO alumno) throws CIAExcepcion;
    
    AlumnoInfDTO convertirEstudianteJSONaDTO(JSONObject alumno);
    
    JSONObject convertirEstudianteDTOaJSON(AlumnoInfDTO alumno);
    
}
