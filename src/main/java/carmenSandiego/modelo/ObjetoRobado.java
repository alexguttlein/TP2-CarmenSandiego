package carmenSandiego.modelo;

import carmenSandiego.modelo.ciudad.Ciudad;

public class ObjetoRobado {
    Caracteristica nombre;
    Ciudad ciudadOrigen;
    Caracteristica importancia;
    /*
    Capaz es mejor pasar importancia a una interfaz y crear las 3 categorias que hay como clases hijas
    y q tenga como atributo la cant de vuelos q puede realizar el ladron (en nuestro modelo, la cantidad
    de ciudades q pasa el ladron)
    Beneficio: omitimos el hardcodeo del tamanio del array
    Desventaja: es importante el orden de la creacion de los objetos
        Habra if sin importar como lo hagamos (o al menos no se me ocurrio una buena solucion):
            -Si no tenemos la clase importacion, tendriamos que hacer if esValioso -> 4 ciudades
            -Si lo tenemos a la clase, if en la creacion del ObjetoRobado if (dato == "valioso") -> 4 ciudades
     */

    public ObjetoRobado(Caracteristica nombre, Ciudad ciudadOrigen, Caracteristica importancia){
        this.nombre = nombre;
        this.ciudadOrigen = ciudadOrigen;
        this.importancia = importancia;
        /*
        Aca nose si es mejor pasarle como parametro instancias de Caracterista o directamente string
        y hacerlo como ladron q la crean dentro del constructor de ObjetoRobado. Porque de esta manera
        tendriamos que instanciar con anterioridad cada atributo
         */
    }

    public Caracteristica getNombre(){return this.nombre;}
    public Ciudad getCiudadOrigen(){return this.ciudadOrigen;}
    public Caracteristica getImportancia(){return this.importancia;}

    public boolean compararObjetoRobado(ObjetoRobado objetoRobado){
        boolean equalNombre = nombre.getCaracteristica() == objetoRobado.getNombre().getCaracteristica();
        boolean equalImportancia = importancia.getCaracteristica() == objetoRobado.getImportancia().getCaracteristica();
        boolean equalCiudad = ciudadOrigen.getNombre() == objetoRobado.getCiudadOrigen().getNombre(); //falta comparador de ciudades

        return equalNombre && equalImportancia && equalCiudad;
        /*
        No entiendo para que necesitariamos comparar los objetos.
        Las pruebas unitarias deberian ser unicamente para probar funcionalidades, q esta clase no tiene por ahora
        Yo creo q tener metodos solo para saber q la clase se creo correctamente es al pedo
        Nisiquiera tendriamos que testear getters y setters
         */
    }

}
