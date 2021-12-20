package carmenSandiego.modelo;

import java.util.*;

public class Tiempo {
    public Calendar calendario;

    public Tiempo(int hora, int dia, int mes, int anio){
        this.calendario = new GregorianCalendar(anio, mes, dia, hora,0);
        //Calendar calendario = new GregorianCalendar();
        //calendario.set(anio, mes, dia, hora, 0, 0);
        //setCalendario(calendario);
        //this.calendario = calendario;
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
        return calendario.get(calendario.HOUR_OF_DAY);
        //return calendario.HOUR_OF_DAY;
        /*
        Hay q ver si podemos/ esta bien acceder a los atributos de calendario directamente con el .
        porque tenemos parte de codigo con ambas cosas.
        ejemplo ya estamos accediendo a la hora del dia de calendario con el .HOUR_OF_DAY, porque
        llamamos al metodo get() de calendario que devuelve el mismo numero.
         */
    }
    public int getDiaActual(){
        return calendario.get(calendario.DAY_OF_WEEK);
    }
    public int getMesActual() {
        return calendario.get(calendario.MONTH);
    }
    public int getAnioActual(){return calendario.get(calendario.YEAR);}

    public boolean compararTiempos(Tiempo tiempo){
        boolean hora = this.getHoraActual() == tiempo.getHoraActual();
        boolean dia = this.getDiaActual() == tiempo.getDiaActual();
        boolean mes = this.getMesActual() == tiempo.getMesActual();
        boolean anio = this.getAnioActual() == tiempo.getAnioActual();

        return hora && dia && mes && anio;
    }
}
