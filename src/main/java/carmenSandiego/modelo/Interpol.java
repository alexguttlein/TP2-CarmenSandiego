package carmenSandiego.modelo;

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
        setLadrones(ladrones);
        setPosibleLadron();
        setEstadoOrdenDeArresto(false);
        setTiempo(tiempo);
        setJugador(jugador);
        setLadron(ladron);
    }

    private void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    private void setLadron(Ladron ladron){
        this.ladron = ladron;
    }

    private void setTiempo(Tiempo tiempo) {this.tiempo = tiempo;}

    public Tiempo getTiempo(){return this.tiempo;}

    private void setEstadoOrdenDeArresto(boolean estado) {
        this.estadoOrdenDeArresto = estado;
    }

    private void setPosibleLadron() {
        ArrayList<String> datosLadron = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));
        this.posibleLadron = new Ladron(datosLadron);
    }

    private void setLadrones(Ladrones ladrones){
        this.ladrones = ladrones;
    }

    public void setDatoGenero(String dato){
        posibleLadron.setGenero(dato);
    }

    public void setDatoHobby(String dato){
        posibleLadron.setHobby(dato);
    }

    public void setDatoCabello(String dato){
        posibleLadron.setCabello(dato);
    }

    public void setDatoSenia(String dato){
        posibleLadron.setSenia(dato);
    }

    public void setDatoVehiculo(String dato){
        posibleLadron.setVehiculo(dato);
    }

    public Ladron getPosibleLadron(){
        return this.posibleLadron;
    }


    public List<Ladron> buscarPosiblesLadrones() {
        List<Ladron> ladrones = this.ladrones.getLadrones();
        List<Ladron> posiblesLadrones = new ArrayList<Ladron>();

        for(Ladron l: ladrones)
            if (compararLadrones(this.getPosibleLadron(), l))
                posiblesLadrones.add(l);

        this.setPosiblesLadrones(posiblesLadrones);
        return posiblesLadrones;
    }

    private boolean compararCaracteristica(String datoA, String datoB){
        if(datoA != "")
            return datoA.equals(datoB);
        return true;
    }

    public void emitirOrdenDeArresto(){
        buscarPosiblesLadrones();

        if (getPosiblesLadrones().size() == 1) {
            setEstadoOrdenDeArresto(true);
            getTiempo().addHoras(3);
        }
    }

    public List<Ladron> getPosiblesLadrones(){return this.posiblesLadrones;}

    private void setPosiblesLadrones(List<Ladron> posiblesLadrones){this.posiblesLadrones = posiblesLadrones;}

    public boolean atraparSospechoso(){
        boolean comparacionLadrones = compararLadrones(this.ladron, this.posibleLadron);
        if(comparacionLadrones && this.estadoOrdenDeArresto) //se debe tener orden de arresto emitida sobre el ladron correcto
            jugador.addArresto();
        return this.estadoOrdenDeArresto && comparacionLadrones;
    }

    public boolean compararLadrones(Ladron ladronA, Ladron ladronB){
        boolean datoGenero = compararCaracteristica(ladronA.getGenero(), ladronB.getGenero());
        boolean datoHobby = compararCaracteristica(ladronA.getHobby(), ladronB.getHobby());
        boolean datoCabello = compararCaracteristica(ladronA.getCabello(), ladronB.getCabello());
        boolean datoSenia = compararCaracteristica(ladronA.getSenia(), ladronB.getSenia());
        boolean datoVehiculo = compararCaracteristica(ladronA.getVehiculo(), ladronB.getVehiculo());

        return datoGenero && datoHobby && datoCabello && datoSenia && datoVehiculo;
    }

    public Ladron getLadron(){return this.ladron;}
}
