package edu.badpals.valorantapi.Controller;

import edu.badpals.valorantapi.Model.Character;
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
import java.util.ArrayList;

public class SearchController {

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

    private AgentsController agentsController;

    public void handlebtnBuscar(ActionEvent event) {
        String agenteBuscado = txtBuscaAg.getText().trim();
        Character buscaAgente = buscarAgente(agenteBuscado);

        if (buscaAgente != null) {
            try {
                // Carga la nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/agents.fxml"));
                Parent root = loader.load();

                // Obtiene el controlador de la nueva ventana
                AgentsController agentsController = loader.getController();
                agentsController.setAgentes(buscaAgente);

                // Obtiene el estado actual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                // Muestra la ventana
                stage.show();
            } catch (IOException e) {
                System.out.println("Error handlebtnBuscar: " + e.getMessage());
            }
        } else {
            lblBuscaAg.setText("Agente no encontrado.");
        }
    }

    public void handlebtnSalir(ActionEvent event) {
        try {
            // Carga la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/login.fxml"));
            Parent root = loader.load();

            // Obtiene el estado actual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Muestra la ventana
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Character buscarAgente(String agenteBuscado) {
        AgentsController search = new AgentsController();
        search.getAgentes();
        for (Character agente : search.getAgentes()) {
            if (agente.getNombre().equalsIgnoreCase(agenteBuscado)) {
                return agente;
            }
        }
        return null;
    }
}