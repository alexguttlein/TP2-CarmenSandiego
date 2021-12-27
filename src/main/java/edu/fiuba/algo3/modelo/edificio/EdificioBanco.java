package edu.fiuba.algo3.modelo.edificio;



import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.GeneradorRandom;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.Pista;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaAeropuerto;
import edu.fiuba.algo3.modelo.edificio.comportamiento.pistas.PistaBanco;
import edu.fiuba.algo3.modelo.jugador.rango.Rango;

import java.util.List;

public class EdificioBanco extends Edificio {

    public EdificioBanco(Caracteristica nombreEdificio){
        super.setNombre(nombreEdificio);
    }

    public void setPista(Caracteristica dialogo, Caracteristica descripcion){
        Pista pista = new PistaBanco(dialogo, descripcion);
        super.setPista(pista);
    }

    @Override
    public void modificarPista(Ciudad ciudadSiguiente, Ladron ladron, Rango rangoPersonaje) {
        Pista pista = determinarTipoDePista(ciudadSiguiente, ladron, rangoPersonaje);
        super.setPista(pista);
    }

    private Pista determinarTipoDePista(Ciudad ciudad, Ladron ladron, Rango rangoDificultad){
        int dificultad = rangoDificultad.getArrestosParaAscender();
        GeneradorRandom generadorRandom = new GeneradorRandom(dificultad,1);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();
        int valorGenerado = listaGenerada.get(0);

        Pista pista;
        if(valorGenerado < (int)(dificultad/2)){ //modificar
            Caracteristica pistaDestino = new Caracteristica("Estuvo consultando la tasa de cambio para cambiar su moneda a " + ciudad.getMoneda().getCaracteristica() + ". ");
            Caracteristica pistaLadron = determinarPistaLadron(ladron);
            pista = new PistaAeropuerto(pistaDestino, pistaLadron);

        }
        else {
            Caracteristica dialogoMoneda = new Caracteristica("Estuvo consultando la tasa de cambio para cambiar su moneda a ");
            pista = new PistaAeropuerto(dialogoMoneda, ciudad.getMoneda());
        }
        return pista;
    }

    private Caracteristica determinarPistaLadron(Ladron ladron) {
        GeneradorRandom generadorRandom = new GeneradorRandom(5, 1);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();
        int valor = listaGenerada.get(0);

        Caracteristica pistaLadron;

        switch (valor){
            case 0:
                pistaLadron = new Caracteristica("Era una persona de genero " + ladron.getGenero().getCaracteristica());
                break;
            case 1:
                pistaLadron = new Caracteristica("Se paso todo el tiempo hablando de " + ladron.getHobby().getCaracteristica());
                break;
            case 2:
                pistaLadron = new Caracteristica("Tenia cabello " + ladron.getCabello().getCaracteristica());
                break;
            case 3:
                pistaLadron = new Caracteristica("No pude dejar de ver su " + ladron.getSenia().getCaracteristica());
                break;
            default:
                pistaLadron = new Caracteristica("Dejo estacionado su " + ladron.getVehiculo().getCaracteristica() + " en la entrada.");
                break;
        }
        return pistaLadron;
    }
}
