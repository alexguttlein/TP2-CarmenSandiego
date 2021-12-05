package carmenSandiego.modelo;

public class EstadoDormido implements EstadoJugador {

    private final int HORAS_DE_SUENIO = 8;

    public void pasarTiempo(){
        Reloj reloj = Reloj.getInstance();
        reloj.agregarHoras(HORAS_DE_SUENIO);
    }
}
