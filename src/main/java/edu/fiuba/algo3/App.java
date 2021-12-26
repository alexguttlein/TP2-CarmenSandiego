package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonJugar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Dónde en el mundo está Carmen Sandiego?");
        //label.setTextFill(Color.rgb(255,255,255));
        //label.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40) );
        stage.setTitle("Juego Carmen Sandiego");

        StackPane layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));



        HBox contenedorImagenCarmenSandiego = new HBox();
        Image imagenFondo2 = new Image("file:src/main/java/edu.fiuba.algo3.modelo.datosDelJuego/ImagenFondo.png");
        //Image imagenFondo = new Image("https://styleworkscreative.com/wp-content/uploads/2018/09/Carmen-Sandiego-Logo-A.png",898,645,false, false);
        BackgroundSize backgroundSize = new BackgroundSize(1280, 720, false, false, false, false);
        BackgroundImage image = new BackgroundImage(imagenFondo2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, //CENTER para que se mueva, DEFAULT estática.
                backgroundSize);
        contenedorImagenCarmenSandiego.setBackground(new Background(image));


        Button button = new Button();
        BotonJugar botonJugar = new BotonJugar(button, stage);
        button.setOnAction(botonJugar);


        VBox contenedorBotonJugar = new VBox(button);
        contenedorBotonJugar.setSpacing(200);
        contenedorBotonJugar.setPadding(new Insets(10));
        contenedorBotonJugar.setTranslateX(550);
        contenedorBotonJugar.setTranslateY(360);


        layout.getChildren().add(contenedorImagenCarmenSandiego);
        layout.getChildren().add(contenedorBotonJugar);

        var scene = new Scene(layout, 1280, 720);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}