package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorComputadora;
import edu.fiuba.algo3.controlador.LabelEleccion;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

import static javafx.geometry.VPos.CENTER;

public class ContenedorComputadora extends AnchorPane {
    AnchorPane anchorPane;
    Stage stage;
    Jugador jugador;
    Partida partida;
    ControladorComputadora controladorComputadora;

    public ContenedorComputadora(AnchorPane anchorPane, Stage stage, Partida partida) {
        this.anchorPane = anchorPane;
        this.stage = stage;
        this.partida = partida;
        this.controladorComputadora = new ControladorComputadora(stage, partida);
        modelar();
    }

    private void modelar(){
        anchorPane.getChildren().clear();
        modelarBoton();
        modelarGrid();
    }

    private void modelarBoton() {
        Font font = Font.font("Copperplate Gothic Bold", 20);

        Button buttonAceptar = new Button("ACEPTAR");
        buttonAceptar.setStyle("-fx-background-color: #239B56; -fx-background-radius: 15; -fx-pref-height: 50; -fx-pref-width: 160");
        buttonAceptar.setFont(font);

        Button buttonCancelar = new Button("CANCELAR");
        buttonCancelar.setStyle("-fx-background-color: #EC7063; -fx-background-radius: 15; -fx-pref-height: 50; -fx-pref-width: 160");
        buttonCancelar.setFont(font);

        AnchorPane.setBottomAnchor(buttonAceptar, 20.0);
        AnchorPane.setRightAnchor(buttonAceptar, 200.0);
        AnchorPane.setBottomAnchor(buttonCancelar, 20.0);
        AnchorPane.setRightAnchor(buttonCancelar, 20.0);
        anchorPane.getChildren().addAll(buttonAceptar, buttonCancelar);
        controladorComputadora.setButtonAceptar(buttonAceptar);
        controladorComputadora.setButtonCancelar(buttonCancelar);
    }

    private void modelarGrid() {
        Font font = Font.font("Copperplate Gothic Bold", 30);

        Label labelRazgo = new Label("RAZGOS");
        labelRazgo.setStyle("-fx-content-display: CENTER; -fx-alignment: CENTER; -fx-text-fill: #1fff00; -fx-pref-width: 330; -fx-pref-height: 45");
        labelRazgo.setFont(Font.font("Copperplate Gothic Bold", 50));

        Label labelGenero = new Label("Genero:");
        labelGenero.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-text-fill: WHITE");
        labelGenero.setFont(font);
        labelGenero.setPadding(new Insets(0,0,0,20));

        Label labelHobby = new Label("Hobby");
        labelHobby.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-text-fill: WHITE");
        labelHobby.setFont(font);
        labelHobby.setPadding(new Insets(0,0,0,20));

        Label labelSenia = new Label("Senia:");
        labelSenia.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-text-fill: WHITE");
        labelSenia.setFont(font);
        labelSenia.setPadding(new Insets(0,0,0,20));

        Label labelCabello = new Label("Cabello:");
        labelCabello.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-text-fill: WHITE");
        labelCabello.setFont(font);
        labelCabello.setPadding(new Insets(0,0,0,20));

        Label labelVehiculo = new Label("Vehiculo:");
        labelVehiculo.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-text-fill: WHITE");
        labelVehiculo.setFont(font);
        labelVehiculo.setPadding(new Insets(0,0,0,20));

        ArrayList<String> opcionesGenero = new ArrayList<>(Arrays.asList("Masculino", "Femenimo", "---"));
        ArrayList<String> opcionesHobby = new ArrayList<>(Arrays.asList("Escalar", "Croquet", "Tenis", "---"));
        ArrayList<String> opcionesSenia = new ArrayList<>(Arrays.asList("Anillo", "Tatuaje", "Joyas", "---"));
        ArrayList<String> opcionesCabello = new ArrayList<>(Arrays.asList("Negro", "Rojo", "Rubio", "Castanio", "---"));
        ArrayList<String> opcionesVehiculo = new ArrayList<>(Arrays.asList("Moto", "Convertible", "Limusina", "---"));

        LabelEleccion labelEleccionGenero = new LabelEleccion("Genero", opcionesGenero, partida, anchorPane);
        LabelEleccion labelEleccionHobby = new LabelEleccion("Hobby", opcionesHobby, partida, anchorPane);
        LabelEleccion labelEleccionSenia = new LabelEleccion("Senia", opcionesSenia, partida, anchorPane);
        LabelEleccion labelEleccionCabello = new LabelEleccion("Cabello", opcionesCabello, partida, anchorPane);
        LabelEleccion labelEleccionVehiculo = new LabelEleccion("Vehiculo", opcionesVehiculo, partida, anchorPane);

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-pref-height: 400; -fx-pref-width: 600; -fx-background-color: #616A6B; -fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: BLACK; -fx-border-width: 5");
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(126);
        gridPane.getRowConstraints().add(row1);

        gridPane.add(labelRazgo,0,0,2,1);
        gridPane.add(labelGenero,0,1);
        gridPane.add(labelHobby,0,2);
        gridPane.add(labelSenia,0,3);
        gridPane.add(labelCabello,0,4);
        gridPane.add(labelVehiculo,0,5);
        gridPane.add(labelEleccionGenero,1,1);
        gridPane.add(labelEleccionHobby,1,2);
        gridPane.add(labelEleccionSenia,1,3);
        gridPane.add(labelEleccionCabello,1,4);
        gridPane.add(labelEleccionVehiculo,1,5);

        GridPane.setHalignment(labelRazgo, HPos.CENTER);
        GridPane.setValignment(labelRazgo, CENTER);

        GridPane.setMargin(labelGenero,new Insets(0,20,0,0));
        GridPane.setMargin(labelHobby,new Insets(0,20,0,0));
        GridPane.setMargin(labelSenia,new Insets(0,20,0,0));
        GridPane.setMargin(labelCabello,new Insets(0,20,0,0));
        GridPane.setMargin(labelVehiculo,new Insets(0,20,0,0));
        GridPane.setMargin(labelEleccionGenero,new Insets(0,20,0,20));
        GridPane.setMargin(labelEleccionHobby,new Insets(0,20,0,20));
        GridPane.setMargin(labelEleccionSenia,new Insets(0,20,0,20));
        GridPane.setMargin(labelEleccionCabello,new Insets(0,20,0,20));
        GridPane.setMargin(labelEleccionVehiculo,new Insets(0,20,0,20));


        AnchorPane.setTopAnchor(gridPane, 100.0);
        AnchorPane.setBottomAnchor(gridPane, 100.0);
        AnchorPane.setRightAnchor(gridPane, 100.0);
        AnchorPane.setLeftAnchor(gridPane, 100.0);
        anchorPane.getChildren().addAll(gridPane);
    }
}
