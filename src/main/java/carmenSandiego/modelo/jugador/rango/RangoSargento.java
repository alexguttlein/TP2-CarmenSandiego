package carmenSandiego.modelo.jugador.rango;

public class RangoSargento implements Rango {

    private String rangoActual;
    private int cantidadDeArrestos;
    private int velocidad;

    public RangoSargento(int arrestos){
        this.cantidadDeArrestos = arrestos;
        this.rangoActual = "Sargento";
        this.setVelocidad(1500);
    }

    @Override
    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}

    @Override
    public void setArrestosParaAscender(int arrestosParaAscender){}

    @Override
    public boolean compararRangos(Rango rango) {
        boolean velocidad = this.getVelocidad() == rango.getVelocidad();
        boolean nombre = this.getNombreRango() == rango.getNombreRango();
        return velocidad && nombre;
    }

    @Override
    public int getArrestosParaAscender(){return 0;}

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
        return this;
    }

    @Override
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}

    @Override
    public int getVelocidad(){return this.velocidad;}
}