package pruebasUnitarias;

import carmenSandiego.modelo.*;
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
        //sinPista.mostrarPistas();
        assertEquals("Disculpa no lo vimos por aca", sinPista.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaBanco() {
        pistaBanco.setPista("pesos");
        //pistaBanco.mostrarPistas();
        assertEquals("Vino a cambiar un poco de pesos", pistaBanco.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaAeropuerto() {
        pistaAeropuerto.setPista("celeste y blanca con un sol en el centro");
        //pistaAeropuerto.mostrarPistas();
        assertEquals("Se subio a un avion celeste y blanca con un sol en el centro", pistaAeropuerto.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaBiblioteca() {
        pistaBiblioteca.setPista("espaniol");
        //pistaBiblioteca.mostrarPistas();
        assertEquals("Agarro un diccionario espaniol", pistaBiblioteca.getPista());
    }
    @Test
    public void seMuestraCorrectamentePistaPuerto() {
        pistaPuerto.setPista("ganaderia");
        //pistaPuerto.mostrarPistas();
        assertEquals("Al lugar que iba exportaban mucho ganaderia", pistaPuerto.getPista());
    }

}
