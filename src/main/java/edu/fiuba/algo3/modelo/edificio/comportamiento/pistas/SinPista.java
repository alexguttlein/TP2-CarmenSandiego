package edu.fiuba.algo3.modelo.edificio.comportamiento.pistas;

public class SinPista implements ComportamientoPistas {//ver que no sea una clase anemica
    private String base = "Disculpa no lo vimos por aca";

    public SinPista(){}

    public void mostrarPistas(){
        System.out.println(base);
    }

    public String getPista() {
        return base;
    }

}
