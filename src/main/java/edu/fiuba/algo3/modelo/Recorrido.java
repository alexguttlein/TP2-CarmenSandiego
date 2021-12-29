package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;

public class Recorrido {
    private ArrayList<Ciudad> recorridoReal;
    private Ciudades ciudades;
    private int cantidadDeCiudadesSecundarias;

    public Recorrido(ObjetoRobado unObjetoRobado, Ciudades ciudades){
        this.ciudades = ciudades;
        this.recorridoReal = new ArrayList<Ciudad>();
        this.cantidadDeCiudadesSecundarias = 2; //Fijarse si alcanza para 3 por ciudad principal (cantCiudadPpal*cantCiudadesSec+cantCiudadPpal)
        crearRecorrido(unObjetoRobado);
    }

    public void crearRecorrido(ObjetoRobado unObjetoRobado){
        if (unObjetoRobado.getImportancia().getCaracteristica().equals("Comun")){
            inicializarRecorrido(4, unObjetoRobado);
        }
        else if (unObjetoRobado.getImportancia().getCaracteristica().equals("Importante")){
            inicializarRecorrido(5, unObjetoRobado);
        }
        else{  //"Muy importante"
            inicializarRecorrido(7, unObjetoRobado);
        }
    }

    public void inicializarRecorrido(int cantidadDePaises, ObjetoRobado unObjetoRobado){
        int index = this.ciudades.obtenerIndiceDeCiudad(unObjetoRobado.getCiudadOrigen());
        GeneradorRandom random = new GeneradorRandom(this.ciudades.getCiudades().size(), cantidadDePaises-1, index);
        List<Integer> listaGenerada = random.getListaGenerada(); //se genera lista de ciudades aleatorias sin la de origen

        //removerCiudadOrigen(unObjetoRobado.getCiudadOrigen());       //Para que no se repita la ciudad de origen
        //recorridoReal.add(unObjetoRobado.getCiudadOrigen());

        agregarCiudadAlRecorrido(unObjetoRobado.getCiudadOrigen());

        for(int i = 0; i < cantidadDePaises-1; i++){
            Ciudad ciudadSiguiente = this.ciudades.getCiudades().get( listaGenerada.get(i) );
            agregarCiudadAlRecorrido(ciudadSiguiente);
            recorridoReal.get(i).setCiudadSiguiente(ciudadSiguiente);
        }

/*
        for (int i = 0; i < cantidadDePaises-1; i++){               //cantidadDePaises-1 pq ya agregué la primera manualmente
            Ciudad ciudadSiguiente = obtenerCiudadAleatoria();
            agregarCiudadAlRecorrido(ciudadSiguiente);
            recorridoReal.get(i).setCiudadSiguiente(ciudadSiguiente);
        }
 */
        //agregarCiudadesSecundarias(cantidadDePaises);
        recorridoReal.get(cantidadDePaises-1).setLadronUltimaCiudad();
    }


/*
    private void removerCiudadOrigen(Ciudad ciudadOrigen) {
        for (int i = 0; i < ciudades.getCiudades().size(); i++){
            if (ciudadOrigen.getNombre().getCaracteristica().equals(ciudades.getCiudades().get(i).getNombre().getCaracteristica())){
                ciudades.getCiudades().remove(i);
            }
        }
    }
*/
    public void agregarCiudadAlRecorrido(Ciudad nuevaCiudad){
        this.recorridoReal.add(nuevaCiudad);
    }
/*
    private Ciudad obtenerCiudadAleatoria(){
        int valorAleatorio = (int)(Math.random()*ciudades.getCiudades().size());
        return ciudades.getCiudades().remove(valorAleatorio);
    }
*/

    private void agregarCiudadesSecundarias() {
        for (int i = 0; i < this.ciudades.getCiudades().size(); i++){
            agregarCiudadSecundaria(this.ciudades.getCiudades().get(i), i);
        }
    }

    private void agregarCiudadSecundaria(Ciudad ciudad, int indiceCiudad){
        //int index = obtenerIndiceDeCiudad(ciudad);
        GeneradorRandom generadorRandom = new GeneradorRandom(this.ciudades.getCiudades().size(), this.cantidadDeCiudadesSecundarias, indiceCiudad);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();

        for (int i = 0; i < this.cantidadDeCiudadesSecundarias; i++){
            Ciudad ciudadAleatoria = this.ciudades.getCiudades().get( listaGenerada.get(i) );
            ciudad.agregarCiudadSecundaria(ciudadAleatoria);
        }

        /*for (int i = 0; i < this.cantidadDeCiudadesSecundarias; i++) {
            Ciudad ciudadAleatoria = obtenerCiudadAleatoria();
            ciudad.agregarCiudadSecundaria(ciudadAleatoria);
            ciudadAleatoria.agregarCiudadSecundaria(ciudad);
        }
         */
    }

    public ArrayList<Ciudad> getRecorridoReal(){
        return this.recorridoReal;
    }

    //Recorrido tiene un arreglo donde se setean las ciudades principales y se conectan entre ellas,
    //luego va agregando a cada ciudad principal una cantidad de ciudades secundarias, donde el ladron
    //no estuvo (la ultima ciudad tambien tiene ciudades secundarias aunque no las necesitaria, pero eso
    // se puede cambiar donde está comentado)



    /*
    private void agregarCiudadesSecundarias(int cantidadDePaises) {
        Ciudad primeraCiudad = recorridoReal.get(0);
        agregarCiudadSecundaria(primeraCiudad, 3);
        for (int i = 1; i < cantidadDePaises-1; i++){
            agregarCiudadSecundaria(recorridoReal.get(i),2);
        }
    }

        private void agregarCiudadSecundaria(Ciudad ciudad, int cantidadCiudadesSecundarias){
        for (int i = 0; i < cantidadCiudadesSecundarias; i++) {
            Ciudad ciudadAleatoria = obtenerCiudadAleatoria();
            ciudad.agregarCiudadSecundaria(ciudadAleatoria);
            ciudadAleatoria.agregarCiudadSecundaria(ciudad);
        }
    }
     */
}
