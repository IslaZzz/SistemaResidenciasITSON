/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package administradorResidentes;

import java.util.List;

/**
 *
 * @author rauln
 */
public interface IAdministradorResidentesDos {
    List<String> obtenerResidentesPorHabitacion(Integer piso , Integer habitacion);
}
