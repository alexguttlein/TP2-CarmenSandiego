package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCsv {
    ArrayList<ArrayList<String>> lectura;
    public static final String SEPARADOR = ";";

    public LectorCsv(String ruta){
        ArrayList<ArrayList<String>> lectura = new ArrayList<ArrayList<String>>();

        ArrayList<String> datosLeidos;
        BufferedReader bufferLectura = null;

        try {
            bufferLectura = new BufferedReader(new FileReader(ruta));

            String linea = bufferLectura.readLine();

            while (linea != null) {
                String[] campos = linea.split(SEPARADOR);
                datosLeidos = new ArrayList<String>();
                for(String c: campos) {
                    datosLeidos.add(c);
                }
                lectura.add(datosLeidos);
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
        this.setLectura(lectura);
    }

    private void setLectura(ArrayList<ArrayList<String>> lectura) {
        this.lectura = lectura;
    }

    public ArrayList<ArrayList<String>> getLectura(){return this.lectura;}

}
