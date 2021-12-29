package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotonViajeAEdificio implements EventHandler<ActionEvent> {

    private Button boton;
    private Stage stage;
    private Edificio nuevoEdificio;
    private Jugador jugador;
    private Partida partida;

    public BotonViajeAEdificio(Button boton, Stage stage, Edificio nuevoEdificio, Jugador jugador, Partida partida) {
        this.boton = boton;
        this.stage = stage;
        this.nuevoEdificio = nuevoEdificio;
        this.jugador = jugador;
        this.partida = partida;
        boton.setText(nuevoEdificio.getNombre().getCaracteristica());
        boton.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 40));
        boton.setTextFill(Color.rgb(255, 150, 69));
        boton.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void handle(ActionEvent eventoNuevo) {
        jugador.visitarEdificio(nuevoEdificio);
        String pista = nuevoEdificio.getPistaCompleta();
        ContenedorPrincipal nuevoContenedor = new ContenedorPrincipal(stage, partida);
        ControladorPrincipal controladorPrincipal = nuevoContenedor.getControladorPrincipal();
        controladorPrincipal.modificarText(pista);
        Scene nuevaEscena = new Scene(nuevoContenedor, 1280, 720);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}