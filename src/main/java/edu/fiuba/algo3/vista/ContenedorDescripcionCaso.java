package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorDescripcionCaso extends TextArea {

    public ContenedorDescripcionCaso(String descripcion){
        this.setText(descripcion);
        this.setEditable(false);
        this.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, 28));
        this.setTranslateX(-450);
        this.setTranslateY(100);
        this.setMaxHeight(620);
        this.setMaxWidth(400);
        this.setWrapText(true);
    }
}
