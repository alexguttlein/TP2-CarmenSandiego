package carmenSandiego.modelo;

import java.util.*;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int horasDeSuenio;
    private int vecesHeridoPorCuchillo;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.rango = new Rango();
        this.horasDeSuenio = 8;
        this.vecesHeridoPorCuchillo = 0;
    }

    public String getNombre(){return this.nombre;}

    public String getRango(){return this.rango.getRango();}

    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}

    public void addArresto(){this.rango.addArresto();}

    public Ciudad getCiudadActual(){return this.ciudadActual;}

    public void setCiudadActual(Ciudad ciudadActual){
        this.ciudadActual = ciudadActual;
    }

    public int dormir(){return this.horasDeSuenio;}

    public int serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(this.vecesHeridoPorCuchillo == 1) return 2;
        return 1;
    }

    public int serHeridoPorArmaDeFuego(){return 4;}
}
