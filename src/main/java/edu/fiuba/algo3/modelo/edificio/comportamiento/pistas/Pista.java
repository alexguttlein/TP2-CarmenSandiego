package edu.fiuba.algo3.modelo.edificio.comportamiento.pistas;

import edu.fiuba.algo3.modelo.Caracteristica;

public interface Pista {

    void setDialogo(Caracteristica dialogo);

    void setDescripcion(Caracteristica descripcion);

    Caracteristica getDialogo();

    Caracteristica getDescripcion();

    boolean compararPista(Pista pista);
}