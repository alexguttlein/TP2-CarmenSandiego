package carmenSandiego.modelo;

public abstract class Edificio {
    private String pistaCorrecta; // Bandera {rojo blanco y azul}
    private String pistaIncorrecta; // No lo vimos x aca
    private boolean pasoLadron;
    private int vecesVisitados;

    public int getPista(Ciudad ciudadSig){
        int demora;
        this.addVecesVisitados();
        if (pasoLadron == true)
            mostrarPista(ciudadSig, pistaCorrecta);
        else
            mostrarPista(ciudadSig, pistaIncorrecta);
        demora = this.calcularDemora();
        return demora;
    }

    protected void mostrarPista(Ciudad ciudadSig, String unaPista){
        System.out.println(unaPista);
    }

    public void addVecesVisitados() {
        this.vecesVisitados += 1;
    }

    protected int calcularDemora(){
        int demora;
        switch (vecesVisitados){
            case 1:
                demora = 1;
                break;
            case 2:
                demora = 2;
                break;
            default:
                demora = 3;
                break;
        }
        return demora;
    }

    public int getVecesVisitados() {
        return vecesVisitados;
    }

    public String getPistaCorrecta() {
        return pistaCorrecta;
    }

    public String getPistaIncorrecta() {
        return pistaIncorrecta;
    }
}