package carmenSandiego.modelo.estadoJugador;

import carmenSandiego.modelo.Tiempo;

public class EstadoHeridoConCuchilloMultiplesVeces implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(1);
    }
}
