package pruebasUnitarias;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ciudades;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class CiudadesTest {

    Ciudades ciudades = new Ciudades();

    @Test
    public void seInstancianCorrectamenteLasCiudades(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();

        assertEquals("Buenos Aires", listaCiudades.get(0).getNombre().getCaracteristica());
        assertEquals("Pekin", listaCiudades.get(1).getNombre().getCaracteristica());
        assertEquals("Baghdad", listaCiudades.get(2).getNombre().getCaracteristica());
        assertEquals("Puerto Moresby", listaCiudades.get(3).getNombre().getCaracteristica());
        assertEquals("El Cairo", listaCiudades.get(19).getNombre().getCaracteristica());
        assertEquals("Kathmandu", listaCiudades.get(20).getNombre().getCaracteristica());
    }

}
