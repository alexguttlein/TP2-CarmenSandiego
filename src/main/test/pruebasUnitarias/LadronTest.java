package pruebasUnitarias;

import carmenSandiego.modelo.Ladron;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadronTest {
    ArrayList datosLadron = new ArrayList<>(Arrays.asList("Carmen Sandiego", "Femenino", "Tennis",
            "Castanio", "Joyas", "Convertible"));

    Ladron ladron = new Ladron(datosLadron);

    @Test
    public void losDatosDelLadronSonCorrectos(){
        assertEquals("Carmen Sandiego", ladron.getNombre());
        assertEquals("Femenino", ladron.getGenero());
        assertEquals("Tennis", ladron.getHobby());
        assertEquals("Castanio", ladron.getCabello());
        assertEquals("Joyas", ladron.getSenia());
        assertEquals("Convertible", ladron.getVehiculo());
    }
}
