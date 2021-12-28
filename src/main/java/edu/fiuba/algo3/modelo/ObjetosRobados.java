package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.rango.RangoDetective;
import edu.fiuba.algo3.modelo.jugador.rango.RangoInvestigador;
import edu.fiuba.algo3.modelo.jugador.rango.RangoNovato;

import java.util.ArrayList;
import java.util.List;

public class ObjetosRobados {

    private ArrayList<ObjetoRobado> objetosRobados = new ArrayList<>();
    private Ciudades ciudades;
    private ArrayList<ObjetoRobado> objetosComunes = new ArrayList<>();
    private ArrayList<ObjetoRobado> objetosImportantes = new ArrayList<>();
    private ArrayList<ObjetoRobado> objetosMuyImportantes = new ArrayList<>();

    public ObjetosRobados(Ciudades ciudades){
        this.ciudades = ciudades;
        inicializarObjetosRobados();
    }

    private void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    private void inicializarObjetosRobados() {
        ArrayList<ArrayList<String>> datosObjetos;
        LectorCsv leerArchivo = new LectorCsv("src/main/java/edu/fiuba/algo3/datosDelJuego/objetosRobados.csv");
        datosObjetos = leerArchivo.getLectura();

        for(ArrayList<String> objetoRobado: datosObjetos)
            crearObjetoRobado(objetoRobado);
    }

    private void crearObjetoRobado(ArrayList<String> datosObjetoRobado) {
        Caracteristica nombre = new Caracteristica(datosObjetoRobado.get(0));
        Ciudad ciudadOrigen = determinarCiudadDeOrigen(new Caracteristica(datosObjetoRobado.get(1)));
        Caracteristica importancia = new Caracteristica(datosObjetoRobado.get(2));

        ObjetoRobado objetoRobado = new ObjetoRobado(nombre, ciudadOrigen, importancia);
        addObjetoRobado(objetoRobado);
    }

    private Ciudad determinarCiudadDeOrigen(Caracteristica nombreCiudadOrigen) {
        for(Ciudad c: this.ciudades.getCiudades())
            if(nombreCiudadOrigen.compararCaracteristica(c.getNombre()))
                return c;
        return null;
    }

    private void addObjetoRobado(ObjetoRobado objetoRobado) {
        this.objetosRobados.add(objetoRobado);
        if(objetoRobado.getImportancia().compararCaracteristica(new Caracteristica("Comun")))
            this.objetosComunes.add(objetoRobado);
        else if(objetoRobado.getImportancia().compararCaracteristica(new Caracteristica("Importante")))
            this.objetosImportantes.add(objetoRobado);
        else this.objetosMuyImportantes.add(objetoRobado);
    }

    public ArrayList<ObjetoRobado> getObjetosRobados(){
        return this.objetosRobados;
    }
    public ArrayList<ObjetoRobado> getObjetosComunes(){
        return this.objetosComunes;
    }
    public ArrayList<ObjetoRobado> getObjetosImportantes(){
        return this.objetosImportantes;
    }
    public ArrayList<ObjetoRobado> getObjetosMuyImportantes(){
        return this.objetosMuyImportantes;
    }

    public ObjetoRobado seleccionarObjetoRobadoAleatorio(Jugador jugador){
        ArrayList<ObjetoRobado> listaObjetosRobados;
        //si el rango del jugador es novato, el objeto tiene que ser comun
        //si el rango del jugador es detective el objeto tiene que ser importante
        //si el rango del jugador es sargento o investigador, el objeto tiene que ser muy importante
        if(jugador.getRango().compararRangos(new RangoNovato(0)))
            listaObjetosRobados = this.getObjetosComunes();
        else if(jugador.getRango().compararRangos(new RangoDetective(5)))
            listaObjetosRobados = this.getObjetosImportantes();
        else listaObjetosRobados = this.getObjetosMuyImportantes();

        GeneradorRandom generadorRandom = new GeneradorRandom(listaObjetosRobados.size(), 1);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();

        ObjetoRobado objeto = listaObjetosRobados.get(listaGenerada.get(0));
        return objeto;
    }

}
