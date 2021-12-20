package carmenSandiego.modelo;

import java.util.ArrayList;

public class Ladron {
    private Caracteristica nombre;
    private Caracteristica genero;
    private Caracteristica hobby;
    private Caracteristica cabello;
    private Caracteristica senia;
    private Caracteristica vehiculo;

    public Ladron(ArrayList<String> datosLadron){
        setNombre(new Caracteristica(datosLadron.get(0)));
        setGenero(new Caracteristica(datosLadron.get(1)));
        setHobby(new Caracteristica(datosLadron.get(2)));
        setCabello(new Caracteristica(datosLadron.get(3)));
        setSenia(new Caracteristica(datosLadron.get(4)));
        setVehiculo(new Caracteristica(datosLadron.get(5)));
    }

    public void setNombre(Caracteristica nombre){this.nombre = nombre;}
    public void setGenero(Caracteristica genero){this.genero = genero;}
    public void setHobby(Caracteristica hobby){this.hobby = hobby;}
    public void setCabello(Caracteristica cabello){this.cabello = cabello;}
    public void setSenia(Caracteristica senia){this.senia = senia;}
    public void setVehiculo(Caracteristica vehiculo){this.vehiculo = vehiculo;}

    public Caracteristica getNombre(){return this.nombre;}
    public Caracteristica getGenero(){return this.genero;}
    public Caracteristica getHobby(){return this.hobby;}
    public Caracteristica getCabello(){return this.cabello;}
    public Caracteristica getSenia(){return this.senia;}
    public Caracteristica getVehiculo(){return this.vehiculo;}

    public boolean compararConLadron(Ladron otroLadron){
        boolean equalNombre = nombre.compararCaracteristica(otroLadron.getNombre());
        boolean equalGenero = genero.compararCaracteristica(otroLadron.getGenero());
        boolean equalHobby = hobby.compararCaracteristica(otroLadron.getHobby());
        boolean equalCabello = cabello.compararCaracteristica(otroLadron.getCabello());
        boolean equalSenia = senia.compararCaracteristica(otroLadron.getSenia());
        boolean equalVehiculo = vehiculo.compararCaracteristica(otroLadron.getVehiculo());

        return equalNombre && equalGenero && equalHobby && equalCabello && equalSenia && equalVehiculo;
    }
}
