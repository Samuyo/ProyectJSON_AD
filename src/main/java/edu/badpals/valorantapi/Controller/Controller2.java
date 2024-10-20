package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
;

import java.io.IOException;

public class Controller2 {

    public void btnEnviar(ActionEvent event){
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

    public void btnBuscar(ActionEvent event){
        try {
            // Carga la nueva venta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/agents.fxml"));
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

    public void btnReturn(ActionEvent event){
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
