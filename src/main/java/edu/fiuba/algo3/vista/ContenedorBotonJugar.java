package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonJugar;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContenedorBotonJugar extends VBox {

    public ContenedorBotonJugar(BotonJugar boton){
        super();
        this.setSpacing(200);
        this.setPadding(new Insets(10));
        this.setTranslateX(550);
        this.setTranslateY(360);
    }
}
