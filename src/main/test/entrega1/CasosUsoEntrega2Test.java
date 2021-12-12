package entrega1;

import carmenSandiego.modelo.Interpol;
import carmenSandiego.modelo.Ladron;
import carmenSandiego.modelo.Ladrones;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosUsoEntrega2Test {
    Ladrones ladrones = new Ladrones();
    Interpol interpol = new Interpol(ladrones);
    Ladron ladronMereyLaroc = ladrones.getLadrones().get(5);
    Ladron ladronKatherineDrib = ladrones.getLadrones().get(7);
    List<Ladron> posiblesLadrones;

    //caso uso 3: Cargar en la computadora los datos recopilados y buscar sospechosos
    @Test
    public void seIngresanAlgunosDatosEnLaComputadoraDeInterpolYSeEncuentranDosPosiblesLadrones(){
        interpol.setDatoGenero("Femenino");
        interpol.setDatoCabello("Castanio");
        interpol.setDatoHobby("Escalar");

        posiblesLadrones = interpol.buscarPosiblesLadrones();

        assertEquals(2, posiblesLadrones.size());
        assertEquals(ladronMereyLaroc, posiblesLadrones.get(0));
        assertEquals(ladronKatherineDrib, posiblesLadrones.get(1));
    }

}
