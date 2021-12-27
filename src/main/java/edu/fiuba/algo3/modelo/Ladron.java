package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ladron {
    private Caracteristica nombre;
    private Caracteristica genero;
    private Caracteristica hobby;
    private Caracteristica cabello;
    private Caracteristica senia;
    private Caracteristica vehiculo;
    private List<Caracteristica> listaCaracteristicas = new ArrayList<>();

    public Ladron(ArrayList<String> datosLadron){
        this.nombre = new Caracteristica(datosLadron.get(0));
        this.genero = new Caracteristica(datosLadron.get(1));
        this.hobby = new Caracteristica(datosLadron.get(2));
        this.cabello = new Caracteristica(datosLadron.get(3));
        this.senia = new Caracteristica(datosLadron.get(4));
        this.vehiculo = new Caracteristica(datosLadron.get(5));
    }

    public void setNombre(Caracteristica nombre){this.nombre = nombre;}
    public void setGenero(Caracteristica genero){this.genero = genero; listaCaracteristicas.add(genero);}
    public void setHobby(Caracteristica hobby){this.hobby = hobby; listaCaracteristicas.add(hobby);}
    public void setCabello(Caracteristica cabello){this.cabello = cabello; listaCaracteristicas.add(cabello);}
    public void setSenia(Caracteristica senia){this.senia = senia; listaCaracteristicas.add(senia);}
    public void setVehiculo(Caracteristica vehiculo){this.vehiculo = vehiculo; listaCaracteristicas.add(vehiculo);}

    public Caracteristica getNombre(){return this.nombre;}
    public Caracteristica getGenero(){return this.genero;}
    public Caracteristica getHobby(){return this.hobby;}
    public Caracteristica getCabello(){return this.cabello;}
    public Caracteristica getSenia(){return this.senia;}
    public Caracteristica getVehiculo(){return this.vehiculo;}
    public List<Caracteristica> getListaCaracteristicas(){return this.listaCaracteristicas;}

    public boolean compararConLadron(Ladron otroLadron){
        return otroLadron.compararCaracteristicas(nombre, genero, hobby, cabello, senia, vehiculo);
    }

    private boolean compararCaracteristicas(Caracteristica unNombre, Caracteristica unGenero, Caracteristica unHobby,
                                            Caracteristica unCabello, Caracteristica unaSenia, Caracteristica unVehiculo){
        boolean mismoNombre = this.nombre.compararCaracteristica(unNombre);
        boolean mismoGenero = this.genero.compararCaracteristica(unGenero);
        boolean mismoHobby = this.hobby.compararCaracteristica(unHobby);
        boolean mismoCabello = this.cabello.compararCaracteristica(unCabello);
        boolean mismaSenia = this.senia.compararCaracteristica(unaSenia);
        boolean mismoVehiculo = this.vehiculo.compararCaracteristica(unVehiculo);

        return mismoNombre && mismoGenero && mismoHobby && mismoCabello && mismaSenia && mismoVehiculo;
    }
}
