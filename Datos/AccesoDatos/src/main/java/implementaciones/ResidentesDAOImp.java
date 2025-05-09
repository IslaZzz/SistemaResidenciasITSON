package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import dto.ResidenteDTO;
import entities.Residente;
import enums.TipoResidente;
import interfaz.IResidentesDAO;

public class ResidentesDAOImp implements IResidentesDAO {

    @Override
    public Residente registrarResidente(ResidenteDTO residenteDTO) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Residente residente = parsearResidenteDTO(residenteDTO);
        residentes.insertOne(residente);
        return residente;
    }

    @Override
    public ResidenteDTO obtenerResidente(String matricula) {
        MongoCollection<Residente> residentes = obtenerColeccionResidentes();
        Residente residente = residentes.find(eq("matricula", matricula)).first();
        if (residente != null) {
            return parsearResidente(residente);
        }
        return null;
    }

    private MongoCollection<Residente> obtenerColeccionResidentes() {
        MongoDatabase db = ManejadorConexiones.obtenerConexion();
        return db.getCollection("residentes", Residente.class);
    }

    private Residente parsearResidenteDTO(ResidenteDTO dto) {
        Residente residente = new Residente();
        residente.setMatricula(dto.getMatricula());
        residente.setNombreCompleto(dto.getNombreCompleto());
        residente.setGenero(dto.getGenero());
        residente.setSemestre(dto.getSemestre());
        residente.setCarrera(dto.getCarrera());
        residente.setCorreo(dto.getCorreo());
        residente.setTelefono(dto.getTelefono());
        residente.setDireccion(dto.getDireccion());
        residente.setNombreContactoEmergencia(dto.getNombreContactoEmergencia());
        residente.setTelefonoContactoEmergencia(dto.getTelefonoContactoEmergencia());
        if(dto.getTipoResidente() != null) {
            residente.setTipoResidente(parsearTipoResidente(dto.getTipoResidente()));
        }
        return residente;
    }

    private ResidenteDTO parsearResidente(Residente residente) {
        ResidenteDTO residenteDTO = new ResidenteDTO(
                residente.getMatricula(),
                residente.getNombreCompleto(),
                residente.getGenero(),
                residente.getSemestre(),
                residente.getCarrera(),
                residente.getCorreo(),
                residente.getTelefono(),
                residente.getDireccion(),
                residente.getNombreContactoEmergencia(),
                residente.getTelefonoContactoEmergencia()
        );
        residenteDTO.setTipoResidente(residente.getTipoResidente().toString());
        return residenteDTO;
    }

    private TipoResidente parsearTipoResidente(String tipo) {
        switch (tipo) {
            case "NUEVO_INGRESO":
                return TipoResidente.NUEVO_INGRESO;
            case "DEPORTISTA":
                return TipoResidente.DEPORTISTA;
            case "EXTRANJERO":
                return TipoResidente.EXTRANJERO;
            default:
                throw new IllegalArgumentException("Tipo de residente no válido: " + tipo);
        }
    }

    @Override
    public ResidenteDTO asignarHabitacion(String matricula, String idHabitacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarHabitacion'");
    }

}
