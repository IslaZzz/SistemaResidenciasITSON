package control;

import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import excepciones.NegocioException;
import itson.negocios_administradoractividadeslimpieza.AdministradorActividadesLimpiezaFachada;
import itson.negocios_administradoractividadeslimpieza.IAdministradorActividadesLimpieza;
import itson.negocios_administradorpersonal.AdministradorPersonalFachada;
import itson.negocios_administradorpersonal.IAdministradorPersonal;
import itson.negocios_administradorzonas.AdministradorZonasFachada;
import itson.negocios_administradorzonas.IAdministradorZonas;
import presentacion.FrmActividadesLimpieza;
import presentacion.FrmRegistrarActividadLimpieza;

public class ControlActividadesLimpieza {

    private FrmActividadesLimpieza ventanaActividadesLimpieza;
    private FrmRegistrarActividadLimpieza ventanaRegistrarActividadLimpieza;

    private static ControlActividadesLimpieza instance;

    public static ControlActividadesLimpieza getInstance() {
        if (instance == null) {
            instance = new ControlActividadesLimpieza();
        }
        return instance;
    }
    
    private ControlActividadesLimpieza() {
        // Constructor privado para implementar el patrón Singleton
    }

    public void iniciarFlujo() {
        ventanaActividadesLimpieza = new FrmActividadesLimpieza(this);
        ventanaActividadesLimpieza.setVisible(true);
    }

    public void abrirRegistrarActividad() {
        ventanaRegistrarActividadLimpieza = new FrmRegistrarActividadLimpieza(this);
        ventanaRegistrarActividadLimpieza.setVisible(true);
    }

    public void acabarCaso() {
        ControlFlujo.iniciarFlujo();
    }

    public List<ZonaDTO> obtenerZonas() {
        IAdministradorZonas adminZonas = new AdministradorZonasFachada();
        return adminZonas.obtenerZonas();
    }

    public List<PersonalDTO> obtenerPersonal() {
        IAdministradorPersonal adminPersonal = new AdministradorPersonalFachada();
        return adminPersonal.obtenerPersonalPorPuesto("LIMPIEZA");
    }

    public List<ActividadLimpiezaDTO> obtenerActividades() {
        IAdministradorActividadesLimpieza adminActividades = new AdministradorActividadesLimpiezaFachada();
        return adminActividades.obtenerActividadesLimpieza();
    }

    public ZonaDTO obtenerZona(ZonaDTO zona) throws NegocioException {
        IAdministradorZonas adminZonas = new AdministradorZonasFachada();
        ZonaDTO zonaEncontrada = adminZonas.obtenerZona(zona);
        return zonaEncontrada;
    }

    public PersonalDTO obtenerPersonal(PersonalDTO personal) throws NegocioException {
        IAdministradorPersonal adminPersonal = new AdministradorPersonalFachada();
        PersonalDTO personalEncontrado = adminPersonal.obtenerPersonal(personal);
        return personalEncontrado;
    }

    public void registrarActividad(ActividadLimpiezaDTO actividad, ZonaDTO zona, PersonalDTO personal) throws NegocioException {
        IAdministradorActividadesLimpieza adminActividades = new AdministradorActividadesLimpiezaFachada();
        adminActividades.registrarActividadLimpieza(actividad, zona, personal);
    }

}
