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

    public Partida(Jugador jugador, ObjetoRobado objetoRobado, Ladron ladron, Interpol interpol, Tiempo tiempo) {
        this.setTiempo(tiempo);
        this.setJugador(jugador);
        this.setObjetoRobado(objetoRobado);
        this.setLadronActual(ladron);
        this.setInterpol(interpol);
        this.generarCiudades();
    }

    private void setTiempo(Tiempo tiempo){this.tiempo = tiempo;}
    private void setJugador(Jugador jugador){this.jugador = jugador;}
    private void setObjetoRobado(ObjetoRobado objetoRobado){this.objetoRobado = objetoRobado;}
    private void setLadronActual(Ladron ladron){this.ladronActual = ladron;}
    private void setInterpol(Interpol interpol){this.interpol = interpol;}

    private void generarCiudades(){
        this.ciudades = new Ciudades();
    }

    public Ciudades getCiudades(){return this.ciudades;}
}

