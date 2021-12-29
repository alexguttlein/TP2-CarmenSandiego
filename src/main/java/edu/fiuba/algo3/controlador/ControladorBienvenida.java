package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.scene.Node;
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
            //Aca tenemos q instanciar el otro contenedor y cambiar la escena
            //Ya tenes el stage solo es setearle el scene
            System.out.println("Clicked");
        } else if (value == "SALIR"){
            stage.close();
        }
    }

}
