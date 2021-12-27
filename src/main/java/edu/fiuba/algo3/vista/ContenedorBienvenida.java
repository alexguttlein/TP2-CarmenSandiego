package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.BotonJugar;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorBienvenida extends HBox{
    Stage stage;

    public ContenedorBienvenida(Stage stage, Scene proximaEscena){
        super();
        this.stage = stage;

        Image imagenFondo2 = new Image("file:src/main/java/edu/fiuba/algo3/datosDelJuego/ImagenFondo.png");
        //Image imagenFondo = new Image("https://styleworkscreative.com/wp-content/uploads/2018/09/Carmen-Sandiego-Logo-A.png",898,645,false, false);
        BackgroundSize backgroundSize = new BackgroundSize(1280, 720, false, false, false, false);
        BackgroundImage image = new BackgroundImage(imagenFondo2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, //CENTER para que se mueva, DEFAULT estática.
                backgroundSize);
        this.setBackground(new Background(image));


        Button button = new Button();
        BotonJugar botonJugar = new BotonJugar(button, stage, proximaEscena);
        button.setOnAction(botonJugar);

        Button button2 = new Button();
        BotonJugar botonJugar2 = new BotonJugar(button2, stage, proximaEscena);
        button2.setOnAction(botonJugar2);

        VBox contenedorBotonJugar = new VBox(button, button2);
        contenedorBotonJugar.setSpacing(200);
        contenedorBotonJugar.setPadding(new Insets(10));
        contenedorBotonJugar.setTranslateX(550);
        contenedorBotonJugar.setTranslateY(360);

        this.getChildren().add(contenedorBotonJugar);

    }

}
