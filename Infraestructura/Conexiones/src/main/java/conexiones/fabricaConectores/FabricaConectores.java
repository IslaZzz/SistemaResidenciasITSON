package conexiones.fabricaConectores;

import conexiones.implementaciones.ConectorCIA;
import conexiones.interfaces.IConector;

public class FabricaConectores {

    public static IConector crearConector(String tipoConexion) {
        if(tipoConexion.equals("CIA")){
            return new ConectorCIA();
        }
        //agregar mas conectores
        return null;
    }
}
