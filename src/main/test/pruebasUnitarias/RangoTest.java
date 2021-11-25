package pruebasUnitarias;

import carmenSandiego.modelo.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangoTest {
    Rango rango = new Rango();

    @Test
    public void seRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        rango.addArresto();

        assertEquals(1, rango.getCantidadDeArrestos());
    }

    @Test
    public void seRealizan5ArrestosYElRangoAumentaADetective(){
        for(int i = 0; i < 5; i++)
            rango.addArresto();

        assertEquals(5, rango.getCantidadDeArrestos());
        assertEquals("Detective", rango.getRango());
    }

    @Test
    public void seRealizan10ArrestosYElRangoAumentaAInvestigador(){
        for(int i = 0; i < 10; i++)
            rango.addArresto();

        assertEquals(10, rango.getCantidadDeArrestos());
        assertEquals("Investigador", rango.getRango());
    }

    @Test
    public void seRealizan20ArrestosYElRangoAumentaASargento(){
        for(int i = 0; i < 20; i++)
            rango.addArresto();

        assertEquals(20, rango.getCantidadDeArrestos());
        assertEquals("Sargento", rango.getRango());
    }
}
