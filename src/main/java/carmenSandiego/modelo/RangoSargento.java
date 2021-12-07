package carmenSandiego.modelo;

public class RangoSargento implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;

    public RangoSargento(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.rangoActual = "Sargento";
    }

    @Override
    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    @Override
    public int getArrestosParaAscender(){return 0;}

    @Override
    public void addArresto(){
        this.cantidadDeArrestos += 1;
    }

    @Override
    public String getRango(){return this.rangoActual;}

    @Override
    public double getTiempoDeViaje(double distancia){
        return distancia/1500;
    }

    @Override
    public Rango verificarRango(){
        return this;
    }
}