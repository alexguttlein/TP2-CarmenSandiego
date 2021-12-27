module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens edu.fiuba.algo3 to javafx.fxml, javafx.graphics, javafx.base, javafx.controls;
    opens edu.fiuba.algo3.controlador to javafx.fxml, javafx.controls, javafx.base, javafx.graphics;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controlador;
}