package carmenSandiego.modelo;

import datosDelJuego.LectorCsv;

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
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/ladrones.csv");
        datosLadrones = leerArchivo.getLectura();

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

    public List<Ladron> getLadrones(){
        return this.ladrones;
    }

}
