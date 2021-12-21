package pruebasUnitarias;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ciudades;
import carmenSandiego.modelo.edificio.Edificio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CiudadesTest {

    Ciudades ciudades = new Ciudades();

    @Test
    public void seInstancianCorrectamenteLasCiudades(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();

        Caracteristica buenosAires = new Caracteristica("Buenos Aires");
        Caracteristica pekin = new Caracteristica("Pekin");
        Caracteristica baghdad = new Caracteristica("Baghdad");
        Caracteristica moresby = new Caracteristica("Puerto Moresby");
        Caracteristica cairo = new Caracteristica("El Cairo");
        Caracteristica kathmandu = new Caracteristica("Kathmandu");

        assertTrue(buenosAires.compararCaracteristica(listaCiudades.get(0).getNombre()));
        assertTrue(pekin.compararCaracteristica(listaCiudades.get(1).getNombre()));
        assertTrue(baghdad.compararCaracteristica(listaCiudades.get(2).getNombre()));
        assertTrue(moresby.compararCaracteristica(listaCiudades.get(3).getNombre()));
        assertTrue(cairo.compararCaracteristica(listaCiudades.get(19).getNombre()));
        assertTrue(kathmandu.compararCaracteristica(listaCiudades.get(20).getNombre()));

    }

    @Test
    public void seInstancianLosEdificiosDeLasCiudadesCorrectamenteYTodosSonDiferentes(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();

        //la cantidad de edificios es la esperada
        assertEquals(3, listaCiudades.get(5).getEdificios().size());

        //todos los edificios son diferentes
        Ciudad ciudad = listaCiudades.get(0);
        ArrayList<Edificio> edificios = ciudad.getEdificios();

        assertFalse(edificios.get(0).compararEdificios(edificios.get(1)));
        assertFalse(edificios.get(1).compararEdificios(edificios.get(2)));
        assertFalse(edificios.get(2).compararEdificios(edificios.get(0)));
    }

    @Test
    public void losEdificiosDeCadaCiudadSeCreanConUnaPistaPredeterminada(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();

        Ciudad ciudad = listaCiudades.get(0);
        ArrayList<Edificio> edificios = ciudad.getEdificios();

        assertNotNull(edificios.get(0).getPista());
        assertNotNull(edificios.get(1).getPista());
        assertNotNull(edificios.get(2).getPista());
    }

}
