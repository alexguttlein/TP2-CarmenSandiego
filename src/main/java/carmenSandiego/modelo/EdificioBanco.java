package carmenSandiego.modelo;

public class EdificioBanco extends Edificio {

    public EdificioBanco(){}

    public void mostrarNombreDelEdificio(){
        System.out.println("Banco");
    }

    public void setPistas(Ciudad ciudadSig) {
        ComportamientoPistas pista = new PistaBanco();
        //ciudadSig.
        super.setComportamientoPistas(pista);
    }
}
