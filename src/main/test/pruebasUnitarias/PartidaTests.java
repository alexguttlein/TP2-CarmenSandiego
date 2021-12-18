package pruebasUnitarias;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.Partida;
import carmenSandiego.modelo.Jugador;
import carmenSandiego.modelo.ciudad.Ciudades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    Ciudades ciudades = new Ciudades();
    Partida partida = new Partida(jugadorMock, objetoRobadoMock, ladronMock, interpolMock, tiempoMock, ciudades);

    /*
    @Test
    public void partidaRecibeLosObjetosInstanciadosCorrectamente(){
        when(tiempoMock.getHoraActual()).thenReturn(7);
        when(jugadorMock.getCantidadDeArrestos()).thenReturn(0);
        when(objetoRobadoMock.getNombre()).thenReturn("Tesoro");
        when(ladronMock.getGenero()).thenReturn("Femenino");
        when(interpolMock.atraparSospechoso()).thenReturn(false);

        assertEquals(tiempoMock.getHoraActual(), partida.getTiempo().getHoraActual());
        assertEquals(jugadorMock.getCantidadDeArrestos(), partida.getJugador().getCantidadDeArrestos());
        assertEquals(objetoRobadoMock.getNombre(), partida.getObjetoRobado().getNombre());
        assertEquals(ladronMock.getGenero(), partida.getLadronActual().getGenero());
        assertEquals(interpolMock.atraparSospechoso(), partida.getInterpol().atraparSospechoso());
        assertEquals("Buenos Aires", partida.getCiudades().getCiudades().get(0).getNombre());
    }

     */

}
