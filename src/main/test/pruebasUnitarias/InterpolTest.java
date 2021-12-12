package pruebasUnitarias;

import carmenSandiego.modelo.Interpol;
import carmenSandiego.modelo.Ladrones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterpolTest {

    Ladrones ladrones = new Ladrones();
    Interpol interpol = new Interpol(ladrones);

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

        assertEquals(5, interpol.buscarPosiblesLadrones().size());
        assertNull(interpol.emitirOrdenDeArresto());
    }

    @Test
    public void seFiltraPorTodasLasCaracteristicasYSeEmiteOrdenDeArresto(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");

        assertEquals(1, interpol.buscarPosiblesLadrones().size());
        assertNotNull(interpol.emitirOrdenDeArresto());
        assertEquals("Carmen Sandiego", interpol.emitirOrdenDeArresto().getNombre());
    }
}
