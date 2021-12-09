package carmenSandiego.modelo;

import carmenSandiego.modelo.Ladron;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ladrones {

    private ArrayList<Ladron> ladrones = new ArrayList<>();
    public static final String SEPARADOR = ";";

    public Ladrones(){
        inicializarLadrones();
    }

    private void inicializarLadrones() {
        ArrayList<ArrayList<String>> datosLadrones;
        datosLadrones = readCsvArchive();
        for(ArrayList<String> ladron: datosLadrones)
            crearLadron(ladron);
    }

    private void crearLadron(ArrayList<String> datosLadron){
        Ladron ladron = new Ladron(datosLadron);
        addLadron(ladron);
    }

    private void addLadron(Ladron ladron) {
        this.ladrones.add(ladron);
    }

    private  ArrayList<ArrayList<String>> readCsvArchive() {
        ArrayList<ArrayList<String>> datosLadrones = new ArrayList<ArrayList<String>>();
        ArrayList<String> datosLadron;
        BufferedReader bufferLectura = null;

        try {
            bufferLectura = new BufferedReader(new FileReader("src/main/java/datosDelJuego/ladrones.csv"));

            String linea = bufferLectura.readLine();

            while (linea != null) {
                String[] campos = linea.split(SEPARADOR);
                datosLadron = new ArrayList<String>();
                for(String c: campos) {
                    datosLadron.add(c);
                }
                datosLadrones.add(datosLadron);
                linea = bufferLectura.readLine();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datosLadrones;
    }

    public List<Ladron> getLadrones(){
        return this.ladrones;
    }

}
