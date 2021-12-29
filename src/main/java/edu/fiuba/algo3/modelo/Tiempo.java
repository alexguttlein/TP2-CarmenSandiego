package edu.fiuba.algo3.modelo;

import java.text.SimpleDateFormat;
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
        calendario.add(calendario.HOUR_OF_DAY, horas);
        seAlcanzoElLimiteDeTiempo(horas);
    }

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

    public String obtenerDiaDeLaSemana(){
        String nombreDia;
        switch(this.getDiaActual()){
            case 1: nombreDia = "Domingo"; break;
            case 2: nombreDia = "Lunes"; break;
            case 3: nombreDia = "Martes"; break;
            case 4: nombreDia = "Miercoles"; break;
            case 5: nombreDia = "Jueves"; break;
            case 6: nombreDia = "Viernes"; break;
            case 7: nombreDia = "Sabado"; break;
            default: nombreDia = "Error"; break;
        }
        return nombreDia;
    }


}
