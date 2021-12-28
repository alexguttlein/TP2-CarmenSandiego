package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Partida {

    private Jugador jugador;
    private ObjetoRobado objetoRobado;
    private Ladron ladronActual;
    private Interpol interpol;
    private Ciudades ciudades;
    private Tiempo tiempo;
    private Recorrido recorrido;

    public Partida(Jugador jugador, ObjetoRobado objetoRobado, Ladron ladron, Interpol interpol,
                   Tiempo tiempo, Ciudades ciudades) {
        this.tiempo = tiempo;
        this.jugador = jugador;
        this.objetoRobado = objetoRobado;
        this.interpol = interpol;
        this.ladronActual = ladron;
        this.ciudades = ciudades;
        this.recorrido = new Recorrido(this.objetoRobado, this.ciudades);
        this.ladronActual.setRecorrido(this.recorrido);
        //this.modificarPistasPorDondePasoElLadron();
    }

    private void modificarPistasPorDondePasoElLadron() {
        for(Ciudad c: this.recorrido.getRecorridoReal()) {
            if ((c.getPasoLadron()) && (c.getCiudadSiguiente() != null))
                c.modificarPistasPorDondePasoElLadron(this.ladronActual, c.getCiudadSiguiente());
        }
    }

    //private void setTiempo(Tiempo tiempo){this.tiempo = tiempo;}
    //private void setJugador(Jugador jugador){this.jugador = jugador;}
    //private void setObjetoRobado(ObjetoRobado objetoRobado){this.objetoRobado = objetoRobado;}
    //private void setLadronActual(Ladron ladron){this.ladronActual = ladron;}
    //private void setInterpol(Interpol interpol){this.interpol = interpol;}
    //private void setCiudades(Ciudades ciudades){this.ciudades = ciudades;}

    public Tiempo getTiempo(){return this.tiempo;}
    public Jugador getJugador(){return this.jugador;}
    public ObjetoRobado getObjetoRobado(){return this.objetoRobado;}
    public Ladron getLadronActual(){return this.ladronActual;}
    public Interpol getInterpol(){return this.interpol;}
    public Ciudades getCiudades(){return this.ciudades;}
    public Recorrido getRecorrido(){return this.recorrido;}

}

