package controlConexiones;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.fabricaConectores.FabricaConectores;
import conexiones.interfaces.IConectorMensajeria;

/**
 * Clase de control que utiliza el conector de mensajería para enviar reportes
 * por WhatsApp.
 */
public class ControlMensajeria {

    /**
     * Interface para definir los métodos que debe implementar cualquier
     * conector de mensajería, ya sea para enviar reportes por WhatsApp o
     * referencias por correo electrónico.
     */
    IConectorMensajeria conexionMensajeria;

    /**
     * Envía un reporte por WhatsApp utilizando el conector correspondiente.
     *
     * @param reporte Objeto que contiene la información del reporte a enviar.
     * @throws ServidorExcepcion Si ocurre un error en el servidor durante el
     * envío.
     */
    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        this.conexionMensajeria = FabricaConectores.crearConexionMensajeria("WHATSAPP");
        conexionMensajeria.enviarReportePorWhatsapp(reporte);
    }

    /**
     * Envía una referencia de pago por correo electrónico utilizando el
     * conector correspondiente.
     *
     * @param referencia Objeto que contiene la información de la referencia de
     * pago.
     * @return true si el correo fue enviado exitosamente, false en caso
     * contrario.
     * @throws ServidorExcepcion Si ocurre un error en el servidor durante el
     * envío.
     */
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws ServidorExcepcion {
        this.conexionMensajeria = FabricaConectores.crearConexionMensajeria("CORREO");
        return conexionMensajeria.enviarReferenciaCorreo(referencia);
    }
}
