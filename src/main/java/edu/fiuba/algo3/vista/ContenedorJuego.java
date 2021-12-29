package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguiente;
import edu.fiuba.algo3.controlador.BotonViajar;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorJuego extends StackPane {
    private Stage stage;
    private Partida partida;
    private Jugador jugador;

    public ContenedorJuego(Stage stage, Partida partida, Jugador jugador){
        this.stage = stage;
        this.partida = partida;
        this.jugador = jugador;
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //ContenedorDescripcionCiudad descripcionCiudad = new ContenedorDescripcionCiudad();
        ContenedorReloj contenedorReloj = new ContenedorReloj(partida.getTiempo());

        Button boton1 = new Button();
        BotonViajar botonViajar = new BotonViajar(boton1, stage, jugador, this, partida);
        boton1.setOnAction(botonViajar);

        this.getChildren().add(contenedorReloj);
        contenedorReloj.setSpacing(10);
        contenedorReloj.setTranslateY(10);
        contenedorReloj.setTranslateX(50);

        this.getChildren().add(boton1);
    }
}
