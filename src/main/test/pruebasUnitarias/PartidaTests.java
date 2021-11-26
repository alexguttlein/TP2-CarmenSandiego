package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;
import carmenSandiego.modelo.Partida;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PartidaTests {

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




}
