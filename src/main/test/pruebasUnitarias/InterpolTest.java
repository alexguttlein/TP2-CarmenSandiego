package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class InterpolTest {

    Jugador jugadorMock = mock(Jugador.class);
    Tiempo tiempo = new Tiempo(7, 4, 0, 2021);
    Ladrones ladrones = new Ladrones();
    Ladron ladronCarmen = ladrones.getLadrones().get(9);
    Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronCarmen);

    @Test
    public void seIngresanDatosDeUnLadron(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Rojo");
        interpol.setDatoSenia("Anillo");
        interpol.setDatoVehiculo("Convertible");

        assertEquals("Femenino", interpol.getPosibleLadron().getGenero());
        assertEquals("Tenis", interpol.getPosibleLadron().getHobby());
        assertEquals("Rojo", interpol.getPosibleLadron().getCabello());
        assertEquals("Anillo", interpol.getPosibleLadron().getSenia());
        assertEquals("Convertible", interpol.getPosibleLadron().getVehiculo());
    }

    @Test
    public void seFiltraPorGeneroFemeninoYAunNoSePuedeEmitirOrdenDeArresto(){
        interpol.setDatoGenero("Femenino");
        interpol.emitirOrdenDeArresto();

        assertEquals(5, interpol.buscarPosiblesLadrones().size());
        //assertNull(interpol.getLadronParaArrestar());
        assertFalse(interpol.atraparSospechoso());
    }

    @Test
    public void seFiltraPorTodasLasCaracteristicasYSeEmiteOrdenDeArresto(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");

        interpol.emitirOrdenDeArresto();

        assertEquals(1, interpol.buscarPosiblesLadrones().size());
        //assertNotNull(interpol.getLadronParaArrestar());
        assertTrue(interpol.compararLadrones(ladronCarmen, interpol.getLadron()));
        assertTrue(interpol.atraparSospechoso());
    }

    @Test
    public void seEmiteUnaOrdenDeArrestoPasan4Horas(){
        assertEquals(7, interpol.getTiempo().getHoraActual());

        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");

        interpol.emitirOrdenDeArresto();

        assertEquals(10, interpol.getTiempo().getHoraActual());
    }

    @Test
    public void seIntentaEmitirUnaOrdenDeArrestoPeroNoSeTienenLasPruebasNecesariasAsiQueElTiempoNoPasa(){
        assertEquals(7, interpol.getTiempo().getHoraActual());

        interpol.setDatoGenero("Femenino");
        interpol.setDatoCabello("Castanio");

        interpol.emitirOrdenDeArresto();

        assertEquals(7, interpol.getTiempo().getHoraActual());
    }
}
