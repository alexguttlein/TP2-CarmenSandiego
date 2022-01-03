package edu.fiuba.algo3.modelo.edificio.comportamiento.pistas;


import edu.fiuba.algo3.modelo.Caracteristica;

public class PistaAeropuerto implements Pista {

    private Caracteristica dialogo;
    private Caracteristica descripcion;

    public PistaAeropuerto(Caracteristica dialogo, Caracteristica descripcion) {
        setDialogo(dialogo);
        setDescripcion(descripcion);
    }

    public PistaAeropuerto(Caracteristica dialogo){
        this.dialogo = dialogo;
        this.descripcion = new Caracteristica(" ");
    }

    @Override
    public void setDialogo(Caracteristica dialogo){
        this.dialogo = dialogo;
    }

    @Override
    public void setDescripcion(Caracteristica descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Caracteristica getDialogo() {
        return this.dialogo;
    }

    @Override
    public Caracteristica getDescripcion() {
        return this.descripcion;
    }

    @Override
    public boolean compararPista(Pista pista) {
        boolean descripcion = this.descripcion.compararCaracteristica(pista.getDescripcion());
        boolean dialogo = this.dialogo.compararCaracteristica(pista.getDialogo());

        return descripcion && dialogo;
    }

    @Override
    public String getPista(){
        return (dialogo.getCaracteristica() + descripcion.getCaracteristica());    //
    }
}