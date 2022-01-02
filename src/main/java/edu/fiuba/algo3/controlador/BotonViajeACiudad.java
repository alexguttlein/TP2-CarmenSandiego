package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonViajeACiudad implements EventHandler<ActionEvent> {

    private Button boton;
    private Stage stage;
    private Ciudad nuevaCiudad;
    private Jugador jugador;
    private Partida partida;

    public BotonViajeACiudad(Button boton, Stage stage, Ciudad nuevaCiudad, Jugador jugador, Partida partida) {
        this.boton = boton;
        this.stage = stage;
        this.nuevaCiudad = nuevaCiudad;
        this.jugador = jugador;
        this.partida = partida;
        boton.setText(nuevaCiudad.getNombre().getCaracteristica());
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        String texto2 = jugador.serAtacado();
        jugador.viajar(nuevaCiudad);
        String texto = "Piloto: \nMision Completa! \nHemos descendido con exito a " + jugador.getCiudadActual().getNombre().getCaracteristica() + ". ";
        ContenedorPrincipal nuevoContenedor = new ContenedorPrincipal(stage, partida);
        ControladorPrincipal controladorPrincipal = nuevoContenedor.getControladorPrincipal();
        controladorPrincipal.modificarText(texto + texto2);
        Scene nuevaEscena = new Scene(nuevoContenedor, 1280, 720);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}