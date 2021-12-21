package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ConPista;
import carmenSandiego.modelo.edificio.comportamiento.pistas.PistaPuerto;

public class EdificioPuerto extends Edificio{

    public EdificioPuerto(){}

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaPuerto();
        pista.setPista(ciudadSig.getIndustria().getCaracteristica());
        super.setComportamientoPistas(pista);
    }

}