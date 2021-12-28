package pruebasUnitarias;


import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.*;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.*;
import edu.fiuba.algo3.modelo.jugador.rango.Rango;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PistaTest {
    Ciudad ciudadMock = mock(Ciudad.class);
    Ladron ladronMock = mock(Ladron.class);
    Rango rangoMock = mock(Rango.class);

    Caracteristica nombreAerop = new Caracteristica("Aeropuerto");
    Caracteristica nombrePuerto = new Caracteristica("Puerto");
    Caracteristica nombreBiblio = new Caracteristica("Biblioteca");
    Caracteristica nombreBanco = new Caracteristica("Banco");

    Edificio aeropuerto = new EdificioAeropuerto(nombreAerop);
    Edificio puerto = new EdificioPuerto(nombrePuerto);
    Edificio biblioteca = new EdificioBiblioteca(nombreBiblio);
    Edificio banco = new EdificioBanco(nombreBanco);

    @Test
    public void laPistaDelAeropuertoEsLaEsperada(){
        Caracteristica dialogoAerop = new Caracteristica("Subio a un avion que tenia bandera ");
        Caracteristica descripcionAerop = new Caracteristica("celeste y blanca.");
        Pista pista = new PistaAeropuerto(dialogoAerop, descripcionAerop);

        aeropuerto.setPista(pista);

        assertTrue(aeropuerto.getPista().compararPista(pista));
    }

    @Test
    public void laPistaDelPuertoEsLaEsperada(){
        Caracteristica dialogoPuerto = new Caracteristica("Estuvo conversando con el capitan de un barco que tenia bandera ");
        Caracteristica descripcionPuerto = new Caracteristica("celeste y blanca.");
        Pista pista = new PistaPuerto(dialogoPuerto, descripcionPuerto);

        puerto.setPista(pista);

        assertTrue(puerto.getPista().compararPista(pista));
    }

    @Test
    public void laPistaDelBancoEsLaEsperada(){
        Caracteristica dialogoBanco = new Caracteristica("Estuvo consultando la tasa de cambio para cambiar su moneda a ");
        Caracteristica descripcionBanco = new Caracteristica("peso.");
        Pista pista = new PistaPuerto(dialogoBanco, descripcionBanco);

        banco.setPista(pista);

        assertTrue(banco.getPista().compararPista(pista));
    }

    @Test
    public void laPistaDeLaBibliotecaEsLaEsperada(){
        Caracteristica dialogoBiblioteca = new Caracteristica("Busco informacion sobre destinos que tengan ");
        Caracteristica descripcionBiblioteca = new Caracteristica("montanias.");
        Pista pista = new PistaBiblioteca(dialogoBiblioteca, descripcionBiblioteca);

        biblioteca.setPista(pista);

        assertTrue(biblioteca.getPista().compararPista(pista));
    }

    @Test
    public void seModificaLaPistaDelAeropuerto(){
        when(ciudadMock.getBandera()).thenReturn(new Caracteristica("celeste y blanca"));
        when(rangoMock.getArrestosParaAscender()).thenReturn(10);
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(ladronMock.getCabello()).thenReturn(new Caracteristica("Rojo"));
        when(ladronMock.getHobby()).thenReturn(new Caracteristica("Tenis"));
        when(ladronMock.getSenia()).thenReturn(new Caracteristica("Anillo"));
        when(ladronMock.getVehiculo()).thenReturn(new Caracteristica("Auto"));

        Pista pista = new PistaAeropuerto(new Caracteristica("No lo hemos visto por aqui"), new Caracteristica(""));
        aeropuerto.setPista(pista);
        assertTrue(aeropuerto.getPista().compararPista(pista));

        aeropuerto.modificarPista(ciudadMock, ladronMock, rangoMock);

        assertNotNull(aeropuerto.getPista());
    }

    @Test
    public void seModificaLaPistaDelPuerto(){
        when(ciudadMock.getBandera()).thenReturn(new Caracteristica("celeste y blanca"));
        when(rangoMock.getArrestosParaAscender()).thenReturn(10);
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(ladronMock.getCabello()).thenReturn(new Caracteristica("Rojo"));
        when(ladronMock.getHobby()).thenReturn(new Caracteristica("Tenis"));
        when(ladronMock.getSenia()).thenReturn(new Caracteristica("Anillo"));
        when(ladronMock.getVehiculo()).thenReturn(new Caracteristica("Auto"));

        Pista pista = new PistaPuerto(new Caracteristica("No lo hemos visto por aqui"), new Caracteristica(""));
        puerto.setPista(pista);
        assertTrue(puerto.getPista().compararPista(pista));

        puerto.modificarPista(ciudadMock, ladronMock, rangoMock);

        assertNotNull(puerto.getPista());
    }

    @Test
    public void seModificaLaPistaDelBanco(){
        when(ciudadMock.getMoneda()).thenReturn(new Caracteristica("peso"));
        when(rangoMock.getArrestosParaAscender()).thenReturn(10);
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(ladronMock.getCabello()).thenReturn(new Caracteristica("Rojo"));
        when(ladronMock.getHobby()).thenReturn(new Caracteristica("Tenis"));
        when(ladronMock.getSenia()).thenReturn(new Caracteristica("Anillo"));
        when(ladronMock.getVehiculo()).thenReturn(new Caracteristica("Auto"));

        Pista pista = new PistaBanco(new Caracteristica("No lo hemos visto por aqui"), new Caracteristica(""));
        banco.setPista(pista);
        assertTrue(banco.getPista().compararPista(pista));

        banco.modificarPista(ciudadMock, ladronMock, rangoMock);

        assertNotNull(banco.getPista());
    }

    @Test
    public void seModificaLaPistaDeLaBiblioteca(){
        when(ciudadMock.getGeografia()).thenReturn(new Caracteristica("montanias"));
        when(rangoMock.getArrestosParaAscender()).thenReturn(10);
        when(ladronMock.getGenero()).thenReturn(new Caracteristica("Femenino"));
        when(ladronMock.getCabello()).thenReturn(new Caracteristica("Rojo"));
        when(ladronMock.getHobby()).thenReturn(new Caracteristica("Tenis"));
        when(ladronMock.getSenia()).thenReturn(new Caracteristica("Anillo"));
        when(ladronMock.getVehiculo()).thenReturn(new Caracteristica("Auto"));

        Pista pista = new PistaBiblioteca(new Caracteristica("No lo hemos visto por aqui"), new Caracteristica(""));
        biblioteca.setPista(pista);
        assertTrue(biblioteca.getPista().compararPista(pista));

        biblioteca.modificarPista(ciudadMock, ladronMock, rangoMock);

        assertNotNull(biblioteca.getPista());
    }
}
