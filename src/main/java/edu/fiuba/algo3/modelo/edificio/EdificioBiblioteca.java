package edu.fiuba.algo3.modelo.edificio;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.ConPista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaBiblioteca;

public class EdificioBiblioteca extends Edificio {

    public EdificioBiblioteca(){}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBiblioteca();
        pista.setPista(ciudadSig.getIdioma().getCaracteristica());
        super.setComportamientoPistas(pista);
    }
}