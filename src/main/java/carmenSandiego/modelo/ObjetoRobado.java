package carmenSandiego.modelo;

public class ObjetoRobado {
    String nombre;
    Ciudad ciudadOrigen;
    String importancia;

    public ObjetoRobado(String nombre, Ciudad ciudadOrigen, String importancia){
        this.nombre = nombre;
        this.ciudadOrigen = ciudadOrigen;
        this.importancia = importancia;
    }

    public String getNombre(){return this.nombre;}

    public Ciudad getCiudadOrigen(){return this.ciudadOrigen;}

    public String getImportancia(){return this.importancia;}

}
