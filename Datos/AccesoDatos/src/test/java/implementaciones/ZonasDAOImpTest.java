package implementaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dto.ZonaDTO;
import entities.Zona;
import exceptions.NoEncontradoException;
import interfaz.IZonasDAO;

public class ZonasDAOImpTest {

    IZonasDAO zonasDAO = new ZonasDAOImp();
    Zona zonaGuardada;

    public ZonasDAOImpTest() {
    }

    @BeforeAll
    public static void activarModoPruebas() {
        ManejadorConexiones.activateTestMode();
    }

    @AfterAll
    public static void desactivarModoPruebas() {
        ManejadorConexiones.deactivateTestMode();
    }

    @AfterEach
    public void eliminarZonaGuardada() {
        if (zonaGuardada != null) {
            ZonaDTO zonaDTO = new ZonaDTO(zonaGuardada.getId().toString(), zonaGuardada.getPiso(),
                    zonaGuardada.getNombre());
            try {
                zonasDAO.eliminarZona(zonaDTO);
            } catch (NoEncontradoException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testAgregarZona() {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Zona A");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        assertNotNull(zonaGuardada);
        assertNotNull(zonaGuardada.getId());
        assertEquals(zonaDTO.getPiso(), zonaGuardada.getPiso());
        assertEquals(zonaDTO.getNombre(), zonaGuardada.getNombre());
    }

    @Test
    public void testEliminarZona() {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Zona A");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        try {
            zonasDAO.eliminarZona(zonaDTO);
            assertThrows(NoEncontradoException.class, () -> {
                zonasDAO.obtenerZona(zonaDTO);
            });
        } catch (NoEncontradoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtenerZona() {
        ZonaDTO zonaDTO = new ZonaDTO(1, "Zona A");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO);
        try {
            ZonaDTO zonaObtenida = zonasDAO.obtenerZona(zonaDTO);
            assertNotNull(zonaObtenida);
            assertEquals(zonaGuardada.getId(), new ObjectId(zonaObtenida.getId()));
            assertEquals(zonaGuardada.getPiso(), zonaObtenida.getPiso());
            assertEquals(zonaGuardada.getNombre(), zonaObtenida.getNombre());
        } catch (NoEncontradoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtenerZonas() {
        ZonaDTO zonaDTO1 = new ZonaDTO(1, "Zona A");
        zonaGuardada = zonasDAO.agregarZona(zonaDTO1);
        List<ZonaDTO> zonas = zonasDAO.obtenerZonas();
        assertNotNull(zonas);
        assertTrue(zonas.size() >= 1);
        assertTrue(zonas.stream().anyMatch(z -> z.getId().equals(zonaGuardada.getId().toString())));
    }

}
