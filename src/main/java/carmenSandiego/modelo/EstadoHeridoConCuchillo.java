package carmenSandiego.modelo;

public class EstadoHeridoConCuchillo implements EstadoJugador{

    private final int HORAS_HERIDO = 2;

    public void pasarTiempo(){
        Reloj reloj = Reloj.getInstance();
        reloj.agregarHoras(HORAS_HERIDO);
    }
}
