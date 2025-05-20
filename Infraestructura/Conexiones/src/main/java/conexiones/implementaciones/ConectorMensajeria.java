package conexiones.implementaciones;

import DTO_Infraestructura.ReferenciaPagoInfDTO;
import DTO_Infraestructura.ReporteInfDTO;
import conexiones.excepciones.ServidorExcepcion;
import conexiones.interfaces.IConectorMensajeria;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Clase ConectorMensajeria que implementa la interfaz IConectorMensajeria.
 * Proporciona métodos para enviar mensajes a través de diferentes medios de
 * mensajería, como WhatsApp y correo electrónico, dependiendo de la
 * configuración especificada.
 */
public class ConectorMensajeria implements IConectorMensajeria {

    private String tipoMensajeria;
    private URL url;
    private Session session;
    final String remitente = "itsonresidencias@gmail.com";
    final String clave = "xbgf ofwm hxsx yagg";

    /**
     * Constructor que inicializa el conector de mensajería según el tipo
     * especificado.
     *
     * @param tipoMensajeria Tipo de mensajería a usar ("WHATSAPP" o "CORREO").
     * - Si es "WHATSAPP", se configura la URL para el servicio de envío de
     * reportes. - Si es "CORREO", se configura la sesión SMTP para envío de
     * correos usando Gmail.
     * @throws RuntimeException Si la URL para WhatsApp es inválida.
     */
    public ConectorMensajeria(String tipoMensajeria) {
        if (tipoMensajeria.equals("WHATSAPP")) {
            try {
                this.url = new URL("http://localhost:5001/api/enviarReporte"); // Cambiar si es necesario
            } catch (Exception e) {
                throw new RuntimeException("URL inválida para ConectorMensajeria", e);
            }
        } else if (tipoMensajeria.equals("CORREO")) {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            this.session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitente, clave);
                }
            });
        }

    }

    /**
     * Envía un reporte vía WhatsApp usando una solicitud HTTP POST con el
     * reporte en formato JSON.
     *
     * @param reporte Objeto DTO que contiene la información del reporte a
     * enviar.
     * @throws ServidorExcepcion Si ocurre un error en la conexión o envío.
     */
    @Override
    public void enviarReportePorWhatsapp(ReporteInfDTO reporte) throws ServidorExcepcion {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            JSONObject reporteJson = convertirReporteAJson(reporte);
            String jsonString = reporteJson.toString();

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
                os.write(input);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200 && responseCode != 201) {
                throw new ServidorExcepcion("Error al enviar reporte. Código HTTP: " + responseCode);
            }

        } catch (Exception e) {
            throw new ServidorExcepcion("Error al enviar reporte", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * Convierte un objeto ReporteInfDTO a un objeto JSON para su envío.
     *
     * @param reporte Objeto DTO que contiene la información del reporte.
     * @return JSONObject con la representación JSON del reporte.
     */
    private JSONObject convertirReporteAJson(ReporteInfDTO reporte) {
        JSONObject json = new JSONObject();
        json.put("piso", reporte.getPiso());
        json.put("habitacion", reporte.getHabitacion());
        json.put("residente", reporte.getResidente());
        json.put("horaInicio", reporte.getHorarioVisita());
        json.put("descripcion", reporte.getDescripcionProblema());
        return json;
    }

    /**
     * Convierte un objeto ReferenciaPagoInfDTO a un archivo PDF con formato
     * institucional.
     *
     * @param referencia Objeto DTO que contiene la información de la referencia
     * de pago.
     * @return Archivo PDF generado con los datos de la referencia, o null si
     * hay error.
     */
    private File convertirReferenciaAPDF(ReferenciaPagoInfDTO referencia) {
        try {
            // tamaño de la hoja
            Rectangle tamañoPersonalizado = new Rectangle(612, 580);
            Document documento = new Document(tamañoPersonalizado);

            // creacion de archivo
            String nombreArchivo = "referencia_pago_" + referencia.getFolio() + ".pdf";
            File archivoPDF = new File(nombreArchivo);
            PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));
            documento.open();

            // contenido del archivo
            // === Encabezado con texto institucional y logo ===
            PdfPTable encabezado = new PdfPTable(2);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new float[]{3, 1});

            Font fontInstitucion = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            Paragraph textoInstitucional = new Paragraph(
                    "Instituto Tecnológico de Sonora\n"
                    + "Universidad Pública\n"
                    + "Unidad Obregón, Campus Náinari.\n"
                    + "Antonio Caso 2266, Villa ITSON, C.P. 85130.", fontInstitucion);
            PdfPCell celdaTexto = new PdfPCell(textoInstitucional);
            celdaTexto.setBorder(Rectangle.NO_BORDER);
            celdaTexto.setVerticalAlignment(Element.ALIGN_MIDDLE);
            encabezado.addCell(celdaTexto);

            Image imgLogoItson = Image.getInstance("src/main/resources/imagenes/logo_ITSON.png");
            imgLogoItson.scaleToFit(100, 100);
            PdfPCell celdaLogo = new PdfPCell(imgLogoItson);
            celdaLogo.setBorder(Rectangle.NO_BORDER);
            celdaLogo.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaLogo.setVerticalAlignment(Element.ALIGN_MIDDLE);
            encabezado.addCell(celdaLogo);

            documento.add(encabezado);

            // === Título ===
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
            Paragraph titulo = new Paragraph("REFERENCIA DE PAGO", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(Chunk.NEWLINE);

            // === Fecha de generación ===
            Paragraph fechaGeneracion = new Paragraph("Fecha de generación: " + referencia.getFechaGeneracion());
            fechaGeneracion.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fechaGeneracion);

            // === Línea separadora ===
            LineSeparator separator = new LineSeparator();
            separator.setLineWidth(2f);
            documento.add(new Chunk(separator));

            // === Fuentes ===
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font negritaGrande = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font normalGrande = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL);
            Font negritaRoja = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.RED);
            Font normalRoja = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.RED);

            // === Datos del residente ===
            documento.add(Chunk.NEWLINE);
            documento.add(crearParrafoConEtiqueta("Residente: ", referencia.getNombreResidente(), negrita, normal));
            documento.add(crearParrafoConEtiqueta("ID Alumno: ", referencia.getMatriculaResidente(), negrita, normal));
            documento.add(crearParrafoConEtiqueta("Correo: ", referencia.getCorreoResidente(), negrita, normal));
            documento.add(crearParrafoConEtiqueta("Carrera: ", referencia.getCarreraResidente(), negrita, normal));

            LineSeparator separator2 = new LineSeparator();
            separator2.setLineWidth(2f);
            documento.add(new Chunk(separator2));

            // === Concepto y total ===
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(crearParrafoConEtiqueta("Concepto: ", "Residencias ITSON - Habitación " + referencia.getHabitacion(), negritaGrande, normalGrande));
            documento.add(Chunk.NEWLINE);
            documento.add(crearParrafoConEtiqueta("Total a pagar: $", String.valueOf(referencia.getImporte()), negritaGrande, negritaGrande));
            documento.add(Chunk.NEWLINE);

            // === Imágenes: BBVA + Código QR ===
            PdfPTable tablaImagenes = new PdfPTable(2);
            tablaImagenes.setWidthPercentage(100);
            tablaImagenes.setWidths(new float[]{1, 1});

            Image imgBBVA = Image.getInstance("src/main/resources/imagenes/BBVA-logo.png");
            imgBBVA.scaleToFit(100, 50);
            PdfPCell celdaBBVA = new PdfPCell(imgBBVA);
            celdaBBVA.setBorder(Rectangle.NO_BORDER);
            celdaBBVA.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaImagenes.addCell(celdaBBVA);

            Image imgQR = Image.getInstance("src/main/resources/imagenes/codigo_qr.png");
            imgQR.scaleToFit(100, 100);
            PdfPCell celdaQR = new PdfPCell(imgQR);
            celdaQR.setBorder(Rectangle.NO_BORDER);
            celdaQR.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaImagenes.addCell(celdaQR);

            documento.add(tablaImagenes);

            // === Folio y referencia ===
            PdfPTable tablaFolioReferencia = new PdfPTable(2);
            tablaFolioReferencia.setWidthPercentage(100);
            tablaFolioReferencia.setSpacingBefore(10);
            tablaFolioReferencia.setWidths(new float[]{1, 1});

            PdfPCell celdaFolio = new PdfPCell(crearParrafoConEtiqueta("Folio: ", referencia.getFolio(), negritaGrande, normalGrande));
            celdaFolio.setBorder(Rectangle.NO_BORDER);
            tablaFolioReferencia.addCell(celdaFolio);

            PdfPCell celdaReferencia = new PdfPCell(crearParrafoConEtiqueta("Referencia: ", referencia.getReferencia(), negritaGrande, normalGrande));
            celdaReferencia.setBorder(Rectangle.NO_BORDER);
            tablaFolioReferencia.addCell(celdaReferencia);

            documento.add(tablaFolioReferencia);

            // === Separador ===
            LineSeparator separator3 = new LineSeparator();
            separator3.setLineWidth(2f);
            documento.add(new Chunk(separator3));
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            // === Fecha de vencimiento centrada y en rojo ===
            Paragraph vencimiento = crearParrafoConEtiqueta("Fecha de vencimiento: ", referencia.getFechaVencimiento().toString(), negritaRoja, normalRoja);
            vencimiento.setAlignment(Element.ALIGN_CENTER);
            documento.add(vencimiento);
            documento.close();
            return archivoPDF;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Genera un parrafo con 2 fuentes diferentes para darle mejor formato a los
     * textos del pdf
     *
     * @param etiqueta Recibe una etiqueta de tipo string
     * @param valor Recibe un valor de tipo string
     * @param fontEtiqueta Recibe una fuente para la etiqueta
     * @param fontValor Recibe una fuente para el valor
     * @return regresa el parrafo con los parametros otorgados
     */
    private Paragraph crearParrafoConEtiqueta(String etiqueta, String valor, Font fontEtiqueta, Font fontValor) {
        Paragraph parrafo = new Paragraph();
        parrafo.add(new Chunk(etiqueta, fontEtiqueta));
        parrafo.add(new Chunk(valor, fontValor));
        return parrafo;
    }

    /**
     * Envía la referencia de pago generada en PDF como un archivo adjunto por
     * correo electrónico.
     *
     * @param referencia Objeto DTO que contiene la información de la referencia
     * de pago.
     * @return true si el correo fue enviado correctamente, false en caso
     * contrario.
     * @throws ServidorExcepcion Si ocurre un error al generar el PDF o enviar
     * el correo.
     */
    @Override
    public boolean enviarReferenciaCorreo(ReferenciaPagoInfDTO referencia) throws ServidorExcepcion {
        try {
            File archivoPDF = convertirReferenciaAPDF(referencia);
            if (archivoPDF == null) {
                throw new ServidorExcepcion("Error al generar el archivo pdf");
            }

            Message message = new MimeMessage(session); // Usamos la session ya configurada
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(referencia.getCorreoResidente()));
            message.setSubject("Referencia de Pago - ITSON");

            MimeBodyPart texto = new MimeBodyPart();
            texto.setText("Hola " + referencia.getNombreResidente() + ",\n\nAdjunto encontrarás tu referencia de pago.\n\nSaludos.\nResidencias ITSON");

            MimeBodyPart adjunto = new MimeBodyPart();
            adjunto.attachFile(archivoPDF);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            multipart.addBodyPart(adjunto);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo enviado correctamente.");
            return true;

        } catch (Exception e) {
            throw new ServidorExcepcion("Error al generar el archivo pdf");

        }

    }

}
