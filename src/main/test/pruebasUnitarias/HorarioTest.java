package pruebasUnitarias;

import carmenSandiego.modelo.Horario;
import carmenSandiego.modelo.Reloj;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import carmenSandiego.modelo.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorarioTest {
    Horario horario = new Horario();
    Jugador mockJugador = mock(Jugador.class);

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

    //Test de reloj con Singleton
    @Test
    public void seAgregarDosHorasAReloj(){
        Reloj reloj = Reloj.getInstance();
        reloj.reiniciar();
        reloj.agregarHoras(2);
        assertEquals(9, reloj.getHoraActual());
    }

    @Test
    public void seAgregan30HorasYPasaASerMartesALas13(){
        Reloj reloj = Reloj.getInstance();  //Ojo que cada vez que se modifica queda modificado siempre!!!
        reloj.reiniciar();
        reloj.agregarHoras(30);

        assertEquals(1, reloj.getDiaActual());
        assertEquals(13, reloj.getHoraActual());
    }

}
