package carmenSandiego.modelo.pistas;

import carmenSandiego.modelo.comportamiento.ComportamientoPistas;

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
