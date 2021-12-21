package carmenSandiego.modelo.pistas;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.Ladron;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.jugador.rango.Rango;
import carmenSandiego.modelo.pistas.Pista;

public class PistaBiblioteca implements Pista {

    private Caracteristica dialogo;
    private Caracteristica descripcion;

    public PistaBiblioteca(Caracteristica dialogo, Caracteristica descripcion) {
        setDialogo(dialogo);
        setDescripcion(descripcion);
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

}

