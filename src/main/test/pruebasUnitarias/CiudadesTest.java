package pruebasUnitarias;

import carmenSandiego.modelo.Ciudad;
import carmenSandiego.modelo.Ciudades;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CiudadesTest {

    Ciudades ciudades = new Ciudades();

    @Test
    public void seInstancianCorrectamenteLasCiudades(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();

        assertEquals("Buenos Aires", listaCiudades.get(0).getNombre());
        assertEquals("Pekin", listaCiudades.get(1).getNombre());
        assertEquals("Baghdad", listaCiudades.get(2).getNombre());
        assertEquals("Puerto Moresby", listaCiudades.get(3).getNombre());
        assertEquals("El Cairo", listaCiudades.get(19).getNombre());
        assertEquals("Kathmandu", listaCiudades.get(20).getNombre());
    }

}
