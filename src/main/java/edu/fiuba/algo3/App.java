package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonJugar;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorBotonJugar;
import edu.fiuba.algo3.vista.ContenedorBienvenida;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego Carmen Sandiego");

        Partida partida = crearModelo();
        Jugador jugador = partida.getJugador();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, partida, jugador);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1280, 720);

        ContenedorBienvenida contenedorImagenCarmenSandiego = new ContenedorBienvenida(stage, escenaJuego);
        Scene escenaBienvenida = new Scene(contenedorImagenCarmenSandiego, 1280, 720);



        stage.setScene(escenaBienvenida);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


    public Partida crearModelo(){
        Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");
        ObjetosRobados objetosRobados = new ObjetosRobados(ciudades);
        ObjetoRobado objetoRobado = objetosRobados.getObjetoRobadoAlAzar();
        Ladrones ladrones = new Ladrones("src/main/java/edu/fiuba/algo3/datosDelJuego/ladrones.csv");
        Ladron ladron = ladrones.getLadronAlAzar();
        Tiempo tiempo = new Tiempo();
        Jugador jugador = new Jugador("Jugador", tiempo);
        Interpol interpol = new Interpol(ladrones, tiempo, jugador, ladron);
        Partida partida = new Partida(jugador, objetoRobado, ladron, interpol, tiempo, ciudades);
        return partida;
    }

}



//var label = new Label("Dónde en el mundo está Carmen Sandiego?");
//label.setTextFill(Color.rgb(255,255,255));
//label.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40) );


//StackPane layout = new StackPane();
//layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


    //StackPane layout = new StackPane();
    //ImageView iview = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/ImagenFondo.png");
    //Button boton = new Button();

    //layout.getChildren().add(iview);
    // layout.getChildren().add(boton);
    //layout.setAlignment(boton, Pos.BOTTOM_CENTER);
    //Scene escena = new Scene(layout);