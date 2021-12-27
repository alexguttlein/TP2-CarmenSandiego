package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPrincipal extends HBox {
    private Stage stage;
    private Partida partida;
    private Jugador jugador;

    public ContenedorPrincipal(Stage stage, Partida partida, Jugador jugador){
        this.stage = stage;
        this.partida = partida;
        this.jugador = jugador;
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }


}
