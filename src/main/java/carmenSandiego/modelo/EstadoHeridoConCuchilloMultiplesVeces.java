package carmenSandiego.modelo;

public class EstadoHeridoConCuchilloMultiplesVeces implements EstadoJugador {

    private final int HORAS_HERIDO = 1;

    public void pasarTiempo(){
        Reloj reloj = Reloj.getInstance();
        reloj.agregarHoras(HORAS_HERIDO);
    }
}
