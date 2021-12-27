package pruebasUnitarias;

import edu.fiuba.algo3.modelo.edificio.comportamiento.demora.ComportamientoDeDemora;
import edu.fiuba.algo3.modelo.edificio.comportamiento.demora.Demora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComportamientoDeDemoraTest {

    ComportamientoDeDemora demora = new Demora();

    @Test
    public void ingresa1SolaVez() {
        assertEquals(1,demora.calcularDemora(1));
    }
    @Test
    public void ingresa2Veces() {
        assertEquals(2,demora.calcularDemora(2));
    }
    @Test
    public void ingreaVariasVeces() {
        assertEquals(3,demora.calcularDemora(3));
        assertEquals(3,demora.calcularDemora(5));
        assertEquals(3,demora.calcularDemora(99));
    }

}
