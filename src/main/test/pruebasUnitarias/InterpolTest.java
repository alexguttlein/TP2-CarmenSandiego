package pruebasUnitarias;

import carmenSandiego.modelo.Interpol;
import carmenSandiego.modelo.Ladrones;
import carmenSandiego.modelo.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InterpolTest {

    Tiempo tiempo = new Tiempo(7, 4, 0, 2021);
    Ladrones ladrones = new Ladrones();
    Interpol interpol = new Interpol(ladrones, tiempo);

    @Test
    public void seIngresanDatosDeUnLadron(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Rojo");
        interpol.setDatoSenia("Anillo");
        interpol.setDatoVehiculo("Convertible");

        assertEquals("Femenino", interpol.getLadronBuscado().getGenero());
        assertEquals("Tenis", interpol.getLadronBuscado().getHobby());
        assertEquals("Rojo", interpol.getLadronBuscado().getCabello());
        assertEquals("Anillo", interpol.getLadronBuscado().getSenia());
        assertEquals("Convertible", interpol.getLadronBuscado().getVehiculo());
    }

    @Test
    public void seFiltraPorGeneroFemeninoYAunNoSePuedeEmitirOrdenDeArresto(){
        interpol.setDatoGenero("Femenino");
        interpol.emitirOrdenDeArresto();

        assertEquals(5, interpol.buscarPosiblesLadrones().size());
        assertNull(interpol.getLadronParaArrestar());
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
        assertNotNull(interpol.getLadronParaArrestar());
        assertEquals("Carmen Sandiego", interpol.getLadronParaArrestar().getNombre());
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
