package edu.badpals.valorantapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.badpals.valorantapi.Model.User;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main extends Application {
    User user;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        user = new User();
        user.saveUser();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/badpals/valorantapi/login.fxml"));
            primaryStage.setTitle("Login ValorantAPI");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}