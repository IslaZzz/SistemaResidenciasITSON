/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradorResidentes;

import java.util.List;
import objetosnegocio.ResidenteBO;

/**
 *
 * @author rauln
 */
public class AdministradorResidentesDosFachada implements IAdministradorResidentesDos {

    private ResidenteBO residenteBO = ResidenteBO.getInstance();

    @Override
    public List<String> obtenerResidentesPorHabitacion(Integer piso, Integer habitacion) {
        return residenteBO.obtenerResidentesPorHabitacion(piso, habitacion);

    }
}
