package pruebasUnitarias;

import carmenSandiego.modelo.Jugador;
import carmenSandiego.modelo.Ciudad;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import carmenSandiego.modelo.Horario;

public class JugadorTest {
    Jugador jugador= new Jugador("Alex");
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void porDefectoUnJugadorTieneCeroArrestos(){
        assertEquals("Alex", jugador.getNombre());
        assertEquals(0, jugador.getCantidadDeArrestos());
    }

    @Test
    public void porDefectoUnJugadorTieneRangoNovato(){
        assertEquals("Novato", jugador.getRango());
    }

    @Test
    public void jugadorRealizaUnArresto(){
        jugador.addArresto();
        assertEquals(1, jugador.getCantidadDeArrestos());
    }

    @Test
    public void jugadorRealiza5ArrestosYSuRangoAumentaADetective(){
        for(int i = 0; i < 5; i++)
            jugador.addArresto();
        assertEquals("Detective", jugador.getRango());
    }

    @Test
    public void jugadorRealiza10ArrestosYSuRangoAumentaAInvestigador(){
        for(int i = 0; i < 10; i++)
            jugador.addArresto();
        assertEquals("Investigador", jugador.getRango());
    }

    @Test
    public void jugadorRealiza15ArrestosYSuRangoSigueSiendoInvestigador(){
        for(int i = 0; i < 15; i++)
            jugador.addArresto();
        assertEquals("Investigador", jugador.getRango());
    }

    @Test
    public void jugadorRealiza20ArrestosYSuRangoAumentaASargento(){
        for(int i = 0; i < 20; i++)
            jugador.addArresto();
        assertEquals("Sargento", jugador.getRango());
    }

    @Test
    public void jugadorRealiza25ArrestosYSuRangoSigueSiendoSargento(){
        for(int i = 0; i < 25; i++)
            jugador.addArresto();
        assertEquals("Sargento", jugador.getRango());
    }

    @Test
    public void seAsignaUnaCiudadAJugador(){
        when(ciudadMock.getNombre()).thenReturn("Buenos Aires");
        jugador.setCiudadActual(ciudadMock);

        assertEquals("Buenos Aires", jugador.getCiudadActual().getNombre());
    }

    @Test
    public void jugadorDuermePor8Horas(){
        assertEquals(8, jugador.dormir());
    }


    @Test
    public void jugadorEsHeridoPorCuchilloUnaVezYPasan2Horas(){
        int horarioAnterior = jugador.getHorario().getHoraActual();
        jugador.serHeridoPorCuchillo();
        int horarioActual = jugador.getHorario().getHoraActual();
        assertEquals(2, (horarioActual-horarioAnterior));
    }

    @Test
    public void jugadorEsHeridoPorCuchillo3VecesYPasan4Horas(){
        int horarioAnterior = jugador.getHorario().getHoraActual();
        for(int i = 0; i < 3; i++)
            jugador.serHeridoPorCuchillo();
        int horarioActual = jugador.getHorario().getHoraActual();
        assertEquals(4, (horarioActual-horarioAnterior));
    }


    @Test
    public void jugadorEsHeridoPorArmaDeFuegoYPasan4Horas(){
        int horarioAnterior = jugador.getHorario().getHoraActual();
        jugador.serHeridoPorArmaDeFuego();
        int horarioActual = jugador.getHorario().getHoraActual();
        assertEquals(4, (horarioActual-horarioAnterior));
    }



}
