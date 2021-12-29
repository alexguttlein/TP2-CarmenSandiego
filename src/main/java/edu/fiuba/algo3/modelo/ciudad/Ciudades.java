package edu.fiuba.algo3.modelo.ciudad;


import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.GeneradorRandom;
import edu.fiuba.algo3.modelo.LectorCsv;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.edificio.EdificioAeropuerto;
import edu.fiuba.algo3.modelo.edificio.EdificioBanco;
import edu.fiuba.algo3.modelo.edificio.EdificioPuerto;
import edu.fiuba.algo3.modelo.edificio.EdificioBiblioteca;

import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.*;

import java.util.ArrayList;
import java.util.List;


public class Ciudades {

    private ArrayList<Ciudad> ciudades = new ArrayList<>();

    public Ciudades(String rutaArchivoCSV){
        inicializarCiudades(rutaArchivoCSV);
    }

    private void inicializarCiudades(String rutaArchivoCSV) {
        ArrayList<ArrayList<String>> datosCiudades;
        LectorCsv leerArchivo = new LectorCsv(rutaArchivoCSV);

        datosCiudades = leerArchivo.getLectura();

        for(ArrayList<String> ciudad: datosCiudades)
            crearCiudad(ciudad);
    }

    private void crearCiudad(ArrayList<String> datosCiudad) {
        Ciudad ciudad = new Ciudad(datosCiudad);
        agregarEdificios(ciudad);
        addCiudad(ciudad);
    }

    private void agregarEdificios(Ciudad ciudad) {
        ArrayList<ArrayList<String>> nombreEdificios;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/edu/fiuba/algo3/datosDelJuego/edificios.csv");
        nombreEdificios = leerArchivo.getLectura();

        int cantidadALeer = 3;
        List<Integer> randomIndex = seleccionadorAlAzar(nombreEdificios.get(0).size(), cantidadALeer);

        int i = 0;
        for(i = 0; i < cantidadALeer; i++)
            for (ArrayList<String> e: nombreEdificios){
                String nombre = e.get(randomIndex.get(i));
                ciudad.addEdificio(crearEdificio(nombre));
            }
    }

    private Edificio crearEdificio(String nombreEdificio) {
        Edificio edificio = null;
        Pista pista = null;
        Caracteristica pistaInicial;
        Caracteristica pistaVacia = new Caracteristica("");
        if(nombreEdificio.equals("Aeropuerto")){
            edificio = new EdificioAeropuerto(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaAeropuerto(pistaInicial, pistaVacia);
        }
        if(nombreEdificio.equals("Puerto")){
            edificio = new EdificioPuerto(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaPuerto(pistaInicial, pistaVacia);
        }
        if(nombreEdificio.equals("Biblioteca")){
            edificio = new EdificioBiblioteca(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaBiblioteca(pistaInicial, pistaVacia);
        }
        if(nombreEdificio.equals("Banco")){
            edificio = new EdificioBanco(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaBanco(pistaInicial, pistaVacia);
        }
        edificio.setPista(pista);
        return edificio;
    }

    private List<Integer> seleccionadorAlAzar(int tamanio, int cantidad){

        GeneradorRandom generadorRandom = new GeneradorRandom(tamanio, cantidad);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();

        return listaGenerada;
    }

    private void addCiudad(Ciudad ciudad) {this.ciudades.add(ciudad);}

    public ArrayList<Ciudad> getCiudades(){return this.ciudades;}

    private Caracteristica generarPistaInicial(){
        ArrayList<ArrayList<String>> pistasIniciales;
        LectorCsv lectura = new LectorCsv("src/main/java/edu/fiuba/algo3/datosDelJuego/pistasIniciales.csv");

        pistasIniciales = lectura.getLectura();

        int cantidadALeer = 1;
        List<Integer> randomIndex = seleccionadorAlAzar(pistasIniciales.get(0).size(), cantidadALeer);

        int valor = randomIndex.get(0);

        return new Caracteristica(pistasIniciales.get(0).get(valor));
    }

    public void agregarCiudadesSecundarias(int cantidadAAgregar) {
        for(Ciudad c: this.ciudades) {
            int indexAIgnorar = obtenerIndiceDeCiudad(c);
            GeneradorRandom generadorRandom = new GeneradorRandom(this.ciudades.size(), cantidadAAgregar, indexAIgnorar);
            List<Integer> listaGenerada = generadorRandom.getListaGenerada();
            for(int i = 0; i < cantidadAAgregar; i++)
                c.agregarCiudadSecundaria(this.getCiudades().get( listaGenerada.get(i) ));
        }
    }

    public int obtenerIndiceDeCiudad(Ciudad ciudad) {
        int i = -1;
        for(i = 0; i < this.getCiudades().size(); i++){
            if(this.getCiudades().get(i).getNombre().compararCaracteristica(ciudad.getNombre()))
                return i;
        }
        return -1;
    }
}
