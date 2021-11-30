package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;
import carmenSandiego.modelo.Partida;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PartidaTests {

    ArrayList pistasCiudadMexico = new ArrayList(Arrays.asList("Mexico","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "19.801771980077525", "-98.97085615538418"));
    ArrayList pistasCiudadMontreal = new ArrayList(Arrays.asList("Montreal","Celeste y blanca con un sol", "Peso",
            "Campos", "Cataratas del Iguazu", "Ganaderia", "Yaguarete", "Messi", "Espaniol", "Arte Mapuche",
            "Cristianismo", "Presidente", "Antigua Colonia Espaniola", "46.27068001656241", "-72.94882925379466"));

    Ciudad ciudadMexico = new Ciudad(pistasCiudadMexico);
    Ciudad ciudadMontreal = new Ciudad(pistasCiudadMontreal);
    ArrayList ciudades = new ArrayList(Arrays.asList(ciudadMontreal, ciudadMexico));

    Jugador jugador = new Jugador("Ivan");
    ObjetoRobado objetoRobadoMock = mock(ObjetoRobado.class);
    Partida partida = new Partida(jugador, objetoRobadoMock, ciudades);

    @Test
    public void jugadorViajaDeMontrealAMexico() {
        jugador.setCiudadActual(ciudadMontreal);
        partida.cambiarCiudad("Mexico");
        assertEquals(ciudadMexico.getNombre(), jugador.getCiudadActual().getNombre());
    }






    /*
    @Test
    public void jugadorSufreHeridaConCuchilloUnaVezYPasan2Horas(){
        Partida nuevaPartida = new Partida();

        nuevaPartida.moverseDeCiudad(); //dentro llama al metodo ataque con cuchillo

        assertEquals(9, nuevaPartida.getHora());
    }


    @Test
    public void detectiveDuermeYPasan8Horas(){
        Partida nuevaPartida = new Partida();

        nuevaPartida.dormir();

        assertEquals(15, nuevaPartida.getHora());
    }
     */




}
