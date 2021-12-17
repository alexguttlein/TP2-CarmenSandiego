package pruebasUnitarias;

import carmenSandiego.modelo.Tiempo;
import org.junit.jupiter.api.Test;

import static java.util.Calendar.*;
import static org.junit.jupiter.api.Assertions.*;

public class TiempoTest {

    Tiempo reloj = new Tiempo(7, 4, 0, 2021);

    @Test
    public void elRelojSeInicializaLunesDeEneroALas7AM(){
        assertEquals(7, reloj.getHoraActual());
        assertEquals(MONDAY, reloj.getDiaActual());
        assertEquals(JANUARY, reloj.getMesActual());
    }

    @Test
    public void seAgregan5HorasAlRejol(){
        reloj.addHoras(5);
        assertEquals(12, reloj.getHoraActual());
    }

    @Test
    public void seAgregan24HsYElDiaPasaASerMartes() {
        reloj.addHoras(24);

        assertEquals(TUESDAY, reloj.getDiaActual());
        assertEquals(7, reloj.getHoraActual());
    }

    @Test
    public void seComparanDosTiemposYResultanSerIguales(){
        Tiempo tiempoAux = new Tiempo(9, 4, 0, 2021);
        reloj.addHoras(2);

        assertTrue(reloj.compararTiempos(tiempoAux));
    }

    @Test
    public void seComparanDosTiemposYResultanSerDiferentes(){
        Tiempo tiempoAux = new Tiempo(9, 4, 0, 2021);

        assertFalse(reloj.compararTiempos(tiempoAux));
    }

}
