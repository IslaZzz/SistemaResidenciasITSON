package com.mycompany.comunicacioncia.interfaz;

import DTO_Infraestructura.EstudianteDTO;
import excepciones.CIAExcepcion;
import org.json.JSONObject;

public interface IComunicacionCIA {
    EstudianteDTO getEstudiante(String matricula) throws CIAExcepcion;
    
    EstudianteDTO convertirAEstudiante(JSONObject alumno);
    
}
