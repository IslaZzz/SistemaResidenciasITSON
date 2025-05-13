package control;

import presentacion.FrmMenuPrincipal;

/**
 * Controlador principal para gestionar el flujo de la aplicacion.
 * Administra la navegacion entre el menu principal y los diferentes casos de uso,
 * como registro de residentes, reportes de mantenimiento y actividades de limpieza.
 */
public class ControlFlujo {
    
    /**
     * Ventana principal de la aplicacion, utilizada para mostrar el menu inicial.
     */
    private static FrmMenuPrincipal ventana = new FrmMenuPrincipal();
    
    /**
     * Inicia el flujo de la aplicacion mostrando el menu principal.
     * Configura la ventana como visible y centrada en la pantalla.
     */
    public static void iniciarFlujo(){
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    /**
     * Inicia el caso de uso para reportes de mantenimiento.
     * Cierra el menu principal y delega el control al controlador de reportes.
     */
    public static void empezarCasoReporteMantenimiento(){
        ventana.dispose();
        ControlReporteMantenimiento controlReporteMantenimiento = new ControlReporteMantenimiento();
        controlReporteMantenimiento.iniciarFlujo();
    }
    
    /**
     * Inicia el caso de uso para registrar un nuevo residente.
     * Cierra el menu principal y delega el control al controlador de alta de residentes.
     */
    public static void empezarCasoAltaResidente(){
        ventana.dispose();
        ControlAltaResidente controlAlta = new ControlAltaResidente();
        controlAlta.iniciarFlujo();
    }

    /**
     * Inicia el caso de uso para actualizar los datos de un residente.
     * Cierra el menu principal y delega el control al controlador de actualizacion de residentes.
     */
    public static void empezarCasoActualizarResidente() {
        ventana.dispose();
        ControlActualizarResidente controlActualizarResidente= new ControlActualizarResidente();
        controlActualizarResidente.iniciarFlujo();
}
    /**
     * Inicia el caso de uso para generar una referencia de pago.
     * Cierra el menu principal y delega el control al controlador de referencias de pago.
     */
    public static void empezarCasoGenerarReferencia(){
        ventana.dispose();
        ControlGenerarReferenciaPago controlGenerarReferencia = new ControlGenerarReferenciaPago();
        controlGenerarReferencia.iniciarFlujo();
    }
    
    /**
     * Inicia el caso de uso para gestionar actividades de limpieza.
     * Cierra el menu principal y delega el control al controlador de actividades de limpieza.
     */
    public static void empezarCasoActividadesLimpieza(){
        ventana.dispose();
        ControlActividadesLimpieza controlActividadesLimpieza = ControlActividadesLimpieza.getInstance();
        controlActividadesLimpieza.iniciarFlujo();
    }

    /**
     * Cierra la aplicacion completamente.
     * Termina la ejecucion del programa.
     */
    public static void cerrarAplicacion(){
        System.exit(0);
    }
    
}
