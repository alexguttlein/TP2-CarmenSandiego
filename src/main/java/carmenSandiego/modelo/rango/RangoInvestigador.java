package carmenSandiego.modelo.rango;

public class RangoInvestigador implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;
    private int velocidad;

    public RangoInvestigador(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.setArrestosParaAscender(20);
        this.rangoActual = "Investigador";
        this.setVelocidad(1300);
    }

    @Override
    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    @Override
    public void setArrestosParaAscender(int arrestosParaAscender){
        this.arrestosParaAscender = arrestosParaAscender;
    }

    @Override
    public boolean compararRangos(Rango rango) {
        boolean velocidad = this.getVelocidad() == rango.getVelocidad();
        boolean nombre = this.getNombreRango() == rango.getNombreRango();
        return velocidad && nombre;
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
            return new RangoSargento(this.getCantidadDeArrestos());
        return this;
    }

    @Override
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}

    @Override
    public int getVelocidad(){return this.velocidad;}
}
