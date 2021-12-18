package pruebasUnitarias;

import carmenSandiego.modelo.Ladron;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadronTest {
    ArrayList datosLadronCarmen = new ArrayList<>(Arrays.asList("Carmen Sandiego", "Femenino", "Tenis", "Castanio", "Joyas", "Convertible"));
    ArrayList datosSospechoso = new ArrayList<>(Arrays.asList("", "Femenino", "Tenis", "Castanio", "", "Convertible"));
    ArrayList datosSospechosoVacio = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));
    ArrayList datosSospechosoIncorrecto = new ArrayList<>(Arrays.asList("", "Masculino", "Futbol", "Rojo", "", ""));

    Ladron ladronCarmen = new Ladron(datosLadronCarmen);
    Ladron ladronSospechoso = new Ladron(datosSospechoso);
    Ladron ladronSospechosoVacio = new Ladron(datosSospechosoVacio);
    Ladron ladronSospechosoIncorrecto = new Ladron(datosSospechosoIncorrecto);

    @Test
    public void hagoComparacionCompletaEntreSospechosoYLadron(){
        assertEquals(false, ladronCarmen.comparar(ladronSospechoso));
        assertEquals(false, ladronSospechoso.comparar(ladronCarmen));
    }

    @Test
    public void hagoComparacionDeSospechosoEntreSospechosoYCarmen(){
        assertEquals(true, ladronCarmen.compararSospechoso(ladronSospechoso));
        assertEquals(true, ladronSospechoso.compararSospechoso(ladronCarmen));
    }

    @Test
    public void hagoComparacionDeSospechosoVacioYCarmen(){
        assertEquals(false, ladronCarmen.comparar(ladronSospechosoVacio));
        assertEquals(false, ladronSospechosoVacio.comparar(ladronCarmen));
        assertEquals(true, ladronCarmen.compararSospechoso(ladronSospechosoVacio));
        assertEquals(true, ladronSospechosoVacio.compararSospechoso(ladronCarmen));
    }

    @Test
    public void hagoComparacionDeSospechosoIncorrectoConCarmen(){
        assertEquals(false, ladronCarmen.comparar(ladronSospechosoIncorrecto));
        assertEquals(false, ladronSospechosoIncorrecto.comparar(ladronCarmen));
        assertEquals(false, ladronCarmen.compararSospechoso(ladronSospechosoIncorrecto));
        assertEquals(false, ladronSospechosoIncorrecto.compararSospechoso(ladronCarmen));
    }

    /*
    @Test
    public void losDatosDelLadronSonCorrectos(){
        assertEquals("Carmen Sandiego", ladron.getNombre());
        assertEquals("Femenino", ladron.getGenero());
        assertEquals("Tennis", ladron.getHobby());
        assertEquals("Castanio", ladron.getCabello());
        assertEquals("Joyas", ladron.getSenia());
        assertEquals("Convertible", ladron.getVehiculo());
    }

     */
}
