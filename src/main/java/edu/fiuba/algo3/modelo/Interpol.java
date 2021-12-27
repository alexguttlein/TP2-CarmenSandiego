package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interpol {
    private Ladrones ladrones;  //listado que contiene a todos los ladrones posibles
    private Ladron posibleLadron; //ladron que corresponde con la descripcion cargada
    private List<Ladron> posiblesLadrones;
    private boolean estadoOrdenDeArresto;
    private Tiempo tiempo;
    private Jugador jugador;
    private Ladron ladron; //ladron de la partida actual

    public Interpol(Ladrones ladrones, Tiempo tiempo, Jugador jugador, Ladron ladron){
        this.ladrones = ladrones;
        this.tiempo = tiempo;
        this.jugador = jugador;
        this.ladron = ladron;
        this.estadoOrdenDeArresto = false;
        setPosibleLadron();
    }

    private void setLadrones(Ladrones ladrones){
        this.ladrones = ladrones;
    }
    private void setLadron(Ladron ladron){
        this.ladron = ladron;
    }
    private void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    private void setTiempo(Tiempo tiempo) {this.tiempo = tiempo;}
    private void setEstadoOrdenDeArresto(boolean estado) {
        this.estadoOrdenDeArresto = estado;
    }
    private void setPosiblesLadrones(List<Ladron> posiblesLadrones){this.posiblesLadrones = posiblesLadrones;}
    private void setPosibleLadron() {
        ArrayList<String> datosLadron = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));
        this.posibleLadron = new Ladron(datosLadron);
    }

    public void setDatoGenero(Caracteristica dato){
        posibleLadron.setGenero(dato);
    }
    public void setDatoHobby(Caracteristica dato){
        posibleLadron.setHobby(dato);
    }
    public void setDatoCabello(Caracteristica dato){
        posibleLadron.setCabello(dato);
    }
    public void setDatoSenia(Caracteristica dato){
        posibleLadron.setSenia(dato);
    }
    public void setDatoVehiculo(Caracteristica dato){
        posibleLadron.setVehiculo(dato);
    }
    public Tiempo getTiempo(){return this.tiempo;}
    public Ladron getLadron(){return this.ladron;}
    public Ladron getPosibleLadron(){
        return this.posibleLadron;
    }
    public List<Ladron> getPosiblesLadrones(){return this.posiblesLadrones;}

    public List<Ladron> buscarPosiblesLadrones() {
        List<Ladron> ladrones = this.ladrones.getLadrones();
        List<Ladron> posiblesLadrones = new ArrayList<Ladron>();

        for(Ladron l: ladrones)
            if (compararLadrones(this.getPosibleLadron(), l))
                posiblesLadrones.add(l);

        this.setPosiblesLadrones(posiblesLadrones);
        return posiblesLadrones;
    }

    public boolean compararLadrones(Ladron ladronA, Ladron ladronB){
        boolean datoGenero = compararDatoLadron(ladronA.getGenero(), ladronB.getGenero());
        boolean datoHobby = compararDatoLadron(ladronA.getHobby(), ladronB.getHobby());
        boolean datoCabello = compararDatoLadron(ladronA.getCabello(), ladronB.getCabello());
        boolean datoSenia = compararDatoLadron(ladronA.getSenia(), ladronB.getSenia());
        boolean datoVehiculo = compararDatoLadron(ladronA.getVehiculo(), ladronB.getVehiculo());

        return datoGenero && datoHobby && datoCabello && datoSenia && datoVehiculo;
    }

    private boolean compararDatoLadron(Caracteristica datoA, Caracteristica datoB){
        if(datoA.getCaracteristica() != "")
            return datoA.compararCaracteristica(datoB);
        return true;
    }

    public void emitirOrdenDeArresto(){
        buscarPosiblesLadrones();

        if (getPosiblesLadrones().size() == 1) {
            setEstadoOrdenDeArresto(true);
            this.posibleLadron = getPosiblesLadrones().get(0);
            getTiempo().addHoras(3);
        }
    }

    public boolean atraparSospechoso(){
        boolean comparacionLadrones = this.ladron.compararConLadron(this.posibleLadron);
        if(comparacionLadrones && this.estadoOrdenDeArresto) //se debe tener orden de arresto emitida sobre el ladron correcto
            jugador.addArresto();
        return this.estadoOrdenDeArresto && comparacionLadrones;
    }
}
