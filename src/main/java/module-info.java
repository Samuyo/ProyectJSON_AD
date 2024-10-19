module edu.badpals.valorantapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens edu.badpals.valorantapi to javafx.fxml;
    exports edu.badpals.valorantapi;
    exports Controlador;
    opens Controlador to javafx.fxml;
    exports edu.badpals.valorantapi.Controller;
    opens edu.badpals.valorantapi.Controller to javafx.fxml;
}