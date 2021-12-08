package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangoTest {
    Rango novato = new RangoNovato(0);
    Rango detective = new RangoDetective(5);
    Rango investigador = new RangoInvestigador(10);
    Rango sargento = new RangoSargento(20);

    @Test
    public void novatoRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        novato.addArresto();

        assertEquals(5, novato.getArrestosParaAscender());
        assertEquals(1, novato.getCantidadDeArrestos());
        assertEquals("Novato", novato.getNombreRango());
    }

    @Test
    public void detectiveRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        detective.addArresto();

        assertEquals(10, detective.getArrestosParaAscender());
        assertEquals(6, detective.getCantidadDeArrestos());
        assertEquals("Detective", detective.getNombreRango());
    }

    @Test
    public void investigadorRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        investigador.addArresto();

        assertEquals(20, investigador.getArrestosParaAscender());
        assertEquals(11, investigador.getCantidadDeArrestos());
        assertEquals("Investigador", investigador.getNombreRango());
    }

    @Test
    public void sargentoRealizaUnArrestoYAumentaLaCantidadDeArrestos(){
        sargento.addArresto();

        assertEquals(21, sargento.getCantidadDeArrestos());
        assertEquals("Sargento", sargento.getNombreRango());
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
