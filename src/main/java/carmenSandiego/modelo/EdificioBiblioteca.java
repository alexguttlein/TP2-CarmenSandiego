package carmenSandiego.modelo;

public class EdificioBiblioteca extends Edificio {

    public EdificioBiblioteca(){
        comportamientoPistas = new ConPista();
        noHayPista = "Disculpa no lo vimos por aca";
    }

    public void mostrarNombreDelEdificio(){
        System.out.println("Biblioteca");
    }

    public String getPista(Ciudad ciudadSig){

        if(comportamientoPistas.tienePista()){//violar el tell dont ask ¿?
            return comportamientoPistas.getPista(ciudadSig.getGeografia());
        }
        return comportamientoPistas.getPista(this.noHayPista);
    }
}