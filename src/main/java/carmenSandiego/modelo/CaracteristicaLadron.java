package carmenSandiego.modelo;

public class CaracteristicaLadron {
    String caracteristica;

    public CaracteristicaLadron(String caracteristica){
        this.caracteristica = caracteristica;
    }

    public boolean comparar(CaracteristicaLadron otraCaracteristica){
       return otraCaracteristica.serComparada(caracteristica);
    }

    private boolean serComparada(String otraCaracteristica){
        return caracteristica.equals(otraCaracteristica);
    }

    public void mostrar(){
        System.out.println(caracteristica);
    }

    public boolean compararSospechoso(CaracteristicaLadron otraCaracteristica) {
        return otraCaracteristica.serComparadaSospechoso(caracteristica);
    }

    private boolean serComparadaSospechoso(String otraCaracteristica) {
        if (otraCaracteristica.equals("") || this.caracteristica.equals(""))
            return true;
        return this.caracteristica.equals(otraCaracteristica);
    }
}
