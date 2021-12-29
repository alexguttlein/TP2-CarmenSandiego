package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.ObjetoRobado;
import edu.fiuba.algo3.modelo.ObjetosRobados;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.rango.RangoDetective;
import edu.fiuba.algo3.modelo.jugador.rango.RangoInvestigador;
import edu.fiuba.algo3.modelo.jugador.rango.RangoNovato;
import edu.fiuba.algo3.modelo.jugador.rango.RangoSargento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class ObjetosRobadosTest {

    Ciudades ciudadesMock = mock(Ciudades.class);
    Jugador jugadorMock = mock(Jugador.class);
    ObjetosRobados objetosRobados = new ObjetosRobados(ciudadesMock);
    ArrayList<ObjetoRobado> listaObjetosRobados = objetosRobados.getObjetosRobados();

    @Test
    public void losObjetosRobadosSeInstancianCorrectamente(){
        assertTrue(new Caracteristica("Huevo de hace 1000 años").compararCaracteristica(listaObjetosRobados.get(0).getNombre()));
        assertTrue(new Caracteristica("Tabla Babilonia").compararCaracteristica(listaObjetosRobados.get(1).getNombre()));
        assertTrue(new Caracteristica("Colmillo de jabali").compararCaracteristica(listaObjetosRobados.get(2).getNombre()));
        assertTrue(new Caracteristica("Coleccion Real de Cuarzo").compararCaracteristica(listaObjetosRobados.get(24).getNombre()));
        assertTrue(new Caracteristica("Rubi Serendip").compararCaracteristica(listaObjetosRobados.get(25).getNombre()));
    }

    @Test
    public void seSeleccionaUnObjetoRobadoAleatorioDeTipoComun(){
        when(jugadorMock.getRango()).thenReturn(new RangoNovato(0));
        ObjetoRobado objetoRandom = objetosRobados.seleccionarObjetoRobadoAleatorio(jugadorMock);

        assertNotNull(objetoRandom);
        assertTrue(objetoRandom.getImportancia().compararCaracteristica(new Caracteristica("Comun")));
    }

    @Test
    public void seSeleccionaUnObjetoRobadoAleatorioDeTipoImportante(){
        when(jugadorMock.getRango()).thenReturn(new RangoDetective(5));
        ObjetoRobado objetoRandom = objetosRobados.seleccionarObjetoRobadoAleatorio(jugadorMock);

        assertNotNull(objetoRandom);
        assertTrue(objetoRandom.getImportancia().compararCaracteristica(new Caracteristica("Importante")));
    }
/*
    @Test
    public void seSeleccionaUnObjetoRobadoAleatorioDeTipoMuyImportante(){
        when(jugadorMock.getRango()).thenReturn(new RangoInvestigador(10));
        ObjetoRobado objetoRandom = objetosRobados.seleccionarObjetoRobadoAleatorio(jugadorMock);

        assertNotNull(objetoRandom);
        assertTrue(objetoRandom.getImportancia().compararCaracteristica(new Caracteristica("Muy Importante")));
    }

 */

}

