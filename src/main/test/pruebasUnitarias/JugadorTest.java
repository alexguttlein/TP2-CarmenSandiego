package pruebasUnitarias;

import carmenSandiego.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    Jugador jugador= new Jugador("Alex");

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
}
