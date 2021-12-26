package pruebasUnitarias;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class CiudadesTest {

    Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/modelo/datosDelJuego/ciudades.csv");

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
