package carmenSandiego.modelo;

public abstract class Edificio{

    ComportamientoPistas comportamientoPistas;
    ComportamientoDeDemora comportamientoDeDemora;
    ComportamientoVisita comportamientoVisita;
    protected String noHayPista;

    public Edificio(){
        comportamientoDeDemora = new Demora();
        comportamientoVisita = new Acceder();
    }
    public abstract void mostrarNombreDelEdificio();
    public abstract String getPista(Ciudad ciudadSig);

    public void mostrarPista(String unaPista){
        this.comportamientoPistas.mostrarPistas(unaPista);
    }
    public void setComportamientoPistas(ComportamientoPistas pista){
        this.comportamientoPistas =  pista;
    }
    public void entrarAlEdificio(int veces){
        comportamientoVisita.entrarAlEdificio(veces, comportamientoDeDemora);
    }
    public int getCantidadDeVisitas() {
        return comportamientoVisita.getTotalVisitas();
    }
    public int getDemora(){
        return comportamientoDeDemora.getDemora( comportamientoVisita.getTotalVisitas());
    }
}