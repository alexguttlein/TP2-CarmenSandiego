package carmenSandiego.modelo;

public class EdificioBiblioteca extends Edificio {

    public EdificioBiblioteca(){}

    public void mostrarNombreDelEdificio(){
        System.out.println("Biblioteca");
    }

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBiblioteca();
        pista.setPista(ciudadSig.getIdioma());
        super.setComportamientoPistas(pista);
    }
}