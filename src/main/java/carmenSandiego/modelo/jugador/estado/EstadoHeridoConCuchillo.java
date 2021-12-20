package carmenSandiego.modelo.jugador.estado;

import carmenSandiego.modelo.Tiempo;

public class EstadoHeridoConCuchillo implements EstadoJugador{

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(2);
    }
}
