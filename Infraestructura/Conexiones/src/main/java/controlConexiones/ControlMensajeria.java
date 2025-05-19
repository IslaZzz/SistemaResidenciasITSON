package controlConexiones;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.fabricaConectores.FabricaConectores;
import conexiones.implementaciones.ConectorMensajeria;
import conexiones.interfaces.IConectorMensajeria;


/**
 * Clase de control que utiliza el conector de mensajería para enviar reportes por WhatsApp.
 */
public class ControlMensajeria {
    
    IConectorMensajeria conexionMensajeria;

    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        this.conexionMensajeria = FabricaConectores.crearConexionMensajeria("WHATSAPP");
        conexionMensajeria.enviarReportePorWhatsapp(reporte);
    }
    
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws ServidorExcepcion {
        this.conexionMensajeria = FabricaConectores.crearConexionMensajeria("CORREO");
        return conexionMensajeria.enviarReferenciaCorreo(referencia);
    }
}
