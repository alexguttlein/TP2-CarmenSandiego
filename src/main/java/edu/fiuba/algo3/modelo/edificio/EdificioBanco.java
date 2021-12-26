package edu.fiuba.algo3.modelo.edificio;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.ConPista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaBanco;

public class EdificioBanco extends Edificio {

    public EdificioBanco(){}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBanco();
        pista.setPista(ciudadSig.getMoneda().getCaracteristica());
        super.setComportamientoPistas(pista);
    }
}
