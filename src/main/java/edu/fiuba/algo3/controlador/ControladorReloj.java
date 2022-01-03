package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.ciudad.Ciudad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorReloj extends VBox {

    public ControladorReloj(Tiempo reloj, Ciudad ciudadActual, Label labelUbicacion, Label labelHorario) {
        labelUbicacion.setText(ciudadActual.getNombre().getCaracteristica());
        labelHorario.setText(reloj.obtenerDiaDeLaSemana() + ", " + Integer.toString(reloj.getHoraActual()) + "hs");
    }

    public ControladorReloj(Stage stage, Tiempo reloj, Label labelHorario) {
        labelHorario.setText(reloj.getTiempoRestante());
    }

}