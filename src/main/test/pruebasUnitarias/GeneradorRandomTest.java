package pruebasUnitarias;


import edu.fiuba.algo3.modelo.GeneradorRandom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneradorRandomTest {

    GeneradorRandom generadorRandom = new GeneradorRandom(5,3);

    @Test
    public void seGeneranTresNumerosAleatoriosMenoresACinco(){
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();

        assertEquals(3, listaGenerada.size());
        assertTrue(listaGenerada.get(0) < 5 && listaGenerada.get(0) >= 0);
        assertTrue(listaGenerada.get(1) < 5 && listaGenerada.get(1) >= 0);
        assertTrue(listaGenerada.get(2) < 5 && listaGenerada.get(2) >= 0);
    }
}