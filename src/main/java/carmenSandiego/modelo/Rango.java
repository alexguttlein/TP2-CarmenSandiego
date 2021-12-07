package carmenSandiego.modelo;

public interface Rango {

    int getCantidadDeArrestos();
    int getArrestosParaAscender();
    void addArresto();
    String getRango();
    double getTiempoDeViaje(double distancia);
    Rango verificarRango();

    public int getVelocidad(){return 1100;} //Está hardcodeado, hay que cambiarlo
}
