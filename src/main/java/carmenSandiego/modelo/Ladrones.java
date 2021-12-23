package carmenSandiego.modelo;

import datosDelJuego.LectorCsv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladrones {
    private final ArrayList<Ladron> ladrones = new ArrayList<>();

    public Ladrones(){
        inicializarLadrones();
    }

    private void inicializarLadrones() {
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/ladrones.csv");
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
