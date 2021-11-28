package carmenSandiego.modelo;

import java.util.ArrayList;

public class Ciudad {
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

    private ArrayList<Edificio> edificios;
    private Ciudad ciudadSiguiente;
    private boolean pasoLadron;

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
        this.pasoLadron = false;
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

    public int visitarEdificio(Ciudad ciudadSig, Edificio unEdificio){
        return unEdificio.getPista(ciudadSig);
    }

    public void setCiudadSiguiente(Ciudad ciudadSiguiente) {
        this.ciudadSiguiente = ciudadSiguiente;
        this.setPasoLadron();
    }

    public Ciudad getCiudadSiguiente(){return this.ciudadSiguiente;}

    private void setPasoLadron(){this.pasoLadron = true;}

    public boolean getPasoLadron(){return this.pasoLadron;}
}


