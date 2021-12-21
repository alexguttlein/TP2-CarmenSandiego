package pruebasUnitarias;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ubicacion;
import carmenSandiego.modelo.jugador.rango.Rango;
import carmenSandiego.modelo.jugador.rango.RangoNovato;
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
        assertTrue(new Caracteristica(("Buenos Aires")).compararCaracteristica(ciudad.getNombre()));
        assertTrue(new Caracteristica(("Peso")).compararCaracteristica(ciudad.getMoneda()));
        assertTrue(new Caracteristica(("Campos")).compararCaracteristica(ciudad.getGeografia()));
        assertTrue(new Caracteristica(("Cataratas del Iguazu")).compararCaracteristica(ciudad.getHitos()));
        assertTrue(new Caracteristica(("Ganaderia")).compararCaracteristica(ciudad.getIndustria()));
        assertTrue(new Caracteristica(("Yaguarete")).compararCaracteristica(ciudad.getAnimales()));
        assertTrue(new Caracteristica(("Messi")).compararCaracteristica(ciudad.getPersonalidades()));
        assertTrue(new Caracteristica(("Espaniol")).compararCaracteristica(ciudad.getIdioma()));
        assertTrue(new Caracteristica(("Arte Mapuche")).compararCaracteristica(ciudad.getArte()));
        assertTrue(new Caracteristica(("Cristianismo")).compararCaracteristica(ciudad.getReligion()));
        assertTrue(new Caracteristica(("Presidente")).compararCaracteristica(ciudad.getGobierno()));
        assertTrue(new Caracteristica(("Antigua Colonia Espaniola")).compararCaracteristica(ciudad.getVarios()));
        assertTrue(new Ubicacion(-34.58952254327074,-58.34678308238882).compararUbicacion(ciudad.getUbicacion()));
    }

    @Test
    public void seAsignaLaCiudadSiguientePorLaQuePasoElLadron(){
        when(ciudadMock.getNombre()).thenReturn(new Caracteristica("Londres"));
        ciudad.setCiudadSiguiente(ciudadMock);

        assertTrue(ciudad.getCiudadSiguiente().getNombre().compararCaracteristica(ciudadMock.getNombre()));
        assertTrue(ciudad.getPasoLadron());
    }

    @Test
    public void siUnLadronNoPasoPorUnaCiudadEstaNoTendraAsignadaUnaCiudadSiguiente(){
        assertFalse(ciudad.getPasoLadron());
        assertNull(ciudad.getCiudadSiguiente());
    }

    @Test
    public void seDefineElRangoDeUnJugadorAUnaCiudad(){
        Rango rango = new RangoNovato(0);
        Rango rangoNovato = new RangoNovato(0);
        ciudad.setRangoPersonaje(rango);

        assertTrue(ciudad.getRango().compararRangos(rangoNovato));
    }


}
