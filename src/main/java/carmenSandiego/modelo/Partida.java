package carmenSandiego.modelo;

import java.util.ArrayList;
import carmenSandiego.modelo.Ciudad;

public class Partida {

    private Jugador jugador;
    private ObjetoRobado objetoRobado;
    private Ladron ladronActual;
    private Interpol interpol;
    private Ciudades ciudades;
    private Tiempo tiempo;

    public Partida(Jugador jugador, ObjetoRobado objetoRobado, Ladron ladron, Interpol interpol,
                   Tiempo tiempo, Ciudades ciudades) {
        this.tiempo = tiempo;
        this.jugador = jugador;
        this.objetoRobado = objetoRobado;
        this.ladronActual = ladron;
        this.interpol = interpol;
        this.ciudades = ciudades;
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

}

