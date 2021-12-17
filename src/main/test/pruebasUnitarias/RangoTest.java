package pruebasUnitarias;

import carmenSandiego.modelo.rango.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangoTest {
    Rango novato = new RangoNovato(0);
    Rango detective = new RangoDetective(5);
    Rango investigador = new RangoInvestigador(10);
    Rango sargento = new RangoSargento(20);

    @Test
    public void novatoRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        Rango rangoEsperado = new RangoNovato(0);
        novato.addArresto();

        assertEquals(5, novato.getArrestosParaAscender());
        assertEquals(1, novato.getCantidadDeArrestos());
        assertEquals("Novato", novato.getNombreRango());
        assertTrue(novato.compararRangos(rangoEsperado));
    }

    @Test
    public void detectiveRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        Rango rangoEsperado = new RangoDetective(5);
        detective.addArresto();

        assertEquals(10, detective.getArrestosParaAscender());
        assertEquals(6, detective.getCantidadDeArrestos());
        assertEquals("Detective", detective.getNombreRango());
        assertTrue(detective.compararRangos(rangoEsperado));
    }

    @Test
    public void investigadorRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        Rango rangoEsperado = new RangoInvestigador(10);
        investigador.addArresto();

        assertEquals(20, investigador.getArrestosParaAscender());
        assertEquals(11, investigador.getCantidadDeArrestos());
        assertEquals("Investigador", investigador.getNombreRango());
        assertTrue(investigador.compararRangos(rangoEsperado));
    }

    @Test
    public void sargentoRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        Rango rangoEsperado = new RangoSargento(20);
        sargento.addArresto();

        assertEquals(21, sargento.getCantidadDeArrestos());
        assertEquals("Sargento", sargento.getNombreRango());
        assertTrue(sargento.compararRangos(rangoEsperado));
    }

    @Test
    public void cadaRangoRealizaUnViajeDeIgualDistanciaEnDiferenteTiempo(){
        double viaje = 10000;

        assertEquals(11,(int)novato.getTiempoDeViaje(viaje));
        assertEquals(9,(int)detective.getTiempoDeViaje(viaje));
        assertEquals(7,(int)investigador.getTiempoDeViaje(viaje));
        assertEquals(6,(int)sargento.getTiempoDeViaje(viaje));
    }
}
