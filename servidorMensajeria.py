from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/api/enviarReporte', methods=['POST'])
def recibir_reporte():
    try:
        reporte = request.get_json()

        # Solo mostramos el contenido recibido por consola
        print("✅ Reporte recibido:")
        print(reporte)

        # Puedes agregar validación aquí si deseas
        return jsonify({"mensaje": "Reporte recibido correctamente"}), 200

    except Exception as e:
        print("❌ Error al procesar el reporte:", str(e))
        return jsonify({"error": "Error al procesar el reporte"}), 400

if __name__ == '__main__':
    app.run(port=5001)
