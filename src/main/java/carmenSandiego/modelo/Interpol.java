package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interpol {
    private Ladrones ladrones;
    private Ladron ladronBuscado;
    private List<Ladron> posiblesLadrones;
    private Ladron ladronParaArrestar;
    private boolean estadoOrdenDeArresto;
    private Tiempo tiempo;

    public Interpol(Ladrones ladrones, Tiempo tiempo){
        setLadrones(ladrones);
        setLadronBuscado();
        setEstadoOrdenDeArresto(false);
        setTiempo(tiempo);
    }

    private void setTiempo(Tiempo tiempo) {this.tiempo = tiempo;}

    public Tiempo getTiempo(){return this.tiempo;}

    private void setEstadoOrdenDeArresto(boolean estado) {
        this.estadoOrdenDeArresto = estado;
    }

    private void setLadronBuscado() {
        ArrayList<String> datosLadron = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));
        this.ladronBuscado = new Ladron(datosLadron);
    }

    private void setLadrones(Ladrones ladrones){
        this.ladrones = ladrones;
    }

    public void setDatoGenero(String dato){
        ladronBuscado.setGenero(dato);
    }

    public void setDatoHobby(String dato){
        ladronBuscado.setHobby(dato);
    }

    public void setDatoCabello(String dato){
        ladronBuscado.setCabello(dato);
    }

    public void setDatoSenia(String dato){
        ladronBuscado.setSenia(dato);
    }

    public void setDatoVehiculo(String dato){
        ladronBuscado.setVehiculo(dato);
    }

    public Ladron getLadronBuscado(){
        return this.ladronBuscado;
    }


    public List<Ladron> buscarPosiblesLadrones() {
        List<Ladron> ladrones = this.ladrones.getLadrones();
        List<Ladron> posiblesLadrones = new ArrayList<Ladron>();

        for(Ladron l: ladrones)
            if (compararConLadronBuscado(l))
                posiblesLadrones.add(l);

        this.setPosiblesLadrones(posiblesLadrones);
        return posiblesLadrones;
    }

    private boolean compararConLadronBuscado(Ladron ladron){
        boolean datoGenero = compararCaracteristica(this.getLadronBuscado().getGenero(), ladron.getGenero());
        boolean datoHobby = compararCaracteristica(this.getLadronBuscado().getHobby(), ladron.getHobby());
        boolean datoCabello = compararCaracteristica(this.getLadronBuscado().getCabello(), ladron.getCabello());
        boolean datoSenia = compararCaracteristica(this.getLadronBuscado().getSenia(), ladron.getSenia());
        boolean datoVehiculo = compararCaracteristica(this.getLadronBuscado().getVehiculo(), ladron.getVehiculo());

        return datoGenero && datoHobby && datoCabello && datoSenia && datoVehiculo;
    }

    private boolean compararCaracteristica(String datoA, String datoB){
        if(datoA != "")
            return datoA.equals(datoB);
        return true;
    }

    public void emitirOrdenDeArresto(){
        buscarPosiblesLadrones();

        if (getPosiblesLadrones().size() == 1) {
            setLadronParaArrestar(getPosiblesLadrones().get(0));
            setEstadoOrdenDeArresto(true);
            getTiempo().addHoras(3);
        }
    }

    public List<Ladron> getPosiblesLadrones(){return this.posiblesLadrones;}

    private void setPosiblesLadrones(List<Ladron> posiblesLadrones){this.posiblesLadrones = posiblesLadrones;}

    private void setLadronParaArrestar(Ladron ordenDeArresto){this.ladronParaArrestar = ordenDeArresto;}

    public Ladron getLadronParaArrestar(){return this.ladronParaArrestar;}

    public boolean atraparSospechoso(){
        return this.estadoOrdenDeArresto;
    }
}
