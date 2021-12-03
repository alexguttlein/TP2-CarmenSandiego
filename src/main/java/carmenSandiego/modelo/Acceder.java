package carmenSandiego.modelo;

public class Acceder implements ComportamientoVisita{

    private int cantVisita;

    public void entrarAlEdificio(int vecesVisitado, ComportamientoDeDemora comportamientoDemora) {
        vecesVisitado += 1;
        comportamientoDemora.getDemora(vecesVisitado);
        cantVisita= vecesVisitado;
    }
    public int getTotalVisitas() {
        return cantVisita;
    }
}
