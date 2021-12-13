package carmenSandiego.modelo;

public class EstadoHeridoPorArmaDeFuego implements EstadoJugador {

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(4);
    }
}
