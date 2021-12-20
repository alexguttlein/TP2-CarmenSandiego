package pruebasUnitarias;

import carmenSandiego.modelo.Caracteristica;
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
        assertTrue(new Caracteristica("Huevo de hace 1000 años").compararCaracteristica(listaObjetosRobados.get(0).getNombre()));
        assertTrue(new Caracteristica("Tabla Babilonia").compararCaracteristica(listaObjetosRobados.get(1).getNombre()));
        assertTrue(new Caracteristica("Colmillo de jabali").compararCaracteristica(listaObjetosRobados.get(2).getNombre()));
        assertTrue(new Caracteristica("Coleccion Real de Cuarzo").compararCaracteristica(listaObjetosRobados.get(24).getNombre()));
        assertTrue(new Caracteristica("Rubi Serendip").compararCaracteristica(listaObjetosRobados.get(25).getNombre()));
    }

}
