package carmenSandiego.modelo;

public class EdificioBanco extends Edificio {

    public EdificioBanco(){}

    public void mostrarNombreDelEdificio(){
        System.out.println("Banco");
    }

    public void setPistas(Ciudad ciudadSig) {
        ConPista pista = new PistaBanco();
        pista.setPista(ciudadSig.getMoneda());
        super.setComportamientoPistas(pista);
    }
}
