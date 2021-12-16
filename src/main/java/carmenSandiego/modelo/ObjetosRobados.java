package carmenSandiego.modelo;

import datosDelJuego.LectorCsv;

import java.util.ArrayList;
import java.util.List;

public class ObjetosRobados {

    private ArrayList<ObjetoRobado> objetosRobados = new ArrayList<>();
    private Ciudades ciudades;

    public ObjetosRobados(Ciudades ciudades){
        this.setCiudades(ciudades);
        inicializarObjetosRobados();
    }

    private void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    private void inicializarObjetosRobados() {
        ArrayList<ArrayList<String>> datosObjetos;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/datosDelJuego/objetosRobados.csv");
        datosObjetos = leerArchivo.getLectura();

        for(ArrayList<String> objetoRobado: datosObjetos)
            crearObjetoRobado(objetoRobado);
    }

    private void crearObjetoRobado(ArrayList<String> datosObjetoRobado) {
        String nombre = datosObjetoRobado.get(0);
        Ciudad ciudadOrigen = determinarCiudadDeOrigen(datosObjetoRobado.get(1));
        String importancia = datosObjetoRobado.get(2);

        ObjetoRobado objetoRobado = new ObjetoRobado(nombre, ciudadOrigen, importancia);
        addObjetoRobado(objetoRobado);
    }

    private Ciudad determinarCiudadDeOrigen(String nombreCiudadOrigen) {
        for(Ciudad c: this.ciudades.getCiudades())
            if(nombreCiudadOrigen == c.getNombre())
                return c;
        return null;
    }

    private void addObjetoRobado(ObjetoRobado objetoRobado) {
        this.objetosRobados.add(objetoRobado);
    }

    public ArrayList<ObjetoRobado> getObjetosRobados(){
        return this.objetosRobados;
    }

}