package entrega1;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosUsoEntrega2Test {
    //Setup Ciudades
    ArrayList pistasCiudadMexico = new ArrayList(Arrays.asList("Ciudad de Mexico", "Verde, blanca y roja", "Peso",
            "Golfo", "Chichen Itza", "Mineria", "Aguila Real", "Frida Khalo", "Espaniol", "Mayas", "Catolicismo",
            "Presidente", "Tacos y picantes", "19.548689551677576", "-99.20369094783788"));
    ArrayList pistasMontreal = new ArrayList(Arrays.asList("Montreal", "Bandera con la hoja de arce", "Dolar",
            "Segundo pais mas grande", "Catarata del Niagara", "Explotacion forestal", "Alce", "Justin Bieber",
            "Ingles", "Amerindios", "Cristianismo", "Presidente", "Nieve", "45.49839849712126", "-73.55989592010529"));

    Ciudad ciudadMexico = new Ciudad(pistasCiudadMexico);
    Ciudad ciudadMontreal = new Ciudad(pistasMontreal);

    //Setup jugador / reloj
    Tiempo reloj = new Tiempo();
    Jugador jugador = new Jugador("Max", reloj);

    //Setup Ladrones / Interpol
    Ladrones ladrones = new Ladrones();
    Interpol interpol = new Interpol(ladrones);
    Ladron ladronMereyLaroc = ladrones.getLadrones().get(5);
    Ladron ladronKatherineDrib = ladrones.getLadrones().get(7);
    List<Ladron> posiblesLadrones;

    //caso uso 1: Detective sufre una herida de cuchillo.
    //Detective duerme.
    @Test
    public void detectiveSufreHeridaDeCuchilloYLuegoDuerme(){
        jugador.serHeridoPorCuchillo();
        jugador.dormir();

        assertEquals(17, reloj.getHoraActual());
    }

    //caso uso 2: Detective con rango Investigador toma caso de un robo viaja de Montreal a México
    @Test
    public void jugadorConRangoInvestigadorViajaDeMontrealAMexico(){
        jugador.setCiudadActual(ciudadMontreal);

        for(int i = 0; i < 10; i++){
            jugador.addArresto();
        }

        jugador.viajar(ciudadMexico);

        assertEquals("Investigador", jugador.getRango().getNombreRango());
        assertEquals(9, reloj.getHoraActual());
    }

    //caso uso 3: Cargar en la computadora los datos recopilados y buscar sospechosos.
    @Test
    public void seIngresanAlgunosDatosEnLaComputadoraDeInterpolYSeEncuentranDosPosiblesLadrones(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoHobby("Escalar");

        posiblesLadrones = interpol.buscarPosiblesLadrones();

        assertEquals(2, posiblesLadrones.size());
        assertEquals(ladronMereyLaroc, posiblesLadrones.get(0));
        assertEquals(ladronKatherineDrib, posiblesLadrones.get(1));
    }



}
