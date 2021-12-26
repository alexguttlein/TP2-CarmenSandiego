package edu.fiuba.algo3.modelo.jugador.estado;

import edu.fiuba.algo3.modelo.Tiempo;

public class EstadoDormido implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(8);
    }
}
