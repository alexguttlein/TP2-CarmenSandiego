package carmenSandiego.modelo;


import java.util.ArrayList;
import java.util.Arrays;

public class Reloj {
    static final int HORA_INICIAL = 7;
    static final int DIA_INICIAL = 0;

    private static Reloj instance = new Reloj();
    private final ArrayList<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes",
            "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));
    private int horaActual;
    private int diaActual;

    private Reloj(){
        horaActual = HORA_INICIAL;
        diaActual = DIA_INICIAL;
    }

    public static Reloj getInstance(){
        return instance;
    }

    public void agregarHoras(int horas){
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

    public void reiniciar(){
        horaActual = HORA_INICIAL;
        diaActual = DIA_INICIAL;
    }

}
