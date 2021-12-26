package pruebasUnitarias;

import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComportamientoPistaTest {

    SinPista sinPista = new SinPista();
    PistaBanco pistaBanco = new PistaBanco();
    PistaAeropuerto pistaAeropuerto = new PistaAeropuerto();
    PistaBiblioteca pistaBiblioteca = new PistaBiblioteca();
    PistaPuerto pistaPuerto = new PistaPuerto();

    @Test
    public void seMuestraCorrectamenteSinPista() {
        assertEquals("Disculpa no lo vimos por aca", sinPista.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaBanco() {
        pistaBanco.setPista("pesos");
        assertEquals("Vino a cambiar un poco de pesos", pistaBanco.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaAeropuerto() {
        pistaAeropuerto.setPista("celeste y blanca con un sol en el centro");
        assertEquals("Se subió a un avion celeste y blanca con un sol en el centro", pistaAeropuerto.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaBiblioteca() {
        pistaBiblioteca.setPista("espaniol");
        assertEquals("Agarró un diccionario espaniol", pistaBiblioteca.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaPuerto() {
        pistaPuerto.setPista("ganaderia");
        assertEquals("Al lugar que iba exportaban mucho ganaderia", pistaPuerto.getPista());
    }
}
