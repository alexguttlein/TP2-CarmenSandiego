package carmenSandiego.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ciudad {
    private String sinPista;
    private String nombre;
    private String bandera;
    private String moneda;
    private String geografia;
    private String hitos;
    private String industria;
    private String animales;
    private String personalidades;
    private String idioma;
    private String arte;
    private String religion;
    private String gobierno;
    private String varios;
    private Double latitud;
    private Double longitud;

    private ArrayList<Edificio> edificios;
    private Ciudad ciudadSiguiente;
    private boolean pasoLadron;
    private final Map<Ciudad, Integer> mapaDistancias = new HashMap<>();

    public Ciudad(ArrayList<String> pistasCiudad){
        this.nombre = pistasCiudad.get(0);
        this.bandera = pistasCiudad.get(1);
        this.moneda = pistasCiudad.get(2);
        this.geografia = pistasCiudad.get(3);
        this.hitos = pistasCiudad.get(4);
        this.industria = pistasCiudad.get(5);
        this.animales = pistasCiudad.get(6);
        this.personalidades = pistasCiudad.get(7);
        this.idioma = pistasCiudad.get(8);
        this.arte = pistasCiudad.get(9);
        this.religion = pistasCiudad.get(10);
        this.gobierno = pistasCiudad.get(11);
        this.varios = pistasCiudad.get(12);
        this.latitud = Double.parseDouble(pistasCiudad.get(13));
        this.longitud = Double.parseDouble(pistasCiudad.get(14));
        this.pasoLadron = false;
        this.sinPista ="Disculpa no lo vimos por aca";
    }

    public String getNombre(){return this.nombre;}
    public String getBandera(){return this.bandera;}
    public String getMoneda(){return this.moneda;}
    public String getGeografia(){return this.geografia;}
    public String getHitos(){return this.hitos;}
    public String getIndustria(){return this.industria;}
    public String getAnimales(){return this.animales;}
    public String getPersonalidades(){return this.personalidades;}
    public String getIdioma(){return this.idioma;}
    public String getArte(){return this.arte;}
    public String getReligion(){return this.religion;}
    public String getGobierno(){return this.gobierno;}
    public String getVarios(){return this.varios;}
    public String getSinPista(){return this.sinPista;};

    public String visitarEdificio(Ciudad ciudadSig, Edificio unEdificio){
        return unEdificio.getPista(ciudadSig);
    }

    public void setCiudadSiguiente(Ciudad ciudadSiguiente) {
        this.ciudadSiguiente = ciudadSiguiente;
        this.setPasoLadron();
    }

    public Ciudad getCiudadSiguiente(){return this.ciudadSiguiente;}

    private void setPasoLadron(){this.pasoLadron = true;}

    public boolean getPasoLadron(){return this.pasoLadron;}
/*
    public int obtenerTiempoDeViajeHasta(Ciudad ciudad, Rango rango){
        int tiempo = 0;
        return tiempo;
    }
*/
    /*public int visitar(Edificio edificio){
        return edificio.visitar();
    }*/


    public double obtenerDistancia(Ciudad ciudadDestino) {
        double latitudCiudadDestino = ciudadDestino.getLatitud();
        double longitudCiudadDestino = ciudadDestino.getLongitud();
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(latitudCiudadDestino - this.latitud);
        double dLng = Math.toRadians(longitudCiudadDestino - this.longitud);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(latitudCiudadDestino));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
    }

    public double getLatitud() {
        return this.latitud;
    }

    public double getLongitud(){
        return this.longitud;
    }


}


