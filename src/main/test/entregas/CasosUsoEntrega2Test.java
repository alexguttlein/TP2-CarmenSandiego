package entregas;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ciudades;
import carmenSandiego.modelo.edificio.*;
import carmenSandiego.modelo.Interpol;
import carmenSandiego.modelo.jugador.Jugador;
import carmenSandiego.modelo.jugador.rango.Rango;
import carmenSandiego.modelo.jugador.rango.RangoInvestigador;
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

    Edificio banco = new EdificioBanco(new Caracteristica("Banco"));
    Ciudades ciudades = new Ciudades("src/main/java/datosDelJuego/ciudades.csv");

    //Setup jugador / tiempo
    Tiempo reloj = new Tiempo(7, 4, 0, 2021);
    Jugador jugador = new Jugador("Max", reloj);

    //Setup objetoRobado
    Caracteristica nombreObjeto = new Caracteristica("Incan Gold Mask");
    Caracteristica importanciaObjeto = new Caracteristica("Importante");
    ObjetoRobado objetoRobado = new ObjetoRobado(nombreObjeto, ciudadMexico, importanciaObjeto);

    //Setup Ladrones / Interpol
    Ladrones ladrones = new Ladrones("src/main/java/datosDelJuego/ladrones.csv");
    Ladron ladronMereyLaroc = ladrones.getLadrones().get(5);
    Ladron ladronKatherineDrib = ladrones.getLadrones().get(7);
    Interpol interpol = new Interpol(ladrones, reloj, jugador, ladronMereyLaroc);
    List<Ladron> posiblesLadrones;

    //Setup Ladron
    Caracteristica genero = new Caracteristica("Femenino");
    Caracteristica hobby = new Caracteristica("Escalar");
    Caracteristica cabello = new Caracteristica("Castanio");
    Caracteristica senia = new Caracteristica("Joyas");
    Caracteristica vehiculo = new Caracteristica("Convertible");

    //Setup Partida
    Partida partida = new Partida(jugador, objetoRobado, ladronMereyLaroc, interpol, reloj, ciudades);

    //caso uso 1: Detective sufre una herida de cuchillo.
    //Detective duerme.
    @Test
    public void detectiveSufreHeridaDeCuchilloYLuegoDuerme(){
        Tiempo tiempoEsperado = new Tiempo(17,4,0,2021);
        jugador.serHeridoPorCuchillo();
        jugador.dormir();

        assertTrue(reloj.compararTiempos(tiempoEsperado));
    }

    //caso uso 2: Detective con rango Investigador toma caso de un robo viaja de Montreal a México
    @Test
    public void jugadorConRangoInvestigadorViajaDeMontrealAMexico(){
        Tiempo tiempoEsperado = new Tiempo(10,4,0,2021);
        Rango rangoEsperado = new RangoInvestigador(10);
        jugador.setCiudadActual(ciudadMontreal);

        for(int i = 0; i < 10; i++){
            jugador.addArresto();
        }

        jugador.viajar(ciudadMexico);

        assertTrue(jugador.getRango().compararRangos(rangoEsperado));
        assertTrue(reloj.compararTiempos(tiempoEsperado));
    }

    //caso uso 3: Cargar en la computadora los datos recopilados y buscar sospechosos.
    @Test
    public void seIngresanAlgunosDatosEnLaComputadoraDeInterpolYSeEncuentranDosPosiblesLadrones(){
        interpol.setDatoGenero(genero);
        interpol.setDatoCabello(cabello);
        interpol.setDatoHobby(hobby);

        posiblesLadrones = interpol.buscarPosiblesLadrones();

        assertEquals(2, posiblesLadrones.size());
        assertTrue(ladronMereyLaroc.compararConLadron(posiblesLadrones.get(0)));
        assertTrue(ladronKatherineDrib.compararConLadron(posiblesLadrones.get(1)));
    }

    //caso uso 4: Intentas atrapar al sospechoso sin la orden de arresto emitida.
    @Test
    public void seIntentaAtraparAlSospechosoSinUnaOrdenDearrestoEmitida(){
        Caracteristica hobbyTenis = new Caracteristica("Tenis");

        interpol.setDatoGenero(genero);
        interpol.setDatoHobby(hobbyTenis);
        interpol.setDatoCabello(cabello);
        interpol.setDatoSenia(senia);
        interpol.setDatoVehiculo(vehiculo);

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
        Tiempo tiempoEsperado = new Tiempo(16,4,0,2021);
        Caracteristica vehiculoLimusina = new Caracteristica("Limusina");

        ciudadMexico.addEdificio(banco);

        for(int i = 0; i < 6; i++){
            jugador.addArresto();
        }

        jugador.setCiudadActual(objetoRobado.getCiudadOrigen());
        jugador.visitarEdificio(banco); //pasa 1 hora
        jugador.visitarEdificio(banco); //pasan 2 horas

        jugador.viajar(ciudadMontreal); //pasan 3 horas

        interpol.setDatoGenero(genero);
        interpol.setDatoHobby(hobby);
        interpol.setDatoCabello(cabello);
        interpol.setDatoSenia(senia);
        interpol.setDatoVehiculo(vehiculoLimusina);

        interpol.emitirOrdenDeArresto(); //pasan 3 horas

        assertTrue(reloj.compararTiempos(tiempoEsperado));
        assertTrue(interpol.atraparSospechoso());
        assertEquals(7, jugador.getCantidadDeArrestos()); //se agrerga un nuevo arresto
        assertTrue(interpol.compararLadrones(interpol.getPosibleLadron(), interpol.getLadron()));
        assertTrue(interpol.compararLadrones(interpol.getPosibleLadron(), partida.getLadronActual()));
    }

}
