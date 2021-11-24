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
        this.nombre = datosLadron.get(0);
        this.genero = datosLadron.get(1);
        this.hobby = datosLadron.get(2);
        this.cabello = datosLadron.get(3);
        this.senia = datosLadron.get(4);
        this.vehiculo = datosLadron.get(5);
    }

    public String getNombre(){return this.nombre;}
    public String getGenero(){return this.genero;}
    public String getHobby(){return this.hobby;}
    public String getCabello(){return this.cabello;}
    public String getSenia(){return this.senia;}
    public String getVehiculo(){return this.vehiculo;}
}
