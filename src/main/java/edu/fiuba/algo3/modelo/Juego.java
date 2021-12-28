package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private Ciudades ciudades;
    private Ladrones ladrones;
    private Tiempo tiempo;
    private Jugador jugador;
    private Interpol interpol;
    private ObjetoRobado objetoRobado;
    private Ladron ladronActual;

    public Juego(){
        Ladrones ladrones = new Ladrones("src/main/java/edu/fiuba/algo3/datosDelJuego/ladrones.csv");
        Tiempo tiempo = new Tiempo(7, 4, 0, 2021);
        Jugador jugador = new Jugador("Player 1", tiempo);

        this.jugador = jugador;
        this.tiempo = tiempo;
        this.ladrones = ladrones;
        this.prepararPartida();
    }

    private void prepararPartida(){
        this.ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");
        ObjetosRobados objetosRobados = new ObjetosRobados(this.ciudades);
        this.asignarRangoDeJugadorALasCiudades();
        this.ladronActual = this.seleccionarLadron(); //se selecciona ladron para la partida
        this.interpol = new Interpol(this.ladrones, this.tiempo, this.jugador, ladronActual);
        this.objetoRobado = this.seleccionarObjetoRobadoAleatorio(objetosRobados); //se selecciona objeto para la partida
    }

    private void asignarRangoDeJugadorALasCiudades() {
        for(Ciudad c: this.ciudades.getCiudades())
            c.setRangoPersonaje(jugador.getRango());
    }

    private Ladron seleccionarLadron(){
        Ladron ladron = this.ladrones.seleccionarLadronAleatorio();
        return ladron;
    }

    private ObjetoRobado seleccionarObjetoRobadoAleatorio(ObjetosRobados objetosRobados){
        ObjetoRobado objetoRobado = objetosRobados.seleccionarObjetoRobadoAleatorio(this.jugador);
        return objetoRobado;
    }

    public ObjetoRobado getObjetoRobado(){return this.objetoRobado;}
    public Ladron getLadronActual(){return this.ladronActual;}
    public Interpol getInterpol(){return this.interpol;}
    public Tiempo getTiempo(){return this.tiempo;}
    public Jugador getJugador(){return this.jugador;}
    public Ciudades getCiudades(){return this.ciudades;}

}