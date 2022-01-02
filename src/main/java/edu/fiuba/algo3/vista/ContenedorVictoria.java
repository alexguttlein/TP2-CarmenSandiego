package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorVictoria extends AnchorPane {
    Stage stage;
    Partida partida;
    Jugador jugador;

    public ContenedorVictoria(Stage stage, Partida partida){
        this.stage = stage;
        this.partida = partida;
        this.jugador = partida.getJugador();
        modelar();
    }

    private void modelar() {
        Font font = Font.font("Copperplate Gothic Bold", 40);

        ImageView imagenPrision = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenPrision.png");
        imagenPrision.setFitHeight(626);
        imagenPrision.setFitWidth(650);
        imagenPrision.setPreserveRatio(true);
        imagenPrision.setLayoutX(640);
        imagenPrision.setLayoutY(47);

        ImageView imagenLadron = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenLadron.png");
        imagenLadron.setFitHeight(423);
        imagenLadron.setFitWidth(429);
        imagenLadron.setPreserveRatio(true);
        imagenLadron.setLayoutX(731);
        imagenLadron.setLayoutY(151);

        Label label1 = new Label("Enhorabuena Agente");
        label1.setStyle("-fx-pref-height: 110; -fx-pref-width: 500; -fx-text-alignment: CENTER; -fx-text-fill: #b03a2e; -fx-wrap-text: TRUE");
        label1.setLayoutX(97);
        label1.setLayoutY(220);
        label1.setFont(font);

        Label label2 = new Label(jugador.getNombre().getCaracteristica());
        label2.setStyle("-fx-pref-height: 55; -fx-pref-width: 451; -fx-text-alignment: CENTER; -fx-alignment: CENTER");
        label2.setLayoutX(110);
        label2.setLayoutY(336);
        label2.setFont(font);

        Label label3 = new Label("Ha atrapado exitosamente al ladron");
        label3.setStyle("-fx-pref-height: 110; -fx-pref-width: 554; -fx-text-alignment: CENTER; -fx-wrap-text: TRUE");
        label3.setLayoutX(59);
        label3.setLayoutY(391);
        label3.setFont(font);

        this.setStyle("-fx-background-color: #85929E");
        AnchorPane.setTopAnchor(label1,220.0);
        AnchorPane.setLeftAnchor(label1, 97.0);
        AnchorPane.setBottomAnchor(label3,220.0);
        this.getChildren().addAll(imagenLadron, imagenPrision, label1, label2, label3);
    }
}
