package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import edu.fiuba.algo3.vista.ContenedorVictoria;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorComputadora {
    Stage stage;
    Partida partida;
    Jugador jugador;
    Button buttonAceptar;
    Button buttonCancelar;

    public ControladorComputadora(Stage stage, Partida partida) {
        this.stage = stage;
        this.partida = partida;
        this.jugador = partida.getJugador();
    }

    public void setButtonAceptar(Button boton){
        this.buttonAceptar = boton;
        buttonAceptar.setOnAction(this::onClickAceptar);
    }

    public void setButtonCancelar(Button boton){
        this.buttonCancelar = boton;
        buttonCancelar.setOnAction(this::onClickCancelar);
    }

    private void onClickAceptar(ActionEvent event) {
        partida.getInterpol().emitirOrdenDeArresto();
        if (partida.getInterpol().atraparSospechoso() == true){
            ContenedorVictoria contenedorVictoria = new ContenedorVictoria(stage, partida);
            Scene nuevaEscena = new Scene(contenedorVictoria, 1280, 720);
            stage.setScene(nuevaEscena);
            stage.show();
        } else {
            ContenedorPrincipal nuevoContenedor = new ContenedorPrincipal(stage, partida);
            Scene nuevaEscena = new Scene(nuevoContenedor, 1280, 720);
            stage.setScene(nuevaEscena);
            stage.show();
        }
    }

    private void onClickCancelar(ActionEvent actionEvent) {
        ContenedorPrincipal nuevoContenedor = new ContenedorPrincipal(stage, partida);
        Scene nuevaEscena = new Scene(nuevoContenedor, 1280, 720);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
