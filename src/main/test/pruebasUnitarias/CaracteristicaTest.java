package pruebasUnitarias;

import carmenSandiego.modelo.Caracteristica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaracteristicaTest {

    Caracteristica nombre = new Caracteristica("Nombre");
    Caracteristica nombre2 = new Caracteristica("Nombre");
    Caracteristica nombre3 = new Caracteristica("nombre");

    @Test
    public void seComparanDosCaracterisiticasIguales(){
        assertTrue(nombre.compararCaracteristica(nombre2));
    }

    @Test
    public void seComparanDosCaracterisiticasDiferentes(){
        assertFalse(nombre.compararCaracteristica(nombre3));
    }

}
