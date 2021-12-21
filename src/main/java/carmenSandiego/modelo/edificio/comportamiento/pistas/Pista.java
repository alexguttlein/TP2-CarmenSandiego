package carmenSandiego.modelo.pistas;

import carmenSandiego.modelo.Caracteristica;

public interface Pista {

    void setDialogo(Caracteristica dialogo);
    void setDescripcion(Caracteristica descripcion);
    Caracteristica getDialogo();
    Caracteristica getDescripcion();
    boolean compararPista(Pista pista);

}
