module edu.badpals.valorantapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens edu.badpals.valorantapi to javafx.fxml;
    exports edu.badpals.valorantapi.Controller to javafx.fxml;
    opens edu.badpals.valorantapi.Controller to javafx.fxml;
}