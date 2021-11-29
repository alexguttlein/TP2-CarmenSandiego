package carmenSandiego.modelo;

public class EdificioAeropuerto extends Edificio {
    private int vecesVisitados;

    public EdificioAeropuerto(String unaPistaCorrecta, String unaPistaIncorrecta, boolean pasoLadron){
        this.vecesVisitados = 0;
        super.setPasoLadron(pasoLadron);
        super.setPistaCorrecta(unaPistaCorrecta);
        super.setPistaIncorrecta(unaPistaIncorrecta);
    }

    @Override
    public String getPista(Ciudad ciudadSig) {
        return super.getPista(ciudadSig);
    }

    @Override
    public int getVecesVisitado(){
        return super.getVecesVisitado();
    }

    @Override
    public int getDemora(){
        return super.getDemora();
    }

    @Override
    public void visitar(){
        super.visitar();
    }
}
