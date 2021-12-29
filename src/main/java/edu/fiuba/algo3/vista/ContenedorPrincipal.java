package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorPrincipal extends AnchorPane {
    Stage stage;
    Partida partida;
    Jugador jugador;

    public ContenedorPrincipal(Stage stage){
        this.stage = stage;
        partida = crearModeloJuego();
        jugador = partida.getJugador();
        this.setStyle("-fx-background-color: #5D6D7E");
        this.modelar();
    }

    public Partida crearModeloJuego(){
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

    public void modelar(){
        setHBox();
        setReloj();
        setPantallaTexto();
        setPantalla();
    }

    private void setHBox(){
        HBox hBox = new HBox();
        hBox.setStyle("-fx-pref-width: 440; -fx-pref-height: 90; -fx-background-color: #34495E; -fx-background-radius: 15");

        Button buttonLupa = new Button();
        Button buttonAvion = new Button();
        Button buttonComputadora = new Button();

        buttonLupa.setStyle("-fx-background-color: #2874A6; -fx-background-radius: 15; -fx-pref-height: 70; -fx-pref-width: 160");
        ImageView imagenLupa = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenLupa.png");
        imagenLupa.setFitHeight(50);
        imagenLupa.setFitWidth(56);
        imagenLupa.setPreserveRatio(true);
        buttonLupa.setGraphic(imagenLupa);

        buttonAvion.setStyle("-fx-background-color: #DC7633; -fx-background-radius: 15; -fx-pref-height: 70; -fx-pref-width: 160");
        ImageView imagenAvion = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenAvion1.png");
        imagenAvion.setFitHeight(50);
        imagenAvion.setFitWidth(73);
        imagenAvion.setPreserveRatio(true);
        buttonAvion.setGraphic(imagenAvion);

        buttonComputadora.setStyle("-fx-background-color: #6C3483; -fx-background-radius: 15; -fx-pref-height: 70; -fx-pref-width: 80");
        ImageView imagenComputadora = new ImageView("file:src/main/java/edu/fiuba/algo3/datosDelJuego/Imagenes/ImagenComputadora.png");
        imagenComputadora.setFitHeight(50);
        imagenComputadora.setFitWidth(100);
        imagenComputadora.setPreserveRatio(true);
        buttonComputadora.setGraphic(imagenComputadora);

        hBox.setMargin(buttonLupa, new Insets(10,5,10,10));
        hBox.setMargin(buttonAvion, new Insets(10,5,10,5));
        hBox.setMargin(buttonComputadora, new Insets(10,10,10,5));
        AnchorPane.setBottomAnchor(hBox, 10.0);
        AnchorPane.setRightAnchor(hBox, 10.0);
        hBox.getChildren().addAll(buttonLupa, buttonAvion, buttonComputadora);
        this.getChildren().add(hBox);
    }

    private void setReloj(){
        AnchorPane paneSupIzq = new AnchorPane();
        paneSupIzq.setStyle("-fx-background-color: #34495E; -fx-background-radius: 15; -fx-pref-height: 90; -fx-pref-width: 450");
        paneSupIzq.setLayoutX(10);
        paneSupIzq.setLayoutY(10);

        Label labelUbicacion = new Label("Ubicacion Actual");
        Label labelTiempo = new Label("Dia, Hora");
        Font font = Font.font("Copperplate Gothic Bold", 30);

        labelUbicacion.setStyle("-fx-pref-height: 45; -fx-pref-width: 430; -fx-alignment: CENTER; -fx-text-fill: WHITE");
        labelUbicacion.setFont(font);
        AnchorPane.setLeftAnchor(labelUbicacion, 10.0);
        AnchorPane.setRightAnchor(labelUbicacion, 10.0);
        AnchorPane.setTopAnchor(labelUbicacion, 5.0);

        labelTiempo.setStyle("-fx-pref-height: 45; -fx-pref-width: 430; -fx-alignment: CENTER; -fx-text-fill: WHITE");
        labelTiempo.setFont(font);
        AnchorPane.setLeftAnchor(labelTiempo, 10.0);
        AnchorPane.setRightAnchor(labelTiempo, 10.0);
        AnchorPane.setBottomAnchor(labelTiempo, 5.0);


        AnchorPane paneInfDer = new AnchorPane();
        paneInfDer.setStyle("-fx-background-color: #34495E; -fx-background-radius: 15; -fx-pref-height: 90; -fx-pref-width: 350");
        paneInfDer.setLayoutX(475);
        paneInfDer.setLayoutY(620);

        Label labelTiempoRestante = new Label("Tiempo Restante");
        Label laberlDiahoraRestante = new Label("Dia Hora Restante");

        labelTiempoRestante.setStyle("-fx-pref-height: 45; -fx-pref-width: 330; -fx-alignment: CENTER; -fx-text-fill: WHITE");
        labelTiempoRestante.setFont(font);
        AnchorPane.setLeftAnchor(labelTiempoRestante, 10.0);
        AnchorPane.setRightAnchor(labelTiempoRestante, 10.0);
        AnchorPane.setTopAnchor(labelTiempoRestante, 5.0);

        laberlDiahoraRestante.setStyle("-fx-pref-height: 45; -fx-pref-width: 330; -fx-alignment: CENTER; -fx-text-fill: WHITE");
        laberlDiahoraRestante.setFont(font);
        AnchorPane.setLeftAnchor(laberlDiahoraRestante, 10.0);
        AnchorPane.setRightAnchor(laberlDiahoraRestante, 10.0);
        AnchorPane.setBottomAnchor(laberlDiahoraRestante, 5.0);

        AnchorPane.setRightAnchor(paneInfDer, 460.0);
        paneSupIzq.getChildren().addAll(labelUbicacion, labelTiempo);
        paneInfDer.getChildren().addAll(labelTiempoRestante, laberlDiahoraRestante);
        this.getChildren().addAll(paneSupIzq, paneInfDer);
    }

    private void setPantallaTexto(){
        AnchorPane paneSupDer = new AnchorPane();
        paneSupDer.setStyle("-fx-background-color: #34495E; -fx-background-radius: 15; -fx-pref-height: 600; -fx-pref-width: 450");
        paneSupDer.setLayoutX(25);
        paneSupDer.setLayoutY(112);

        Label labelTextoJuego = new Label("Texto Juego");
        TextField textField = new TextField();
        Font font = Font.font("Copperplate Gothic Bold", 30);

        textField.setStyle("-fx-pref-height: 45; -fx-pref-width: 410; -fx-background-color: transparent");
        AnchorPane.setLeftAnchor(textField, 20.0);
        AnchorPane.setRightAnchor(textField, 20.0);
        AnchorPane.setBottomAnchor(textField, 20.0);

        labelTextoJuego.setStyle("-fx-pref-height: 600; -fx-pref-width: 450; -fx-alignment: TOP_LEFT;-fx-wrap-text: TRUE; -fx-text-fill: WHITE");
        labelTextoJuego.setFont(font);
        labelTextoJuego.setLineSpacing(5);
        labelTextoJuego.setPadding(new Insets(70,0,0,10));
        AnchorPane.setLeftAnchor(labelTextoJuego, 10.0);
        AnchorPane.setRightAnchor(labelTextoJuego, 10.0);
        AnchorPane.setTopAnchor(labelTextoJuego, 20.0);
        AnchorPane.setBottomAnchor(labelTextoJuego, 20.0);

        AnchorPane.setLeftAnchor(paneSupDer, 10.0);
        AnchorPane.setBottomAnchor(paneSupDer, 10.0);
        paneSupDer.getChildren().addAll(textField, labelTextoJuego);
        this.getChildren().add(paneSupDer);
    }
    private void setPantalla(){
        AnchorPane paneInfIzq = new AnchorPane();
        paneInfIzq.setStyle("-fx-background-color: #34495E; -fx-background-radius: 15; -fx-pref-height: 600; -fx-pref-width: 800");
        AnchorPane.setRightAnchor(paneInfIzq, 10.0);
        AnchorPane.setTopAnchor(paneInfIzq, 10.0);

        this.getChildren().add(paneInfIzq);
    }
}
