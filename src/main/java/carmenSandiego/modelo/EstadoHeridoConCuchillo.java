package carmenSandiego.modelo;

public class EstadoHeridoConCuchillo implements EstadoJugador{

    public void pasarTiempo(Horario reloj){
        reloj.addHoras(2);
    }
}
