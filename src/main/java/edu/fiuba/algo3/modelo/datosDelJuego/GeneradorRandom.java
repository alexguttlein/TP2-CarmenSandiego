package edu.fiuba.algo3.modelo.datosDelJuego;

import java.util.ArrayList;
import java.util.List;

public class GeneradorRandom {

    private List<Integer> listaGenerada = new ArrayList<Integer>();

    public GeneradorRandom(int size, int cantidad){
        this.seleccionadorAlAzar(size, cantidad);
    }

    private void seleccionadorAlAzar(int size, int cantidad) {
        int numeroRandom;

        while (listaGenerada.size() < cantidad){
            numeroRandom = (int) (Math.random() * (size));
            if(!this.listaGenerada.contains(numeroRandom))
                this.listaGenerada.add(numeroRandom);
        }
    }

    public List<Integer> getListaGenerada(){return this.listaGenerada;}
}
