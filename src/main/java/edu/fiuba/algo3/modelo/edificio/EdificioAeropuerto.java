package edu.fiuba.algo3.modelo.edificio;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.ConPista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaAeropuerto;

public class EdificioAeropuerto extends Edificio {

    public EdificioAeropuerto() {}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaAeropuerto();
        pista.setPista(ciudadSig.getBandera().getCaracteristica());
        super.setComportamientoPistas(pista);
    }

}

