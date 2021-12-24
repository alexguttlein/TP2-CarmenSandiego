package pruebasUnitarias;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.Partida;
import carmenSandiego.modelo.jugador.Jugador;
import carmenSandiego.modelo.ciudad.Ciudades;
import carmenSandiego.modelo.Interpol;
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
    Ciudades ciudades = new Ciudades("src/main/java/datosDelJuego/ciudades.csv");
    Partida partida = new Partida(jugadorMock, objetoRobadoMock, ladronMock, interpolMock, tiempoMock, ciudades);

    @Test
    public void partidaRecibeLosObjetosInstanciadosCorrectamente(){

        when(tiempoMock.getHoraActual()).thenReturn(7);
        when(jugadorMock.getCantidadDeArrestos()).thenReturn(0);
        when(objetoRobadoMock.getNombre()).thenReturn(new Caracteristica("Tesoro"));
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(interpolMock.atraparSospechoso()).thenReturn(false);

        assertEquals(tiempoMock.getHoraActual(), partida.getTiempo().getHoraActual());
        assertEquals(jugadorMock.getCantidadDeArrestos(), partida.getJugador().getCantidadDeArrestos());
        assertEquals(objetoRobadoMock.getNombre(), partida.getObjetoRobado().getNombre());
        assertEquals(ladronMock.getGenero(), partida.getLadronActual().getGenero());
        assertEquals(interpolMock.atraparSospechoso(), partida.getInterpol().atraparSospechoso());
        assertEquals("Buenos Aires", partida.getCiudades().getCiudades().get(0).getNombre().getCaracteristica());
    }

}

