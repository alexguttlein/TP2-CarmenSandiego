package pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PartidaTests {

    Tiempo tiempoMock = mock(Tiempo.class);
    Jugador jugadorMock = mock(Jugador.class);
    ObjetoRobado objetoRobadoMock = mock(ObjetoRobado.class);
    Ladron ladronMock = mock(Ladron.class);
    Interpol interpolMock = mock(Interpol.class);
    Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");


    @Test
    public void partidaRecibeLosObjetosInstanciadosCorrectamente(){

        when(tiempoMock.getHoraActual()).thenReturn(7);
        when(jugadorMock.getCantidadDeArrestos()).thenReturn(0);
        when(objetoRobadoMock.getImportancia()).thenReturn(new Caracteristica("Comun"));
        when(objetoRobadoMock.getCiudadOrigen()).thenReturn(ciudades.getCiudades().get(0));
        when(objetoRobadoMock.getNombre()).thenReturn(new Caracteristica("Tesoro"));
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(interpolMock.atraparSospechoso()).thenReturn(false);

        Partida partida = new Partida(jugadorMock, objetoRobadoMock, ladronMock, interpolMock, tiempoMock, ciudades);

        assertEquals(tiempoMock.getHoraActual(), partida.getTiempo().getHoraActual());
        assertEquals(jugadorMock.getCantidadDeArrestos(), partida.getJugador().getCantidadDeArrestos());
        assertEquals(objetoRobadoMock.getNombre(), partida.getObjetoRobado().getNombre());
        assertEquals(ladronMock.getGenero(), partida.getLadronActual().getGenero());
        assertEquals(interpolMock.atraparSospechoso(), partida.getInterpol().atraparSospechoso());
        assertEquals(ciudades, partida.getCiudades());
    }
}

