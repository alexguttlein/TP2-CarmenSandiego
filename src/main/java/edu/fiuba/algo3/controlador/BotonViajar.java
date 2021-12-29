package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonViajar implements EventHandler<ActionEvent> {

    private Button botonJugar;
    private Stage stage;
    private Jugador jugador;
    private ContenedorJuego stackPane;
    private Partida partida;

    public BotonViajar(Button botonJugar, Stage stage, Jugador jugador, ContenedorJuego stackPane, Partida partida) {
        this.botonJugar = botonJugar;
        this.stage = stage;
        this.jugador = jugador;
        this.stackPane = stackPane;
        this.partida = partida;
        botonJugar.setText("Viajar");
        botonJugar.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        botonJugar.setTextFill(Color.rgb(255, 150, 69));
        botonJugar.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        String textoClickeado = "Me han clickeado";
        System.out.println(textoClickeado);
        VBox contenedorCiudades = new VBox();

        ArrayList<Ciudad> ciudadesDisponibles = jugador.getCiudadActual().getCiudadesDisponiblesParaViajar();
        if (jugador.getCiudadActual().getCiudadesDisponiblesParaViajar().size() == 3){
            Button boton1 = new Button();
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);

            Button boton2 = new Button();
            BotonViajeACiudad botonCiudad2 = new BotonViajeACiudad(boton2, stage, ciudadesDisponibles.get(1), jugador, partida);
            boton2.setOnAction(botonCiudad2);

            Button boton3 = new Button(ciudadesDisponibles.get(2).getNombre().getCaracteristica());
            BotonViajeACiudad botonCiudad3 = new BotonViajeACiudad(boton3, stage, ciudadesDisponibles.get(2), jugador, partida);
            boton3.setOnAction(botonCiudad3);

            contenedorCiudades.getChildren().addAll(boton1,boton2,boton3);
        }
        else{
            Button boton1 = new Button();
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);
            contenedorCiudades.getChildren().add(boton1);
        }

        Button boton = new Button();
        BotonRetroceder botonRetroceder = new BotonRetroceder(boton, stage, stage.getScene());
        boton.setOnAction(botonRetroceder);
        contenedorCiudades.getChildren().add(boton);

        StackPane nuevoStackPane = new StackPane(contenedorCiudades);
        contenedorCiudades.setAlignment(Pos.CENTER);
        contenedorCiudades.setSpacing(30);
        Scene nuevaEscena = new Scene(nuevoStackPane,1280,720);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
