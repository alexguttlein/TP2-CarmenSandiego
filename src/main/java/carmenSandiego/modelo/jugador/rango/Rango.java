package carmenSandiego.modelo.jugador.rango;

public abstract class Rango {
    protected String rangoActual;
    protected int cantidadDeArrestos;
    protected int velocidad;

    public int getCantidadDeArrestos(){return this.cantidadDeArrestos;}
    public String getNombreRango(){return this.rangoActual;}
    public int getVelocidad(){return this.velocidad;}

    public abstract int getArrestosParaAscender();
    public abstract Rango verificarRango();

    public boolean compararRangos(Rango rango) {
        boolean velocidad = this.getVelocidad() == rango.getVelocidad();
        boolean nombre = this.getNombreRango() == rango.getNombreRango();
        return velocidad && nombre;
    }

    public void addArresto(){
        this.cantidadDeArrestos += 1;
    }
}
