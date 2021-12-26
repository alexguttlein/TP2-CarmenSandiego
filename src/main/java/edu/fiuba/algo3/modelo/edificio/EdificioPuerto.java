package edu.fiuba.algo3.modelo.edificio;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.ConPista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaPuerto;

public class EdificioPuerto extends Edificio{

    public EdificioPuerto(){}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaPuerto();
        pista.setPista(ciudadSig.getIndustria().getCaracteristica());
        super.setComportamientoPistas(pista);
    }

}