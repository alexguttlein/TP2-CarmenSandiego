package carmenSandiego.modelo;

public abstract class Edificio {
    private String pistaCorrecta; // Bandera {rojo blanco y azul}
    private String pistaIncorrecta; // No lo vimos x aca
    private boolean pasoLadron;
    private int vecesVisitados;
    private int demora;

    public Edificio(String unaPistaCorrecta, String unaPistaIncorrecta, boolean pasoLadron){
        this.vecesVisitados = 0;
        this.pasoLadron = pasoLadron;
        this.pistaCorrecta = unaPistaCorrecta;
        this.pistaIncorrecta = unaPistaIncorrecta;
    }

    public String getPista(Ciudad ciudadSig){
        if (pasoLadron)
            return this.getPistaCorrecta();
        else
            return this.getPistaIncorrecta();
    }
/*
    protected void mostrarPista(Ciudad ciudadSig, String unaPista){
        System.out.println(unaPista);
    }
*/
    protected void calcularDemora(){
        switch (vecesVisitados){
            case 1:
                this.demora = 1;
                break;
            case 2:
                this.demora = 2;
                break;
            default:
                this.demora = 3;
                break;
        }
    }

    public int getDemora(){
        return this.demora;
    }

    public void addVecesVisitados(){
        this.vecesVisitados += 1;
    }

    public int getVecesVisitado() {
        return this.vecesVisitados;
    }

    public String getPistaCorrecta() {
        return this.pistaCorrecta;
    }

    public String getPistaIncorrecta() {
        return this.pistaIncorrecta;
    }

    protected void setPasoLadron(boolean pasoLadron){
        this.pasoLadron = pasoLadron;
    };

    protected void setPistaCorrecta(String unaPistaCorrecta){
        this.pistaCorrecta = unaPistaCorrecta;
    };

    protected void setPistaIncorrecta(String unaPistaIncorrecta) {
        this.pistaIncorrecta = unaPistaIncorrecta;
    }

    public void visitar(){
        this.addVecesVisitados();
        this.calcularDemora();
    }
}