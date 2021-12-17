package carmenSandiego.modelo.pistas;

import carmenSandiego.modelo.comportamiento.ComportamientoPistas;

public abstract class ConPista implements ComportamientoPistas {
    protected String base;
    protected String pista;

    public void mostrarPistas(){
        System.out.println(base + " " + pista);
    };

    public String getPista() {
        return (base + " " + pista);
    }

    public void setPista(String unaPista) {
        this.pista = unaPista;
    }
}
