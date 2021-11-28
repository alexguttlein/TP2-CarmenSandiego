package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Horario {
    private final ArrayList<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes",
            "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));
    int diaActual;
    int horaActual;

    public Horario(){
        this.diaActual = 0;
        this.horaActual = 7;
    }

    public void addHoras(int horas){
        if (this.horaActual + horas >= 24){
            this.diaActual = ((this.diaActual + 1) % dias.size());
        }
        this.horaActual = ((this.horaActual + horas) % 24);
    }

    public int getDiaActual(){return this.diaActual;}

    public int getHoraActual(){return this.horaActual;}

    public String getDiaYHoraActual(){
        String diaYHoraActual = (dias.get(this.diaActual) + " - " + this.horaActual + ":00 HS");
        return diaYHoraActual;
    }

}
