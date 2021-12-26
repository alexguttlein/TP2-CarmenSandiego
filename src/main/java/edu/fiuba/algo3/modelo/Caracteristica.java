package edu.fiuba.algo3.modelo;

public class Caracteristica {
    String caracteristica;

    public Caracteristica(String caracteristica){
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica(){return this.caracteristica;}

    public boolean compararCaracteristica(Caracteristica otraCaracteristica){
        return otraCaracteristica.serComparada(caracteristica);
    }

    private boolean serComparada(String otraCaracteristica){
        return caracteristica.equals(otraCaracteristica);
    }
}
