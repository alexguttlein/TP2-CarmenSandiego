package pruebasUnitarias;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.ciudad.Ubicacion;
import edu.fiuba.algo3.modelo.jugador.rango.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UbicacionTest {
    Ubicacion ubicacionSalida = new Ubicacion(45.573279804398034, -73.49124739806629);
    Ubicacion ubicacionDestino = new Ubicacion(23.564780856080713, -101.16072897108585);

    Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");

    //las primera latitud y longitud son de Montreal y las otras son de Mexico.
    //las horas de viaje se redondean para abajo/arriba dependiendo si el decimal es mayor/menor a la mitad
    //las distancias se redondean para abajo

    @Test
    public void obtengoLaDistanciaEntreLasCoordenadas(){
        double distanciaObtenida = ubicacionSalida.obtenerDistancia(ubicacionDestino);

        assertEquals(3489,distanciaObtenida);
    }

    @Test
    public void obtengoLaCantidadDeHorasQueLlevaViajarDesdeMontrealAMexicoParaLosDistintosRangos(){
        Rango novatoMock = mock(RangoNovato.class);
        Rango detectiveMock = mock(RangoDetective.class);
        Rango investigadorMock = mock(RangoInvestigador.class);
        Rango sargentoMock = mock(RangoSargento.class);

        when(novatoMock.getVelocidad()).thenReturn(900);
        when(detectiveMock.getVelocidad()).thenReturn(1100);
        when(investigadorMock.getVelocidad()).thenReturn(1300);
        when(sargentoMock.getVelocidad()).thenReturn(1500);

        assertEquals(4, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, novatoMock.getVelocidad()));
        assertEquals(3, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, detectiveMock.getVelocidad()));
        assertEquals(3, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, investigadorMock.getVelocidad()));
        assertEquals(2, ubicacionSalida.obtenerHorasDeViaje(ubicacionDestino, sargentoMock.getVelocidad()));
    }

    @Test
    public void seObtieneDistanciaEntreDistintasCiudades(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();
        Ciudad ciudadBuenosAires = listaCiudades.get(0);
        Ciudad ciudadRoma = listaCiudades.get(12);
        Ciudad ciudadOslo = listaCiudades.get(5);

        assertEquals(12244, ciudadBuenosAires.getUbicacion().obtenerDistancia(ciudadOslo.getUbicacion()));
        assertEquals(11147, ciudadBuenosAires.getUbicacion().obtenerDistancia(ciudadRoma.getUbicacion()));
        assertEquals(2007, ciudadOslo.getUbicacion().obtenerDistancia(ciudadRoma.getUbicacion()));
        assertEquals(0, ciudadOslo.getUbicacion().obtenerDistancia(ciudadOslo.getUbicacion()));
    }

    @Test
    public void seObtienenTiemposDeViajeEntreDistintasCiudadesParaJugadorNovato(){
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();
        Ciudad ciudadBuenosAires = listaCiudades.get(0);
        Ciudad ciudadRoma = listaCiudades.get(12);
        Ciudad ciudadOslo = listaCiudades.get(5);

        assertEquals(14, ciudadBuenosAires.getUbicacion().obtenerHorasDeViaje(ciudadOslo.getUbicacion(), 900));
        assertEquals(12, ciudadBuenosAires.getUbicacion().obtenerHorasDeViaje(ciudadRoma.getUbicacion(), 900));
        assertEquals(2, ciudadRoma.getUbicacion().obtenerHorasDeViaje(ciudadOslo.getUbicacion(), 900));
        assertEquals(0, ciudadRoma.getUbicacion().obtenerHorasDeViaje(ciudadRoma.getUbicacion(), 900));
    }
}
