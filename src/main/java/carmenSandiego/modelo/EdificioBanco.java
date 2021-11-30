package carmenSandiego.modelo;

public class EdificioBanco extends Edificio {
    private int vecesVisitados;

    //Constructor
    public EdificioBanco(String unaPistaCorrecta, String unaPistaIncorrecta, boolean pasoLadron){
        super(unaPistaCorrecta, unaPistaIncorrecta, pasoLadron);
    }
/*
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
 */
}
