package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import edu.badpals.valorantapi.Model.Character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class AgentsController implements Controller {
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


    public void handlebtnReturn(ActionEvent event) {
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

    private void accesoAPI() {
        try {
            // Crear un objeto URL
            URL obj = new URL(finalURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configurar el método de solicitud
            con.setRequestMethod("GET");

            // Obtener el código de respuesta
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Character> procesarRespuesta(String jsonResponse) {
        ArrayList<Character> agentes = new ArrayList<>();

        // Convertir la respuesta JSON en un objeto JSONObject
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray agentsArray = jsonObject.getJSONArray("data");


        // Iterar sobre cada agente en el array
        for (int i = 0; i < agentsArray.length(); i++) {
            JSONObject agent = agentsArray.getJSONObject(i);
            String uuid = agent.getString("uuid");
            String displayName = agent.getString("displayName");
            String description = agent.getString("description");
            String fullPortrait = agent.getString("fullPortrait");

            // Obtener el rol
            JSONObject role = agent.getJSONObject("role");
            String roleName = role.getString("displayName");

            // Obtener las habilidades
            JSONArray abilitiesArray = agent.getJSONArray("abilities");
            ArrayList<String> abilityNames = new ArrayList<>();
            for (int j = 0; j < abilitiesArray.length(); j++) {
                JSONObject ability = abilitiesArray.getJSONObject(j);
                abilityNames.add(ability.getString("displayName"));
            }

            // Crear un nuevo objeto Agent
            Character character = new Character(uuid, displayName, description, fullPortrait, roleName, abilityNames);
            agentes.add(character);
        }
        return agentes;
    }

    public ArrayList<Character> getAgentes() {
        accesoAPI();
        return procesarRespuesta(finalURL);
    }
}
