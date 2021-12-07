package carmenSandiego.modelo;

public class RangoDetective implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;

    public RangoDetective(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 10;
        this.rangoActual = "Detective";
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
        return distancia/1100;
    }

    @Override
    public Rango verificarRango(){
        if(this.getCantidadDeArrestos() == this.arrestosParaAscender)
            return new RangoInvestigador(this.getCantidadDeArrestos());
        return this;
    }
}
