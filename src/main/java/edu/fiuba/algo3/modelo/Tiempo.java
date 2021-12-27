package edu.fiuba.algo3.modelo;

import java.util.*;

public class Tiempo {
    public Calendar calendario;
    private int cantidadHorasDisponibles;

    public Tiempo(int hora, int dia, int mes, int anio){
        this.calendario = new GregorianCalendar(anio, mes, dia, hora,0);
        this.cantidadHorasDisponibles = 154;
    }
    public Tiempo(){
        this.calendario = new GregorianCalendar(2021,0,4,7,0);  //Lunes 4 de enero a las 07:00 hs
        this.cantidadHorasDisponibles = 154;
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
        int diaAntesDeAgregarHoras = calendario.get(calendario.DAY_OF_WEEK);
        calendario.add(calendario.HOUR_OF_DAY, horas);
        int diaLuegoDeAgregarHoras = calendario.get(calendario.DAY_OF_WEEK);
        jugadorDebeDormir(diaAntesDeAgregarHoras, diaLuegoDeAgregarHoras);
        seAlcanzoElLimiteDeTiempo(horas);
    }


    private void jugadorDebeDormir(int diaAntesDeAgregarHoras, int diaLuegoDeAgregarHoras){
        if (diaAntesDeAgregarHoras != diaLuegoDeAgregarHoras){
            this.addHoras(8);
        }
    };

    public boolean compararTiempos(Tiempo tiempo){
        boolean mismaHora = this.getHoraActual() == tiempo.getHoraActual();
        boolean mismoDia = this.getDiaActual() == tiempo.getDiaActual();
        boolean mismoMes = this.getMesActual() == tiempo.getMesActual();
        boolean mismoAnio = this.getAnioActual() == tiempo.getAnioActual();

        return mismaHora && mismoDia && mismoMes && mismoAnio;
    }


    public boolean seAlcanzoElLimiteDeTiempo(int horas){
        this.cantidadHorasDisponibles -= horas;
        if (this.cantidadHorasDisponibles <= 0)
            return true;
        return false;
    }


}
