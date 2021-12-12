package carmenSandiego.modelo;

public class EstadoHeridoPorArmaDeFuego implements EstadoJugador {

    public void pasarTiempo(Horario reloj){
        reloj.addHoras(4);
    }
}
