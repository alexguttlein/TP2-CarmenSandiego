package carmenSandiego.modelo;

public class Visita implements ComportamientoVisita{
    private int cantVisita = 0;

    public void entrarAlEdificio() {
        cantVisita += 1;
    }

    public int getTotalVisitas() {
        return cantVisita;
    }
}
