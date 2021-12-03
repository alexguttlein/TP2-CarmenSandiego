package pruebasUnitarias;

import carmenSandiego.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EdificioTest {

    Edificio banco = new EdificioBanco();
    Edificio aeropuerto = new EdificioAeropuerto();
    Edificio biblioteca = new EdificioBiblioteca();
    Edificio puerto = new EdificioPuerto();

    Ciudad ciudadMock = mock(Ciudad.class);

    @Test
    public void seIngresa1SolaVezAlEdificio(){

        banco.entrarAlEdificio(0);
        aeropuerto.entrarAlEdificio(0);
        biblioteca.entrarAlEdificio(0);
        puerto.entrarAlEdificio(0);

        assertEquals(1, banco.getCantidadDeVisitas());
        assertEquals(1, aeropuerto.getCantidadDeVisitas());
        assertEquals(1, biblioteca.getCantidadDeVisitas());
        assertEquals(1, puerto.getCantidadDeVisitas());
    }
    @Test
    public void seIngresa2VecesAlEdificio(){

        banco.entrarAlEdificio(1);
        aeropuerto.entrarAlEdificio(1);
        biblioteca.entrarAlEdificio(1);
        puerto.entrarAlEdificio(1);

        assertEquals(2, banco.getCantidadDeVisitas());
        assertEquals(2, aeropuerto.getCantidadDeVisitas());
        assertEquals(2, biblioteca.getCantidadDeVisitas());
        assertEquals(2, puerto.getCantidadDeVisitas());
    }
    @Test
    public void seIngresaNVecesAlEdificio(){

        for(int i = 0; i < 55; i++){
            banco.entrarAlEdificio(i);
            aeropuerto.entrarAlEdificio(i);
            biblioteca.entrarAlEdificio(i);
            puerto.entrarAlEdificio(i);
        }
        assertEquals(55, banco.getCantidadDeVisitas());
        assertEquals(55, aeropuerto.getCantidadDeVisitas());
        assertEquals(55, biblioteca.getCantidadDeVisitas());
        assertEquals(55, puerto.getCantidadDeVisitas());
    }
    @Test
    public void seIngresa1SolaVezAlBancoYSeObtieneUnaPista(){

        when(ciudadMock.getMoneda()).thenReturn("Pesos");
        banco.entrarAlEdificio(0);
        assertEquals("Pesos", banco.getPista(ciudadMock));
    }
    @Test
    public void seIngresa1SolaVezAlAeropuertoYSeObtieneUnaPista(){

        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        aeropuerto.entrarAlEdificio(0);
        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));
    }
    @Test
    public void seIngresa1SolaVezAlBibliotecaYSeObtieneUnaPista(){

        when(ciudadMock.getGeografia()).thenReturn("Campos");
        biblioteca.entrarAlEdificio(0);
        assertEquals("Campos", biblioteca.getPista(ciudadMock));
    }
    @Test
    public void seIngresa1SolaVezAlPuertoYSeObtieneUnaPista(){//¿Cual es la pista del Puerto?

        /*when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        puerto.entrarAlEdificio(0);
        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));*/
    }
    @Test
    public void seIngresa10vecesAlBancoYSeObtieneUnaPista(){

        when(ciudadMock.getMoneda()).thenReturn("Pesos");
        banco.entrarAlEdificio(10);
        assertEquals("Pesos", banco.getPista(ciudadMock));
    }
    @Test
    public void seIngresa10vecesAlAeropuertoYSeObtieneUnaPista(){

        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        aeropuerto.entrarAlEdificio(10);
        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));
    }
    @Test
    public void seIngresa10vecesAlBibliotecaYSeObtieneUnaPista(){
        when(ciudadMock.getGeografia()).thenReturn("Campos");
        aeropuerto.entrarAlEdificio(10);
        assertEquals("Campos", biblioteca.getPista(ciudadMock));
    }
    @Test
    public void elEdificioNoTienePista(){

        when(ciudadMock.getSinPista()).thenReturn("Disculpa no lo vimos por aca");

        banco.setComportamientoPistas(new SinPista());
        biblioteca.setComportamientoPistas(new SinPista());
        aeropuerto.setComportamientoPistas(new SinPista());
        puerto.setComportamientoPistas(new SinPista());

        assertEquals("Disculpa no lo vimos por aca", banco.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", aeropuerto.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", puerto.getPista(ciudadMock));
    }
    @Test
    public  void elEdificioEnUnInicioTieneUnaPistaYLuegoYaNoTienePista(){

        when(ciudadMock.getSinPista()).thenReturn("Disculpa no lo vimos por aca");

        banco.setComportamientoPistas(new ConPista());
        banco.setComportamientoPistas(new SinPista());

        aeropuerto.setComportamientoPistas(new ConPista());
        aeropuerto.setComportamientoPistas(new SinPista());

        biblioteca.setComportamientoPistas(new ConPista());
        biblioteca.setComportamientoPistas(new SinPista());

        puerto.setComportamientoPistas(new ConPista());
        puerto.setComportamientoPistas(new SinPista());

        assertEquals("Disculpa no lo vimos por aca", banco.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", biblioteca.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", aeropuerto.getPista(ciudadMock));
        assertEquals("Disculpa no lo vimos por aca", puerto.getPista(ciudadMock));

    }
    @Test
    public  void elBancoEnUnInicioNoTienePistaYLuegoSiTienePista(){

        when(ciudadMock.getMoneda()).thenReturn("Pesos");

        banco.setComportamientoPistas(new SinPista());
        banco.setComportamientoPistas(new ConPista());

        assertEquals("Pesos", banco.getPista(ciudadMock));

    }
    @Test
    public  void elAeropuertoEnUnInicioNoTienePistaYLuegoSiTienePista(){

        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");
        aeropuerto.setComportamientoPistas(new SinPista());
        aeropuerto.setComportamientoPistas(new ConPista());
        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));

    }
    @Test
    public  void laBibliotecaEnUnInicioNoTienePistaYLuegoSiTienePista(){

        when(ciudadMock.getGeografia()).thenReturn("Campos");
        biblioteca.setComportamientoPistas(new SinPista());
        biblioteca.setComportamientoPistas(new ConPista());
        assertEquals("Campos", biblioteca.getPista(ciudadMock));

    }
    @Test
    public  void elBancoEnUnInicioNoTienePistaYLuegoSiTienePistaContandoLaCantidadDeVisita(){

        when(ciudadMock.getMoneda()).thenReturn("Pesos");

        banco.entrarAlEdificio(0);
        banco.setComportamientoPistas(new SinPista());
        banco.entrarAlEdificio(1);
        banco.setComportamientoPistas(new ConPista());

        assertEquals("Pesos", banco.getPista(ciudadMock));
        assertEquals(2, banco.getCantidadDeVisitas());

    }
    @Test
    public  void elAeropuertoEnUnInicioNoTienePistaYLuegoSiTienePistaContandoLaCantidadDeVisita(){

        when(ciudadMock.getBandera()).thenReturn("Sol en el centro");

        aeropuerto.entrarAlEdificio(0);
        aeropuerto.setComportamientoPistas(new SinPista());
        aeropuerto.entrarAlEdificio(1);
        aeropuerto.setComportamientoPistas(new ConPista());

        assertEquals("Sol en el centro", aeropuerto.getPista(ciudadMock));
        assertEquals(2, aeropuerto.getCantidadDeVisitas());

    }
    @Test
    public  void laBibliotecaEnUnInicioNoTienePistaYLuegoSiTienePistaContandoLaCantidadDeVisita(){

        when(ciudadMock.getGeografia()).thenReturn("Campos");

        biblioteca.entrarAlEdificio(0);
        biblioteca.setComportamientoPistas(new SinPista());
        biblioteca.entrarAlEdificio(1);
        biblioteca.setComportamientoPistas(new ConPista());

        assertEquals("Campos", biblioteca.getPista(ciudadMock));
        assertEquals(2, biblioteca.getCantidadDeVisitas());

    }
    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora(){

        banco.entrarAlEdificio(0);//se cuenta desde el cero, ver clase Demora
        banco.setComportamientoPistas(new ConPista());
        assertEquals(1, banco.getDemora());

    }
    @Test
    public void seVisitaUnBancoPorSegundaVezYSeDemoran2Horas(){

        banco.entrarAlEdificio(1); //se cuenta desde el cero, ver clase Demora
        banco.setComportamientoPistas(new ConPista());
        assertEquals(2, banco.getDemora());

    }
    @Test
    public void seVisitaUnBancoPorDecimaVezYSeDemoran3Horas(){
        banco.entrarAlEdificio(9);//se cuenta desde el cero, ver clase Demora
        assertEquals(3, banco.getDemora());
    }
    @Test
    public void seVisitaUnaBibliotecaPorPrimeraVezYSeDemora1Hora(){
        biblioteca.entrarAlEdificio(0);//se cuenta desde el cero, ver clase Demora
        assertEquals(1, biblioteca.getDemora());
    }
    @Test
    public void seVisitaUnaBibliotecaPorSegundaVezYSeDemoran2Horas(){
        biblioteca.entrarAlEdificio(1);//se cuenta desde el cero, ver clase Demora
        assertEquals(2, biblioteca.getDemora());
    }
    @Test
    public void seVisitaUnaBibliotecaPorDecimaVezYSeDemoran3Horas(){
        biblioteca.entrarAlEdificio(9);//se cuenta desde el cero, ver clase Demora
        assertEquals(3, biblioteca.getDemora());
    }
    @Test
    public void seVisitaUnAeropuertoPorPrimeraVezYSeDemora1Hora(){
        aeropuerto.entrarAlEdificio(0);//se cuenta desde el cero, ver clase Demora
        assertEquals(1, aeropuerto.getDemora());
    }
    @Test
    public void seVisitaUnAeropuertoPorSegundaVezYSeDemoran2Horas(){
        aeropuerto.entrarAlEdificio(1);//se cuenta desde el cero, ver clase Demora
        assertEquals(2, aeropuerto.getDemora());
    }
    @Test
    public void seVisitaUnAeropuertoPorDecimaVezYSeDemoran3Horas(){
        aeropuerto.entrarAlEdificio(9);//se cuenta desde el cero, ver clase Demora
        assertEquals(3, aeropuerto.getDemora());
    }
    @Test
    public void seVisitaUnPuertoPorPrimeraVezYSeDemora1Hora(){
        puerto.entrarAlEdificio(0);//se cuenta desde el cero, ver clase Demora
        assertEquals(1, puerto.getDemora());
    }
    @Test
    public void seVisitaUnPuertoPorSegundaVezYSeDemoran2Horas(){
        puerto.entrarAlEdificio(1);//se cuenta desde el cero, ver clase Demora
        assertEquals(2, puerto.getDemora());
    }
    @Test
    public void seVisitaUnPuertoPorDecimaVezYSeDemoran3Horas(){
        puerto.entrarAlEdificio(9);//se cuenta desde el cero, ver clase Demora
        assertEquals(3, puerto.getDemora());
    }

}



  /*

    @Test
    public void seVisitaUnBancoUnaVez(){
        bancoPasoLadron.visitar();
        assertEquals(1, bancoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnBancoPorPrimeraVezYSeDemora1Hora1(){
        assertEquals(1, bancoPasoLadron.visitar());
    }

    @Test
    public void seVisitaUnBancoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            bancoPasoLadron.visitar();
        assertEquals(2, bancoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnBancoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            bancoPasoLadron.visitar();
        assertEquals(3, bancoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaDosVeces(){
        for(int i = 0; i < 2; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(2, bibliotecaPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnaBibliotecaPorPrimeraVezYSeDemora1Hora1(){
        bibliotecaPasoLadron.visitar();
        assertEquals(1, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(2, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnaBibliotecaPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            bibliotecaPasoLadron.visitar();
        assertEquals(3, bibliotecaPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoCincoVeces(){
        for(int i = 0; i < 5; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(5, aeropuertoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnAeropuertoPorPrimeraVezYSeDemora1Hora1(){
        aeropuertoPasoLadron.visitar();
        assertEquals(1, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(2, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnAeropuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            aeropuertoPasoLadron.visitar();
        assertEquals(3, aeropuertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoOchoVeces(){
        for(int i = 0; i < 8; i++)
            puertoPasoLadron.visitar();
        assertEquals(8, puertoPasoLadron.getVecesVisitado());
    }

    @Test
    public void seVisitaUnPuertoPorPrimeraVezYSeDemora1Hora1(){
        puertoPasoLadron.visitar();
        assertEquals(1, puertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorSegundaVezYSeDemoran2Horas(){
        for(int i = 0; i < 2; i++)
            puertoPasoLadron.visitar();
        assertEquals(2, puertoPasoLadron.getDemora());
    }

    @Test
    public void seVisitaUnPuertoPorDecimaVezYSeDemoran3Horas(){
        for(int i = 0; i < 10; i++)
            puertoPasoLadron.visitar();
        assertEquals(3, puertoPasoLadron.getDemora());
    }
}*/