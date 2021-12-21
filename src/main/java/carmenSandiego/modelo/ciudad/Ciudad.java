package carmenSandiego.modelo.ciudad;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.edificio.Edificio;
import carmenSandiego.modelo.jugador.rango.Rango;

import java.util.ArrayList;

public class Ciudad {
    private Ladron ladron;
    private Caracteristica nombre;
    private Caracteristica bandera;
    private Caracteristica moneda;
    private Caracteristica geografia;
    private Caracteristica hitos;
    private Caracteristica industria;
    private Caracteristica animales;
    private Caracteristica personalidades;
    private Caracteristica idioma;
    private Caracteristica arte;
    private Caracteristica religion;
    private Caracteristica gobierno;
    private Caracteristica varios;
    private Ubicacion ubicacion;

    private ArrayList<Edificio> edificios = new ArrayList<>();
    private Ciudad ciudadSiguiente;
    private boolean pasoLadron;
    private Rango rangoPersonaje;

    public Ciudad(ArrayList<String> pistasCiudad){
        this.nombre = new Caracteristica(pistasCiudad.get(0));
        this.bandera = new Caracteristica(pistasCiudad.get(1));
        this.moneda = new Caracteristica(pistasCiudad.get(2));
        this.geografia = new Caracteristica(pistasCiudad.get(3));
        this.hitos = new Caracteristica(pistasCiudad.get(4));
        this.industria = new Caracteristica(pistasCiudad.get(5));
        this.animales = new Caracteristica(pistasCiudad.get(6));
        this.personalidades = new Caracteristica(pistasCiudad.get(7));
        this.idioma = new Caracteristica(pistasCiudad.get(8));
        this.arte = new Caracteristica(pistasCiudad.get(9));
        this.religion = new Caracteristica(pistasCiudad.get(10));
        this.gobierno = new Caracteristica(pistasCiudad.get(11));
        this.varios = new Caracteristica(pistasCiudad.get(12));
        setPasoLadron(false);
        double latitud = Double.parseDouble(pistasCiudad.get(13));
        double longitud = Double.parseDouble(pistasCiudad.get(14));
        this.ubicacion = new Ubicacion(latitud, longitud);
    }

    public Caracteristica getNombre(){return this.nombre;}
    public Caracteristica getBandera(){return this.bandera;}
    public Caracteristica getMoneda(){return this.moneda;}
    public Caracteristica getGeografia(){return this.geografia;}
    public Caracteristica getHitos(){return this.hitos;}
    public Caracteristica getIndustria(){return this.industria;}
    public Caracteristica getAnimales(){return this.animales;}
    public Caracteristica getPersonalidades(){return this.personalidades;}
    public Caracteristica getIdioma(){return this.idioma;}
    public Caracteristica getArte(){return this.arte;}
    public Caracteristica getReligion(){return this.religion;}
    public Caracteristica getGobierno(){return this.gobierno;}
    public Caracteristica getVarios(){return this.varios;}

    public int visitarEdificio(Edificio unEdificio){
        return unEdificio.entrarAlEdificio();
    }

    public void setCiudadSiguiente(Ciudad ciudadSiguiente) {
        this.ciudadSiguiente = ciudadSiguiente;
        this.setPasoLadron(true);
    }

    public Ciudad getCiudadSiguiente(){return this.ciudadSiguiente;}

    private void setPasoLadron(boolean pasoLadron){this.pasoLadron = pasoLadron;}

    public boolean getPasoLadron(){return this.pasoLadron;}

    public void setLadron(Ladron ladron){this.ladron = ladron;}

    public Ubicacion getUbicacion(){return this.ubicacion;}

    public void setPistasEdificio(){
        if ((ciudadSiguiente != null) && getPasoLadron()){
            for (Edificio edificio: edificios){
                edificio.modificarPista(this.ciudadSiguiente, this.ladron, this.rangoPersonaje);
            }
        }
    }

    public int viajarHasta(int velocidad, Ciudad ciudadDestino){
        return this.getUbicacion().obtenerHorasDeViaje(ciudadDestino.getUbicacion(), velocidad);
    }

    public void addEdificio(Edificio unEdificio){
        this.edificios.add(unEdificio);
    }

    public ArrayList<Edificio> getEdificios(){return this.edificios;}

    public void setRangoPersonaje(Rango rango){this.rangoPersonaje = rango;}

    public Rango getRango(){return this.rangoPersonaje;}

}


