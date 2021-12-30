package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage);
        //ContenedorPrincipal contenedorBienvenida = new ContenedorPrincipal(stage);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, 1280, 720);

        stage.setTitle("Juego Carmen Sandiego");
        stage.setScene(escenaBienvenida);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
