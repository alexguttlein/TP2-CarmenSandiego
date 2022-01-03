package edu.fiuba.algo3.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ContenedorDerrota extends AnchorPane {
    Stage stage;

    public ContenedorDerrota(){
        this.setStyle("-fx-background-color: BLACK");
        this.modelar();
    }

    private void modelar() {
        ImageView imagenLadron = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenLadron.png");
        imagenLadron.setFitHeight(423);
        imagenLadron.setFitWidth(429);
        imagenLadron.setPreserveRatio(true);
        imagenLadron.setLayoutX(731);
        imagenLadron.setLayoutY(151);
        this.getChildren().addAll(imagenLadron);
    }

}
