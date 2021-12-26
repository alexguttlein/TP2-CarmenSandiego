package edu.fiuba.algo3.modelo.edificio.comportamiento.pistas;

public abstract class ConPista implements ComportamientoPistas {
    protected String base;
    protected String pista;

    public String getPista() {
        return (base + " " + pista);
    }

    public void setPista(String unaPista) {
        this.pista = unaPista;
    }
}
