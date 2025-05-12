package control;

import presentacion.FrmActividadesLimpieza;
import presentacion.FrmRegistrarActividadLimpieza;

public class ControlActividadesLimpieza {

    private FrmActividadesLimpieza ventanaActividadesLimpieza;
    private FrmRegistrarActividadLimpieza ventanaRegistrarActividadLimpieza;

    public ControlActividadesLimpieza() {
        // Constructor de la clase
    }

    public void iniciarFlujo() {
        ventanaActividadesLimpieza = new FrmActividadesLimpieza(this);
        ventanaActividadesLimpieza.setVisible(true);
    }

    public void abrirRegistrarActividad() {
        ventanaRegistrarActividadLimpieza = new FrmRegistrarActividadLimpieza(this);
        ventanaRegistrarActividadLimpieza.setVisible(true);
    }

    public void acabarCaso() {
        ControlFlujo.iniciarFlujo();
    }

}
