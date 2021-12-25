package carmenSandiego.modelo.edificio;

import carmenSandiego.modelo.Caracteristica;
import carmenSandiego.modelo.Ladron;
import carmenSandiego.modelo.ciudad.Ciudad;
import carmenSandiego.modelo.jugador.rango.Rango;
import datosDelJuego.GeneradorRandom;

import java.util.List;

public class EdificioBanco extends Edificio {

    public EdificioBanco(Caracteristica nombreEdificio){
        super.setNombre(nombreEdificio);
    }

    public void setPista(Caracteristica dialogo, Caracteristica descripcion){
        carmenSandiego.modelo.pistas.Pista pista = new carmenSandiego.modelo.pistas.PistaBanco(dialogo, descripcion);
        super.setPista(pista);
    }

    @Override
    public void modificarPista(Ciudad ciudadSiguiente, Ladron ladron, Rango rangoPersonaje) {
        carmenSandiego.modelo.pistas.Pista pista = determinarTipoDePista(ciudadSiguiente, ladron, rangoPersonaje);
        super.setPista(pista);
    }

    private carmenSandiego.modelo.pistas.Pista determinarTipoDePista(Ciudad ciudad, Ladron ladron, Rango rangoDificultad){
        int dificultad = rangoDificultad.getArrestosParaAscender();
        GeneradorRandom generadorRandom = new GeneradorRandom(dificultad,1);
        List<Integer> listaGenerada = generadorRandom.getListaGenerada();
        int valorGenerado = listaGenerada.get(0);

        carmenSandiego.modelo.pistas.Pista pista;
        if(valorGenerado < (int)(dificultad/2)){ //modificar
            Caracteristica pistaDestino = new Caracteristica("Estuvo consultando la tasa de cambio para cambiar su moneda a " + ciudad.getMoneda().getCaracteristica() + ". ");
            Caracteristica pistaLadron = determinarPistaLadron(ladron);
            pista = new carmenSandiego.modelo.pistas.PistaAeropuerto(pistaDestino, pistaLadron);

        }
        else {
            Caracteristica dialogoMoneda = new Caracteristica("Estuvo consultando la tasa de cambio para cambiar su moneda a ");
            pista = new carmenSandiego.modelo.pistas.PistaAeropuerto(dialogoMoneda, ciudad.getMoneda());
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
