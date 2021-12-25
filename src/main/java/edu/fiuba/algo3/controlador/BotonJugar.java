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

    public BotonJugar(Button botonJugar) {
        this.botonJugar = botonJugar;
        botonJugar.setText("JUGAR");
        botonJugar.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        botonJugar.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        botonJugar.setTextFill(Color.rgb(255, 150, 69));
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        String textoClickeado = "Me han clickeado";
        System.out.println(textoClickeado);
        this.botonJugar.setText(textoClickeado);
        StackPane layout = new StackPane();
        var escenaNueva = crearNuevaEscena(layout, 1280, 720);
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)eventoNuevo.getSource()).getScene().getWindow(); //Este
        //Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow(); //O este
        stageTheEventSourceNodeBelongs.setScene(escenaNueva);
    }

    public Scene crearNuevaEscena(StackPane layout, int ancho, int largo){
        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        var nuevaEscena = new Scene(layout, ancho, largo);
        return nuevaEscena;
    }
}
