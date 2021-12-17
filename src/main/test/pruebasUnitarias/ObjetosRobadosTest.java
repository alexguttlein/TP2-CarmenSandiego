package pruebasUnitarias;

import carmenSandiego.modelo.ciudad.Ciudades;
import carmenSandiego.modelo.ObjetoRobado;
import carmenSandiego.modelo.ObjetosRobados;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

public class ObjetosRobadosTest {

    Ciudades ciudadesMock = mock(Ciudades.class);
    ObjetosRobados objetosRobados = new ObjetosRobados(ciudadesMock);
    ArrayList<ObjetoRobado> listaObjetosRobados = objetosRobados.getObjetosRobados();

    @Test
    public void losObjetosRobadosSeInstancianCorrectamente(){
        assertEquals("Huevo de hace 1000 años", listaObjetosRobados.get(0).getNombre());
        assertEquals("Tabla Babilonia", listaObjetosRobados.get(1).getNombre());
        assertEquals("Colmillo de jabali", listaObjetosRobados.get(2).getNombre());
        assertEquals("Coleccion Real de Cuarzo", listaObjetosRobados.get(24).getNombre());
        assertEquals("Rubi Serendip", listaObjetosRobados.get(25).getNombre());
    }

}
