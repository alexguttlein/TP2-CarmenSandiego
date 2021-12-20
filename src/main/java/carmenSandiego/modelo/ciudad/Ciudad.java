package carmenSandiego.modelo.ciudad;

import carmenSandiego.modelo.edificio.Edificio;

import java.util.ArrayList;

public class Ciudad {
    //Creo q deberiamos desacernos de los strings y encapsularlo.
    //Nose si utilizar la clase Caracteristica como los demas o crear una clase x cada atributo
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
    private Ubicacion ubicacion;

    private ArrayList<Edificio> edificios = new ArrayList<>();
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
        this.ubicacion = new Ubicacion(Double.parseDouble(pistasCiudad.get(13)), Double.parseDouble(pistasCiudad.get(14)));
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

    public int visitarEdificio(Edificio unEdificio){
        return unEdificio.entrarAlEdificio();
    }

    public void setCiudadSiguiente(Ciudad ciudadSiguiente) {
        this.ciudadSiguiente = ciudadSiguiente;
        this.setPasoLadron();
    }

    public Ciudad getCiudadSiguiente(){return this.ciudadSiguiente;}

    private void setPasoLadron(){this.pasoLadron = true;}

    public boolean getPasoLadron(){return this.pasoLadron;}

    public Ubicacion getUbicacion(){return this.ubicacion;}

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

    public int viajarHasta(int velocidad, Ciudad ciudadDestino){
        return ciudadDestino.viajar(ubicacion, velocidad);
        //return this.getUbicacion().obtenerHorasDeViaje(ciudadDestino.getUbicacion(), velocidad);
    }

    public int viajar(Ubicacion ubicacionOrigen, int velocidad ){
        return ubicacion.obtenerHorasDeViaje(ubicacionOrigen, velocidad);
    }

    public void addEdificio(Edificio unEdificio){
        this.edificios.add(unEdificio);
    }

}


