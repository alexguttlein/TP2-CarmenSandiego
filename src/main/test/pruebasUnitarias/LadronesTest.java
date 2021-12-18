package pruebasUnitarias;

import carmenSandiego.modelo.Ladron;
import carmenSandiego.modelo.Ladrones;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadronesTest {

    Ladrones ladrones = new Ladrones();
    List<Ladron> listaLadrones = ladrones.getLadrones();

    ArrayList datosLadron = new ArrayList<>(Arrays.asList("Carmen Sandiego", "Femenino", "Tenis",
            "Castanio", "Joyas", "Convertible"));

    Ladron ladron = new Ladron(datosLadron);

    /*
    @Test
    public void elPrimerLadronEsElEsperado(){
        assertEquals("Nick Brunch", listaLadrones.get(0).getNombre());
    }

    @Test
    public void todosLosLadronesTienenElNombreEsperado(){
        assertEquals("Nick Brunch", listaLadrones.get(0).getNombre());
        assertEquals("Len Bulk", listaLadrones.get(1).getNombre());
        assertEquals("Ihor Ihorovitch", listaLadrones.get(2).getNombre());
        assertEquals("Fast Eddie B.", listaLadrones.get(3).getNombre());
        assertEquals("Scar Graynolt", listaLadrones.get(4).getNombre());
        assertEquals("Merey Laroc", listaLadrones.get(5).getNombre());
        assertEquals("Lady Agatha", listaLadrones.get(6).getNombre());
        assertEquals("Katherine Drib", listaLadrones.get(7).getNombre());
        assertEquals("Dazzle Annie", listaLadrones.get(8).getNombre());
        assertEquals("Carmen Sandiego", listaLadrones.get(9).getNombre());
    }

     */

}

