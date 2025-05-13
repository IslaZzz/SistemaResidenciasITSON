package com.mycompany.comunicacioncia.interfaz;

import DTO_Infraestructura.AlumnoInfDTO;
import excepciones.CIAExcepcion;
import org.json.JSONObject;

/**
 * Interfaz que define las operaciones para la comunicación con el sistema CIA
 * (Central de Información Académica).
 *
 * Esta interfaz proporciona métodos para obtener información de un estudiante,
 * convertir la información de un estudiante de un formato JSON a un DTO, y
 * viceversa.
 */
public interface IComunicacionCIA {

    /**
     * Obtiene los detalles de un estudiante específico desde el sistema CIA.
     *
     * @param alumno El objeto DTO que representa al estudiante cuya información
     * se desea obtener.
     * @return El objeto DTO del estudiante con la información obtenida.
     * @throws CIAExcepcion Si ocurre un error al obtener la información del
     * estudiante.
     */
    AlumnoInfDTO getEstudiante(AlumnoInfDTO alumno) throws CIAExcepcion;

    /**
     * Convierte un objeto JSON que representa a un estudiante en un objeto DTO
     * de tipo AlumnoInfDTO.
     *
     * @param alumno El objeto JSON que representa al estudiante.
     * @return El objeto DTO de tipo AlumnoInfDTO con la información convertida.
     */
    AlumnoInfDTO convertirEstudianteJSONaDTO(JSONObject alumno);

    /**
     * Convierte un objeto DTO de tipo AlumnoInfDTO en un objeto JSON que
     * representa la información del estudiante.
     *
     * @param alumno El objeto DTO de tipo AlumnoInfDTO que representa al
     * estudiante.
     * @return El objeto JSON con la información del estudiante.
     */
    JSONObject convertirEstudianteDTOaJSON(AlumnoInfDTO alumno);

}
