package carmenSandiego.modelo;

import java.util.ArrayList;
import carmenSandiego.modelo.Ciudad;

public class Partida {

    private Jugador jugador;
    private ObjetoRobado objetoRobado;
    private final ArrayList<Ciudad> ciudades;

    public Partida(Jugador nuevoJugador, ObjetoRobado objetoRobado, ArrayList<Ciudad> ciudades){
        this.jugador = nuevoJugador;
        this.objetoRobado = objetoRobado;
        this.ciudades = ciudades;
    }

    //public void dormir(){
    //    horario.addHoras(jugador.dormir());
    //}

    //public void herirConCuchillo(){
    //    horario.addHoras(jugador.serHeridoPorCuchillo());
    //}


/*
    public void cambiarCiudad(String nombreNuevaCiudad) {
        Ciudad ciudadActual = jugador.getCiudadActual();
        Ciudad nuevaCiudad = buscarCiudad(nombreNuevaCiudad);
        double distanciaEntreCiudades = ciudadActual.obtenerDistancia(nuevaCiudad);
        //Pasar el tiempo y cambiar la hora
        jugador.setCiudadActual(nuevaCiudad);
    }

 */

    public Ciudad buscarCiudad(String nombreNuevaCiudad){
        Ciudad ciudadBuscada = ciudades.get(0);
        for (Ciudad ciudadActual : ciudades){
            if (ciudadActual.getNombre() == nombreNuevaCiudad) {
                ciudadBuscada = ciudadActual;
            }
        }
        return ciudadBuscada;
    }

    //public void jugadorDebeDormir(){
    //    horario.esHorarioDeDormir(jugador);
    //}
}
    /*
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

     */

