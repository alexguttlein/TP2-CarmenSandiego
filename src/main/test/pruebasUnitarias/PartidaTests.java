package pruebasUnitarias;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.Partida;
import carmenSandiego.modelo.Jugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PartidaTests {
/*
    ArrayList pistasCiudadMexico = new ArrayList(Arrays.asList("Mexico","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "19.801771980077525", "-98.97085615538418"));
    ArrayList pistasCiudadMontreal = new ArrayList(Arrays.asList("Montreal","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "46.27068001656241", "-72.94882925379466"));

    Ciudad ciudadMontreal = new Ciudad(pistasCiudadMontreal);
    Ciudad ciudadMexico = new Ciudad(pistasCiudadMexico);
    ArrayList ciudades = new ArrayList(Arrays.asList(ciudadMontreal, ciudadMexico));

    Jugador jugador = new Jugador("Ivan", new Tiempo());
    ObjetoRobado objetoRobadoMock = mock(ObjetoRobado.class);


 */
    Tiempo tiempoMock = mock(Tiempo.class);
    Jugador jugadorMock = mock(Jugador.class);
    ObjetoRobado objetoRobadoMock = mock(ObjetoRobado.class);
    Ladron ladronMock = mock(Ladron.class);
    Interpol interpolMock = mock(Interpol.class);
    Partida partida = new Partida(jugadorMock, objetoRobadoMock, ladronMock, interpolMock, tiempoMock);

    @Test
    public void alIniciarLaPartidaSeGeneranCorrectamenteLasCiudades(){
        Ciudades ciudades = partida.getCiudades();

        assertEquals("Buenos Aires", ciudades.getCiudades().get(0).getNombre());
    }

}
