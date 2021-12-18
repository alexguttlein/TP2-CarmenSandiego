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

    public boolean compararObjetoRobado(ObjetoRobado objetoRobado){
        boolean nombre = this.nombre.getCaracteristica() == objetoRobado.getNombre().getCaracteristica();
        boolean importancia = this.importancia.getCaracteristica() == objetoRobado.getImportancia().getCaracteristica();
        boolean ciudad = this.ciudadOrigen.getNombre() == objetoRobado.getCiudadOrigen().getNombre(); //falta comparador de ciudades

        return nombre && importancia && ciudad;
    }

}
