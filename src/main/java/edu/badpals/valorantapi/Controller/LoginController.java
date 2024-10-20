package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginController {
    String archivo = "src/main/resources/BD/users.txt";
    @FXML
    public TextField txtLogin;

    @FXML
    public Label lblLogin;

    @FXML
    public TextField txtPassword;

    @FXML
    public Label lblPassword;

    @FXML
    public Button btnEnviar;

    private HashMap<String, String> userCredentials = new HashMap<>();

    @FXML
    public void initialize() {
        leer();
    }

    private void leer(){

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine())!= null){
                String[] partes = linea.split("=", 2);
                if (partes.length == 2) {
                    String usuario = partes[0].trim();
                    String contrasenia = partes[1].trim();
                    userCredentials.put(usuario, contrasenia);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleBtnEnter(ActionEvent event){
        String user = txtLogin.getText();
        String password = txtPassword.getText();

        if (autentificacionUser(user,password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/search.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Autenticación fallida. Usuario o contraseña incorrecta.");

        }
    }

    private boolean autentificacionUser(String user, String password){
        if (userCredentials.containsKey(user)) {
            return userCredentials.get(user).equals(password);
        }
        return false;
    }
}
