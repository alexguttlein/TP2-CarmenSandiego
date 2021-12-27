package pruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class InterpolTest {
    Jugador jugadorMock = mock(Jugador.class);
    Tiempo tiempo = new Tiempo(7, 4, 0, 2021);
    Ladrones ladrones = new Ladrones("src/main/java/edu/fiuba/algo3/datosDelJuego/ladrones.csv");
    Ladron ladronCarmen = ladrones.getLadrones().get(9);
    Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronCarmen);

    Caracteristica genero = new Caracteristica("Femenino");
    Caracteristica hobby = new Caracteristica("Tenis");
    Caracteristica cabello = new Caracteristica("Castanio");
    Caracteristica senia = new Caracteristica("Joyas");
    Caracteristica vehiculo = new Caracteristica("Convertible");

    @Test
    public void seIngresanDatosDeUnLadron(){

        Ladron posibleLadron = interpol.getPosibleLadron();

        interpol.setDatoGenero(genero);
        interpol.setDatoHobby(hobby);
        interpol.setDatoCabello(cabello);
        interpol.setDatoSenia(senia);
        interpol.setDatoVehiculo(vehiculo);

        assertTrue(genero.compararCaracteristica(posibleLadron.getGenero()));
        assertTrue(hobby.compararCaracteristica(posibleLadron.getHobby()));
        assertTrue(cabello.compararCaracteristica(posibleLadron.getCabello()));
        assertTrue(senia.compararCaracteristica(posibleLadron.getSenia()));
        assertTrue(vehiculo.compararCaracteristica(posibleLadron.getVehiculo()));
    }

    @Test
    public void seFiltraPorGeneroFemeninoYAunNoSePuedeEmitirOrdenDeArresto(){
        interpol.setDatoGenero(genero);
        interpol.emitirOrdenDeArresto();

        assertEquals(5, interpol.buscarPosiblesLadrones().size());
        assertFalse(interpol.atraparSospechoso());
    }

    @Test
    public void seFiltraPorTodasLasCaracteristicasYSeEmiteOrdenDeArresto(){
        interpol.setDatoGenero(genero);
        interpol.setDatoHobby(hobby);
        interpol.setDatoCabello(cabello);
        interpol.setDatoSenia(senia);
        interpol.setDatoVehiculo(vehiculo);

        interpol.emitirOrdenDeArresto();

        assertEquals(1, interpol.buscarPosiblesLadrones().size());
        assertTrue(interpol.compararLadrones(ladronCarmen, interpol.getLadron()));
        assertTrue(interpol.atraparSospechoso());
    }

    @Test
    public void seEmiteUnaOrdenDeArrestoPasan4Horas(){
        Tiempo tiempoEsperado = new Tiempo(10, 04, 00, 2021);

        interpol.setDatoGenero(genero);
        interpol.setDatoHobby(hobby);
        interpol.setDatoCabello(cabello);
        interpol.setDatoSenia(senia);
        interpol.setDatoVehiculo(vehiculo);

        interpol.emitirOrdenDeArresto();

        assertTrue(tiempo.compararTiempos(tiempoEsperado));
    }

    @Test
    public void seIntentaEmitirUnaOrdenDeArrestoPeroNoSeTienenLasPruebasNecesariasAsiQueElTiempoNoPasa(){
        Tiempo tiempoEsperado = new Tiempo(7, 04, 00, 2021);

        interpol.setDatoGenero(genero);
        interpol.setDatoCabello(cabello);

        interpol.emitirOrdenDeArresto();

        assertTrue(tiempo.compararTiempos(tiempoEsperado));
    }


}
