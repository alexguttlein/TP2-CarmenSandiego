package pruebasUnitarias;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Ladrones;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadronesTest {

    Ladrones ladrones = new Ladrones("src/main/java/edu/fiuba/algo3/modelo/datosDelJuego/ladrones.csv");
    ArrayList<Ladron> listaLadrones = ladrones.getLadrones();

    @Test
    public void elPrimerLadronEsElEsperado(){
        Caracteristica nombre = new Caracteristica("Nick Brunch");
        Caracteristica genero = new Caracteristica("Masculino");
        Caracteristica hobby = new Caracteristica("Escalar");
        Caracteristica cabello = new Caracteristica("Negro");
        Caracteristica senia = new Caracteristica("Anillo");
        Caracteristica vehiculo = new Caracteristica("Moto");

        Ladron ladron = listaLadrones.get(0);

        assertEquals(nombre.getCaracteristica(), ladron.getNombre().getCaracteristica());
        assertTrue(ladron.getNombre().compararCaracteristica(nombre));
        assertTrue(ladron.getGenero().compararCaracteristica(genero));
        assertTrue(ladron.getHobby().compararCaracteristica(hobby));
        assertTrue(ladron.getCabello().compararCaracteristica(cabello));
        assertTrue(ladron.getSenia().compararCaracteristica(senia));
        assertTrue(ladron.getVehiculo().compararCaracteristica(vehiculo));
    }

    @Test
    public void todosLosLadronesTienenElNombreEsperado(){
        Caracteristica ladronNick = new Caracteristica("Nick Brunch");
        Caracteristica ladronLen = new Caracteristica("Len Bulk");
        Caracteristica ladronIhor = new Caracteristica("Ihor Ihorovitch");
        Caracteristica ladronFast = new Caracteristica("Fast Eddie B.");
        Caracteristica ladronScar = new Caracteristica("Scar Graynolt");
        Caracteristica ladronMerey = new Caracteristica("Merey Laroc");
        Caracteristica ladronLady = new Caracteristica("Lady Agatha");
        Caracteristica ladronDrib = new Caracteristica("Katherine Drib");
        Caracteristica ladronAnnie = new Caracteristica("Dazzle Annie");
        Caracteristica ladronCarmen = new Caracteristica("Carmen Sandiego");

        assertTrue(ladronNick.compararCaracteristica(listaLadrones.get(0).getNombre()));
        assertTrue(ladronLen.compararCaracteristica(listaLadrones.get(1).getNombre()));
        assertTrue(ladronIhor.compararCaracteristica(listaLadrones.get(2).getNombre()));
        assertTrue(ladronFast.compararCaracteristica(listaLadrones.get(3).getNombre()));
        assertTrue(ladronScar.compararCaracteristica(listaLadrones.get(4).getNombre()));
        assertTrue(ladronMerey.compararCaracteristica(listaLadrones.get(5).getNombre()));
        assertTrue(ladronLady.compararCaracteristica(listaLadrones.get(6).getNombre()));
        assertTrue(ladronDrib.compararCaracteristica(listaLadrones.get(7).getNombre()));
        assertTrue(ladronAnnie.compararCaracteristica(listaLadrones.get(8).getNombre()));
        assertTrue(ladronCarmen.compararCaracteristica(listaLadrones.get(9).getNombre()));

    }

}

