package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ConPista;
import carmenSandiego.modelo.edificio.comportamiento.pistas.PistaBanco;

public class EdificioBanco extends Edificio {

    public EdificioBanco(){}

/*    public void mostrarNombreDelEdificio(){
        System.out.println("Banco");
    }

 */

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBanco();
        pista.setPista(ciudadSig.getMoneda());
        super.setComportamientoPistas(pista);
    }
}