package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.comportamiento.Demora;
import carmenSandiego.modelo.pistas.SinPista;
import carmenSandiego.modelo.comportamiento.Visita;
import carmenSandiego.modelo.comportamiento.ComportamientoDeDemora;
import carmenSandiego.modelo.comportamiento.ComportamientoPistas;
import carmenSandiego.modelo.comportamiento.ComportamientoVisita;

public abstract class Edificio{
    protected ComportamientoPistas comportamientoPistas;
    protected ComportamientoDeDemora comportamientoDeDemora;
    protected ComportamientoVisita comportamientoVisita;

    protected Edificio(){
        comportamientoDeDemora = new Demora();
        comportamientoVisita = new Visita();
    }

    public String getPista() {
        return comportamientoPistas.getPista();
    }

    /*public void mostrarPista(){
        this.comportamientoPistas.mostrarPistas();
    }

     */

    public int entrarAlEdificio(){
        comportamientoVisita.entrarAlEdificio();
        return this.getDemora();
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