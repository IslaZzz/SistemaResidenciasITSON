package objetosnegocio;

import dto.ActividadLimpiezaDTO;

public class ActividadLimpiezaBO {

    private static ActividadLimpiezaBO instance;

    private ActividadLimpiezaBO() { }

    public static ActividadLimpiezaBO getInstance() {
        if (instance == null) {
            instance = new ActividadLimpiezaBO();
        }
        return instance;
    }

    public void registrarActividadLimpieza(ActividadLimpiezaDTO actividad) {
        // Lógica para registrar la actividad de limpieza
        // Aquí puedes llamar a la capa de acceso a datos para guardar la actividad
        // Por ejemplo:
        // ActividadesLimpiezaDAOImp actividadesLimpiezaDAO = new ActividadesLimpiezaDAOImp();
        // actividadesLimpiezaDAO.registrarActividad(actividad);
    }

}
