package carmenSandiego.modelo;

import java.util.ArrayList;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.ciudad.Ciudades;

public class Recorrido {
    private ArrayList<Ciudad> recorridoReal;
    private Ciudades ciudades;
    private int cantidadDeCiudadesSecundarias;

    public Recorrido(ObjetoRobado unObjetoRobado){
        this.ciudades = new Ciudades();
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
        removerCiudadOrigen(unObjetoRobado.getCiudadOrigen());       //Para que no se repita la ciudad de origen
        recorridoReal.add(unObjetoRobado.getCiudadOrigen());
        for (int i = 0; i < cantidadDePaises-1; i++){               //cantidadDePaises-1 pq ya agregué la primera manualmente
            Ciudad ciudadSiguiente = obtenerCiudadAleatoria();
            agregarCiudadAlRecorrido(ciudadSiguiente);
            recorridoReal.get(i).setCiudadSiguiente(ciudadSiguiente);
        }
        agregarCiudadesSecundarias(cantidadDePaises);
        recorridoReal.get(cantidadDePaises-1).setLadronUltimaCiudad();
    }

    private void removerCiudadOrigen(Ciudad ciudadOrigen) {
        for (int i = 0; i < ciudades.getCiudades().size(); i++){
            if (ciudadOrigen.getNombre().getCaracteristica().equals(ciudades.getCiudades().get(i).getNombre().getCaracteristica())){
                ciudades.getCiudades().remove(i);
            }
        }
    }

    public void agregarCiudadAlRecorrido(Ciudad nuevaCiudad){
        recorridoReal.add(nuevaCiudad);
    }

    private Ciudad obtenerCiudadAleatoria(){
        int valorAleatorio = (int)(Math.random()*ciudades.getCiudades().size());
        return ciudades.getCiudades().remove(valorAleatorio);
    }


    private void agregarCiudadesSecundarias(int cantidadDePaises) {
        for (int i = 0; i < cantidadDePaises; i++){   //Si quiero que la ultima no tenga ciudades secundarias, le resto 1 a cantidadDePaises
            agregarCiudadSecundaria(recorridoReal.get(i));
        }
    }

    private void agregarCiudadSecundaria(Ciudad ciudad){
        for (int i = 0; i < this.cantidadDeCiudadesSecundarias; i++) {
            Ciudad ciudadAleatoria = obtenerCiudadAleatoria();
            ciudad.agregarCiudadSecundaria(ciudadAleatoria);
            ciudadAleatoria.agregarCiudadSecundaria(ciudad);
        }
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
