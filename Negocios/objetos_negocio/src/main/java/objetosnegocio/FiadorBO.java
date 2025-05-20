package objetosnegocio;

import dto.FiadorDTO;
import dto.ResidenteDTO;
import entities.Fiador;
import excepciones.NegocioException;
import exceptions.NoEncontradoException;
import implementaciones.AccesoDatosFachada;
import interfaz.IAccesoDatos;

public class FiadorBO {
    
    private static FiadorBO instance;
    
    private FiadorBO(){}

    public static FiadorBO getInstance() {
        if (instance == null) {
            instance = new FiadorBO();
        }
        return instance;
    }

    public Fiador registrarFiador(FiadorDTO fiador, ResidenteDTO residenteDTO) throws NoEncontradoException, NegocioException {
        validarFiador(fiador); 

        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.registrarFiador(fiador, residenteDTO);
    }

    public FiadorDTO consultarFiador(ResidenteDTO residenteDTO) throws NegocioException, NoEncontradoException {
        IAccesoDatos accesoDatos = new AccesoDatosFachada();
        return accesoDatos.consultarFiador(residenteDTO);
    }

    /**
     * Validaciones BO de fiador
     */
    private void validarFiador(FiadorDTO fiadorDTO) throws NegocioException {
        if (fiadorDTO == null) {
            throw new IllegalArgumentException("El fiador no puede ser nulo.");
        }

        if (isNullOrEmpty(fiadorDTO.getNombreCompleto())) {
            throw new IllegalArgumentException("El nombre del fiador no puede estar vacío.");
        }

        if (isNullOrEmpty(fiadorDTO.getDireccion())) {
            throw new IllegalArgumentException("La dirección del fiador no puede estar vacía.");
        }

        if (isNullOrEmpty(fiadorDTO.getOcupacion())) {
            throw new IllegalArgumentException("La ocupación del fiador no puede estar vacía.");
        }

        String telefono = fiadorDTO.getNumeroTelefono();
        if (isNullOrEmpty(telefono)) {
            throw new IllegalArgumentException("El teléfono del fiador no puede estar vacío.");
        }

        if (!telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe contener 10 dígitos .");
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
