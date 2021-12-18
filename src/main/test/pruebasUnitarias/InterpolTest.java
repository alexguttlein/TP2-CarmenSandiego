package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class InterpolTest {

    Jugador jugadorMock = mock(Jugador.class);
    Tiempo tiempo = new Tiempo(7, 4, 0, 2021);
    Ladrones ladrones = new Ladrones();

    ArrayList datosSospechoso = new ArrayList<>(Arrays.asList("", "Femenino", "Tenis", "Castanio", "", "Convertible"));
    ArrayList datosSospechosoIncorrecto = new ArrayList<>(Arrays.asList("", "Masculino", "Futbol", "Rojo", "", ""));
    Ladron ladronSospechoso = new Ladron(datosSospechoso);
    Ladron ladronSospechosoIncorrecto = new Ladron(datosSospechosoIncorrecto);

    @Test
    public void seComparaPosibleLadronConCarmen(){
        Ladron ladronCarmen = ladrones.getLadrones().get(9);
        Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronCarmen);
        interpol.setSospechosoArrestado(ladronCarmen);
        interpol.mostrarLadrones();

        assertEquals(true, interpol.compararLadrones());
    }

    @Test
    public void seFijaSiCarmenEsSospechosa(){
        Ladron ladronCarmen = ladrones.getLadrones().get(9);
        Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronCarmen);
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");
        //Femenino;Tenis;Castanio;Joyas;Convertible

        assertEquals(true, interpol.compararLadrones(ladronCarmen));
    }

    @Test
    public void seFijaSiLenEsSospechoso(){
        Ladron ladronLen = ladrones.getLadrones().get(1);
        Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronLen);
        interpol.setDatoGenero("Femenino");
        interpol.setDatoHobby("Tenis");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoSenia("Joyas");
        interpol.setDatoVehiculo("Convertible");
        //Femenino;Tenis;Castanio;Joyas;Convertible

        assertEquals(false, interpol.compararLadrones(ladronLen));
    }

    @Test
    public void laListaDePosiblesLadronesSeReduceAlObtenerUnDatoNuevo(){
        Ladron ladronCarmen = ladrones.getLadrones().get(9);
        Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronCarmen);
        interpol.setDatoGenero("Femenino");

        //interpol.mostrarPosiblesLadrones();
        interpol.filtrarPosiblesLadrones();
        //interpol.mostrarPosiblesLadrones();

        assertEquals(5, interpol.getPosiblesLadrones().size());
        assertEquals(10, interpol.getLadrones().size());
    }

    @Test
    public void laListaDePosiblesLadronesSeReduceA2(){
        Ladron ladronLen = ladrones.getLadrones().get(1);
        Interpol interpol = new Interpol(ladrones, tiempo, jugadorMock, ladronLen);

        interpol.setDatoGenero("Masculino");
        interpol.setDatoCabello("Rojo");
        interpol.filtrarPosiblesLadrones();

        assertEquals(2, interpol.getPosiblesLadrones().size());
    }


    /*
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

     */
}
