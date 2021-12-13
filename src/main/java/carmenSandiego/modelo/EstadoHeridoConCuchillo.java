package carmenSandiego.modelo;

public class EstadoHeridoConCuchillo implements EstadoJugador{

    public void pasarTiempo(Tiempo reloj){
        reloj.addHoras(2);
    }
}
