package pruebasUnitarias;


import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.edificio.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EdificioTest {
    Edificio banco = new EdificioBanco(new Caracteristica("Banco"));
    Edificio aeropuerto = new EdificioAeropuerto(new Caracteristica("Aeropuerto"));
    Edificio biblioteca = new EdificioBiblioteca(new Caracteristica("Biblioteca"));
    Edificio puerto = new EdificioPuerto(new Caracteristica("Puerto"));

    @Test
    public void seIngresa1SolaVezAlEdificio(){
        banco.entrarAlEdificio();
        aeropuerto.entrarAlEdificio();
        biblioteca.entrarAlEdificio();
        puerto.entrarAlEdificio();

        assertEquals(1, banco.getCantidadDeVisitas());
        assertEquals(1, aeropuerto.getCantidadDeVisitas());
        assertEquals(1, biblioteca.getCantidadDeVisitas());
        assertEquals(1, puerto.getCantidadDeVisitas());
    }

    @Test
    public void seIngresa2VecesAlEdificio(){
        for (int i = 0; i < 2; i++) {
            banco.entrarAlEdificio();
            aeropuerto.entrarAlEdificio();
            biblioteca.entrarAlEdificio();
            puerto.entrarAlEdificio();
        }
        assertEquals(2, banco.getCantidadDeVisitas());
        assertEquals(2, aeropuerto.getCantidadDeVisitas());
        assertEquals(2, biblioteca.getCantidadDeVisitas());
        assertEquals(2, puerto.getCantidadDeVisitas());
    }

    @Test
    public void seIngresa55VecesAlEdificio(){
        for(int i = 0; i < 55; i++){
            banco.entrarAlEdificio();
            aeropuerto.entrarAlEdificio();
            biblioteca.entrarAlEdificio();
            puerto.entrarAlEdificio();
        }
        assertEquals(55, banco.getCantidadDeVisitas());
        assertEquals(55, aeropuerto.getCantidadDeVisitas());
        assertEquals(55, biblioteca.getCantidadDeVisitas());
        assertEquals(55, puerto.getCantidadDeVisitas());
    }
    /*
        @Test
        public void seIngresa1SolaVezAlBancoYSeObtieneUnaPista(){
            pistaBanco.setPista("pesos");
            banco.setComportamientoPistas(pistaBanco);
            banco.entrarAlEdificio();

            assertEquals("Vino a cambiar un poco de pesos", banco.getPista());
        }

        @Test
        public void seIngresa1SolaVezAlAeropuertoYSeObtieneUnaPista(){
            pistaAeropuerto.setPista("celeste y blanca con un sol en el centro");
            aeropuerto.setComportamientoPistas(pistaAeropuerto);
            aeropuerto.entrarAlEdificio();

            assertEquals("Se subio a un avion celeste y blanca con un sol en el centro", aeropuerto.getPista());
        }

        @Test
        public void seIngresa1SolaVezAlBibliotecaYSeObtieneUnaPista(){
            pistaBiblioteca.setPista("espaniol");
            biblioteca.setComportamientoPistas(pistaBiblioteca);
            biblioteca.entrarAlEdificio();

            assertEquals("Agarro un diccionario espaniol", biblioteca.getPista());
        }

        @Test
        public void seIngresa1SolaVezAlPuertoYSeObtieneUnaPista(){
            pistaPuerto.setPista("ganaderia");
            puerto.setComportamientoPistas(pistaPuerto);
            puerto.entrarAlEdificio();

            assertEquals("Al lugar que iba exportaban mucho ganaderia", puerto.getPista());
        }

        @Test
        public void elEdificioNoTienePista(){
            banco.setSinPista();
            biblioteca.setSinPista();
            aeropuerto.setSinPista();
            puerto.setSinPista();
            assertEquals("Disculpa no lo vimos por aca", banco.getPista());
            assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista());
            assertEquals("Disculpa no lo vimos por aca", aeropuerto.getPista());
            assertEquals("Disculpa no lo vimos por aca", puerto.getPista());
        }
    */
    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora(){
        banco.entrarAlEdificio();
        assertEquals(1, banco.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorSegundaVezYSeDemoran2Horas(){
        banco.entrarAlEdificio();
        banco.entrarAlEdificio();
        assertEquals(2, banco.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorDecimaVezYSeDemoran3Horas(){
        for (int i = 0; i < 10; i++){
            banco.entrarAlEdificio();
        }
        assertEquals(3, banco.getDemora());
    }

    @Test
    public void seVisita5vecesUnBancoYSeDemoraEnTotal12Horas(){
        int demoraTotal = 0;
        for (int i = 0; i < 5; i++){
            banco.entrarAlEdificio();
            demoraTotal += banco.getDemora();
        }
        assertEquals(12, demoraTotal);
    }

}


