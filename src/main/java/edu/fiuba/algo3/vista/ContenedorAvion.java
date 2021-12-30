package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonViajeACiudad;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorAvion extends AnchorPane {
    AnchorPane anchorPane;
    Stage stage;
    Jugador jugador;
    Partida partida;

    public ContenedorAvion(AnchorPane anchorPane, Stage stage, Partida partida) {
        this.anchorPane = anchorPane;
        this.stage = stage;
        this.partida = partida;
        this.jugador = partida.getJugador();
        modelar();
    }

    public void modelar(){
        anchorPane.getChildren().clear();
        ArrayList<Ciudad> ciudadesDisponibles = jugador.getCiudadActual().getCiudadesDisponiblesParaViajar();
        Font font = Font.font("Copperplate Gothic Bold", 30);

        VBox contenedorCiudades = new VBox();
        contenedorCiudades.setStyle("-fx-pref-width: 800; -fx-pref-height: 600; -fx-background-color: #34495E; -fx-background-radius: 15");
        if (jugador.getCiudadActual().getCiudadesDisponiblesParaViajar().size() == 3){
            Button boton1 = new Button();
            boton1.setStyle("-fx-pref-width: 300; -fx-pref-height: 70;-fx-background-color: #E74C3C; -fx-background-radius: 15");
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);
            boton1.setFont(font);

            Button boton2 = new Button();
            boton2.setStyle("-fx-pref-width: 300; -fx-pref-height: 70;-fx-background-color: #E74C3C; -fx-background-radius: 15");
            BotonViajeACiudad botonCiudad2 = new BotonViajeACiudad(boton2, stage, ciudadesDisponibles.get(1), jugador, partida);
            boton2.setOnAction(botonCiudad2);
            boton2.setFont(font);

            Button boton3 = new Button();
            boton3.setStyle("-fx-pref-width: 300; -fx-pref-height: 70;-fx-background-color: #E74C3C; -fx-background-radius: 15");
            BotonViajeACiudad botonCiudad3 = new BotonViajeACiudad(boton3, stage, ciudadesDisponibles.get(2), jugador, partida);
            boton3.setOnAction(botonCiudad3);
            boton3.setFont(font);

            contenedorCiudades.setMargin(boton1, new Insets(30,0,15,0));
            contenedorCiudades.setMargin(boton2, new Insets(15,0,15,0));
            contenedorCiudades.setMargin(boton3, new Insets(15,0,30,0));
            contenedorCiudades.getChildren().addAll(boton1,boton2,boton3);
        }
        else {
            Button boton1 = new Button();
            boton1.setStyle("-fx-pref-width: 300; -fx-pref-height: 70;-fx-background-color: #E74C3C; -fx-background-radius: 15");
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);
            boton1.setFont(font);

            contenedorCiudades.setMargin(boton1, new Insets(30,0,15,0));
            contenedorCiudades.getChildren().add(boton1);
        }

        AnchorPane.setTopAnchor(contenedorCiudades, 100.0);
        AnchorPane.setBottomAnchor(contenedorCiudades, 100.0);
        AnchorPane.setRightAnchor(contenedorCiudades, 250.0);
        AnchorPane.setLeftAnchor(contenedorCiudades, 250.0);
        anchorPane.getChildren().add(contenedorCiudades);
    }
}
