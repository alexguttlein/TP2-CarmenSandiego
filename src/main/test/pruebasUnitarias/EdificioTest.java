package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class EdificioTest {
    String unaPistaCorrecta = "Si, vino a cambiar un poco de pesos";
    String unaPistaIncorrecta = "Disculpa no lo vimos por aca";

    EdificioBanco banco = new EdificioBanco(unaPistaCorrecta, unaPistaIncorrecta, true);
    EdificioBiblioteca biblioteca = new EdificioBiblioteca(unaPistaCorrecta, unaPistaIncorrecta, false);
    EdificioAeropuerto aeropuerto = new EdificioAeropuerto(unaPistaCorrecta, unaPistaIncorrecta, true);
    EdificioPuerto puerto = new EdificioPuerto(unaPistaCorrecta, unaPistaIncorrecta, false);
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void muestraPistaBancoPorDondePasoElLadron(){
        assertEquals("Si, vino a cambiar un poco de pesos", banco.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaBibliotecaPorDondeNoPasoElLadron(){
        assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaAeropuertoPorDondePasoElLadron(){
        assertEquals("Si, vino a cambiar un poco de pesos", aeropuerto.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaPuertoPorDondeNoPasoElLadron(){
        assertEquals("Disculpa no lo vimos por aca", puerto.getPista(ciudadMock));
    }

    @Test
    public void seVisitaUnBancoUnaVez(){
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

    @Test
    public void seVisitaUnaBibliotecaDosVeces(){
        for(int i = 0; i < 2; i++)
            biblioteca.visitar();
        assertEquals(2, biblioteca.getVecesVisitado());
    }

    @Test
    public void seVisitaUnaBibliotecaPorPrimeraVezYSeDemora1Hora1(){
        biblioteca.visitar();
        assertEquals(1, biblioteca.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            biblioteca.visitar();
        assertEquals(2, biblioteca.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            biblioteca.visitar();
        assertEquals(3, biblioteca.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoCincoVeces(){
        for(int i = 0; i < 5; i++)
            aeropuerto.visitar();
        assertEquals(5, aeropuerto.getVecesVisitado());
    }

    @Test
    public void seVisitaUnAeropuertoPorPrimeraVezYSeDemora1Hora1(){
        aeropuerto.visitar();
        assertEquals(1, aeropuerto.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            aeropuerto.visitar();
        assertEquals(2, aeropuerto.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            aeropuerto.visitar();
        assertEquals(3, aeropuerto.getDemora());
    }

    @Test
    public void seVisitaUnPuertoOchoVeces(){
        for(int i = 0; i < 8; i++)
            puerto.visitar();
        assertEquals(8, puerto.getVecesVisitado());
    }

    @Test
    public void seVisitaUnPuertoPorPrimeraVezYSeDemora1Hora1(){
        puerto.visitar();
        assertEquals(1, puerto.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            puerto.visitar();
        assertEquals(2, puerto.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            puerto.visitar();
        assertEquals(3, puerto.getDemora());
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