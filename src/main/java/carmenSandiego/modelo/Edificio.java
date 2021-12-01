package carmenSandiego.modelo;

public interface Edificio {

    String getPista(Ciudad ciudadSig);
    void mostrarPista(Ciudad ciudadSig, String unaPista);
    int getDemora();
    int getVecesVisitado();
    boolean getPasoLadron();
    int visitar();
    String getNombre();
}