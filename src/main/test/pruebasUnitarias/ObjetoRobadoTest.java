package pruebasUnitarias;

import carmenSandiego.modelo.Ciudad;
import carmenSandiego.modelo.ObjetoRobado;
import carmenSandiego.modelo.Rango;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetoRobadoTest {
    Ciudad ciudadMock = mock(Ciudad.class);
    ObjetoRobado objetoRobado = new ObjetoRobado(ciudadMock, "Comun");

    @Test
    public void seRobaUnObjetoDeLaCiudadDeBuenosAires(){
        when(ciudadMock.getNombre()).thenReturn("Buenos Aires");

        assertEquals("Buenos Aires", objetoRobado.getCiudadOrigen().getNombre());
    }

    @Test
    public void elObjetoRobadoEsDeImportanciaComun(){

        assertEquals("Comun", objetoRobado.getImportancia());
    }
}
