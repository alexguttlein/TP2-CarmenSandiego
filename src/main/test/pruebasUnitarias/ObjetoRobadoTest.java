package pruebasUnitarias;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ObjetoRobado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetoRobadoTest {
    Ciudad ciudadMock = mock(Ciudad.class);
    Caracteristica objetoEspada = new Caracteristica("Espada de San Martin");
    Caracteristica importancia = new Caracteristica("Comun");

    ObjetoRobado objetoRobado = new ObjetoRobado(objetoEspada, ciudadMock, importancia);

    @Test
    public void seRobaUnObjetoComunDeLaCiudadDeBuenosAires(){
        //when(ciudadMock.getNombre()).thenReturn(new Caracteristica("Buenos Aires"));

        assertEquals(objetoEspada, objetoRobado.getNombre());
        //assertEquals(ciudadMock.getNombre(), objetoRobado.getCiudadOrigen().getNombre());
        assertEquals(importancia, objetoRobado.getImportancia());
    }

    @Test
    public void seComparanDosObjetosRobadosIguales(){
        Caracteristica nombreEsperado = new Caracteristica("Espada de San Martin");
        Caracteristica importanciaEsperada = new Caracteristica("Comun");

        ObjetoRobado otroObjetoRobado = new ObjetoRobado(nombreEsperado, ciudadMock, importanciaEsperada);

        assertTrue(objetoRobado.compararObjetoRobado(otroObjetoRobado));
    }
}
