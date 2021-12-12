package carmenSandiego.modelo;

public class EstadoHeridoConCuchilloMultiplesVeces implements EstadoJugador {

    public void pasarTiempo(Horario reloj){
        reloj.addHoras(1);
    }
}
