package carmenSandiego.modelo;

public class EstadoDormido implements EstadoJugador {

    private final int HORAS_DE_SUENIO = 8;

    public void pasarTiempo(Horario reloj){
        reloj.addHoras(8);
    }
}
