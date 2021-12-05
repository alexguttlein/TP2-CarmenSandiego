package carmenSandiego.modelo;

public class EstadoHeridoPorArmaDeFuego implements EstadoJugador {

    private final int HORAS_HERIDO = 4;

    public void pasarTiempo(){
        Reloj reloj = Reloj.getInstance();
        reloj.agregarHoras(HORAS_HERIDO);
    }
}
