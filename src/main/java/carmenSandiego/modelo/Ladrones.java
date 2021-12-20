package carmenSandiego.modelo;

import datosDelJuego.LectorCsv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladrones {
    private ArrayList<Ladron> ladrones = new ArrayList<>();

    public Ladrones(){
        inicializarLadrones();
    }

    private void inicializarLadrones() {
        ArrayList<ArrayList<String>> datosLadrones;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/ladrones.csv");
        datosLadrones = leerArchivo.getLectura();

        for(ArrayList<String> ladron: datosLadrones) {
            crearLadron(ladron);
        }
    }

    private void crearLadron(ArrayList<String> datosLadron){
        ArrayList datos = new ArrayList<>(Arrays.asList());
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

    public void mostrar(){
        for (Ladron ladronActual : ladrones){
            ladronActual.mostrarDetallesLadron();
            //System.out.println("\n");
        }
    }

}
