package carmenSandiego.modelo;

import carmenSandiego.modelo.ciudad.Ciudad;

public class ObjetoRobado {
    Caracteristica nombre;
    Ciudad ciudadOrigen;
    Caracteristica importancia;

    public ObjetoRobado(Caracteristica nombre, Ciudad ciudadOrigen, Caracteristica importancia){
        this.nombre = nombre;
        this.ciudadOrigen = ciudadOrigen;
        this.importancia = importancia;
    }

    public Caracteristica getNombre(){return this.nombre;}
    public Ciudad getCiudadOrigen(){return this.ciudadOrigen;}
    public Caracteristica getImportancia(){return this.importancia;}

}