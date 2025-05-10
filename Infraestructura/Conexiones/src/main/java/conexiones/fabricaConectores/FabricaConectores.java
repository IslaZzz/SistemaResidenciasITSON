package conexiones.fabricaConectores;

import conexiones.excepciones.ServidorExcepcion;
import conexiones.implementaciones.ConectorCIA;
import conexiones.interfaces.IConector;

public class FabricaConectores {

    public static IConector crearConector(String tipoConexion) throws ServidorExcepcion {
        if(tipoConexion.equals("CIA")){
            return new ConectorCIA();
        }
        //agregar mas conectores
        return null;
    }
}
