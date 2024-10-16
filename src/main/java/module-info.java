module edu.badpals.valorantapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.badpals.valorantapi to javafx.fxml;
    exports edu.badpals.valorantapi;
}