package carmenSandiego.modelo.ciudad;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.edificio.comportamiento.pistas.*;
import carmenSandiego.modelo.edificio.*;
import datosDelJuego.GeneradorRandom;
import datosDelJuego.LectorCsv;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import carmenSandiego.modelo.pistas.Pista;
import carmenSandiego.modelo.pistas.PistaAeropuerto;
import carmenSandiego.modelo.pistas.PistaPuerto;
import carmenSandiego.modelo.pistas.PistaBanco;
import carmenSandiego.modelo.pistas.PistaBiblioteca;


public class Ciudades {

    private ArrayList<Ciudad> ciudades = new ArrayList<>();

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
        agregarEdificios(ciudad);
        addCiudad(ciudad);
    }

    private void agregarEdificios(Ciudad ciudad) {
        ArrayList<ArrayList<String>> nombreEdificios;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/edificios.csv");
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
            edificio = new EdificioAeropuerto(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaAeropuerto(pistaInicial, null);
        }
        if(nombreEdificio.equals("Puerto"));{
            edificio = new EdificioPuerto(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaPuerto(pistaInicial, null);
        }
        if(nombreEdificio.equals("Biblioteca"));{
            edificio = new EdificioBiblioteca(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaBiblioteca(pistaInicial, null);
        }
        if(nombreEdificio.equals("Banco"));{
            edificio = new EdificioBanco(new Caracteristica(nombreEdificio));
            pistaInicial = generarPistaInicial();
            pista = new PistaBanco(pistaInicial, null);
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
        LectorCsv lectura = new LectorCsv("src/main/java/datosDelJuego/pistasIniciales.csv");

        pistasIniciales = lectura.getLectura();

        int cantidadALeer = 1;
        List<Integer> randomIndex = seleccionadorAlAzar(pistasIniciales.get(0).size(), cantidadALeer);

        int valor = randomIndex.get(0);

        return new Caracteristica(pistasIniciales.get(0).get(valor));
    }

}
