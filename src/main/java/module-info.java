module edu.badpals.valorantapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;


    opens edu.badpals.valorantapi to javafx.fxml, javafx.graphics;
    exports edu.badpals.valorantapi.Controller to javafx.fxml;
    opens edu.badpals.valorantapi.Controller to javafx.fxml;
}