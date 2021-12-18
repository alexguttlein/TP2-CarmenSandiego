package pruebasUnitarias;

import carmenSandiego.modelo.CaracteristicaLadron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaracteristicaLadronTest {

    CaracteristicaLadron cabelloRubio = new CaracteristicaLadron("Rubio");
    CaracteristicaLadron cabelloRubio2 = new CaracteristicaLadron("Rubio");
    CaracteristicaLadron cabelloNegro = new CaracteristicaLadron("Negro");
    CaracteristicaLadron cabelloInexistente = new CaracteristicaLadron("");

    @Test
    public void seComparanCaracteristicasQueCoinciden(){
        assertEquals(true, cabelloRubio.comparar(cabelloRubio2));
    }

    @Test
    public void seComparanCaracteristicasQueNoCoinciden(){
        assertEquals(false, cabelloRubio.comparar(cabelloNegro));
        assertEquals(false, cabelloRubio.compararSospechoso(cabelloNegro));
    }

    @Test
    public void seComparaUnaCaracteristicaConOtraVacia(){
        assertEquals(false, cabelloRubio.comparar(cabelloInexistente));
        assertEquals(true, cabelloRubio.compararSospechoso(cabelloInexistente));
    }
}
