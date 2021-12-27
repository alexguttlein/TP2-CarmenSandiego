package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.jugador.estado.*;
import edu.fiuba.algo3.modelo.jugador.rango.Rango;
import edu.fiuba.algo3.modelo.jugador.rango.RangoNovato;

public class Jugador {
    private Caracteristica nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int vecesHeridoPorCuchillo;
    private EstadoJugador estadoJugador;
    private Tiempo reloj;
    //private boolean durmioHoy;

    public Jugador(String nombre, Tiempo reloj){
        this.nombre = new Caracteristica(nombre);
        this.rango = new RangoNovato(0);
        this.vecesHeridoPorCuchillo = 0;
        this.estadoJugador = new EstadoSano();
        this.reloj = reloj;
    }

    public Jugador(String nombre, Tiempo reloj, Rango rango){
        this.nombre = new Caracteristica(nombre);
        this.rango = rango;
        this.vecesHeridoPorCuchillo = 0;
        this.estadoJugador = new EstadoSano();
        this.reloj = reloj;
    }

    public Rango getRango(){
        return this.rango;
    }
    public Caracteristica getNombre(){return this.nombre;}
    public String getNombreRango(){return this.rango.getNombreRango();}
    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}
    public Ciudad getCiudadActual(){return this.ciudadActual;}
    private Tiempo getReloj(){
        return this.reloj;
    }
    public int getVecesHeridoPorCuchillo(){return this.vecesHeridoPorCuchillo;}

    public void setCiudadActual(Ciudad ciudadActual){this.ciudadActual = ciudadActual;}

    public void addArresto(){
        this.rango.addArresto();
        this.rango = rango.verificarRango();
    }

    public void dormir(){
        this.estadoJugador = new EstadoDormido();
        estadoJugador.pasarTiempo(this.getReloj());
        this.sanar();
    }

    public void serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(getVecesHeridoPorCuchillo() == 1) {
            this.estadoJugador = new EstadoHeridoConCuchillo();
        }
        else {
            this.estadoJugador = new EstadoHeridoConCuchilloMultiplesVeces();
        }
        estadoJugador.pasarTiempo(this.reloj);
        this.sanar();
    }

    public void serHeridoPorArmaDeFuego(){
        this.estadoJugador = new EstadoHeridoPorArmaDeFuego();
        estadoJugador.pasarTiempo(this.reloj);
        this.sanar();
    }

    public void sanar(){
        this.estadoJugador = new EstadoSano();
    }

    public void viajar(Ciudad ciudadSiguiente){
        int horasViaje = this.ciudadActual.viajarHasta(rango.getVelocidad(), ciudadSiguiente);
        this.getReloj().addHoras(horasViaje);
        this.setCiudadActual(ciudadSiguiente);
    }

    public void visitarEdificio(Edificio edificio) {
        reloj.addHoras(this.getCiudadActual().visitarEdificio(edificio));
    }
    
}
