package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Recorrido;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JuegoTest {
    Juego juego = new Juego();

    @Test
    public void lasEntidadesSeGeneranCorrectamente(){
        assertNotNull(juego.getObjetoRobado());
        assertNotNull(juego.getLadronActual());
        assertNotNull(juego.getInterpol());
    }

}
