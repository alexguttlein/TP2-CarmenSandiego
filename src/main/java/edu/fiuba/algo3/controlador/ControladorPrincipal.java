package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorAvion;
import edu.fiuba.algo3.vista.ContenedorComputadora;
import edu.fiuba.algo3.vista.ContenedorLupa;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControladorPrincipal {
    Stage stage;
    HBox hBox;
    AnchorPane paneSupIzq;
    AnchorPane paneInfDer;
    AnchorPane paneSupDer;
    AnchorPane paneInfIzq;
    Partida partida;
    Jugador jugador;

    public ControladorPrincipal(Stage stage, Partida partida){
        this.stage = stage;
        this.partida = partida;
        jugador = partida.getJugador();
    }

    public void modificarText(String texto) {
        Label labelPista = (Label)paneInfIzq.getChildren().get(1);
        labelPista.setText(texto);
    }

    public void setHBox(HBox hBox){
        this.hBox = hBox;
        Button buttonLupa = (Button)(hBox.getChildren().get(0));
        buttonLupa.setOnAction(this::onClickLupa);
        Button buttonViaje = (Button)(hBox.getChildren().get(1));
        buttonViaje.setOnAction(this::onClickAvion);
        Button buttonComputadora = (Button)(hBox.getChildren().get(2));
        buttonComputadora.setOnAction(this::onClickComputadora);
    }

    public void setPaneSupIzq(AnchorPane pane){
        this.paneSupIzq = pane;
        actualizarRelojYUbicacion();
    }

    private void actualizarRelojYUbicacion(){
        Tiempo reloj = partida.getTiempo();
        Ciudad ciudadActual = jugador.getCiudadActual();
        Label labelLugar = (Label)(paneSupIzq.getChildren().get(0));
        Label labelHorario = (Label)(paneSupIzq.getChildren().get(1));
        ControladorReloj controladorReloj = new ControladorReloj(reloj, ciudadActual, labelLugar, labelHorario);
    }

    public void setPaneInfDer(AnchorPane pane){
        this.paneInfDer = pane;
        actualizarTiempoRestanta();
    }

    private void actualizarTiempoRestanta(){
        Tiempo reloj = partida.getTiempo();
        Label labelHorario = (Label)(paneInfDer.getChildren().get(1));
        ControladorReloj controladorReloj = new ControladorReloj(reloj, labelHorario);
    }

    public void setPaneSupDer(AnchorPane pane){
        this.paneSupDer = pane;
    }

    public void setPaneInfIzq(AnchorPane pane){
        this.paneInfIzq = pane;
    }

    public void onClickLupa(ActionEvent event){
        ContenedorLupa contenedorLupa = new ContenedorLupa(paneSupDer, stage, partida);
    }

    public void onClickAvion(ActionEvent event){
        ContenedorAvion contenedorAvion = new ContenedorAvion(paneSupDer, stage, partida);
    }

    public void onClickComputadora(ActionEvent event){
        ContenedorComputadora contenedorComputadora = new ContenedorComputadora(paneSupDer, stage, partida);
    }
}