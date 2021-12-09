package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interpol {
    private Ladrones ladrones;
    private Ladron ladronBuscado;
    private List<Ladron> posiblesLadrones;
    private Ladron ordenDeArresto;

    public Interpol(Ladrones ladrones){
        setLadrones(ladrones);
        setLadronBuscado();
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


    public List<Ladron> buscarLadron() {
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

    public Ladron emitirOrdenDeArresto(){
        if (getPosiblesLadrones().size() == 1)
            return getPosiblesLadrones().get(0);
        return null;
    }

    public List<Ladron> getPosiblesLadrones(){return this.posiblesLadrones;}

    private void setPosiblesLadrones(List<Ladron> posiblesLadrones){this.posiblesLadrones = posiblesLadrones;}
}
