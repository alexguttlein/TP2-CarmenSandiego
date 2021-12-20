package carmenSandiego.modelo;

public class Caracteristica {
    String caracteristica;

    public Caracteristica(String caracteristica){
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica(){return this.caracteristica;}

    public boolean compararCaracteristica(Caracteristica caracteristica){
        return this.caracteristica.equals(caracteristica.getCaracteristica());
    }
}
