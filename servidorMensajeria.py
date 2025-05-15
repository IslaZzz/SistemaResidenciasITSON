from flask import Flask, request, jsonify
from envioMensajesWhatsapp import generar_mensaje_whatsapp, enviar_mensaje_whatsapp

app = Flask(__name__)

@app.route('/api/enviarReporte', methods=['POST'])
def recibir_reporte():
    try:
        reporte = request.get_json()

        print("✅ Reporte recibido:")
        print(reporte)

        mensaje = generar_mensaje_whatsapp(reporte)
        print("\n📲 Mensaje para WhatsApp:")
        print(mensaje)

        # Envía el mensaje usando pywhatkit (modificar número de teléfono aquí)
        enviar_mensaje_whatsapp(mensaje, telefono="+526441653126")

        return jsonify({"mensaje": "Reporte recibido y mensaje enviado"}), 200

    except Exception as e:
        print("❌ Error al procesar el reporte:", str(e))
        return jsonify({"error": "Error al procesar el reporte"}), 400

if __name__ == '__main__':
    app.run(port=5001)
