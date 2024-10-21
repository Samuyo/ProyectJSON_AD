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

    public void getAgentes() {
        String jsonResponse = accesoAPI();
        if (jsonResponse != null) {
            ArrayList<Character> agentes = procesarRespuesta(jsonResponse);
            // Aquí puedes hacer algo con la lista de agentes
            for (Character agente : agentes) {
                System.out.println(agente);
            }
        }
    }

    private String accesoAPI() {
        StringBuilder response = new StringBuilder();
        try {
            URL obj = new URL(finalURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // Comprueba si la respuesta es correcta
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.err.println("Error en la conexión: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response.toString();
    }

    private ArrayList<Character> procesarRespuesta(String jsonResponse) {
        ArrayList<Character> agentes = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray agentsArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < agentsArray.length(); i++) {
            JSONObject agent = agentsArray.getJSONObject(i);
            String uuid = agent.getString("uuid");
            String displayName = agent.getString("displayName");
            String description = agent.getString("description");


            String fullPortrait = agent.get("fullPortrait").toString();


            String roleName = "No role";  // Valor por defecto
            if (agent.has("role") && !agent.isNull("role")) {
                JSONObject role = agent.getJSONObject("role");
                roleName = role.getString("displayName");
            } else {
                System.out.println("El agente no tiene un rol definido.");
            }

            JSONArray abilitiesArray = agent.getJSONArray("abilities");
            ArrayList<String> abilityNames = new ArrayList<>();
            for (int j = 0; j < abilitiesArray.length(); j++) {
                JSONObject ability = abilitiesArray.getJSONObject(j);
                abilityNames.add(ability.getString("displayName"));
            }

            Character character = new Character(uuid, displayName, description, fullPortrait, roleName, abilityNames);
            agentes.add(character);
        }
        return agentes;
    }
}
