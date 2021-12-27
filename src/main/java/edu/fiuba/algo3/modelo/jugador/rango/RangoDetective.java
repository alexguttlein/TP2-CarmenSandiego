package edu.fiuba.algo3.modelo.jugador.rango;

public class RangoDetective extends Rango {
    private int arrestosParaAscender;

    public RangoDetective(int arrestos){
        this.rangoActual = "Detective";
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 10;
        this.velocidad = 1100;
    }

    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    public Rango verificarRango(){
        if(this.cantidadDeArrestos == this.arrestosParaAscender)
            return new RangoInvestigador(this.cantidadDeArrestos);
        return this;
    }
}
