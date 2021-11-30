package carmenSandiego.modelo;

import java.util.*;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private int horasDeSuenio;
    private int vecesHeridoPorCuchillo;
    private Horario horario;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.rango = new Rango();
        this.horasDeSuenio = 8;
        this.vecesHeridoPorCuchillo = 0;
        this.horario = new Horario();
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

    public void serHeridoPorCuchillo(){
        this.vecesHeridoPorCuchillo++;
        if(this.vecesHeridoPorCuchillo == 1) {
            horario.addHoras(2);
        }
        else {
            horario.addHoras(1);
        }
    }

    public Horario getHorario(){
        return this.horario;
    }

    public void serHeridoPorArmaDeFuego(){horario.addHoras(4);}


}
