package carmenSandiego.modelo;

import java.util.*;

public class Tiempo {
    public Calendar calendario;

    public Tiempo(int hora, int dia, int mes, int anio){
        this.calendario = new GregorianCalendar(anio, mes, dia, hora,0);
    }
    public Tiempo(){
        this.calendario = new GregorianCalendar(2021,5,1,7,0);
    }

    public Calendar getCalendario(){
        return this.calendario;
    }
    public int getHoraActual(){
        return calendario.get(calendario.HOUR_OF_DAY);
    }
    public int getDiaActual(){
        return calendario.get(calendario.DAY_OF_WEEK);
    }
    public int getMesActual() {
        return calendario.get(calendario.MONTH);
    }
    public int getAnioActual(){return calendario.get(calendario.YEAR);}

    public void addHoras(int horas){
        calendario.add(calendario.HOUR_OF_DAY, horas);
    }

    public boolean compararTiempos(Tiempo tiempo){
        boolean mismaHora = this.getHoraActual() == tiempo.getHoraActual();
        boolean mismoDia = this.getDiaActual() == tiempo.getDiaActual();
        boolean mismoMes = this.getMesActual() == tiempo.getMesActual();
        boolean mismoAnio = this.getAnioActual() == tiempo.getAnioActual();

        return mismaHora && mismoDia && mismoMes && mismoAnio;
    }
}
