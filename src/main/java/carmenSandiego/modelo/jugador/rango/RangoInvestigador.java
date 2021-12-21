package carmenSandiego.modelo.jugador.rango;

public class RangoInvestigador extends Rango {
    private int arrestosParaAscender;

    public RangoInvestigador(int arrestos){
        this.rangoActual = "Investigador";
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 20;
        this.velocidad = 1300;
    }

    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    public Rango verificarRango(){
        if(this.cantidadDeArrestos == this.arrestosParaAscender)
            return new RangoSargento(this.cantidadDeArrestos);
        return this;
    }
}
