package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorBienvenida {
    private Stage stage;
    private Button buttonJugar;
    private Button buttonSalir;

    public ControladorBienvenida(Button buttonJugar, Button buttonSalir){
        this.buttonJugar = buttonJugar;
        this.buttonSalir = buttonSalir;
        this.setActions();
    }

    public void setActions() {
        buttonJugar.setOnAction(this::onClick);
        buttonSalir.setOnAction(this::onClick);
    }

    public void onClick(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String value = (((Button)event.getSource()).getText());
        if (value == "JUGAR") {
            System.out.println("Clicked");
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
            Scene escenaJuego = new Scene(contenedorPrincipal, 1280, 720);
            stage.setScene(escenaJuego);
        } else if (value == "SALIR"){
            stage.close();
        }
    }

}