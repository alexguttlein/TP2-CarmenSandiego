package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ciudad.Ciudades;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorComienzo {
    TextField textField;
    Button buttonIngresar;
    String nombreJugador;

    public ControladorComienzo(TextField textField, Button button){
        this.textField = textField;
        this.buttonIngresar = button;
        buttonIngresar.setOnAction(this::onClick);
    }

    private void onClick(ActionEvent event){
        this.nombreJugador = textField.getText();
        Partida partida = crearModeloJuego();
        String texto = "Buenos días agente " + nombreJugador + ". Nos hemos comunicado con usted para que nos ayude a resolver el siguiente caso: Se ha robado " + partida.getObjetoRobado().getNombre().getCaracteristica() + " de la ciudad " + partida.getObjetoRobado().getCiudadOrigen().getNombre().getCaracteristica() + ". Por favor, ayúdenos a atrapar al ladrón y recuperarlo. Contamos con usted.";
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, partida);
        ControladorPrincipal controladorPrincipal = contenedorPrincipal.getControladorPrincipal();
        controladorPrincipal.modificarText(texto);
        Scene escenaJuego = new Scene(contenedorPrincipal, 1280, 720);
        stage.setScene(escenaJuego);
    }

    public Partida crearModeloJuego(){
        Ciudades ciudades = new Ciudades("src/main/java/edu/fiuba/algo3/datosDelJuego/ciudades.csv");
        ObjetosRobados objetosRobados = new ObjetosRobados(ciudades);
        ObjetoRobado objetoRobado = objetosRobados.getObjetoRobadoAlAzar();
        Ladrones ladrones = new Ladrones("src/main/java/edu/fiuba/algo3/datosDelJuego/ladrones.csv");
        Ladron ladron = ladrones.getLadronAlAzar();
        Tiempo tiempo = new Tiempo();
        Jugador jugador = new Jugador(nombreJugador, tiempo);
        Interpol interpol = new Interpol(ladrones, tiempo, jugador, ladron);
        Partida partida = new Partida(jugador, objetoRobado, ladron, interpol, tiempo, ciudades);

        System.out.println("Genero: " + ladron.getGenero().getCaracteristica());
        System.out.println("Hobby: " + ladron.getHobby().getCaracteristica());
        System.out.println("Senia: " + ladron.getSenia().getCaracteristica());
        System.out.println("Cabello: " + ladron.getCabello().getCaracteristica());
        System.out.println("Vehiculo: " + ladron.getVehiculo().getCaracteristica());

        Recorrido recorrido = partida.getRecorrido();
        System.out.println("\nRecorrido Real:");
        for (int i = 0; i < recorrido.getRecorridoReal().size(); i++){
            System.out.println(recorrido.getRecorridoReal().get(i).getNombre().getCaracteristica());
        }

        return partida;
    }
}
