package carmenSandiego.modelo;

public class ConPista implements ComportamientoPistas{
    private boolean estado;

    public ConPista(){
        estado=true;
    }
    public void mostrarPistas(String pista){
        System.out.println(" " + pista);
    }
    public String getPista(String pista) {
        return pista;
    }
    public boolean tienePista(){
        return estado;
    }
}
