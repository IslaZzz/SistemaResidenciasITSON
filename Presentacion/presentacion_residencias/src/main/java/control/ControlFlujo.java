package control;

import presentacion.FrmMenuPrincipal;

public class ControlFlujo {
    
    private static FrmMenuPrincipal ventana = new FrmMenuPrincipal();
    
    public static void iniciarFlujo(){
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    public static void empezarCasoReporteMantenimiento(){
        ventana.dispose();
        ControlReporteMantenimiento controlReporteMantenimiento = new ControlReporteMantenimiento();
        controlReporteMantenimiento.iniciarFlujo();
    }
    
    public static void empezarCasoAltaResidente(){
        ventana.dispose();
        ControlAltaResidente controlAlta = new ControlAltaResidente();
        controlAlta.iniciarFlujo();
    }

    public static void empezarCasoActualizarResidente() {
        ventana.dispose();
        ControlActualizarResidente controlActualizarResidente= new ControlActualizarResidente();
        controlActualizarResidente.iniciarFlujo();
}
    
    public static void empezarCasoGenerarReferencia(){
        ventana.dispose();
        ControlGenerarReferenciaPago controlGenerarReferencia = new ControlGenerarReferenciaPago();
        controlGenerarReferencia.iniciarFlujo();
    }
    
    public static void empezarCasoActividadesLimpieza(){
        ventana.dispose();
        ControlActividadesLimpieza controlActividadesLimpieza = new ControlActividadesLimpieza();
        controlActividadesLimpieza.iniciarFlujo();
    }

    public static void cerrarAplicacion(){
        System.exit(0);
    }
    
}
