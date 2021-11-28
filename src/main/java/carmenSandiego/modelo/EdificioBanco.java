package carmenSandiego.modelo;

public class EdificioBanco extends Edificio{
    private String pistaCorrecta;
    private String pistaIncorrecta;
    private boolean pasoLadron;
    private int vecesVisitados;

    //Constructor
    public EdificioBanco(String unaPistaCorrecta, String unaPistaIncorrecta, boolean pasoLadron){
        this.pistaCorrecta = unaPistaCorrecta;
        this.pistaIncorrecta = unaPistaIncorrecta;
        this.pasoLadron = pasoLadron;
        this.vecesVisitados = 0;
    }

    @Override
    public int getPista(Ciudad ciudadSig) {
        return super.getPista(ciudadSig);
    }

    @Override
    protected void mostrarPista(Ciudad ciudadSig, String unaPista) {
        super.mostrarPista(ciudadSig, unaPista);
    }

    @Override
    public void addVecesVisitados() {
        super.addVecesVisitados();
    }

    @Override
    protected int calcularDemora() {
        return super.calcularDemora();
    }
}
