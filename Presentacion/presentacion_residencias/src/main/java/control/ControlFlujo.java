package control;

import presentacion.FrmMenuPrincipal;

public class ControlFlujo {
    
    private static FrmMenuPrincipal ventana = new FrmMenuPrincipal();
    
    public static void iniciarFlujo(){
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    public static void empezarCasoAltaResidente(){
        ventana.dispose();
        ControlAltaResidente controlAlta = new ControlAltaResidente();
        controlAlta.iniciarFlujo();
    }
    
    public static void cerrarAplicacion(){
        System.exit(0);
    }
    
}
