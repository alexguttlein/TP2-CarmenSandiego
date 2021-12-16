package carmenSandiego.modelo;

import java.util.*;

public class Tiempo {
    public Calendar calendario;

    public Tiempo(int hora, int dia, int mes, int anio){
        Calendar calendario = new GregorianCalendar();
        calendario.set(anio, mes, dia, hora, 0, 0);

        setCalendario(calendario);
    }

    private void setCalendario(Calendar calendario){
        this.calendario = calendario;
    }

    public Calendar getCalendario(){
        return this.calendario;
    }

    public void addHoras(int horas){
        calendario.add(calendario.HOUR_OF_DAY, horas);
    }

    public int getHoraActual(){
        return this.getCalendario().get(calendario.HOUR_OF_DAY);
    }

    public int getDiaActual(){
        return this.getCalendario().get(calendario.DAY_OF_WEEK);
    }

    public int getMesActual() {
        return this.getCalendario().get(calendario.MONTH);
    }
}
