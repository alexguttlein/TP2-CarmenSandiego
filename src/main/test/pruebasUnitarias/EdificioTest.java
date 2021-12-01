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

    Edificio bancoPasoLadron = new EdificioBanco("Banco", pistaIncorrecta, true);
    Edificio bibliotecaPasoLadron = new EdificioBiblioteca("Biblioteca", pistaIncorrecta, true);
    Edificio aeropuertoPasoLadron = new EdificioAeropuerto("Aeropuerto", pistaIncorrecta, true);
    Edificio puertoPasoLadron = new EdificioPuerto("Puerto", pistaIncorrecta, true);

    Edificio bancoNoPasoLadron = new EdificioBanco("Banco", pistaIncorrecta, false);
    Edificio bibliotecaNoPasoLadron = new EdificioBiblioteca("Biblioteca", pistaIncorrecta, false);
    Edificio aeropuertoNoPasoLadron = new EdificioAeropuerto("Aeropuerto", pistaIncorrecta, false);
    Edificio puertoNoPasoLadron = new EdificioPuerto("Puerto", pistaIncorrecta, false);

    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void muestraPistaBancoPorDondePasoElLadron(){
        when(ciudadMock.getMoneda()).thenReturn("Pesos");

        assertTrue(bancoPasoLadron.getPasoLadron());
        assertEquals("Banco", bancoPasoLadron.getNombre());
        assertEquals("Pesos", bancoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaBancoPorDondeNoPasoElLadron(){
        assertFalse(bancoNoPasoLadron.getPasoLadron());

        assertEquals("Disculpa no lo vimos por aca", bancoNoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaBibliotecaPorDondePasoElLadron(){
        when(ciudadMock.getGeografia()).thenReturn("Campos");

        assertTrue(bibliotecaPasoLadron.getPasoLadron());
        assertEquals("Campos", bibliotecaPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaBibliotecaPorDondeNoPasoElLadron(){
        assertFalse(bibliotecaNoPasoLadron.getPasoLadron());
        assertEquals("Biblioteca", bibliotecaNoPasoLadron.getNombre());
        assertEquals("Disculpa no lo vimos por aca", bibliotecaNoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaAeropuertoPorDondePasoElLadron(){
        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        assertEquals("Aeropuerto", aeropuertoPasoLadron.getNombre());
        assertEquals("Sol en el centro", aeropuertoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaAeropuertoPorDondeNoPasoElLadron(){
        assertFalse(aeropuertoNoPasoLadron.getPasoLadron());

        assertEquals("Disculpa no lo vimos por aca", aeropuertoNoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaPuertoPorDondePasoElLadron(){
        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        assertEquals("Puerto", puertoPasoLadron.getNombre());
        assertEquals("Sol en el centro", puertoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void muestraPistaPuertoPorDondeNoPasoElLadron(){
        assertEquals("Puerto", puertoNoPasoLadron.getNombre());
        assertEquals("Disculpa no lo vimos por aca", puertoNoPasoLadron.getPista(ciudadMock));
    }

    @Test
    public void seVisitaUnBancoUnaVez(){
        bancoPasoLadron.visitar();
        assertEquals(1, bancoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora1(){
        assertEquals(1, bancoPasoLadron.visitar());
    }

    @Test
    public void seVisitaUnBancoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            bancoPasoLadron.visitar();
        assertEquals(2, bancoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            bancoPasoLadron.visitar();
        assertEquals(3, bancoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaDosVeces(){
        for(int i = 0; i < 2; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(2, bibliotecaPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnaBibliotecaPorPrimeraVezYSeDemora1Hora1(){
        bibliotecaPasoLadron.visitar();
        assertEquals(1, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(2, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(3, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoCincoVeces(){
        for(int i = 0; i < 5; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(5, aeropuertoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnAeropuertoPorPrimeraVezYSeDemora1Hora1(){
        aeropuertoPasoLadron.visitar();
        assertEquals(1, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(2, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(3, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoOchoVeces(){
        for(int i = 0; i < 8; i++)
            puertoPasoLadron.visitar();
        assertEquals(8, puertoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnPuertoPorPrimeraVezYSeDemora1Hora1(){
        puertoPasoLadron.visitar();
        assertEquals(1, puertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            puertoPasoLadron.visitar();
        assertEquals(2, puertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            puertoPasoLadron.visitar();
        assertEquals(3, puertoPasoLadron.getDemora());
    }
}