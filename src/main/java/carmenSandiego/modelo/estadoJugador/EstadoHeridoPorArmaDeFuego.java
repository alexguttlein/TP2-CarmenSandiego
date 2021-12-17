package carmenSandiego.modelo.estadoJugador;

import carmenSandiego.modelo.Tiempo;

public class EstadoHeridoPorArmaDeFuego implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(4);
    }
}
