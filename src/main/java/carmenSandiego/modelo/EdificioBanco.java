package carmenSandiego.modelo;

public class EdificioBanco implements Edificio {

    private String pistaIncorrecta;
    private String pista;
    private boolean pasoLadron;
    private int vecesVisitado;
    private int demora;
    private String nombre;

    public EdificioBanco(String nombre, String pistaIncorrecta, boolean pasoLadron){
        this.vecesVisitado = 0;
        this.pasoLadron = pasoLadron;
        this.nombre = nombre;
        this.pistaIncorrecta = pistaIncorrecta;
    }

    public String getPista(Ciudad ciudadSig){
        if (this.pasoLadron) {
            setPista(ciudadSig);
        }
        else
            this.pista = this.pistaIncorrecta;
        return this.pista;
    }

    @Override
    public void mostrarPista(Ciudad ciudadSig, String unaPista) {

    }

    @Override
    public int getDemora() {
        return this.demora;
    }

    @Override
    public int getVecesVisitado() {
        return this.vecesVisitado;
    }

    @Override
    public boolean getPasoLadron() {
        return this.pasoLadron;
    }

    @Override
    public int visitar() {
        this.vecesVisitado += 1;
        this.calcularDemora();
        return this.demora;
    }

    private void setPista(Ciudad ciudadSiguiente){
        this.pista = ciudadSiguiente.getMoneda();
    }

    public void calcularDemora(){
        switch (this.vecesVisitado){
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

    @Override
    public String getNombre(){
        return this.nombre;
    }
}
