package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladrones {
    private ArrayList<Ladron> ladrones;

    public Ladrones(String rutaArchivoCSV){
        this.ladrones = new ArrayList<>();
        inicializarLadrones(rutaArchivoCSV);
    }

    public Ladrones(){
        this.ladrones = new ArrayList<>();
    }

    private void inicializarLadrones(String rutaArchivoCSV) {
        LectorCsv leerArchivo = new LectorCsv(rutaArchivoCSV);
        ArrayList<ArrayList<String>> datosLadrones = leerArchivo.getLectura();

        for(ArrayList<String> ladron: datosLadrones) {
            crearLadron(ladron);
        }
    }

    private void crearLadron(ArrayList<String> datosLadron){
        ArrayList<String> datos = new ArrayList<>(Arrays.asList());
        for(String d: datosLadron)
            datos.add(d);
        Ladron ladron = new Ladron(datos);
        addLadron(ladron);
    }

    private void addLadron(Ladron ladron) {
        this.ladrones.add(ladron);
    }

    public ArrayList<Ladron> getLadrones(){
        return this.ladrones;
    }

}
