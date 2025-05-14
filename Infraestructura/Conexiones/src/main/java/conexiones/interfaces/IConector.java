package conexiones.interfaces;

import conexiones.excepciones.ServidorExcepcion;
import org.json.JSONObject;

/**
 * Interfaz que define el contrato para conectores encargados de realizar
 * operaciones de comunicación con servicios externos, como el servidor CIA.
 */
public interface IConector {

    /**
     * Envía una solicitud para obtener los datos de un alumno a partir de su
     * información básica, generalmente la matrícula. La implementación debe
     * comunicarse con un servicio externo y devolver los datos completos del
     * alumno en formato JSON.
     *
     * @param alumno Objeto {@link JSONObject} que contiene la información
     * básica del alumno (por ejemplo, matrícula).
     * @return Un objeto {@link JSONObject} con los datos completos del alumno
     * si se encuentra; {@code null} si no se encuentra.
     * @throws ServidorExcepcion Si ocurre un error al comunicarse con el
     * servidor externo.
     */
    JSONObject getAlumno(String matricula) throws ServidorExcepcion;
}
