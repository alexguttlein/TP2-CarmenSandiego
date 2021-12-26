package edu.fiuba.algo3.modelo.jugador.rango;

public class RangoNovato extends Rango {
    private int arrestosParaAscender;

    public RangoNovato(int arrestos){
        this.rangoActual = "Novato";
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 5;
        this.velocidad = 900;
    }

    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    public Rango verificarRango(){
        if(this.cantidadDeArrestos == this.arrestosParaAscender)
            return new RangoDetective(this.cantidadDeArrestos);
        return this;
    }
}
