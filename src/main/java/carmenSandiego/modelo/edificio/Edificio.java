package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.edificio.comportamiento.demora.Demora;
import carmenSandiego.modelo.edificio.comportamiento.pistas.SinPista;
import carmenSandiego.modelo.edificio.comportamiento.visita.Visita;
import carmenSandiego.modelo.edificio.comportamiento.demora.ComportamientoDeDemora;
import carmenSandiego.modelo.edificio.comportamiento.pistas.ComportamientoPistas;
import carmenSandiego.modelo.edificio.comportamiento.visita.ComportamientoVisita;

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
    public int entrarAlEdificio(){
        comportamientoVisita.entrarAlEdificio();
        return this.getDemora();
    }
}