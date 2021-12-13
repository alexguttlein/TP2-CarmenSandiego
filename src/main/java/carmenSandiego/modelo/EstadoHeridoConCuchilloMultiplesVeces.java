package carmenSandiego.modelo;

public class EstadoHeridoConCuchilloMultiplesVeces implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(1);
    }
}
