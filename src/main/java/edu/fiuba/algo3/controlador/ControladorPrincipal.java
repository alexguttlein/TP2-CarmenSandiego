package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import edu.fiuba.algo3.modelo.edificio.Edificio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorPrincipal {
    Stage stage;
    HBox hBox;
    AnchorPane paneSupIzq;
    AnchorPane paneInfDer;
    AnchorPane paneSupDer;
    AnchorPane paneInfIzq;
    Partida partida;
    Jugador jugador;

    public ControladorPrincipal(Stage stage, Partida partida){
        this.stage = stage;
        this.partida = partida;
        jugador = partida.getJugador();
    }

    public void modificarText(String texto) {
        Label labelPista = (Label)paneInfIzq.getChildren().get(1);
        labelPista.setText(texto);
    }

    public void setHBox(HBox hBox){
        this.hBox = hBox;
        Button buttonLupa = (Button)(hBox.getChildren().get(0));
        buttonLupa.setOnAction(this::onClickLupa);
        Button buttonViaje = (Button)(hBox.getChildren().get(1));
        buttonViaje.setOnAction(this::onClickAvion);
    }

    public void setPaneSupIzq(AnchorPane pane){
        this.paneSupIzq = pane;
        actualizarRelojYUbicacion();
    }

    public void actualizarRelojYUbicacion(){
        Tiempo reloj = partida.getTiempo();
        Ciudad ciudadActual = jugador.getCiudadActual();
        Label labelLugar = (Label)(paneSupIzq.getChildren().get(0));
        Label labelHorario = (Label)(paneSupIzq.getChildren().get(1));
        ControladorReloj controladorReloj = new ControladorReloj(reloj, ciudadActual, labelLugar, labelHorario);
    }

    public void setPaneInfDer(AnchorPane pane){
        this.paneInfDer = pane;
        Tiempo reloj = partida.getTiempo();
        Label labelHorario = (Label)(paneInfDer.getChildren().get(1));
        ControladorReloj controladorReloj = new ControladorReloj(reloj, labelHorario);
    }

    public void setPaneSupDer(AnchorPane pane){
        this.paneSupDer = pane;
    }

    public void setPaneInfIzq(AnchorPane pane){
        this.paneInfIzq = pane;
    }

    public void onClickLupa(ActionEvent event){
        String textoClickeado = "Me han clickeado Lupa";
        System.out.println(textoClickeado);

        VBox contenedorEdificios = new VBox();
        ArrayList<Edificio> edificiosDisponibles = jugador.getCiudadActual().getEdificios();
        paneSupDer.getChildren().clear();

        Button boton1 = new Button();
        BotonViajeAEdificio botonEdificio1 = new BotonViajeAEdificio(boton1, stage, edificiosDisponibles.get(0), jugador, partida);
        boton1.setOnAction(botonEdificio1);

        Button boton2 = new Button();
        BotonViajeAEdificio botonEdificio2 = new BotonViajeAEdificio(boton2, stage, edificiosDisponibles.get(1), jugador, partida);
        boton2.setOnAction(botonEdificio2);

        Button boton3 = new Button();
        BotonViajeAEdificio botonEdificio3 = new BotonViajeAEdificio(boton3, stage, edificiosDisponibles.get(2), jugador, partida);
        boton3.setOnAction(botonEdificio3);

        contenedorEdificios.getChildren().addAll(boton1, boton2, boton3);
        AnchorPane.setBottomAnchor(contenedorEdificios, 300.0);
        AnchorPane.setRightAnchor(contenedorEdificios, 40.0);
        paneSupDer.getChildren().add(contenedorEdificios);

    }

    public void onClickAvion(ActionEvent event){
        String textoClickeado = "Me han clickeado Avion";
        System.out.println(textoClickeado);

        VBox contenedorCiudades = new VBox();
        contenedorCiudades.setStyle("-fx-pref-width: 400; -fx-pref-height: 300; -fx-background-color: #34495E; -fx-background-radius: 15");
        paneSupDer.getChildren().clear();

        ArrayList<Ciudad> ciudadesDisponibles = jugador.getCiudadActual().getCiudadesDisponiblesParaViajar();
        if (jugador.getCiudadActual().getCiudadesDisponiblesParaViajar().size() == 3){
            Button boton1 = new Button();
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);

            Button boton2 = new Button();
            BotonViajeACiudad botonCiudad2 = new BotonViajeACiudad(boton2, stage, ciudadesDisponibles.get(1), jugador, partida);
            boton2.setOnAction(botonCiudad2);

            Button boton3 = new Button();
            BotonViajeACiudad botonCiudad3 = new BotonViajeACiudad(boton3, stage, ciudadesDisponibles.get(2), jugador, partida);
            boton3.setOnAction(botonCiudad3);

            contenedorCiudades.setMargin(boton1, new Insets(20,50,10,50));
            contenedorCiudades.setMargin(boton2, new Insets(10,50,10,50));
            contenedorCiudades.setMargin(boton3, new Insets(10,50,20,50));
            contenedorCiudades.getChildren().addAll(boton1,boton2,boton3);
        }
        else{
            Button boton1 = new Button();
            BotonViajeACiudad botonCiudad1 = new BotonViajeACiudad(boton1, stage, ciudadesDisponibles.get(0), jugador, partida);
            boton1.setOnAction(botonCiudad1);
            contenedorCiudades.setMargin(boton1, new Insets(20,50,10,50));
            contenedorCiudades.getChildren().add(boton1);
        }

        AnchorPane.setBottomAnchor(contenedorCiudades, 300.0);
        AnchorPane.setRightAnchor(contenedorCiudades, 40.0);
        paneSupDer.getChildren().add(contenedorCiudades);

    }
}