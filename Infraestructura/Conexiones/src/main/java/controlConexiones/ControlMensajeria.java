package controlConexiones;

import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.implementaciones.ConectorMensajeria;
import conexiones.interfaces.IConectorMensajeria;


/**
 * Clase de control que utiliza el conector de mensajería para enviar reportes por WhatsApp.
 */
public class ControlMensajeria {
    
    IConectorMensajeria conexionMensajeria;

    // Constructor donde inicias la conexión
    public ControlMensajeria() {
        this.conexionMensajeria = new ConectorMensajeria(); // <- instancia concreta
    }

    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        conexionMensajeria.enviarReportePorWhatsapp(reporte);
    }
}
