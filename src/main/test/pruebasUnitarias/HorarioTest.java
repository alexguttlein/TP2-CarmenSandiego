package pruebasUnitarias;

import carmenSandiego.modelo.Horario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorarioTest {
    Horario horario = new Horario();

    @Test
    public void porDefectoSeIniciaUnLunesALas7Hs(){
        assertEquals(7, horario.getHoraActual());
        assertEquals(0, horario.getDiaActual());
        assertEquals("Lunes - 7:00 HS", horario.getDiaYHoraActual());
    }

    @Test
    public void seAgreganDosHoras(){
        horario.addHoras(2);

        assertEquals(0, horario.getDiaActual());
        assertEquals(9, horario.getHoraActual());
        assertEquals("Lunes - 9:00 HS", horario.getDiaYHoraActual());
    }

    @Test
    public void seAgregan24HsYElDiaPasaASerMartes(){
        horario.addHoras(24);

        assertEquals(1, horario.getDiaActual());
        assertEquals(7, horario.getHoraActual());
        assertEquals("Martes - 7:00 HS", horario.getDiaYHoraActual());
    }


}
