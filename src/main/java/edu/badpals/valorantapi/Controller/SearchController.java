package edu.badpals.valorantapi.Controller;

import edu.badpals.valorantapi.Controller.AgentsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SearchController implements Controller{


    @FXML
    public Tab tabAgent;

    @FXML
    public TextField txtBuscaAg;

    @FXML
    public Label lblBuscaAg;

    @FXML
    public Button btnBuscar;

    @FXML
    public Button btnExit;



    public void handlebtnBuscar(ActionEvent event){
        setAgentes();
        String agenteBuscado = txtBuscaAg.getText().trim();
        String buscaAgente = agentes.get(agenteBuscado);
        if(buscaAgente != null) {
            try {
                // Carga la nueva venta
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/agents.fxml"));
                Parent root = loader.load();

                // Obtiene el stado actual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                // Muestra la ventana
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handlebtnSalir(ActionEvent event){
        try {
            // Carga la nueva venta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/login.fxml"));
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
