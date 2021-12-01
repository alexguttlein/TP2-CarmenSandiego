package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EdificioTest {
    String pistaIncorrecta = "Disculpa no lo vimos por aca";

    Edificio banco = new EdificioBanco("Banco", pistaIncorrecta, true);
    Edificio biblioteca = new EdificioBiblioteca("Biblioteca", pistaIncorrecta, false);
    Edificio aeropuerto = new EdificioAeropuerto("Aeropuerto", pistaIncorrecta, true);
    Edificio puerto = new EdificioPuerto("Puerto", pistaIncorrecta, false);
    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void muestraPistaBancoPorDondePasoElLadron(){
        when(ciudadMock.getMoneda()).thenReturn("Pesos");

        assertTrue(banco.getPasoLadron());
        assertEquals("Banco", banco.getNombre());
        assertEquals("Pesos", banco.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaBibliotecaPorDondeNoPasoElLadron(){
        assertFalse(biblioteca.getPasoLadron());
        assertEquals("Biblioteca", biblioteca.getNombre());
        assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaAeropuertoPorDondePasoElLadron(){
        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        assertEquals("Aeropuerto", aeropuerto.getNombre());
        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaPuertoPorDondeNoPasoElLadron(){
        assertEquals("Puerto", puerto.getNombre());
        assertEquals("Disculpa no lo vimos por aca", puerto.getPista(ciudadMock));
    }

    @Test
    public void seVisitaUnBancoUnaVez(){
        banco.visitar();
        assertEquals(1, banco.getVecesVisitado());
    }

    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora1(){
        assertEquals(1, banco.visitar());
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
}