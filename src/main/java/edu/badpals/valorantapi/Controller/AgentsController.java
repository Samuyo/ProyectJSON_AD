package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class AgentsController implements Controller{
    private String finalURL = "https://valorant-api.com/v1/agents";

    @FXML
    public Label nomeAge;

    @FXML
    public Label lblAbil4Ag;

    @FXML
    public Label lblAbil3Ag;

    @FXML
    public Label lblAbil1Ag;

    @FXML
    public Label lblAbil2Ag;

    @FXML
    public Label lblDescAg;

    @FXML
    public Label lblRolAg;

    @FXML
    public Button btnReturn;

    HashMap<String, String> agentes = new HashMap<>();


    public void handlebtnReturn(ActionEvent event){
        try {
            // Carga la nueva venta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/search.fxml"));
            Parent root = loader.load();

            // Obtiene el stado actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            // Muestra la ventana
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
