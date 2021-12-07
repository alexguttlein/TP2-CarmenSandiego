package carmenSandiego.modelo;

public class RangoInvestigador implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;

    public RangoInvestigador(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 20;
        this.rangoActual = "Investigador";
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
        return distancia/1300;
    }

    @Override
    public Rango verificarRango(){
        if(this.getCantidadDeArrestos() == this.arrestosParaAscender)
            return new RangoSargento(this.getCantidadDeArrestos());
        return this;
    }
}
