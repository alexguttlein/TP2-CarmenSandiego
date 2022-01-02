package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import edu.fiuba.algo3.vista.ContenedorVictoria;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonViajeAEdificio implements EventHandler<ActionEvent> {

    private Button boton;
    private Stage stage;
    private Edificio nuevoEdificio;
    private Jugador jugador;
    private Partida partida;

    public BotonViajeAEdificio(Button boton, Stage stage, Edificio nuevoEdificio, Jugador jugador, Partida partida) {
        this.boton = boton;
        this.stage = stage;
        this.nuevoEdificio = nuevoEdificio;
        this.jugador = jugador;
        this.partida = partida;
        boton.setText(nuevoEdificio.getNombre().getCaracteristica());
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        jugador.visitarEdificio(nuevoEdificio);
        String pista = nuevoEdificio.getPistaCompleta();
        ContenedorPrincipal nuevoContenedor = new ContenedorPrincipal(stage, partida);
        ControladorPrincipal controladorPrincipal = nuevoContenedor.getControladorPrincipal();
        controladorPrincipal.modificarText(pista);
        Scene nuevaEscena = new Scene(nuevoContenedor, 1280, 720);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}