package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Horario {
    private final ArrayList<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes",
            "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));
    private int diaActual;
    private int horaActual;
    private final int horaDeDormirInicial = 22;
    private final int horaDeDromirFinal = 7;

    public Horario(){
        this.diaActual = 0;    //empieza un lunes
        this.horaActual = 7;  //empieza a las 7 AM
    }

    public void addHoras(int horas){
        if (this.horaActual + horas >= 24){  //if (this.horaActual + horas >= 22) horas += 8
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

    /*
    public void esHorarioDeDormir(Jugador jugador) {
        if (horaActual >= horaDeDormirInicial || horaActual <= horaDeDromirFinal){
            addHoras(jugador.dormir());
        }
    }

     */
}
