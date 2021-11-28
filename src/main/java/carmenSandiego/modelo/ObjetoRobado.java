package carmenSandiego.modelo;

public class ObjetoRobado {
    Ciudad ciudadOrigen;
    String importancia;

    public ObjetoRobado(Ciudad ciudadOrigen, String importancia){
        this.ciudadOrigen = ciudadOrigen;
        this.importancia = importancia;
    }

    public Ciudad getCiudadOrigen(){return this.ciudadOrigen;}

    public String getImportancia(){return this.importancia;}

}
