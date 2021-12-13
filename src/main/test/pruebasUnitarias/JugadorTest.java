package pruebasUnitarias;

import carmenSandiego.modelo.Tiempo;
import carmenSandiego.modelo.Jugador;
import carmenSandiego.modelo.Ciudad;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {

    Ciudad ciudadMexico = new Ciudad(new ArrayList(Arrays.asList("Mexico","verde, blanca y roja", "Peso",
            "asd", "asd", "asd", "ads", "ads", "español", "asd",
            "asd", "asd", "asd", "23.564780856080713", "-101.16072897108585")));

    Ciudad ciudadMontreal = new Ciudad(new ArrayList(Arrays.asList("Montreal","Roja y blanca", "dolar canadiense",
            "asd", "asd", "asd", "asd", "asd", "ingles", "asd",
            "asd", "asd", "asd", "45.573279804398034", "-73.49124739806629")));

    Tiempo reloj = new Tiempo();
    Jugador jugador = new Jugador("Alex", reloj);
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void porDefectoUnJugadorTieneCeroArrestos(){
        assertEquals("Alex", jugador.getNombre());
        assertEquals(0, jugador.getCantidadDeArrestos());
    }

    @Test
    public void porDefectoUnJugadorTieneRangoNovato(){
        assertEquals("Novato", jugador.getNombreRango());
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

        assertEquals(5, jugador.getCantidadDeArrestos());
        assertEquals("Detective", jugador.getNombreRango());
    }

    @Test
    public void jugadorRealiza10ArrestosYSuRangoAumentaAInvestigador(){
        for(int i = 0; i < 10; i++)
            jugador.addArresto();

        assertEquals(10, jugador.getCantidadDeArrestos());
        assertEquals("Investigador", jugador.getNombreRango());
    }

    @Test
    public void jugadorRealiza15ArrestosYSuRangoSigueSiendoInvestigador(){
        for(int i = 0; i < 15; i++)
            jugador.addArresto();

        assertEquals(15, jugador.getCantidadDeArrestos());
        assertEquals("Investigador", jugador.getNombreRango());
    }

    @Test
    public void jugadorRealiza20ArrestosYSuRangoAumentaASargento(){
        for(int i = 0; i < 20; i++)
            jugador.addArresto();

        assertEquals(20, jugador.getCantidadDeArrestos());
        assertEquals("Sargento", jugador.getNombreRango());
    }

    @Test
    public void jugadorRealiza25ArrestosYSuRangoSigueSiendoSargento(){
        for(int i = 0; i < 25; i++)
            jugador.addArresto();

        assertEquals(25, jugador.getCantidadDeArrestos());
        assertEquals("Sargento", jugador.getNombreRango());
    }

    @Test
    public void detectiveViajaDeMontrealAMexico(){
        //distancia de Montreal a Mexico = 3540 km
        //velocidad Detective = 1100 km/h
        //tiempo esperado = 3 horas (se redondea para abajo)

        jugador.setCiudadActual(ciudadMontreal);

        for(int i = 0; i < 5; i++)  //para que el jugador sea de tipo Detective
            jugador.addArresto();
        jugador.viajar(ciudadMexico);

        assertEquals(10, reloj.getHoraActual());
        assertEquals(ciudadMexico,jugador.getCiudadActual());
    }


    @Test
    public void seAsignaUnaCiudadAJugador(){
        when(ciudadMock.getNombre()).thenReturn("Buenos Aires");
        jugador.setCiudadActual(ciudadMock);

        assertEquals("Buenos Aires", jugador.getCiudadActual().getNombre());
    }

    @Test
    public void jugadorEsHeridoPorCuchilloUnaVezYPasan2Horas(){
        jugador.serHeridoPorCuchillo();
        jugador.sanar();

        assertEquals(1, jugador.getVecesHeridoPorCuchillo());
        assertEquals(9, reloj.getHoraActual());
    }

    @Test
    public void jugadorEsHeridoPorCuchillo3VecesYPasan4Horas(){

        for(int i = 0; i < 3; i++)
            jugador.serHeridoPorCuchillo();

        assertEquals(3, jugador.getVecesHeridoPorCuchillo());
        assertEquals(11, reloj.getHoraActual());
    }

    @Test
    public void jugadorEsHeridoPorArmaDeFuegoYPasan4Horas(){
        jugador.serHeridoPorArmaDeFuego();

        assertEquals(11, reloj.getHoraActual());
    }

    @Test
    public void jugadorDuermePor8Horas(){
        jugador.dormir();
        assertEquals(15, reloj.getHoraActual());
    }
}
