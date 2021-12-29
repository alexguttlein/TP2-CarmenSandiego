package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Juego;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JuegoTest {
    Juego juego = new Juego();

    @Test
    public void lasEntidadesSeGeneranCorrectamente(){
        assertNotNull(juego.getObjetoRobado());
        assertNotNull(juego.getLadronActual());
        assertNotNull(juego.getInterpol());

        juego.iniciarPartida();
        assertNotNull(juego.getPartida());
    }

}
