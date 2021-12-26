package edu.fiuba.algo3.modelo.jugador.rango;

public class RangoSargento extends Rango {
    private int arrestosParaAscender;

    public RangoSargento(int arrestos){
        this.rangoActual = "Sargento";
        this.cantidadDeArrestos = arrestos;
        this.arrestosParaAscender = 30;
        this.velocidad = 1500;
    }

    public int getArrestosParaAscender(){return this.arrestosParaAscender;}

    public Rango verificarRango(){
        return this;
    }
}