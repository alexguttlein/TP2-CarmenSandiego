package carmenSandiego.modelo;

public class RangoNovato implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;
    private int velocidad;

    public RangoNovato(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.setArrestosParaAscender(5);
        this.rangoActual = "Novato";
        this.setVelocidad(900);
    }

    @Override
    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    @Override
    public void setArrestosParaAscender(int arrestosParaAscender){
        this.arrestosParaAscender = arrestosParaAscender;
    }

    @Override
    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    @Override
    public void addArresto(){
        this.cantidadDeArrestos += 1;
    }

    @Override
    public String getNombreRango(){return this.rangoActual;}

    @Override
    public double getTiempoDeViaje(double distancia){
        return distancia/this.getVelocidad();
    }

    @Override
    public Rango verificarRango(){
        if(this.getCantidadDeArrestos() == this.arrestosParaAscender)
            return new RangoDetective(this.getCantidadDeArrestos());
        return this;
    }

    @Override
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}

    @Override
    public int getVelocidad(){return this.velocidad;}
}
