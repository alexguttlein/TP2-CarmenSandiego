package entregas;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ciudades;
import carmenSandiego.modelo.edificio.Edificio;
import carmenSandiego.modelo.edificio.EdificioBanco;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    Edificio banco = new EdificioBanco();

    Ciudades ciudades = new Ciudades();

    //Setup jugador / tiempo
    Tiempo reloj = new Tiempo(7, 4, 0, 2021);
    Jugador jugador = new Jugador("Max", reloj);
    ObjetoRobado objetoRobado = new ObjetoRobado("Incan Gold Mask", ciudadMexico, "Importante");

    //Setup Ladrones / Interpol
    Ladrones ladrones = new Ladrones();
    Ladron ladronMereyLaroc = ladrones.getLadrones().get(5);
    Ladron ladronKatherineDrib = ladrones.getLadrones().get(7);
    Interpol interpol = new Interpol(ladrones, reloj, jugador, ladronMereyLaroc);
    List<Ladron> posiblesLadrones;

    //Setup Partida
    Partida partida = new Partida(jugador, objetoRobado, ladronMereyLaroc, interpol, reloj, ciudades);

    //caso uso 1: Detective sufre una herida de cuchillo.
    //Detective duerme.
    @Test
    public void detectiveSufreHeridaDeCuchilloYLuegoDuerme(){
        Tiempo relojAux = new Tiempo(17,4,0,2021);
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
        assertEquals(10, reloj.getHoraActual());
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

    //caso uso 4: Intentas atrapar al sospechoso sin la orden de arresto emitida.
    @Test
    public void seIntentaAtraparAlSospechosoSinUnaOrdenDearrestoEmitida(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");

        assertEquals(1, interpol.buscarPosiblesLadrones().size());
        assertFalse(interpol.atraparSospechoso());
    }

    //caso uso 5: Un detective hace 6 Arrestos.
    //Toma un caso de un sospechoso que robó un Incan Gold Mask.
    //Realiza la investigación.
    //Emite la orden.
    //Atrapa al sospechoso.
    @Test
    public void seRealizaInvestigacionYSeAtrapaAlSospechoso(){
        assertEquals(7, reloj.getHoraActual()); //investigacion comienza a las 7AM

        ciudadMexico.addEdificio(banco);

        for(int i = 0; i < 6; i++){
            jugador.addArresto();
        }

        jugador.setCiudadActual(objetoRobado.getCiudadOrigen());
        jugador.visitarEdificio(banco); //pasa 1 hora
        jugador.visitarEdificio(banco); //pasan 2 horas

        jugador.viajar(ciudadMontreal); //pasan 3 horas

        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Escalar");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Limusina");

        interpol.emitirOrdenDeArresto(); //pasan 3 horas

        assertEquals(16, reloj.getHoraActual());
        assertTrue(interpol.atraparSospechoso());
        assertTrue(interpol.compararLadrones(interpol.getPosibleLadron(), interpol.getLadron()));
        assertTrue(interpol.compararLadrones(interpol.getPosibleLadron(), partida.getLadronActual()));
    }



}
