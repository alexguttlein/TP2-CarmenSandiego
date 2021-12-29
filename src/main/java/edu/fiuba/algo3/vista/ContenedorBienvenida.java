package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorBienvenida;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ContenedorBienvenida extends AnchorPane {
    Stage stage;

    public ContenedorBienvenida(Stage stage){
        super();
        // Puede no estar directamente
        this.stage = stage;
        this.setStyle("-fx-background-color: #3CB371");
        this.modelar();
    }

    public void modelar() {
        ImageView iview = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenFondo.png");
        iview.setFitHeight(520);
        iview.setFitWidth(728);
        iview.setPreserveRatio(true);
        iview.setLayoutX(278);
        iview.setLayoutY(50);

        Button buttonJugar = new Button("JUGAR");
        Button buttonSalir = new Button("SALIR");
        Font font = Font.font("Bauhaus 93", 40);

        buttonJugar.setStyle("-fx-background-color: #ADFF2F; -fx-background-radius: 15; -fx-pref-height: 70; -fx-pref-width: 300");
        buttonJugar.setFont(font);
        buttonJugar.setLayoutX(278);
        buttonJugar.setLayoutY(601);

        buttonSalir.setStyle("-fx-background-color: #FF0000; -fx-background-radius: 15; -fx-pref-height: 70; -fx-pref-width: 300");
        buttonSalir.setFont(font);
        buttonSalir.setLayoutX(702);
        buttonSalir.setLayoutY(601);

        this.getChildren().addAll(iview, buttonJugar, buttonSalir);
        ControladorBienvenida controladorBienvenida = new ControladorBienvenida(buttonJugar, buttonSalir);
    }
}
