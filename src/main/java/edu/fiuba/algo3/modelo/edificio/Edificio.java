package edu.fiuba.algo3.modelo.edificio;


import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.comportamiento.demora.ComportamientoDeDemora;
import edu.fiuba.algo3.modelo.edificio.comportamiento.demora.Demora;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.Pista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.visita.ComportamientoVisita;
import edu.fiuba.algo3.modelo.edificio.comportamiento.visita.Visita;
import edu.fiuba.algo3.modelo.jugador.rango.Rango;

public abstract class Edificio{
    protected ComportamientoDeDemora comportamientoDeDemora;
    protected ComportamientoVisita comportamientoVisita;
    private Caracteristica nombre;
    protected Pista pista;

    protected Edificio(){
        comportamientoDeDemora = new Demora();
        comportamientoVisita = new Visita();
    }

    public Caracteristica getNombre(){return this.nombre;}
    protected void setNombre(Caracteristica nombre) {
        this.nombre = nombre;
    }

    public String getPistaCompleta() {
        return pista.getPista();
    }

    /*
    public void mostrarPista(){
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

    public void setPista(Pista pista){
        this.pista = pista;
    }
    public Pista getPista(){return this.pista;}

    public boolean compararEdificios(Edificio edificio){
        return this.getNombre() == edificio.getNombre();
    }
    public abstract void modificarPista(Ciudad ciudadSiguiente, Ladron ladron, Rango rangoPersonaje);

/*
    public void setComportamientoPistas(ComportamientoPistas pista){
        this.comportamientoPistas =  pista;
    }

    public void setSinPista(){
        ComportamientoPistas sinPista = new SinPista();
        setComportamientoPistas(sinPista);
    }
 */
}