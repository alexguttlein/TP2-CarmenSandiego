package carmenSandiego.modelo;

public interface Rango {

    int getCantidadDeArrestos();
    int getArrestosParaAscender();
    void addArresto();
    String getNombreRango();
    double getTiempoDeViaje(double distancia);
    Rango verificarRango();
    void setVelocidad(int velocidad);
    int getVelocidad();
    void setArrestosParaAscender(int arrestos);

}
