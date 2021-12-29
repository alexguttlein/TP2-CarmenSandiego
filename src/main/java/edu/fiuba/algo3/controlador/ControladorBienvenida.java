package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorBienvenida {
    private Partida partida;
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
            //System.out.println("Clicked");
            partida = crearModeloJuego();
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, partida);
            Scene escenaJuego = new Scene(contenedorPrincipal, 1280, 720);
            stage.setScene(escenaJuego);
        } else if (value == "SALIR"){
            stage.close();
        }
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
}
