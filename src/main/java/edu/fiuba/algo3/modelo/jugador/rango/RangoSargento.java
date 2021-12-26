package edu.fiuba.algo3.modelo.jugador.rango;

public class RangoSargento extends Rango {

    public RangoSargento(int arrestos){
        this.rangoActual = "Sargento";
        this.cantidadDeArrestos = arrestos;
        this.velocidad = 1500;
    }

    public int getArrestosParaAscender(){return 0;}

    public Rango verificarRango(){
        return this;
    }
}