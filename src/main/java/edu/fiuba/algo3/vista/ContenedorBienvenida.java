package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.BotonJugar;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorBienvenida extends StackPane{
    Stage stage;

    public ContenedorBienvenida(Stage stage, Scene proximaEscena){
        super();
        this.stage = stage;

        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        ImageView iview = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/ImagenFondo.png");

        Button button = new Button();
        BotonJugar botonJugar = new BotonJugar(button, stage, proximaEscena);
        button.setOnAction(botonJugar);

        this.getChildren().add(iview);
        this.getChildren().add(button);
        button.setTranslateY(20);

    }

}
