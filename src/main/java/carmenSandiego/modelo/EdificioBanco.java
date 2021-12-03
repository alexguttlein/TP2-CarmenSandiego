package carmenSandiego.modelo;

public class EdificioBanco extends Edificio {

    public EdificioBanco(){
        comportamientoPistas = new ConPista();
        noHayPista = "Disculpa no lo vimos por aca";
    }

    public void mostrarNombreDelEdificio(){
        System.out.println("Banco");
    }

    public String getPista(Ciudad ciudadSig){

        if(comportamientoPistas.tienePista()){//violar el tell dont ask ¿?
            return comportamientoPistas.getPista(ciudadSig.getMoneda());
        }
        return comportamientoPistas.getPista(this.noHayPista);
    }

}
