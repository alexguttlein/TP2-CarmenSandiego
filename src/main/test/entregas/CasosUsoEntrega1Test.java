package entregas;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Calendar.MONDAY;
import static org.junit.jupiter.api.Assertions.*;

public class CasosUsoEntrega1Test<ciudadMexico> {
    ArrayList pistasCiudadMexico = new ArrayList(Arrays.asList("Ciudad de Mexico", "Verde, blanca y roja", "Peso",
            "Golfo", "Chichen Itza", "Mineria", "Aguila Real", "Frida Khalo", "Espaniol", "Mayas", "Catolicismo",
            "Presidente", "Tacos y picantes", "19.548689551677576", "-99.20369094783788"));
    ArrayList pistasMontreal = new ArrayList(Arrays.asList("Montreal", "Bandera con la hoja de arce", "Dolar",
            "Segundo pais mas grande", "Catarata del Niagara", "Explotacion forestal", "Alce", "Justin Bieber",
            "Ingles", "Amerindios", "Cristianismo", "Presidente", "Nieve", "45.49839849712126", "-73.55989592010529"));

    Ciudad ciudadMexico = new Ciudad(pistasCiudadMexico);
    Ciudad ciudadMontreal = new Ciudad(pistasMontreal);

    Edificio banco = new EdificioBanco();
    Edificio aeropuerto = new EdificioAeropuerto();
    Edificio biblioteca = new EdificioBiblioteca();
    Edificio puerto = new EdificioPuerto();

    Tiempo reloj = new Tiempo(7, 4, 0, 2021);
    Jugador jugador = new Jugador("Max", reloj);
//    Reloj reloj = Reloj.getInstance();

    @Test
    public void jugadorVisitaBancoDeMontreal(){
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.addEdificio(banco);
        ciudadMontreal.setPistasEdificio();

        jugador.setCiudadActual(ciudadMontreal);

        jugador.visitarEdificio(banco);
        String pistaEsperada = banco.getPista();

        assertEquals("Vino a cambiar un poco de Peso", pistaEsperada);
        assertEquals(8, reloj.getHoraActual());
    }

    @Test
    public void jugadorVisitaBancoYBibliotecaDeMontreal(){
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.addEdificio(banco);
        ciudadMontreal.addEdificio(biblioteca);
        ciudadMontreal.setPistasEdificio();

        jugador.setCiudadActual(ciudadMontreal);

        String pistaEsperadaBanco = banco.getPista();
        String pistaEsperadaBiblioteca = biblioteca.getPista();

        jugador.visitarEdificio(banco);
        jugador.visitarEdificio(biblioteca);

        assertEquals(9, reloj.getHoraActual());
        assertEquals("Vino a cambiar un poco de Peso", pistaEsperadaBanco);
        assertEquals("Agarro un diccionario Espaniol", pistaEsperadaBiblioteca);
    }

    @Test
    public void jugadorViajaDeMontrealAMexico(){
        jugador.setCiudadActual(ciudadMontreal);
        jugador.viajar(ciudadMexico);

        assertEquals(11, reloj.getHoraActual());
        assertEquals(ciudadMexico, jugador.getCiudadActual());
    }

    @Test
    public void jugadorVisita3VecesAeropuertoY55VecesPuerto(){
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.addEdificio(aeropuerto);
        ciudadMontreal.addEdificio(puerto);
        ciudadMontreal.setPistasEdificio();

        jugador.setCiudadActual(ciudadMontreal);

        String pistaEsperadaAeropuerto = aeropuerto.getPista();
        String pistaEsperadaPuerto = puerto.getPista();

        for(int i = 0; i < 3; i++){
            jugador.visitarEdificio(aeropuerto);
        }

        assertEquals(13, reloj.getHoraActual());

        for(int i = 0; i < 55; i++){
            jugador.visitarEdificio(puerto);
        }

        assertEquals(7, reloj.getHoraActual());
        assertEquals(MONDAY, reloj.getDiaActual());
        assertEquals("Se subio a un avion Verde, blanca y roja", pistaEsperadaAeropuerto);
        assertEquals("Al lugar que iba exportaban mucho Mineria", pistaEsperadaPuerto);
    }

    @Test
    public void detectiveSufreHeridaDeCuchilloYLuegoDuerme(){
        jugador.serHeridoPorCuchillo();
        jugador.dormir();

        assertEquals(17, reloj.getHoraActual());
    }
}
