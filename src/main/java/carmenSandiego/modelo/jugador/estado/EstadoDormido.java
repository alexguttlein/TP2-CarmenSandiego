package carmenSandiego.modelo.jugador.estado;

import carmenSandiego.modelo.Tiempo;

public class EstadoDormido implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(8);
    }
}
