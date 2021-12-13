package carmenSandiego.modelo;

public class EstadoDormido implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(8);
    }
}
