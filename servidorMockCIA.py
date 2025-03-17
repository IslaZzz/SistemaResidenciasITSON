from flask import Flask, jsonify

app = Flask(__name__)

# mock de alumnos
alumnos_mock = {
    "00000252274": {
        "matricula": "00000252274",
        "nombre": "Jorge Cuevas",
        "carrera": "Ingenieria en Software",
        "correo": "jorge@potros.itson.edu.mx",
        "telefono": "6441222916"
    },
    "20231002": {
        "matricula": "00000252687",
        "nombre": "Pedro Luna",
        "carrera": "Ingenieria en Software",
        "correo": "pedro@potros.itson.edu.mx",
        "telefono": "6442531964"
    }
}

@app.route('/alumno/<matricula>', methods=['GET'])
def obtener_alumno(matricula):
    alumno = alumnos_mock.get(matricula)
    if alumno:
        return jsonify(alumno)
    else:
        return jsonify({"error": "Alumno no encontrado"}), 404

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
