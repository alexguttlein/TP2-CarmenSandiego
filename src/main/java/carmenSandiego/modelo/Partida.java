package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Partida {

    private final ArrayList<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));

    private int dia;
    private int hora;

    public Partida(){
        this.dia = 0;
        this.hora = 7; //Hasta las 24
    }

    public void moverseDeCiudad() {
        atacarConCuchillo();
    }

    public void atacarConCuchillo(){
        modificarHora(2);
    }

    public void modificarHora(int cantidadHoras){
        if (this.hora + cantidadHoras >= 24){
            this.dia = ((this.dia + 1) % dias.size());
        }
        this.hora = ((this.hora + cantidadHoras) % 24);
    }


    public int getHora(){
        return this.hora;
    }


    public void dormir() {
        modificarHora(8);
    }
}
