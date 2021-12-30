package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonViajeAEdificio;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorLupa extends AnchorPane {
    AnchorPane anchorPane;
    Stage stage;
    Jugador jugador;
    Partida partida;

    public ContenedorLupa(AnchorPane anchorPane, Stage stage, Partida partida) {
        this.anchorPane = anchorPane;
        this.stage = stage;
        this.partida = partida;
        this.jugador = partida.getJugador();
        modelar();
    }

    public void modelar(){
        anchorPane.getChildren().clear();
        ArrayList<Edificio> edificiosDisponibles = jugador.getCiudadActual().getEdificios();
        Font font = Font.font("Copperplate Gothic Bold", 30);

        VBox contenedorEdificios = new VBox();
        contenedorEdificios.setStyle("-fx-pref-width: 800; -fx-pref-height: 600; -fx-background-color: #34495E; -fx-background-radius: 15");

        Button boton1 = new Button();
        boton1.setStyle("-fx-pref-width: 300; -fx-pref-height: 70;-fx-background-color: #E74C3C; -fx-background-radius: 15");
        BotonViajeAEdificio botonEdificio1 = new BotonViajeAEdificio(boton1, stage, edificiosDisponibles.get(0), jugador, partida);
        boton1.setOnAction(botonEdificio1);
        boton1.setFont(font);

        Button boton2 = new Button();
        boton2.setStyle("-fx-pref-width: 300; -fx-pref-height: 70; -fx-background-color: #E74C3C; -fx-background-radius: 15");
        BotonViajeAEdificio botonEdificio2 = new BotonViajeAEdificio(boton2, stage, edificiosDisponibles.get(1), jugador, partida);
        boton2.setOnAction(botonEdificio2);
        boton2.setFont(font);

        Button boton3 = new Button();
        boton3.setStyle("-fx-pref-width: 300; -fx-pref-height: 70; -fx-background-color: #E74C3C; -fx-background-radius: 15");
        BotonViajeAEdificio botonEdificio3 = new BotonViajeAEdificio(boton3, stage, edificiosDisponibles.get(2), jugador, partida);
        boton3.setOnAction(botonEdificio3);
        boton3.setFont(font);

        VBox.setMargin(boton1, new Insets(30,0,15,0));
        VBox.setMargin(boton2, new Insets(15,0,15,0));
        VBox.setMargin(boton3, new Insets(15,0,30,0));
        contenedorEdificios.getChildren().addAll(boton1, boton2, boton3);
        AnchorPane.setTopAnchor(contenedorEdificios, 100.0);
        AnchorPane.setBottomAnchor(contenedorEdificios, 100.0);
        AnchorPane.setRightAnchor(contenedorEdificios, 250.0);
        AnchorPane.setLeftAnchor(contenedorEdificios, 250.0);
        anchorPane.getChildren().add(contenedorEdificios);
    }
}
