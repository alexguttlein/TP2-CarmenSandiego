package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Recorrido;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class LadronTest {
    ArrayList datosLadron = new ArrayList<>(Arrays.asList("Carmen Sandiego", "Femenino", "Tennis",
            "Castanio", "Joyas", "Convertible"));

    Ladron ladron = new Ladron(datosLadron);

    @Test
    public void losDatosDelLadronSonCorrectos(){
        Caracteristica nombre = new Caracteristica("Carmen Sandiego");
        Caracteristica genero = new Caracteristica("Femenino");
        Caracteristica hobby = new Caracteristica("Tennis");
        Caracteristica cabello = new Caracteristica("Castanio");
        Caracteristica senia = new Caracteristica("Joyas");
        Caracteristica vehiculo = new Caracteristica("Convertible");

        assertTrue(nombre.compararCaracteristica(ladron.getNombre()));
        assertTrue(genero.compararCaracteristica(ladron.getGenero()));
        assertTrue(hobby.compararCaracteristica(ladron.getHobby()));
        assertTrue(cabello.compararCaracteristica(ladron.getCabello()));
        assertTrue(senia.compararCaracteristica(ladron.getSenia()));
        assertTrue(vehiculo.compararCaracteristica(ladron.getVehiculo()));
    }

    @Test
    public void seComparanDosLadronesIguales(){
        Ladron ladron2 = new Ladron(datosLadron);

        assertTrue(ladron2.compararConLadron(ladron));
    }

    @Test
    public void seComparanDosLadronesDistintos(){
        ArrayList datos = new ArrayList<>(Arrays.asList("Carmen Sandiego", "Femenino", "Tennis",
                "Negro", "Joyas", "Convertible"));
        Ladron ladron2 = new Ladron(datos);

        assertFalse(ladron2.compararConLadron(ladron));
    }

    @Test
    public void seAsignaUnRecorridoAlLadron(){
        Recorrido recorridoMock = mock(Recorrido.class);
        ladron.setRecorrido(recorridoMock);

        assertNotNull(ladron.getRecorrido());
    }

}
