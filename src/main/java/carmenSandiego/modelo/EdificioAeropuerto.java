package carmenSandiego.modelo;

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

