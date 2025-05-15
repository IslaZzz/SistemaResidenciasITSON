import pywhatkit
import datetime
import time

def generar_mensaje_whatsapp(reporte: dict) -> str:
    return (
        "🔧 Nuevo reporte de mantenimiento:\n\n"
        f"📌 Piso: {reporte.get('piso', 'N/A')}\n"
        f"🛏️ Habitación: {reporte.get('habitacion', 'N/A')}\n"
        f"👤 Residente: {reporte.get('residente', 'N/A')}\n"
        f"🕐 Horario preferente: {reporte.get('horaInicio', 'N/A')}\n"
        f"📝 Descripción del problema: {reporte.get('descripcion', 'N/A')}"
    )

def enviar_mensaje_whatsapp(mensaje: str, telefono: str):
    """
    Envía un mensaje de WhatsApp instantáneo usando pywhatkit.
    :param mensaje: Texto del mensaje a enviar
    :param telefono: Número de teléfono con código país, ejemplo: +5211234567890
    """

    ahora = datetime.datetime.now()
    # Para enviar instantáneamente, programamos el envío 20 segundos más adelante
    minuto_envio = ahora.minute
    hora_envio = ahora.hour
    segundo_envio = ahora.second + 20
    if segundo_envio >= 60:
        segundo_envio -= 60
        minuto_envio += 1
    if minuto_envio >= 60:
        minuto_envio -= 60
        hora_envio += 1
    if hora_envio >= 24:
        hora_envio = 0

    # Evitar abrir varias ventanas: solo envía 1 vez por ejecución
    pywhatkit.sendwhatmsg_instantly(
        phone_no=telefono,
        message=mensaje,
        wait_time=10,
        tab_close=True,
        close_time=5
    )
    print("✅ Mensaje enviado por WhatsApp.")

    # Esperar un poco para que el mensaje se haya enviado antes de cerrar el script
    time.sleep(15)
