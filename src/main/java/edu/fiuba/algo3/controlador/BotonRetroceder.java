package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonRetroceder implements EventHandler<ActionEvent> {

    private Button boton;
    private Stage stage;
    private Scene escenaAnterior;

    public BotonRetroceder(Button boton, Stage stage, Scene escenaAnterior) {
        this.boton = boton;
        this.stage = stage;
        this.escenaAnterior = escenaAnterior;
        boton.setText("Retroceder");
        boton.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        boton.setTextFill(Color.rgb(255, 150, 69));
        boton.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        System.out.println("Me han clickeado");
        stage.setScene(escenaAnterior);
        stage.show();
    }
}
