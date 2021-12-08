package carmenSandiego.modelo;

public abstract class Edificio{
    protected ComportamientoPistas comportamientoPistas;
    protected ComportamientoDeDemora comportamientoDeDemora;
    protected ComportamientoVisita comportamientoVisita;
    protected int demora;

    protected Edificio(){
        comportamientoDeDemora = new Demora();
        comportamientoVisita = new Visita();
    }

    public abstract void mostrarNombreDelEdificio();

    public String getPista() {
        entrarAlEdificio();
        mostrarPista();
        return comportamientoPistas.getPista();
    };

    public void mostrarPista(){
        this.comportamientoPistas.mostrarPistas();
    }

    public void entrarAlEdificio(){
        comportamientoVisita.entrarAlEdificio();
        demora = getDemora();
        Reloj reloj = Reloj.getInstance();
        reloj.agregarHoras(demora);
    }

    public int getCantidadDeVisitas() {
        return comportamientoVisita.getTotalVisitas();
    }

    public int getDemora(){
        int visitas = comportamientoVisita.getTotalVisitas();
        return comportamientoDeDemora.calcularDemora(visitas);
    }

    public abstract void setPistas(Ciudad ciudadSig);

    public void setComportamientoPistas(ComportamientoPistas pista){
        this.comportamientoPistas =  pista;
    }

    public void setSinPista(){
        ComportamientoPistas sinPista = new SinPista();
        setComportamientoPistas(sinPista);
    }
}