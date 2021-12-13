package carmenSandiego.modelo;

import datosDelJuego.LectorCsv;

import java.util.ArrayList;

public class Ciudades {

    private ArrayList<Ciudad> ciudades = new ArrayList<>();
    public static final String SEPARADOR = ";";

    public Ciudades(){
        inicializarCiudades();
    }

    private void inicializarCiudades() {
        ArrayList<ArrayList<String>> datosCiudades;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/ciudades.csv");

        datosCiudades = leerArchivo.getLectura();

        for(ArrayList<String> ciudad: datosCiudades)
            crearCiudad(ciudad);
    }

    private void crearCiudad(ArrayList<String> datosCiudad) {
        Ciudad ciudad = new Ciudad(datosCiudad);
        addCiudad(ciudad);
    }

    private void addCiudad(Ciudad ciudad) {this.ciudades.add(ciudad);}

    public ArrayList<Ciudad> getCiudades(){return this.ciudades;}

}
