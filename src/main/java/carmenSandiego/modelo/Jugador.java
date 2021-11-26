package carmenSandiego.modelo;

import java.util.*;

public class Jugador {
    private String nombre;
    private Rango rango;
    private Ciudad ciudadActual;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.rango = new Rango();
    }

    public String getNombre(){return this.nombre;}

    public String getRango(){return this.rango.getRango();}

    public int getCantidadDeArrestos(){return this.rango.getCantidadDeArrestos();}

    public void addArresto(){this.rango.addArresto();}

    public Ciudad getCiudadActual(){return this.ciudadActual;}

    public void setCiudadActual(Ciudad ciudadActual){
        this.ciudadActual = ciudadActual;
    }
}
