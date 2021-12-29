package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class GeneradorRandom {

    private int valorAIgnorar;
    private List<Integer> listaGenerada = new ArrayList<Integer>();

    public GeneradorRandom(int size, int cantidad){
        this.valorAIgnorar = -1;
        this.seleccionadorAlAzar(size, cantidad);
    }

    public GeneradorRandom(int size, int cantidad, int valorAIgnorar){
        this.valorAIgnorar = valorAIgnorar;
        this.seleccionadorAlAzar(size, cantidad);
    }

    private void seleccionadorAlAzar(int size, int cantidad) {
        int numeroRandom;

        while (listaGenerada.size() < cantidad){
            numeroRandom = (int) (Math.random() * (size));
            if(!this.listaGenerada.contains(numeroRandom) && numeroRandom != this.valorAIgnorar)
                this.listaGenerada.add(numeroRandom);
        }
    }

    public List<Integer> getListaGenerada(){return this.listaGenerada;}
}
