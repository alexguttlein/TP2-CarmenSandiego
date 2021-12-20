package pruebasUnitarias;

import carmenSandiego.modelo.edificio.comportamiento.visita.Visita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComportamientoVisitaTest {
    Visita contadorVisita = new Visita();

    @Test
    public void seIngresa1SolaVez() {
        contadorVisita.entrarAlEdificio();
        assertEquals(1, contadorVisita.getTotalVisitas());
    }
    @Test
    public void seIngresa55Veces() {
        for (int i = 0; i<55; i++){
            contadorVisita.entrarAlEdificio();
        }
        assertEquals(55, contadorVisita.getTotalVisitas());
    }
}
