package carmenSandiego.modelo;

public interface ComportamientoVisita {

    void entrarAlEdificio(int vecesVisitado, ComportamientoDeDemora comportamientoDemora);
    int getTotalVisitas();
}
