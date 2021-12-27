package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Node;

public class BotonJugar implements EventHandler<ActionEvent> {
    private Button botonJugar;
    private Stage stage;
    private Scene proximaEscena;

    public BotonJugar(Button botonJugar, Stage stage, Scene proximaEscena) {
        this.botonJugar = botonJugar;
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        botonJugar.setText("JUGAR");
        botonJugar.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        botonJugar.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        botonJugar.setTextFill(Color.rgb(255, 150, 69));
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        String textoClickeado = "Me han clickeado";
        System.out.println(textoClickeado);
        this.stage.setScene(proximaEscena);
    }


}
