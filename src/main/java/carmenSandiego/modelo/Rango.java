package carmenSandiego.modelo;

public interface Rango {

    int getCantidadDeArrestos();
    int getArrestosParaAscender();
    void addArresto();
    String getRango();
    double getTiempoDeViaje(double distancia);
    Rango verificarRango();

}
