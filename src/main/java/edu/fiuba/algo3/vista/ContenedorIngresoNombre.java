package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorIngresoNombre extends StackPane {
    private Stage stage;

    public ContenedorIngresoNombre(Stage stage, Scene proximaEscena, TextField cuadroTexto){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Label textoIngreseNombre = new Label("Ingrese su nombre: ");
        textoIngreseNombre.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        textoIngreseNombre.setTextFill(Color.rgb(255, 150, 69));
        cuadroTexto.setPromptText("Ingrese su nombre: ");
        this.getChildren().add(cuadroTexto);
        this.getChildren().add(textoIngreseNombre);
        textoIngreseNombre.setTranslateY(-40);
    }
}
