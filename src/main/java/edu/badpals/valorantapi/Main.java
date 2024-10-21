package edu.badpals.valorantapi;

import edu.badpals.valorantapi.Controller.AgentsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.badpals.valorantapi.Model.User;

import java.io.IOException;

public class Main extends Application {
    User user;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        user = new User();
        user.saveUser();

        AgentsController api = new AgentsController();
        api.getAgentes();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/badpals/valorantapi/login.fxml"));
            primaryStage.setTitle("Login ValorantAPI");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMinWidth(400);
            primaryStage.setMinHeight(300);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error loading the FXML file: " + e.getMessage());
            // Puedes agregar un diálogo de error aquí
        }
    }
}