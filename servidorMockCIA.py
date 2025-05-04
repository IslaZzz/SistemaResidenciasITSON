from flask import Flask, request, jsonify

app = Flask(__name__)

# mock de alumnos
alumnos_mock = {
    "00000252274": {
        "matricula": "00000252274",
        "nombre": "Jorge Cuevas",
        "sexo": "H",
        "semestre": "4",
        "carrera": "Ingenieria en Software",
        "correo": "jorge@potros.itson.edu.mx",
        "telefono": "6441222916",
        "direccion": "Av. Yaqui 1024"
    },
    "00000252687": {
        "matricula": "00000252687",
        "nombre": "Pedro Luna",
        "sexo": "H",
        "semestre": "4",
        "carrera": "Ingenieria en Software",
        "correo": "pedro@potros.itson.edu.mx",
        "telefono": "6442531964",
        "direccion": "Av. Yaqui 1124"
    },
    "00000252825": {
        "matricula": "00000252825",
        "nombre": "Ari Montoya",
        "sexo": "H",
        "semestre": "4",
        "carrera": "Ingenieria en Software",
        "correo": "ari@potros.itson.edu.mx",
        "telefono": "6441653126",
        "direccion": "Av. Yaqui 1324"
    },
    "00000253017": {
        "matricula": "00000253017",
        "nombre": "Abril Reyes",
        "sexo": "M",
        "semestre": "4",
        "carrera": "Ingenieria en Software",
        "correo": "abril@potros.itson.edu.mx",
        "telefono": "6311111405",
        "direccion": "Av. Yaqui 1824"
    },
    "00000241556": {
        "matricula": "00000241556",
        "nombre": "Victoria Valenzuela",
        "sexo": "M",
        "semestre": "4",
        "carrera": "Ingenieria en Software",
        "correo": "victoria@potros.itson.edu.mx",
        "telefono": "6444471622",
        "direccion": "Av. Yaqui 2024"
    }
}

@app.route('/buscar-alumno', methods=['POST'])
def buscar_alumno():
    datos = request.get_json()
    matricula = datos.get("matricula")

    alumno = alumnos_mock.get(matricula)
    if alumno:
        # regresa el alumno y el codigo 200 para confirmar que se encontro
        return jsonify(alumno), 200
    else:
        # regresa el codigo 404 para confirmar que no se encontro
        return jsonify({"error": "Alumno no encontrado"}), 404

if __name__ == '__main__':
    app.run(port=5000)