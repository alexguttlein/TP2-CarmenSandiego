package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ConPista;
import carmenSandiego.modelo.edificio.comportamiento.pistas.PistaAeropuerto;

public class EdificioAeropuerto extends Edificio {

    public EdificioAeropuerto() {}

/*    public void mostrarNombreDelEdificio() {System.out.println("Aeropuerto");}

 */

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaAeropuerto();
        pista.setPista(ciudadSig.getBandera());
        super.setComportamientoPistas(pista);
    }

}

