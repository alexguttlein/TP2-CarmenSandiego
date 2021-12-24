package carmenSandiego.modelo.ciudad;

import carmenSandiego.modelo.*;
import carmenSandiego.modelo.edificio.Edificio;

import java.util.ArrayList;
import java.util.Collections;

public class Ciudad {
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
    private ArrayList<Ciudad> ciudadesSecundarias = new ArrayList<>();
    private boolean pasoLadron;

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
        this.pasoLadron = false;
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
    public Ubicacion getUbicacion(){return this.ubicacion;}
    public boolean getPasoLadron(){return this.pasoLadron;}
    public Ciudad getCiudadSiguiente(){return this.ciudadSiguiente;}

    private void setPasoLadron(){this.pasoLadron = true;}
    public void setCiudadSiguiente(Ciudad ciudadSiguiente) {
        this.ciudadSiguiente = ciudadSiguiente;
        this.setPasoLadron();
    }
    public void setLadronUltimaCiudad(){
        this.pasoLadron = true;
    }
    public void setPistasEdificio(){
        if (ciudadSiguiente == null){
            for (Edificio edificio: edificios){
                edificio.setSinPista();
            }
        }
        for (Edificio edificio: edificios){
            edificio.setPistas(ciudadSiguiente);
        }
    }

    public void agregarCiudadSecundaria(Ciudad nuevaCiudadSecundaria){
        ciudadesSecundarias.add(nuevaCiudadSecundaria);
    }

    public ArrayList<Ciudad> getCiudadesSecundarias(){return this.ciudadesSecundarias;}

    public int visitarEdificio(Edificio unEdificio){
        return unEdificio.entrarAlEdificio();
    }

    public void addEdificio(Edificio unEdificio){
        this.edificios.add(unEdificio);
    }

    public int viajarHasta(int velocidad, Ciudad ciudadDestino){
        return ciudadDestino.viajar(ubicacion, velocidad);
    }

    private int viajar(Ubicacion ubicacionOrigen, int velocidad ){
        return ubicacion.obtenerHorasDeViaje(ubicacionOrigen, velocidad);
    }

    public ArrayList<Ciudad> getCiudadesDisponiblesParaViajar(){       //Arma un arreglo con la ciudadSiguiente y las secundarias
        ArrayList<Ciudad> ciudadesDisponibles = new ArrayList<>();     //y las mezcla para luego elegir a cual viajar.
        for(Ciudad actual : this.ciudadesSecundarias){
            ciudadesDisponibles.add(actual);
        }
        ciudadesDisponibles.add(ciudadSiguiente);
        Collections.shuffle(ciudadesDisponibles);
        return ciudadesDisponibles;
    }

    public ArrayList<Edificio> getEdificios(){return this.edificios;}
}


