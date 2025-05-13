package conexiones.fabricaConectores;

import conexiones.excepciones.ServidorExcepcion;
import conexiones.implementaciones.ConectorCIA;
import conexiones.interfaces.IConector;

/**
 * Clase de fábrica responsable de crear instancias de conectores
 * a diferentes sistemas o servicios, según el tipo de conexión solicitado.
 */
public class FabricaConectores {

    /**
     * Crea y devuelve un conector según el tipo de conexión especificado.
     *
     * @param tipoConexion El tipo de conexión que se desea crear (por ejemplo, "CIA").
     * @return Una implementación de {@link IConector} correspondiente al tipo de conexión solicitado.
     * @throws ServidorExcepcion Si ocurre un error al crear el conector.
     */
    public static IConector crearConector(String tipoConexion) throws ServidorExcepcion {
        if (tipoConexion.equals("CIA")) {
            return new ConectorCIA();
        }
        // Se pueden agregar más condiciones aquí para soportar otros tipos de conectores
        return null;
    }
}
