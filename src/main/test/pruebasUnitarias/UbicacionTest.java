package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UbicacionTest {
    Ubicacion ubicacionSalida = new Ubicacion(45.573279804398034, -73.49124739806629);
    Ubicacion ubicacionDestino = new Ubicacion(23.564780856080713, -101.16072897108585);

    //las primera latitud y longitud son de Montreal y las otras son de Mexico.
    //las horas de viaje se redondean para abajo

    @Test
    public void obtengoLaDistanciaEntreLasCoordenadas(){
        double distanciaObtenida = ubicacionSalida.obtenerDistancia(ubicacionDestino);

        assertEquals(3466,distanciaObtenida,100);
    }

    @Test
    public void obtengoLaCantidadDeHorasQueLlevaViajarDesdeMontrealAMexicoParaLosDistintosRangos(){
        Rango novatoMock = mock(RangoNovato.class);
        Rango detectiveMock = mock(RangoDetective.class);
        Rango investigadorMock = mock(RangoInvestigador.class);
        Rango sargentoMock = mock(RangoSargento.class);

        when(novatoMock.getVelocidad()).thenReturn(900);
        when(detectiveMock.getVelocidad()).thenReturn(1100);
        when(investigadorMock.getVelocidad()).thenReturn(1200);
        when(sargentoMock.getVelocidad()).thenReturn(1500);

        assertEquals(3, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, novatoMock.getVelocidad()));
        assertEquals(3, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, detectiveMock.getVelocidad()));
        assertEquals(2, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, investigadorMock.getVelocidad()));
        assertEquals(2, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, sargentoMock.getVelocidad()));
    }
}