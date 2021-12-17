package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.pistas.ConPista;
import carmenSandiego.modelo.pistas.PistaPuerto;

public class EdificioPuerto extends Edificio{

    public EdificioPuerto(){}
/*    public void mostrarNombreDelEdificio(){
        System.out.println("Puerto");
    }

 */

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaPuerto();
        pista.setPista(ciudadSig.getIndustria());
        super.setComportamientoPistas(pista);
    }

}