package carmenSandiego.modelo.jugador.rango;

public class RangoDetective implements Rango {

    private String nombreRangoActual;
    private int cantidadDeArrestos;
    private int arrestosParaAscender;
    private int velocidad;

    public RangoDetective(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.setArrestosParaAscender(10);
        this.nombreRangoActual = "Detective";
        this.setVelocidad(1100);
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
    public String getNombreRango(){return this.nombreRangoActual;}

    @Override
    public double getTiempoDeViaje(double distancia){
        return distancia/this.getVelocidad();
    }

    @Override
    public Rango verificarRango(){
        if(this.cantidadDeArrestos == this.arrestosParaAscender)
            return new RangoInvestigador(this.cantidadDeArrestos);
        return this;
    }

    @Override
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}

    @Override
    public int getVelocidad(){return this.velocidad;}
}
