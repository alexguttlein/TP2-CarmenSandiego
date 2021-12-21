package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ConPista;
import carmenSandiego.modelo.edificio.comportamiento.pistas.PistaAeropuerto;

public class EdificioAeropuerto extends Edificio {

    public EdificioAeropuerto() {}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaAeropuerto();
        pista.setPista(ciudadSig.getBandera().getCaracteristica());
        super.setComportamientoPistas(pista);
    }

}

