package entrega1;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
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
    Jugador jugador = new Jugador("Max", ciudadMontreal);
    Reloj reloj = Reloj.getInstance();


    @Test
    public void jugadorVisitaBancoDeMontrear(){
        reloj.reiniciar();
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.setEdificios(banco);
        ciudadMontreal.setPistasEdificio();
        String esperado = ciudadMontreal.visitarEdificio(banco);
        assertEquals("Vino a cambiar un poco de Peso", esperado);
        assertEquals(8, reloj.getHoraActual());
    }
    @Test
    public void jugadorVisitaBancoYBibliotecaDeMontreal(){
        reloj.reiniciar();
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.setEdificios(banco);
        ciudadMontreal.setEdificios(biblioteca);
        ciudadMontreal.setPistasEdificio();
        String esperadoBanco = ciudadMontreal.visitarEdificio(banco);
        String esperadoBiblioteca = ciudadMontreal.visitarEdificio(biblioteca);
        assertEquals("Vino a cambiar un poco de Peso", esperadoBanco);
        assertEquals("Agarro un diccionario Espaniol", esperadoBiblioteca);
        assertEquals(9, reloj.getHoraActual());
    }
    @Test
    public void jugadorViajaDeMontrealAMexico(){
        reloj.reiniciar();
        for(int i = 0; i < 5; i++)  //para que el jugador sea de tipo Detective
            jugador.addArresto();
        jugador.viajar(ciudadMexico);
        assertEquals(10,reloj.getHoraActual());
        assertEquals(ciudadMexico,jugador.getCiudadActual());
    }
    @Test
    public void jugadorVisita3VecesAeropuertoY55VecesPuerto(){
        reloj.reiniciar();
        String esperadoAeropuerto = "";
        String esperadoPuerto = "";
        ciudadMontreal.setCiudadSiguiente(ciudadMexico);
        ciudadMontreal.setEdificios(aeropuerto);
        ciudadMontreal.setEdificios(puerto);
        ciudadMontreal.setPistasEdificio();
        for (int i = 0; i < 3; i++) {
            esperadoAeropuerto = ciudadMontreal.visitarEdificio(aeropuerto);
        }
        for (int i = 0; i < 55; i++) {
            esperadoPuerto = ciudadMontreal.visitarEdificio(puerto);
        }
        assertEquals("Se subio a un avion Verde, blanca y roja", esperadoAeropuerto);
        assertEquals("Al lugar que iba exportaban mucho Mineria", esperadoPuerto);
        assertEquals(7, reloj.getHoraActual());
    }





}
