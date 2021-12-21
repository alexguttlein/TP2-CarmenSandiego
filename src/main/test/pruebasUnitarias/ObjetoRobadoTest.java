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
    Caracteristica nombre = new Caracteristica("Espada de San Martin");
    Caracteristica importancia = new Caracteristica("Comun");

    ObjetoRobado objetoRobado = new ObjetoRobado(nombre, ciudadMock, importancia);

    @Test
    public void seRobaUnObjetoComunDeLaCiudadDeBuenosAires(){
        assertEquals(nombre, objetoRobado.getNombre());
        assertEquals(importancia, objetoRobado.getImportancia());
    }

}
