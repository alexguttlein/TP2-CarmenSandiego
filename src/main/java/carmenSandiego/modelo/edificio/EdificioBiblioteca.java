package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ConPista;
import carmenSandiego.modelo.edificio.comportamiento.pistas.PistaBiblioteca;

public class EdificioBiblioteca extends Edificio {

    public EdificioBiblioteca(){}

/*    public void mostrarNombreDelEdificio(){
        System.out.println("Biblioteca");
    }

 */

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBiblioteca();
        pista.setPista(ciudadSig.getIdioma());
        super.setComportamientoPistas(pista);
    }
}