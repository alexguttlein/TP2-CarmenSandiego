package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorComienzo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class ContenedorComienzo extends AnchorPane {

    public ContenedorComienzo(){
        this.setStyle("-fx-background-color: BLACK");
        this.modelar();
    }

    private void modelar() {
        ImageView imagen = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenFondoHacker2.png");
        imagen.setPreserveRatio(true);
        imagen.setFitHeight(720);
        imagen.setFitWidth(1280);
        imagen.setLayoutX(75);
        imagen.setLayoutY(-14);

        Label labelBienvenida = new Label("Bienvenido Agente");
        labelBienvenida.setStyle("-fx-alignment: CENTER; -fx-content-display: CENTER; -fx-pref-height: 80; -fx-pref-width: 580; -fx-text-alignment: CENTER; -fx-text-fill: #00ff35");
        labelBienvenida.setLayoutX(361);
        labelBienvenida.setLayoutY(306);
        labelBienvenida.setFont(Font.font("Copperplate Gothic Bold", 53));

        this.getChildren().addAll(imagen, labelBienvenida);
    }

    public void setMensaje(){
        Label labelMensaje = new Label("Ingrese su nombre");
        labelMensaje.setStyle("-fx-alignment: CENTER; -fx-content-display: CENTER; -fx-pref-height: 45; -fx-pref-width: 330; -fx-text-alignment: CENTER; -fx-text-fill: RED");
        labelMensaje.setLayoutX(660);
        labelMensaje.setLayoutY(439);
        labelMensaje.setFont(Font.font("Copperplate Gothic Bold", 30));

        TextField textField = new TextField("Aqui.....");
        textField.setStyle("-fx-pref-height: 57; -fx-pref-width: 330; -fx-background-color: TRANSPARENT; -fx-text-fill: WHITE");
        textField.setLayoutX(660);
        textField.setLayoutY(467);
        textField.setFont(Font.font("Copperplate Gothic Bold", 30));

        Button buttonIngresar = new Button("Ingresar");
        buttonIngresar.setStyle("-fx-pref-height: 45; -fx-pref-width: 200; -fx-background-color: #E74C3C; -fx-background-radius: 15; -fx-text-fill: WHITE");
        buttonIngresar.setLayoutX(901);
        buttonIngresar.setLayoutY(564);
        buttonIngresar.setFont(Font.font("Copperplate Gothic Bold", 30));

        AnchorPane.setBottomAnchor(buttonIngresar, 100.0);
        this.getChildren().addAll(labelMensaje, textField, buttonIngresar);
        ControladorComienzo controladorComienzo = new ControladorComienzo(textField, buttonIngresar);
    }

}
