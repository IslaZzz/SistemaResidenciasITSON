package conexiones.implementaciones;

import java.net.URL;

public class NewMain {

    public static void main(String[] args) {
        URL resource = NewMain.class.getResource("/ContratoResidenteF.jrxml");
        System.out.println("Ruta del recurso: " + resource);
    }
}
