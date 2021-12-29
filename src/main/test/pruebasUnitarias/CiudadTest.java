package pruebasUnitarias;

import edu.fiuba.algo3.modelo.ObjetoRobado;
import edu.fiuba.algo3.modelo.ObjetosRobados;
import edu.fiuba.algo3.modelo.Recorrido;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.edificio.EdificioBanco;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CiudadTest {

    ArrayList pistasCiudadBuenosAires = new ArrayList(Arrays.asList("Buenos Aires","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "-34.58952254327074", "-58.34678308238882"));

    ArrayList pistasCiudadMontreal = new ArrayList(Arrays.asList("Montreal","Roja y blanca", "dolar canadiense",
            "asd", "asd", "asd", "asd", "asd", "ingles", "asd", "asd", "asd", "asd",
            "45.573279804398034", "-73.49124739806629"));

    Ciudad ciudadBuenosAires = new Ciudad(pistasCiudadBuenosAires);
    Ciudad ciudadMontreal = new Ciudad(pistasCiudadMontreal);
    Edificio bancoMock = mock(EdificioBanco.class);

    @Test
    public void losDatosDeLaCiudadSonLosEsperados(){
        assertEquals("Buenos Aires", ciudadBuenosAires.getNombre().getCaracteristica());
        assertEquals("Celeste y blanca con un sol", ciudadBuenosAires.getBandera().getCaracteristica());
        assertEquals("Peso", ciudadBuenosAires.getMoneda().getCaracteristica());
        assertEquals("Campos", ciudadBuenosAires.getGeografia().getCaracteristica());
        assertEquals("Cataratas del Iguazu", ciudadBuenosAires.getHitos().getCaracteristica());
        assertEquals("Ganaderia", ciudadBuenosAires.getIndustria().getCaracteristica());
        assertEquals("Yaguarete", ciudadBuenosAires.getAnimales().getCaracteristica());
        assertEquals("Messi", ciudadBuenosAires.getPersonalidades().getCaracteristica());
        assertEquals("Espaniol", ciudadBuenosAires.getIdioma().getCaracteristica());
        assertEquals("Arte Mapuche", ciudadBuenosAires.getArte().getCaracteristica());
        assertEquals("Cristianismo", ciudadBuenosAires.getReligion().getCaracteristica());
        assertEquals("Presidente", ciudadBuenosAires.getGobierno().getCaracteristica());
        assertEquals("Antigua Colonia Espaniola", ciudadBuenosAires.getVarios().getCaracteristica());
        assertEquals(-34.58952254327074, ciudadBuenosAires.getUbicacion().getLatitud());
        assertEquals(-58.34678308238882, ciudadBuenosAires.getUbicacion().getLongitud());
    }

    @Test
    public void seAsignaLaCiudadSiguientePorLaQuePasoElLadron(){
        ciudadBuenosAires.setCiudadSiguiente(ciudadMontreal);

        assertEquals("Montreal", ciudadBuenosAires.getCiudadSiguiente().getNombre().getCaracteristica());
        assertTrue(ciudadBuenosAires.getPasoLadron());
    }

    @Test
    public void siUnLadronNoPasoPorUnaCiudadEstaNoTendraAsignadaUnaCiudadSiguiente(){
        assertFalse(ciudadBuenosAires.getPasoLadron());
        assertNull(ciudadBuenosAires.getCiudadSiguiente());
    }

    @Test
    public void jugadorVisitaBanco1Vez(){
        when(bancoMock.entrarAlEdificio()).thenReturn(1);
        int resultadoEsperado = ciudadBuenosAires.visitarEdificio(bancoMock);

        assertEquals(1, resultadoEsperado);
    }

    @Test
    public void jugadorViajaDeBuenosAiresAMontreal(){
        int resultadoEsperado = ciudadBuenosAires.viajarHasta(1000, ciudadMontreal);

        assertEquals(9, resultadoEsperado);
    }

    /*
    @Test
    public void seVenLasCiudadesSecundariasDeUnaCiudad(){
        Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");
        ObjetosRobados objetosRobados = new ObjetosRobados(ciudades);
        ObjetoRobado objetoRobado = objetosRobados.getObjetoRobadoAlAzar();
        Recorrido recorrido = new Recorrido(objetoRobado, ciudades);
        for (Ciudad actual : recorrido.getRecorridoReal()){
            for (Ciudad actual2 : actual.getCiudadesDisponiblesParaViajar()){
                System.out.println(actual.getNombre().getCaracteristica() + ": " + actual2.getNombre().getCaracteristica());
            }
        }
    }

     */
}
