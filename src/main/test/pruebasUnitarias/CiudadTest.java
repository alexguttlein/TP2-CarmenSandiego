package pruebasUnitarias;

import carmenSandiego.modelo.Ciudad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadTest {
    ArrayList pistasCiudad = new ArrayList(Arrays.asList("Buenos Aires","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola"));

    Ciudad ciudad = new Ciudad(pistasCiudad);

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
    }
}