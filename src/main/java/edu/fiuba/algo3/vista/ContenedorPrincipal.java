package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonJugar;
import edu.fiuba.algo3.controlador.BotonSiguiente;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipal extends StackPane {
    private Stage stage;
    private Partida partida;
    private Jugador jugador;

    public ContenedorPrincipal(Stage stage, Partida partida, Jugador jugador, Scene proximaEscena){
        this.stage = stage;
        this.partida = partida;
        this.jugador = jugador;
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        ContenedorDescripcionCaso descripcionDelCaso = new ContenedorDescripcionCaso(obtenerDescripcion());
        ContenedorReloj contenedorReloj = new ContenedorReloj(partida.getTiempo());

        Button botonSiguiente = new Button();
        BotonSiguiente botonSiguienteEscena = new BotonSiguiente(botonSiguiente, stage, proximaEscena);
        botonSiguiente.setOnAction(botonSiguienteEscena);

        this.getChildren().add(descripcionDelCaso);

        this.getChildren().add(contenedorReloj);
        contenedorReloj.setSpacing(10);
        contenedorReloj.setTranslateY(10);
        contenedorReloj.setTranslateX(50);

        this.getChildren().add(botonSiguiente);
        botonSiguiente.setTranslateX(100);
    }

    public String obtenerDescripcion(){
        String descripcion = "Buenas tardes Agente, hoy recurrimos a usted para que nos ayude a resolver el siguiente caso: "+
                "Una persona ha robado " + partida.getObjetoRobado().getNombre().getCaracteristica() + " de la ciudad " + partida.getObjetoRobado().getCiudadOrigen().getNombre().getCaracteristica()
                + ".\n Necesitamos de su ayuda para encontrarlo. Comenzaremos en la ciudad en la que el objeto fue robado";
        return descripcion;
    }


}
