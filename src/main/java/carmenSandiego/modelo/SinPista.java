package carmenSandiego.modelo;

public class SinPista implements ComportamientoPistas{//ver que no sea una clase anemica
    private boolean estado;

    public SinPista(){
        estado=false;
    }
    public void mostrarPistas(String sinPista){
        System.out.println("Disculpa no lo vimos por aca");
    }
    public String getPista(String pista) {
        return pista;
    }
    public boolean tienePista(){
        return estado;
    }
}
