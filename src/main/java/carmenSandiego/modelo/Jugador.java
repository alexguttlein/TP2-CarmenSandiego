package carmenSandiego.modelo;

import java.util.*;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int horasDeSuenio;
    private int vecesHeridoPorCuchillo;
    //private Horario horario;
    private EstadoJugador estadoJugador;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.rango = new RangoNovato(0);
        this.horasDeSuenio = 8;
        this.vecesHeridoPorCuchillo = 0;
        //this.horario = new Horario();
    }

    public String getNombre(){return this.nombre;}

    public String getRango(){return this.rango.getRango();}

    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}

    public void addArresto(){
        this.rango.addArresto();
        this.rango = rango.verificarRango();
    }

    public Ciudad getCiudadActual(){return this.ciudadActual;}

    public void setCiudadActual(Ciudad ciudadActual){
        this.ciudadActual = ciudadActual;
    }

    public void dormir(){
        estadoJugador = new EstadoDormido();
        //estadoJugador.pasarTiempo();
    }

    public void serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(this.vecesHeridoPorCuchillo == 1) {
            estadoJugador = new EstadoHeridoConCuchillo();
        }
        else {
            estadoJugador = new EstadoHeridoConCuchilloMultiplesVeces();
        }
        //estadoJugador.pasarTiempo();
    }

    //public Horario getHorario(){
    //    return this.horario;
    //}

    public void serHeridoPorArmaDeFuego(){
        estadoJugador = new EstadoHeridoPorArmaDeFuego();
        //estadoJugador.pasarTiempo();
    }

    public void pasarTiempo(){
        estadoJugador.pasarTiempo();
    }

    public int getVecesHeridoPorCuchillo(){
        return this.vecesHeridoPorCuchillo;
    }

}
