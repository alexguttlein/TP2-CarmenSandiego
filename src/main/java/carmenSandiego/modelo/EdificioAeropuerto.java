package carmenSandiego.modelo;

public class EdificioAeropuerto extends Edificio {

    public EdificioAeropuerto() {
        comportamientoPistas = new ConPista();
        noHayPista = "Disculpa no lo vimos por aca";
    }

    public void mostrarNombreDelEdificio() {
        System.out.println("Aeropuerto");
    }

    public String getPista(Ciudad ciudadSig) {

        if (comportamientoPistas.tienePista()) {//violar el tell dont ask ¿?
            return comportamientoPistas.getPista(ciudadSig.getBandera());
        }
        return comportamientoPistas.getPista(this.noHayPista);
    }

}

