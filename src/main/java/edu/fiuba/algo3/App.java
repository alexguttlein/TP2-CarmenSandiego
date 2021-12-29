package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonJugar;
import edu.fiuba.algo3.controlador.IngresarTexto;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorBienvenida;
import edu.fiuba.algo3.vista.ContenedorIngresoNombre;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import edu.fiuba.algo3.vista.ContenedorJuego;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Stack;


/**
 * JavaFX App
 */
public class App extends Application {
    private String nombreJugador = "Jugador1";
    private Partida partida;
    private Jugador jugador;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Juego Carmen Sandiego");

        partida = crearModelo();
        jugador = partida.getJugador();

        StackPane layout = new StackPane();
        Scene proximaEscena = new Scene(layout, 400, 400);

        ContenedorJuego pantallaJuego = new ContenedorJuego(stage, partida, jugador);
        Scene escenaJuego = new Scene(pantallaJuego, 1280, 720);

        ContenedorPrincipal descrpcionCaso = new ContenedorPrincipal(stage, partida, jugador, escenaJuego);
        Scene escenaDescripcionCaso = new Scene(descrpcionCaso, 1280, 720);

        ContenedorBienvenida contenedorEscenaBienvenida = new ContenedorBienvenida(stage, escenaDescripcionCaso);
        Scene escenaBienvenida = new Scene(contenedorEscenaBienvenida, 1280, 720);

        /*
        TextField cuadroTexto = new TextField();
        cuadroTexto.setOnKeyPressed( keyEvent -> {if( keyEvent.getCode() == KeyCode.ENTER){
            nombreJugador = cuadroTexto.getText();
            stage.setScene(escenaBienvenida);
            System.out.println(jugador.getNombre().getCaracteristica());
        }
        });

        ContenedorIngresoNombre contenedor1 = new ContenedorIngresoNombre(stage, escenaBienvenida, cuadroTexto);
        Scene nuevaEscena = new Scene(contenedor1, 1280, 720);

         */

        stage.setScene(escenaBienvenida);
        stage.setResizable(false);
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
        Jugador jugador = new Jugador(nombreJugador, tiempo);
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


