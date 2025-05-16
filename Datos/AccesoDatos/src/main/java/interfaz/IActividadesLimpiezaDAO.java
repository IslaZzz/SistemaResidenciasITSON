package interfaz;

import java.util.List;

import dto.ActividadLimpiezaDTO;
import dto.PersonalDTO;
import dto.ZonaDTO;
import entities.ActividadLimpieza;
import exceptions.NoEncontradoException;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de actividades de limpieza
 * en el sistema. Proporciona métodos para registrar, eliminar, obtener y listar actividades de limpieza.
 */
public interface IActividadesLimpiezaDAO {

    /**
     * Registra una nueva actividad de limpieza en el sistema.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a registrar.
     * @return Un objeto ActividadLimpieza que representa la actividad registrada, incluyendo su identificador único.
     * @throws exceptions.NoEncontradoException
     */
    public abstract ActividadLimpieza registrarActividadLimpieza(ActividadLimpiezaDTO actividad) throws NoEncontradoException;

    /**
     * Elimina una actividad de limpieza existente del sistema.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a eliminar.
     * @return true si la operación de eliminación fue exitosa, false en caso contrario.
     * @throws NoEncontradoException Si no se encuentra la actividad con los datos especificados.
     */
    public abstract boolean eliminarActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException;

    /**
     * Obtiene una actividad de limpieza específica del sistema.
     *
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a buscar.
     * @return Un objeto ActividadLimpieza que representa la actividad encontrada.
     */
    public abstract ActividadLimpieza obtenerActividad(ActividadLimpiezaDTO actividad) throws NoEncontradoException;

    /**
     * Obtiene una actividad de limpieza específica del sistema
     * en función del personal y la hora especificados.
     * @param actividad El objeto ActividadLimpiezaDTO que contiene los datos de la actividad a buscar.
     * @return Un objeto ActividadLimpieza que representa la actividad encontrada.
     */
    public abstract ActividadLimpieza obtenerActividadSolapada(ActividadLimpiezaDTO actividad) throws NoEncontradoException;

    /**
     * Obtiene una lista de todas las actividades de limpieza registradas en el sistema.
     *
     * @return Una lista de objetos ActividadLimpieza que representan todas las actividades registradas.
     */
    public abstract List<ActividadLimpieza> obtenerActividadesLimpieza();

    /**
     * Obtiene una lista de actividades de limpieza filtradas según un criterio específico.
     *
     * @param filtro El criterio de filtro para las actividades de limpieza.
     * @return Una lista de objetos ActividadLimpieza que cumplen con el criterio de filtro.
     */
    public abstract List<ActividadLimpieza> obtenerActividadesPorFiltro(String filtro);
}