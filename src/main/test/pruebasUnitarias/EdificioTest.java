package pruebasUnitarias;

import carmenSandiego.modelo.Ciudad;
import carmenSandiego.modelo.EdificioBanco;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class EdificioTest {
    String unaPistaCorrecta = "Si, vino a cambiar un poco de pesos";
    String unaPistaIncorrecta = "Disculpa no lo vimos por aca";

    EdificioBanco banco = new EdificioBanco(unaPistaCorrecta, unaPistaIncorrecta, true);
    EdificioBanco biblioteca = new EdificioBanco(unaPistaCorrecta, unaPistaIncorrecta, false);
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void muestraPistaEdificioPorDondePasoElLadron(){
        assertEquals("Si, vino a cambiar un poco de pesos", banco.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaEdificioPorDondeNoPasoElLadron(){
        assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista(ciudadMock));
    }

    @Test
    public void seVisitaUnEdificioUnaVez(){
        banco.visitar();
        assertEquals(1, banco.getVecesVisitado());
    }

    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora1(){
        banco.visitar();
        assertEquals(1, banco.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            banco.visitar();
        assertEquals(2, banco.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            banco.visitar();
        assertEquals(3, banco.getDemora());
    }

/*
    @Test
    public void muestraPistaCorrectaBiblioteca(){
        assertEquals("Otra pista", edificio.getPista(ciudadSig));
    }

    @Test
    public void muestraPistaIncorrectaBiblioteca(){
        assertEquals("No lo ví por acá", edificio.getPista(ciudadSig));
    }

    @Test
    public void muestraPistaCorrectaPuerto(){
        assertEquals("Re-Otra pista", edificio.getPista(ciudadSig));
    }

    @Test
    public void muestraPistaIncorrectaPuerto(){
        assertEquals("No lo ví por acá", edificio.getPista(ciudadSig));
    }

    @Test
    public void muestraPistaCorrectaAeropuerto(){
        assertEquals("Re-Re-Otra pista",edificio.getPista(ciudadSig));
    }

    @Test
    public void muestraPistaIncorrectaAeropuerto(){
        assertEquals("No lo vi por acá", edificio.getPista(ciudadSig));
    }


    @Test
    public void detectiveVisita1VecesAlBanco(){
        edificio.getPista(ciudadSig);
        assertEquals(1, edificio.getVecesVisitados());
    }

    @Test
    public void detectiveVisita2VecesAlBanco(){
        for(int i = 0; i < 1; i++){
            edificio.addVecesVisitados();
        }

        assertEquals(2, edificio.getVecesVisitados());
    }
    @Test
    public void detectiveVisita1VecesALaBiblioteca(){
        assertEquals(1, edificio.getVecesVisitados());
    }

    @Test
    public void detectiveVisita3VecesAlAeropuerto(){ //debe estar involucrado el tiempo dentro de la implementacion
        for(int i = 0; i < 2; i++){
            edificio.addVecesVisitados();
        }
        assertEquals(3, edificio.getVecesVisitados());
    }

    @Test
    public void detectiveVisita55VecesAlPuerto(){
        for(int i = 0; i < 54; i++){
            edificio.addVecesVisitados();
        }
        assertEquals(55, edificio.getVecesVisitados());
    }
*/
}