package carmenSandiego.modelo;

public class RangoNovato implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;

    public RangoNovato(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 5;
        this.rangoActual = "Novato";
    }

    @Override
    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    @Override
    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    @Override
    public void addArresto(){
        this.cantidadDeArrestos += 1;
    }

    @Override
    public String getRango(){return this.rangoActual;}

    @Override
    public double getTiempoDeViaje(double distancia){
        return distancia/900;
    }

    @Override
    public Rango verificarRango(){
        if(this.getCantidadDeArrestos() == this.arrestosParaAscender)
            return new RangoDetective(this.getCantidadDeArrestos());
        return this;
    }
}
