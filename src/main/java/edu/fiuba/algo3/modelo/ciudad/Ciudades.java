package edu.fiuba.algo3.modelo.ciudad;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.edificio.*;
import edu.fiuba.algo3.modelo.datosDelJuego.GeneradorRandom;
import edu.fiuba.algo3.modelo.datosDelJuego.LectorCsv;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.Pista;

public class Ciudades {

    private ArrayList<Ciudad> ciudades;

    public Ciudades(String rutaArchivoCSV){
        this.ciudades = new ArrayList<>();
        inicializarCiudades(rutaArchivoCSV);
    }

    public Ciudades(){
        this.ciudades = new ArrayList<>();
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

    private void addCiudad(Ciudad ciudad) {this.ciudades.add(ciudad);}

    public ArrayList<Ciudad> getCiudades(){return this.ciudades;}


    //AGREGADO

    private void agregarEdificios(Ciudad ciudad) {
        ArrayList<ArrayList<String>> nombreEdificios;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/edu/fiuba/algo3/modelo/datosDelJuego/edificios.csv");
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
        Edificio edificio;
        Pista pista;
        Caracteristica pistaInicial;
        if(nombreEdificio.equals("Aeropuerto"));{
            edificio = new EdificioAeropuerto();
            //pistaInicial = generarPistaInicial();
            //pista = new PistaAeropuerto(pistaInicial, null);
        }
        if(nombreEdificio.equals("Puerto"));{
            edificio = new EdificioPuerto();
            pistaInicial = generarPistaInicial();
            //pista = new PistaPuerto(pistaInicial, null);
        }
        if(nombreEdificio.equals("Biblioteca"));{
            edificio = new EdificioBiblioteca();
            //pistaInicial = generarPistaInicial();
            //pista = new PistaBiblioteca(pistaInicial, null);
        }
        if(nombreEdificio.equals("Banco"));{
            edificio = new EdificioBanco();
            //pistaInicial = generarPistaInicial();
            //pista = new PistaBanco();
        }
        //edificio.setPista(pista);
        return edificio;
    }

    private List<Integer> seleccionadorAlAzar(int tamanio, int cantidad){

        GeneradorRandom generadorRandom = new GeneradorRandom(tamanio, cantidad);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();

        return listaGenerada;
    }


    //AGREGADO
    private Caracteristica generarPistaInicial(){
        ArrayList<ArrayList<String>> pistasIniciales;
        LectorCsv lectura = new LectorCsv("src/main/java/edu/fiuba/algo3/modelo/datosDelJuego/pistasIniciales.csv");

        pistasIniciales = lectura.getLectura();

        int cantidadALeer = 1;
        List<Integer> randomIndex = seleccionadorAlAzar(pistasIniciales.get(0).size(), cantidadALeer);

        int valor = randomIndex.get(0);

        return new Caracteristica(pistasIniciales.get(0).get(valor));
    }

}
