package edu.badpals.valorantapi.Controller;

import edu.badpals.valorantapi.Model.Character; // Asegúrate de importar la clase Character
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


    AgentsController search = new AgentsController(); // Asegúrate de que esta clase tenga el método getAgentes

    public void handlebtnBuscar(ActionEvent event) {
        String agenteBuscado = txtBuscaAg.getText().trim();
        Character buscaAgente = buscarAgente(agenteBuscado); // Llama a buscarAgente
        System.out.println(search.getAgentes());
        System.out.println(agenteBuscado);
        System.out.println(buscaAgente.getNombre());
        if (buscaAgente != null) {
            search.setAgentes(buscaAgente);

            try {

                // Carga la nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/agents.fxml"));
                Parent root = loader.load();

                // Obtiene el estado actual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                // Muestra la ventana
                stage.show();
            } catch (IOException e) {
                System.out.println("Error handlebtnBuscar");
            }
        } else {
            // Maneja el caso en que no se encuentra el agente
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
        System.out.println(search.getAgentes());
        for (Character agente : search.getAgentes()) { // Asegúrate de que getAgentes devuelve un ArrayList<Character>
            if (agente.getNombre().equals(agenteBuscado)) {
                return agente; // Retorna el agente encontrado
            }
        }
        return null; // Retorna null si no se encuentra el agente
    }
}
