package carmenSandiego.modelo;

import java.util.*;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int vecesHeridoPorCuchillo;
    private EstadoJugador estadoJugador;

    public Jugador(String nombre, Ciudad ciudadInicial){
        this.nombre = nombre;
        this.rango = new Rango();
        this.vecesHeridoPorCuchillo = 0;
        this.estadoJugador = new EstadoSano();
        this.ciudadActual = ciudadInicial;
    }

    public String getNombre(){return this.nombre;}

    public String getRango(){return this.rango.getRango();}

    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}

    public void addArresto(){this.rango.addArresto();}

    //public Ciudad getCiudadActual(){return this.ciudadActual;}

    //public void setCiudadActual(Ciudad ciudadActual){
    //    this.ciudadActual = ciudadActual;
    //}

    public void dormir(){
        estadoJugador = new EstadoDormido();
        estadoJugador.pasarTiempo();
    }

    public void serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(this.vecesHeridoPorCuchillo == 1) {
            estadoJugador = new EstadoHeridoConCuchillo();
        }
        else {
            estadoJugador = new EstadoHeridoConCuchilloMultiplesVeces();
        }
        estadoJugador.pasarTiempo();
    }

    public void serHeridoPorArmaDeFuego(){
        estadoJugador = new EstadoHeridoPorArmaDeFuego();
        estadoJugador.pasarTiempo();
    }

    public void pasarTiempo(){
        estadoJugador.pasarTiempo();
        sanar();
    }

    public void sanar(){
        estadoJugador = new EstadoSano();
    }

    public void viajar(Ciudad ciudadSiguiente){
        ciudadActual.viajarDesde(rango.getVelocidad(), ciudadSiguiente); //habría que cambiarle el nombre
        asignarNuevaCiudadActual(ciudadSiguiente);
    }

    private void asignarNuevaCiudadActual(Ciudad nuevaCiudadActual){
        this.ciudadActual = nuevaCiudadActual;
    }

    public Ciudad getCiudadActual() {
        return this.ciudadActual;
    }
}
