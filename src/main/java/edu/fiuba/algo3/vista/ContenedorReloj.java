package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorReloj extends VBox {
    private int tamanioLetra = 30;

    public ContenedorReloj(Tiempo reloj, Ciudad ciudadActual){
        Label ciudad = new Label(ciudadActual.getNombre().getCaracteristica());
        ciudad.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, tamanioLetra));
        Label hora = new Label(reloj.obtenerDiaDeLaSemana() + ", " + Integer.toString(reloj.getHoraActual()) + "hs");
        hora.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, tamanioLetra));
        this.getChildren().add(ciudad);
        this.getChildren().add(hora);
    }

    public ContenedorReloj(Tiempo reloj){
        Label lugarActual = new Label("Cuartel General");
        lugarActual.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, tamanioLetra));
        Label hora = new Label(reloj.obtenerDiaDeLaSemana() + ", " + Integer.toString(reloj.getHoraActual()) + "hs");
        hora.setFont(Font.font("FreeSerif", FontWeight.EXTRA_BOLD, tamanioLetra));
        this.getChildren().add(lugarActual);
        this.getChildren().add(hora);
    }
}
