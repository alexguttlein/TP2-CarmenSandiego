package carmenSandiego.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ladron {
    private CaracteristicaLadron nombre;
    private CaracteristicaLadron genero;
    private CaracteristicaLadron hobby;
    private CaracteristicaLadron cabello;
    private CaracteristicaLadron senia;
    private CaracteristicaLadron vehiculo;

    public Ladron(ArrayList<String> datosLadron){
        this.nombre = new CaracteristicaLadron(datosLadron.get(0));  //this.nombre = datosLadron.get(0);
        this.genero = new CaracteristicaLadron(datosLadron.get(1));
        this.hobby = new CaracteristicaLadron(datosLadron.get(2));
        this.cabello = new CaracteristicaLadron(datosLadron.get(3));
        this.senia = new CaracteristicaLadron(datosLadron.get(4));
        this.vehiculo = new CaracteristicaLadron(datosLadron.get(5));
    }

    public void mostrar() {
        nombre.mostrar();
    }

    public boolean comparar(Ladron otroLadron){
        return otroLadron.compararCaracteristicas(nombre, genero, hobby, cabello, senia, vehiculo);
    }

    private boolean compararCaracteristicas(CaracteristicaLadron nombre, CaracteristicaLadron genero, CaracteristicaLadron hobby,
                                           CaracteristicaLadron cabello, CaracteristicaLadron senia, CaracteristicaLadron vehiculo){
        boolean mismoNombre = this.nombre.comparar(nombre);
        boolean mismoGenero = this.genero.comparar(genero);
        boolean mismoHobby = this.hobby.comparar(hobby);
        boolean mismoCabello = this.cabello.comparar(cabello);
        boolean mismaSenia = this.senia.comparar(senia);
        boolean mismoVehiculo = this.vehiculo.comparar(vehiculo);
        return mismoNombre && mismoGenero && mismoHobby && mismoCabello && mismaSenia && mismoVehiculo;
    }

    public boolean compararSospechoso(Ladron otroLadron) {
        return otroLadron.compararCaracteristicasSospechoso(genero, hobby, cabello, senia, vehiculo);
    }

    private boolean compararCaracteristicasSospechoso(CaracteristicaLadron genero, CaracteristicaLadron hobby,
                                                     CaracteristicaLadron cabello, CaracteristicaLadron senia, CaracteristicaLadron vehiculo) {
        boolean mismoGenero = this.genero.compararSospechoso(genero);
        boolean mismoHobby = this.hobby.compararSospechoso(hobby);
        boolean mismoCabello = this.cabello.compararSospechoso(cabello);
        boolean mismaSenia = this.senia.compararSospechoso(senia);
        boolean mismoVehiculo = this.vehiculo.compararSospechoso(vehiculo);
        return mismoGenero && mismoHobby && mismoCabello && mismaSenia && mismoVehiculo;
    }

    public void setNombre(String nombre){this.nombre = new CaracteristicaLadron(nombre);}
    public void setGenero(String genero){this.genero = new CaracteristicaLadron(genero);}
    public void setHobby(String hobby){this.hobby = new CaracteristicaLadron(hobby);}
    public void setCabello(String cabello){this.cabello = new CaracteristicaLadron(cabello);}
    public void setSenia(String senia){this.senia = new CaracteristicaLadron(senia);}

    public void setVehiculo(String vehiculo){this.vehiculo = new CaracteristicaLadron(vehiculo);}

    public void mostrarDetallesLadron(){
        nombre.mostrar();
        System.out.print("\n");
        genero.mostrar();
        System.out.print("\n");
        hobby.mostrar();
        System.out.print("\n");
        cabello.mostrar();
        System.out.print("\n");
        senia.mostrar();
        System.out.print("\n");
        vehiculo.mostrar();
        System.out.print("\n");
    }
    /*
    public String getNombre(){return this.nombre;}
    public String getGenero(){return this.genero;}
    public String getHobby(){return this.hobby;}
    public String getCabello(){return this.cabello;}
    public String getSenia(){return this.senia;}
    public String getVehiculo(){return this.vehiculo;}

     */
}
