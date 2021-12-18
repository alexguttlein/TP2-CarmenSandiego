package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interpol {
    private Ladrones ladrones;  //listado que contiene a todos los ladrones posibles
    private Ladron caracteristicasLadron; //ladron que corresponde con la descripcion cargada
    private List<Ladron> posiblesLadrones;
    private boolean estadoOrdenDeArresto;
    private Tiempo tiempo;
    private Jugador jugador;
    private Ladron ladron; //ladron de la partida actual
    private Ladron sospechosoArrestado;

    public Interpol(Ladrones ladrones, Tiempo tiempo, Jugador jugador, Ladron ladron){
        this.ladrones = ladrones;
        this.caracteristicasLadron = new Ladron(new ArrayList<>(Arrays.asList("", "", "", "", "", "")));
        this.posiblesLadrones = ladrones.getLadrones();
        this.estadoOrdenDeArresto = false;
        this.tiempo = tiempo;
        this.jugador = jugador;
        this.ladron = ladron;
        this.sospechosoArrestado = new Ladron(new ArrayList<>(Arrays.asList("", "", "", "", "", "")));
    }

    public Tiempo getTiempo(){return this.tiempo;}

    private void setPosiblesLadrones(List<Ladron> posiblesLadrones){this.posiblesLadrones = posiblesLadrones;}

    public void setDatoGenero(String dato){caracteristicasLadron.setGenero(dato);}

    public void setDatoHobby(String dato){
        caracteristicasLadron.setHobby(dato);
    }

    public void setDatoCabello(String dato){
        caracteristicasLadron.setCabello(dato);
    }

    public void setDatoSenia(String dato){
        caracteristicasLadron.setSenia(dato);
    }

    public void setDatoVehiculo(String dato){
        caracteristicasLadron.setVehiculo(dato);
    }

    public void setSospechosoArrestado(Ladron posibleLadron){this.sospechosoArrestado = posibleLadron;}


    public Ladron getSospechosoArrestado(){return this.sospechosoArrestado;}

    public List<Ladron> getPosiblesLadrones(){return this.posiblesLadrones;}

    public Ladron getLadron(){return this.ladron;}

    //sirve para comparar el sospechoso con el ladron verdadero
    public boolean compararLadrones(){
        return this.ladron.comparar(sospechosoArrestado);
    }  //Es true si todas las caracteristicas son iguales (todas las características están completas)


   //sirve para filtrar la lista de sospechosos
    public boolean compararLadrones(Ladron ladronReal){
        return this.caracteristicasLadron.compararSospechoso(ladronReal);
    } //Es true si las características actuales coinciden

    public void mostrarLadrones(){
        ladrones.mostrar();
    }

    public void mostrarPosiblesLadrones() {
        for (Ladron ladronActual : posiblesLadrones){
            ladronActual.mostrar();
        }
    }

    public void elegirLadron(int posicion){
        sospechosoArrestado = posiblesLadrones.get(posicion);
    }

    public void filtrarPosiblesLadrones(){
        List<Ladron> posiblesLadronesAuxiliar = new ArrayList<Ladron>();
        for (Ladron ladronActual : posiblesLadrones){
            if (caracteristicasLadron.compararSospechoso(ladronActual))
                posiblesLadronesAuxiliar.add(ladronActual);
        }
        this.posiblesLadrones = posiblesLadronesAuxiliar;
    }

    public List<Ladron> getLadrones() {
        return ladrones.getLadrones();
    }


    /*
    public void emitirOrdenDeArresto(){
        buscarPosiblesLadrones();

        if (getPosiblesLadrones().size() == 1) {
            this.estadoOrdenDeArresto = true;
            tiempo.addHoras(3);
        }
    }

    public List<Ladron> buscarPosiblesLadrones() {
        List<Ladron> ladrones = this.ladrones.getLadrones();
        List<Ladron> posiblesLadrones = new ArrayList<Ladron>();

        for(Ladron ladronActual: ladrones)
            if (compararLadrones(this.getPosibleLadron(), ladronActual))
                posiblesLadrones.add(ladronActual);

        this.setPosiblesLadrones(posiblesLadrones);
        return posiblesLadrones;
    }

    public boolean atraparSospechoso(){
        boolean comparacionLadrones = compararLadrones(ladron, posibleLadron);
        if(comparacionLadrones && this.estadoOrdenDeArresto) //se debe tener orden de arresto emitida sobre el ladron correcto
            jugador.addArresto();
        return this.estadoOrdenDeArresto && comparacionLadrones;
    }

     */

    /*
    private void setPosibleLadron() {
        ArrayList<String> datosLadron = new ArrayList<>(Arrays.asList("", "", "", "", "", ""));
        this.posibleLadron = new Ladron(datosLadron);

    }
    private boolean compararCaracteristica(String datoA, String datoB){
        if(datoA != "")
            return datoA.equals(datoB);
        return true;
    }

     */
}
