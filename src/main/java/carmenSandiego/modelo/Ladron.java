package carmenSandiego.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ladron {
    private String nombre;
    private String genero;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public Ladron(ArrayList<String> datosLadron){
        setNombre(datosLadron.get(0));
        setGenero(datosLadron.get(1));
        setHobby(datosLadron.get(2));
        setCabello(datosLadron.get(3));
        setSenia(datosLadron.get(4));
        setVehiculo(datosLadron.get(5));
    }

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setGenero(String genero){this.genero = genero;}
    public void setHobby(String hobby){this.hobby = hobby;}
    public void setCabello(String cabello){this.cabello = cabello;}
    public void setSenia(String senia){this.senia = senia;}
    public void setVehiculo(String vehiculo){this.vehiculo = vehiculo;}

    public String getNombre(){return this.nombre;}
    public String getGenero(){return this.genero;}
    public String getHobby(){return this.hobby;}
    public String getCabello(){return this.cabello;}
    public String getSenia(){return this.senia;}
    public String getVehiculo(){return this.vehiculo;}
}
