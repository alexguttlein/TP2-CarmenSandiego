package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Caracteristica;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorComputadora;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LabelEleccion extends Button {
    private ArrayList<String> listaOpciones;
    private Partida partida;
    private Jugador jugador;
    private String categoria;
    AnchorPane anchorPane;

    public LabelEleccion(String categoria, ArrayList<String> lista, Partida partida, AnchorPane pane) {
        this.listaOpciones = lista;
        this.partida = partida;
        this.jugador = partida.getJugador();
        this.categoria = categoria;
        this.anchorPane = pane;
        modelar();
    }

    private void modelar() {
        Font font = Font.font("Copperplate Gothic Bold", 30);
        this.setStyle("-fx-pref-width: 330; -fx-pref-height: 45; -fx-background-color: #2980B9; -fx-background-radius: 15; -fx-text-fill: WHITE");
        this.setFont(font);
        this.setPadding(new Insets(0,20,0,20));
        this.setOnAction(this::onClick);
        String ultimaOpcion = getLastEleccion();
        this.setText(ultimaOpcion);
    }

    private String getLastEleccion(){
        Ladron posibleLadron = partida.getInterpol().getPosibleLadron();
        String opcion;
        switch (categoria){
            case "Genero":
                opcion = posibleLadron.getGenero().getCaracteristica();
                break;
            case "Hobby":
                opcion = posibleLadron.getHobby().getCaracteristica();
                break;
            case "Senia":
                opcion = posibleLadron.getSenia().getCaracteristica();
                break;
            case "Cabello":
                opcion = posibleLadron.getCabello().getCaracteristica();
                break;
            case "Vehiculo":
                opcion = posibleLadron.getVehiculo().getCaracteristica();
                break;
            default:
                opcion = "";
                break;
        }
        return opcion;
    }

    public void onClick(ActionEvent event){
        String ultimaOpcion = getLastEleccion();
        int posicion = listaOpciones.indexOf(ultimaOpcion);
        if (posicion + 1 == listaOpciones.size()){
            ultimaOpcion = listaOpciones.get(0);
        } else {
            ultimaOpcion = listaOpciones.get(posicion + 1);
        }
        this.setText(ultimaOpcion);
        setDato(ultimaOpcion);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ContenedorComputadora contenedorComputadora = new ContenedorComputadora(anchorPane, stage, partida);
    }

    public void setDato(String dato){
        switch (categoria){
            case "Genero":
                partida.getInterpol().setDatoGenero(new Caracteristica(dato));
                break;
            case "Hobby":
                partida.getInterpol().setDatoHobby(new Caracteristica(dato));
                break;
            case "Senia":
                partida.getInterpol().setDatoSenia(new Caracteristica(dato));
                break;
            case "Cabello":
                partida.getInterpol().setDatoCabello(new Caracteristica(dato));
                break;
            case "Vehiculo":
                partida.getInterpol().setDatoVehiculo(new Caracteristica(dato));
                break;
        }
    }
}
