package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Tiempo;
import org.junit.jupiter.api.Test;

import static java.util.Calendar.*;
import static org.junit.jupiter.api.Assertions.*;

public class TiempoTest {

    @Test
    public void elRelojSeInicializaLunesDeEneroALas7AM(){
        Tiempo reloj = new Tiempo();
        assertEquals(7, reloj.getHoraActual());
        assertEquals(MONDAY, reloj.getDiaActual());
        assertEquals(JANUARY, reloj.getMesActual());
    }

    @Test
    public void seAgregan5HorasAlRejol(){
        Tiempo reloj = new Tiempo();
        reloj.addHoras(5);
        assertEquals(12, reloj.getHoraActual());
    }

    @Test
    public void seAgregan24HsYElDiaPasaASerMartes() {
        Tiempo reloj = new Tiempo();
        reloj.addHoras(24);

        assertEquals(TUESDAY, reloj.getDiaActual());
        assertEquals(7, reloj.getHoraActual());
    }

    @Test
    public void seComparanDosTiemposYResultanSerIguales(){
        Tiempo reloj = new Tiempo();
        Tiempo tiempoAux = new Tiempo(9, 4, 0, 2021);
        reloj.addHoras(2);

        assertTrue(reloj.compararTiempos(tiempoAux));
    }

    @Test
    public void seComparanDosTiemposYResultanSerDiferentes(){
        Tiempo reloj = new Tiempo();
        Tiempo tiempoAux = new Tiempo(9, 4, 0, 2021);

        assertFalse(reloj.compararTiempos(tiempoAux));
    }

    @Test
    public void seCompruebaSiSealcanzoElLimiteDeTiempo(){
        Tiempo tiempo = new Tiempo();
        Tiempo tiempo2 = new Tiempo();

        tiempo.addHoras(153);
        tiempo2.addHoras(154);

        assertFalse(tiempo.seAlcanzoElLimiteDeTiempo());
        assertTrue(tiempo2.seAlcanzoElLimiteDeTiempo());
    }


}
