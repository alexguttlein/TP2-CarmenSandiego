package carmenSandiego.modelo;

import java.util.*;

public class Horario {
    public Calendar calendario;

    public Horario(){
        Calendar calendario = new GregorianCalendar();
        calendario.set(2021, 00, 4, 7, 0, 0);

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
