package pruebasUnitarias;

import carmenSandiego.modelo.ciudad.Ciudad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadTest {
    ArrayList pistasCiudad = new ArrayList(Arrays.asList("Buenos Aires","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "-34.58952254327074", "-58.34678308238882"));

    Ciudad ciudad = new Ciudad(pistasCiudad);
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void losDatosDeLaCiudadSonLosEsperados(){
        assertEquals("Buenos Aires", ciudad.getNombre());
        assertEquals("Celeste y blanca con un sol", ciudad.getBandera());
        assertEquals("Peso", ciudad.getMoneda());
        assertEquals("Campos", ciudad.getGeografia());
        assertEquals("Cataratas del Iguazu", ciudad.getHitos());
        assertEquals("Ganaderia", ciudad.getIndustria());
        assertEquals("Yaguarete", ciudad.getAnimales());
        assertEquals("Messi", ciudad.getPersonalidades());
        assertEquals("Espaniol", ciudad.getIdioma());
        assertEquals("Arte Mapuche", ciudad.getArte());
        assertEquals("Cristianismo", ciudad.getReligion());
        assertEquals("Presidente", ciudad.getGobierno());
        assertEquals("Antigua Colonia Espaniola", ciudad.getVarios());
        assertEquals(-34.58952254327074, ciudad.getUbicacion().getLatitud());
        assertEquals(-58.34678308238882, ciudad.getUbicacion().getLongitud());
    }

    @Test
    public void seAsignaLaCiudadSiguientePorLaQuePasoElLadron(){
        when(ciudadMock.getNombre()).thenReturn("Londres");
        ciudad.setCiudadSiguiente(ciudadMock);

        assertEquals("Londres", ciudad.getCiudadSiguiente().getNombre());
        assertTrue(ciudad.getPasoLadron());
    }

    @Test
    public void siUnLadronNoPasoPorUnaCiudadEstaNoTendraAsignadaUnaCiudadSiguiente(){
        assertFalse(ciudad.getPasoLadron());
        assertNull(ciudad.getCiudadSiguiente());
    }


}
