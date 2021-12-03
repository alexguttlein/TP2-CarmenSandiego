package carmenSandiego.modelo;

public class EdificioPuerto extends Edificio{

    public EdificioPuerto(){
        comportamientoPistas = new ConPista();
        noHayPista = "Disculpa no lo vimos por aca";
    }
    public void mostrarNombreDelEdificio(){
        System.out.println("Puerto");
    }
    public String getPista(Ciudad ciudadSig){

        if(comportamientoPistas.tienePista()){
            return comportamientoPistas.getPista(ciudadSig.getBandera());
        }
        return comportamientoPistas.getPista(this.noHayPista);
    }

}

/*
    private String pistaIncorrecta;
    private String pista;
    private boolean pasoLadron;
    private int vecesVisitado;
    private int demora;
    private String nombre;

    public EdificioPuerto(String nombre, String pistaIncorrecta, boolean pasoLadron){
        comportamientoPistas = new ConPista();
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
        this.pista = ciudadSiguiente.getBandera();
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
    }*/